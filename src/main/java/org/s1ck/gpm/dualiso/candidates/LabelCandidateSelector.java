package org.s1ck.gpm.dualiso.candidates;

import org.s1ck.gpm.dualiso.datastructures.Graph;

public class LabelCandidateSelector implements CandidateSelector {

  @Override
  public int[][] getCandidates(Graph database, Graph pattern) {
    int[][] result = new int[pattern.getSize()][];
    for (int id = 0; id < pattern.getSize(); id++) {
      String label = pattern.getLabel(id);
      result[id] = database.getVerticesByLabel(label);
    }
    return result;
  }
}
