package org.s1ck.gpm.dualiso.utils;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class ArrayUtilsTest {

  private static int[] f1 = {1, 2, 3};
  private static int[] f2 = {3, 4, 5};
  private static int[] f3 = {0};

  @Test
  public void testDoIntersect() {
    assertTrue(ArrayUtils.doIntersect(f1, f2));
    assertTrue(!ArrayUtils.doIntersect(f1, f3));
    assertTrue(ArrayUtils.doIntersect(f1, f1));
  }

  @Test
  public void testIntersect() {
    assertTrue(Arrays.equals(new int[] {3}, ArrayUtils.intersect(f1, f2)));
    assertTrue(Arrays.equals(new int[] {}, ArrayUtils.intersect(f1, f3)));
    assertTrue(Arrays.equals(new int[] {1, 2, 3}, ArrayUtils.intersect(f1, f1)));
  }

  @Test
  public void testUnion() {
    assertTrue(Arrays.equals(new int[] {1, 2, 3, 4, 5}, ArrayUtils.union(f1, f2)));
    assertTrue(Arrays.equals(new int[] {1, 2, 3, 0}, ArrayUtils.union(f1, f3)));
    assertTrue(Arrays.equals(new int[] {1, 2, 3}, ArrayUtils.union(f1, f1)));
  }

  @Test
  public void testTranspose() {
    int[][] t = ArrayUtils.transpose(new int[][] {f1, f2});

    assertTrue(Arrays.equals(new int[] {1, 3}, t[0]));
    assertTrue(Arrays.equals(new int[] {2, 4}, t[1]));
    assertTrue(Arrays.equals(new int[] {3, 5}, t[2]));
  }

  @Test
  public void testContains1() {
    assertTrue(ArrayUtils.contains(f1, 1));
    assertTrue(!ArrayUtils.contains(f1, 4));
  }

  @Test
  public void testContains2() {
    assertTrue(ArrayUtils.contains(f1, 1, 3));
    assertTrue(ArrayUtils.contains(f1, 1, f1.length + 1));
    assertTrue(!ArrayUtils.contains(f1, 4, 4));
    assertTrue(!ArrayUtils.contains(f1, 4, f1.length + 1));
  }

  @Test
  public void testContains3() {
    assertTrue(ArrayUtils.contains(new int[][] {f1, f2, f3}, 1));
    assertTrue(ArrayUtils.contains(new int[][] {f1, f2, f3}, 0));
    assertTrue(!ArrayUtils.contains(new int[][] {f1, f2, f3}, 6));
  }

  @Test
  public void testContains4() {
    assertTrue(ArrayUtils.contains(new int[][] {f1, f2, f3}, 1, 1));
    assertTrue(ArrayUtils.contains(new int[][] {f1, f2, f3}, 1, 4));
    assertTrue(!ArrayUtils.contains(new int[][] {f1, f2, f3}, 4, 0));
    assertTrue(!ArrayUtils.contains(new int[][] {f1, f2, f3}, 6, 4));
  }

  @Test
  public void testCopy() {
    int[][] copy = ArrayUtils.copy(new int[][] { f1, f2 });
    assertTrue(Arrays.equals(copy[0], f1));
    assertTrue(Arrays.equals(copy[1], f2));
  }

  @Test
  public void testIsEmpty() {
    assertTrue(ArrayUtils.isEmpty(new int[0][]));
    assertTrue(!ArrayUtils.isEmpty(new int[][] { f1, f2}));
  }
}