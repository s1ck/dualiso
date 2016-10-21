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

  public static int[] unionSorted(int[] f1, int[] f2) {

    int i = 0;
    int j = 0;
    int m = f1.length;
    int n = f2.length;
    int previous = -1;
    int count = 0;
    int[] accumulator = new int[m + n];
    while (i < m && j < n) {
      if (f1[i] < f2[j]) {
        if (previous < f1[i]) {
          previous = f1[i];
          accumulator[count++] = previous;
        }
        i++;
      } else if (f1[i] > f2[j]) {
        if (previous < f2[j]) {
          previous = f2[j];
          accumulator[count++] = previous;
        }
        j++;
      } else {
        if (previous < f1[i]) {
          previous = f1[i];
          accumulator[count++] = previous;
        }
        i++;
        j++;
      }
    }
    while (i < m) {
      accumulator[count++] = f1[i++];
    }
    while (j < n) {
      accumulator[count++] = f2[j++];
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

  public static int[] intersectSorted(int[] f1, int[] f2) {
    int[] accumulator = new int[Math.min(f1.length, f2.length)];
    int count = 0;
    int i = 0;
    int j = 0;
    int m = f1.length;
    int n = f2.length;
    int previous = -1;
    while (i < m && j < n) {
      if (f1[i] < f2[j]) {
        i++;
      } else if (f1[i] > f2[j]) {
        j++;
      } else {
        if (f1[i] != previous) {
          accumulator[count++] = f1[i];
        }
        i++;
        j++;
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

  public static boolean doIntersectSorted(int[] f1, int[] f2) {
    int i = 0;
    int j = 0;
    while (i < f1.length && j < f2.length) {
      if (f1[i] < f2[j]) {
        i++;
      } else if (f1[i] > f2[j]) {
        j++;
      } else {
        return true;
      }
    }
    return false;
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

  public static boolean containsSorted(int[] f, int e) {
    return containsSorted(f, e, f.length);
  }

  public static boolean containsSorted(int[] f, int e, int cnt) {
    int lo = 0;
    int hi = Math.min(f.length, cnt) - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (e < f[mid]) {
        hi = mid - 1;
      } else if (e > f[mid]) {
        lo = mid + 1;
      } else {
        return true;
      }
    }
    return false;
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

  public static boolean containsSorted(int[][] f, int e) {
    return containsSorted(f, e, f.length);
  }

  public static boolean containsSorted(int[][] f, int e, int row) {
    boolean res = false;
    int bound = Math.min(f.length - 1, row);

    for (int i = 0; i <= bound; i++) {
      if (containsSorted(f[i], e)) {
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
