package org.s1ck.gpm.dualiso.simulation;

import org.apache.commons.lang3.ArrayUtils;
import org.s1ck.gpm.dualiso.datastructures.Graph;

import static org.s1ck.gpm.dualiso.utils.ArrayUtils.*;

/**
 * Checks if each candidate in the database graph has appropriate children
 * and parents according to the pattern graph.
 * <p>
 * Worst case: O(|Eq|x|Vq|x|V|^3)
 */
public class DualSimulation implements SimulationMethod {

  @Override
  public int[][] simulate(Graph g, Graph q, int[][] candidates) {
    boolean changed = true;
    while (changed) {
      changed = false;
      // for each vertex u_Q in the pattern
      for (int u_Q = 0; u_Q < q.getSize(); u_Q++) {
        // for each neighbor of u_Q (v_Q)
        for (int v_Q : q.getNeighbors(u_Q)) {
          // keep track of candidates that have a parent in cand(u_Q)
          int[] v_Q_candidates = new int[0];
          // for each candidate of u_Q (u_G)
          for (int u_G : candidates[u_Q]) {
            int[] intersect =
              sortedIntersect(g.getNeighbors(u_G), candidates[v_Q]);
            // check if edge exists in the database
            if (intersect.length == 0) {
              // if not, remove candidates from cand(u_Q)
              candidates[u_Q] = ArrayUtils.removeElement(candidates[u_Q], u_G);
              // if no candidate is left for u_Q, there is no embedding
              if (candidates[u_Q].length == 0) {
                return new int[0][];
              }
              changed = true;
            }
            // update valid candidates for v_Q
            v_Q_candidates = sortedUnion(v_Q_candidates, intersect);
          }
          // if no candidates for v_Q, there is no embedding
          if (v_Q_candidates.length == 0) {
            return new int[0][];
          }
          // trigger re-eval of candidates of v_Q changed
          if (v_Q_candidates.length < candidates[v_Q].length) {
            changed = true;
          }
          candidates[v_Q] = sortedIntersect(candidates[v_Q], v_Q_candidates);
        }
      }
    }
    return candidates;
  }
}
