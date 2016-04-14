package org.s1ck.gpm.dualiso.simulation;

import org.s1ck.gpm.dualiso.datastructures.Graph;

public interface SimulationMethod {

  int[][] simulate(Graph database, Graph pattern, int[][] candidates);
}
