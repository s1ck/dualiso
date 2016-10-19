package org.s1ck.gpm.dualiso.simulation;

import org.s1ck.gpm.dualiso.datastructures.Graph;

import static org.apache.commons.lang3.ArrayUtils.removeElement;
import static org.s1ck.gpm.dualiso.utils.ArrayUtils.sortedDoIntersect;

/**
 * Checks if each candidate in the database graph has appropriate children
 * according to the pattern graph.
 * <p>
 * Worst case: O(|Eq|x|Vq|x|V|^3)
 */
public class SimpleSimulation implements SimulationMethod {

    @Override
    public int[][] simulate(Graph database, Graph pattern, int[][] candidates) {
        boolean changed = true;
        while (changed) {
            changed = false;
            // for each vertex u_Q in the pattern
            for (int u_Q = 0; u_Q < pattern.getSize(); u_Q++) {
                // for each neighbor of u_Q (v_Q)
                for (int v_Q : pattern.getNeighbors(u_Q)) {
                    // for each candidate of u_Q (u_G)
                    for (int u_G : candidates[u_Q]) {
                        // check if an edge exists in the database
                        if (!sortedDoIntersect(database.getNeighbors(u_G), candidates[v_Q])) {
                            // if not, remove candidates from cand(u_Q)
                            candidates[u_Q] = removeElement(candidates[u_Q], u_G);
                            // if no candidate is left for u_Q, there is no embedding
                            if (candidates[u_Q].length == 0) {
                                return new int[0][];
                            }
                            changed = true;
                        }
                    }
                }
            }
        }
        return candidates;
    }
}
