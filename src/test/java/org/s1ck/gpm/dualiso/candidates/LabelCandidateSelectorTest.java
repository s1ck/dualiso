package org.s1ck.gpm.dualiso.candidates;

import org.junit.Test;
import org.s1ck.gpm.TestData;
import org.s1ck.gpm.dualiso.datastructures.Graph;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LabelCandidateSelectorTest {

  @Test
  public void testCandidateDetection() {
    Graph database = new Graph(TestData.DATABASE_1, TestData.DATABASE_1_LABELS);
    Graph pattern = new Graph(TestData.PATTERN_1, TestData.PATTERN_1_LABELS);

    int[][] candidates = new LabelCandidateSelector().getCandidates(database, pattern);

    assertEquals(3, candidates.length);
    assertTrue(Arrays.equals(new int[] {1, 2, 5}, candidates[0]));
    assertTrue(Arrays.equals(new int[] {0, 4, 6, 8}, candidates[1]));
    assertTrue(Arrays.equals(new int[] {3, 7}, candidates[2]));
  }
}