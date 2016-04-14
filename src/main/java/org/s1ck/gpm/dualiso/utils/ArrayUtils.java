package org.s1ck.gpm.dualiso.utils;

import java.util.Arrays;

public class ArrayUtils {

  public static int[] union(int[] f1, int[] f2) {
    int[] accumulator = new int[f1.length + f2.length];
    int count = 0;

    for (int e : f1) {
      if (!contains(accumulator, e, count)) {
        accumulator[count++] = e;
      }
    }

    for (int e : f2) {
      if (!contains(accumulator, e, count)) {
        accumulator[count++] = e;
      }
    }

    return Arrays.copyOfRange(accumulator, 0, count);
  }

  public static int[] intersect(int[] f1, int[] f2) {
    int[] accumulator = new int[Math.min(f1.length, f2.length)];
    int count = 0;

    for (int a : f1) {
      for (int b : f2) {
        if (a == b) {
          accumulator[count++] = a;
        }
      }
    }

    return Arrays.copyOfRange(accumulator, 0, count);
  }

  public static int[][] transpose(int[][] f) {
    int m = f.length;
    int n = f[0].length;

    int[][] f_transpose = new int[n][m];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        f_transpose[j][i] = f[i][j];
      }
    }

    return f_transpose;
  }

  public static boolean doIntersect(int[] f1, int[] f2) {
    boolean res = false;
    for (int a : f1) {
      for (int b : f2) {
        if (a == b) {
          res = true;
          break;
        }
      }
    }
    return res;
  }

  public static boolean contains(int[] f, int e) {
    return contains(f, e, f.length);
  }

  public static boolean contains(int[] f, int e, int cnt) {
    boolean res = false;
    int bound = Math.min(f.length, cnt);

    for (int i = 0; i < bound; i++) {
      if (f[i] == e) {
        res = true;
        break;
      }
    }
    return res;
  }

  public static boolean contains(int[][] f, int e) {
    return contains(f, e, f.length);
  }

  public static boolean contains(int[][] f, int e, int row) {
    boolean res = false;
    int bound = Math.min(f.length - 1, row);

    for (int i = 0; i <= bound; i++) {
      if (contains(f[i], e)) {
        res = true;
        break;
      }
    }
    return res;
  }

  public static int[][] copy(int[][] f) {
    int m = f.length;
    int[][] res = new int[m][];
    for (int i = 0; i < m; i++) {
      res[i] = Arrays.copyOf(f[i], f[i].length);
    }
    return res;
  }

  public static boolean isEmpty(int[][] f) {
    return f.length == 0;
  }
}
