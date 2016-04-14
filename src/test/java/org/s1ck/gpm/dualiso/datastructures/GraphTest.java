package org.s1ck.gpm.dualiso.datastructures;

import org.junit.Test;
import org.s1ck.gpm.TestData;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GraphTest {

  @Test
  public void testConstructor() {
    Graph g = new Graph(TestData.DATABASE_1, TestData.DATABASE_1_LABELS);

    assertEquals("a", g.getLabel(5));
    assertEquals(9, g.getSize());
    assertTrue(Arrays.equals(new int[] {1, 3}, g.getNeighbors(0)));
    assertTrue(Arrays.equals(new int[] {}, g.getNeighbors(3)));
    assertTrue(Arrays.equals(new int[] {1, 2, 5}, g.getVerticesByLabel("a")));
  }
}
