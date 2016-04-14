package org.s1ck.gpm.dualiso.candidates;

import org.s1ck.gpm.dualiso.datastructures.Graph;

public interface CandidateSelector {

  int[][] getCandidates(Graph database, Graph pattern);
}
