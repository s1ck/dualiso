package org.s1ck.gpm.dualiso;

import org.junit.Test;
import org.s1ck.gpm.TestData;
import org.s1ck.gpm.dualiso.candidates.LabelCandidateSelector;
import org.s1ck.gpm.dualiso.datastructures.Graph;
import org.s1ck.gpm.dualiso.matcher.Matcher;
import org.s1ck.gpm.dualiso.simulation.DualSimulation;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DualIsoTest {

  @Test
  public void testMatch1() {
    Graph database = new Graph(TestData.DATABASE_1, TestData.DATABASE_1_LABELS);
    Graph pattern = new Graph(TestData.PATTERN_1, TestData.PATTERN_1_LABELS);

    Matcher m = new DualIso(new LabelCandidateSelector(), new DualSimulation());

    List<int[]> matches = m.match(database, pattern);

    assertEquals(1, matches.size());
    assertTrue(Arrays.equals(new int[] {2, 6, 7}, matches.get(0)));
  }

  @Test
  public void testMatch2() {
    Graph database = new Graph(TestData.DATABASE_2, TestData.DATABASE_2_LABELS);
    Graph pattern = new Graph(TestData.PATTERN_2, TestData.PATTERN_2_LABELS);

    Matcher m = new DualIso(new LabelCandidateSelector(), new DualSimulation());

    List<int[]> matches = m.match(database, pattern);

    assertEquals(6, matches.size());
    assertTrue(Arrays.equals(new int[] {0, 1, 2, 3}, matches.get(0)));
    assertTrue(Arrays.equals(new int[] {0, 1, 2, 4}, matches.get(1)));
    assertTrue(Arrays.equals(new int[] {0, 1, 3, 2}, matches.get(2)));
    assertTrue(Arrays.equals(new int[] {0, 1, 3, 4}, matches.get(3)));
    assertTrue(Arrays.equals(new int[] {0, 1, 4, 2}, matches.get(4)));
    assertTrue(Arrays.equals(new int[] {0, 1, 4, 3}, matches.get(5)));
  }
}