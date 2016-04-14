package org.s1ck.gpm;

public class TestData {

  //----------------------------------------------------------------------------
  // Example Graph Database 1
  //----------------------------------------------------------------------------

  public static int[][] DATABASE_1 = {
    new int[] {1, 3},     // 0
    new int[] {6},        // 1
    new int[] {6},        // 2
    new int[] {},         // 3
    new int[] {1, 3},     // 4
    new int[] {4},        // 5
    new int[] {2, 5, 7},  // 6
    new int[] {},         // 7
    new int[] {5}         // 8
  };

  public static String[] DATABASE_1_LABELS = {
    "b", // 0
    "a", // 1
    "a", // 2
    "c", // 3
    "b", // 4
    "a", // 5
    "b", // 6
    "c", // 7
    "b"  // 8
  };

  //----------------------------------------------------------------------------
  // Example Graph Database 1
  //----------------------------------------------------------------------------

  public static int[][] DATABASE_2 = {
    new int[] {1},              // 0
    new int[] {0, 2, 3, 4, 5},  // 1
    new int[] {},               // 2
    new int[] {},               // 3
    new int[] {},               // 4
    new int[] {6, 10},          // 5
    new int[] {4, 7, 8, 9},     // 6
    new int[] {1},              // 7
    new int[] {},               // 8
    new int[] {},               // 9
    new int[] {11},             // 10
    new int[] {12},             // 11
    new int[] {11},             // 12
    new int[] {},               // 13
    new int[] {13},             // 14
    new int[] {16},             // 15
    new int[] {17, 18},     // 16
    new int[] {14, 19},     // 17
    new int[] {20},         // 18
    new int[] {14},         // 19
    new int[] {19, 21},     // 20
    new int[] {},           // 21
    new int[] {21, 23},     // 22
    new int[] {25},         // 23
    new int[] {},           // 24
    new int[] {24, 26},     // 25
    new int[] {28},         // 26
    new int[] {},           // 27
    new int[] {27, 29},     // 28
    new int[] {22},         // 29
  };

  public static String[] DATABASE_2_LABELS = {
    "a", // 0
    "b", // 1
    "c", // 2
    "c", // 3
    "c", // 4
    "a", // 5
    "b", // 6
    "a", // 7
    "c", // 8
    "m", // 9
    "c", // 10
    "a", // 11
    "b", // 12
    "c", // 13
    "b", // 14
    "a", // 15
    "b", // 16
    "c", // 17
    "a", // 18
    "a", // 19
    "b", // 20
    "c", // 21
    "b", // 22
    "a", // 23
    "c", // 24
    "b", // 25
    "a", // 26
    "c", // 27
    "b", // 28
    "a", // 29

  };

  //----------------------------------------------------------------------------
  // Example Graph Pattern 1
  //----------------------------------------------------------------------------

  public static int[][] PATTERN_1 = {
    new int[] {1},    // 0
    new int[] {0, 2}, // 1
    new int[] {}      // 2
  };

  public static String[] PATTERN_1_LABELS = {
    "a", // 0
    "b", // 1
    "c", // 2
  };

  //----------------------------------------------------------------------------
  // Example Graph Pattern 2
  //----------------------------------------------------------------------------

  public static int[][] PATTERN_2 = {
    new int[] {1},        // 0
    new int[] {0, 2, 3},  // 1
    new int[] {},         // 2
    new int[] {}          // 3
  };

  public static String[] PATTERN_2_LABELS = {
    "a", // 0
    "b", // 1
    "c", // 2
    "c", // 3
  };
}
