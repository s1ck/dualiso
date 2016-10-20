package org.s1ck.gpm.dualiso.datastructures;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.primitives.Ints;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Graph {

  // |E|
  private int[][] adjacencyList;

  // |V|
  private String[] labels;

  // |L| + |V|
  private Map<String, List<Integer>> labelIdx;

  public Graph(int[][] adjacencyList, String[] labels) {
    this.adjacencyList = adjacencyList;
    for (int i = 0; i < adjacencyList.length; i++) {
      int[] line = adjacencyList[i];
      Arrays.sort(line);
      adjacencyList[i] = line;
    }
    this.labels = labels;
    labelIdx = Maps.newHashMap();
    for (int i = 0; i < labels.length; i++) {
      String label = labels[i];
      if (labelIdx.containsKey(label)) {
        labelIdx.get(label).add(i);
      } else {
        labelIdx.put(label, Lists.newArrayList(i));
      }
    }
  }

  public int getSize() {
    return adjacencyList.length;
  }

  public int[] getNeighbors(int v) {
    return adjacencyList[v];
  }

  public String getLabel(int v) {
    return labels[v];
  }

  public int[] getVerticesByLabel(String label) {
    return Ints.toArray(labelIdx.get(label));
  }
}
