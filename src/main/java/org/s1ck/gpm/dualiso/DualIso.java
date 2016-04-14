package org.s1ck.gpm.dualiso;

import com.google.common.collect.Lists;
import org.s1ck.gpm.dualiso.candidates.CandidateSelector;
import org.s1ck.gpm.dualiso.datastructures.Graph;
import org.s1ck.gpm.dualiso.matcher.Matcher;
import org.s1ck.gpm.dualiso.simulation.SimulationMethod;

import java.util.List;

import static org.s1ck.gpm.dualiso.utils.ArrayUtils.*;

/**
 * Implementation of the Dual-based Isomorphism Algorithm
 *
 * Described in:
 *
 * Saltz et al, "DualIso: An Algorithm for Subgraph Pattern Matching in Very
 * Large Labeled Graphs", IEEE International Congress on Big Data 2014
 *
 */
public class DualIso implements Matcher {

  private final CandidateSelector candidateSelector;

  private final SimulationMethod simulationMethod;

  private List<int[]> matches;

  public DualIso(CandidateSelector candidateSelector, SimulationMethod simulationMethod) {
    this.candidateSelector = candidateSelector;
    this.simulationMethod = simulationMethod;
    this.matches = Lists.newArrayList();
  }

  @Override
  public List<int[]> match(Graph database, Graph pattern) {
    int[][] cand_0 = candidateSelector.getCandidates(database, pattern);
    cand_0 = simulationMethod.simulate(database, pattern, cand_0);

    search(database, pattern, cand_0, 0);

    return matches;
  }

  private void search(Graph database, Graph pattern, int[][] candidates, int depth) {
    if (depth == pattern.getSize()) {
      matches.add(transpose(candidates)[0]);
    } else {
      for (int v_G : candidates[depth]) {
        if (!contains(candidates, v_G, depth - 1)) {
          int[][] cand_copy = copy(candidates);
          cand_copy[depth] = new int[] { v_G };
          cand_copy = simulationMethod.simulate(database, pattern, cand_copy);
          if(!isEmpty(cand_copy)) {
            search(database, pattern, cand_copy, depth + 1);
          }
        }
      }
    }
  }
}
