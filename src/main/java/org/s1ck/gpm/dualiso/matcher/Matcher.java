package org.s1ck.gpm.dualiso.matcher;

import org.s1ck.gpm.dualiso.datastructures.Graph;

import java.util.List;

public interface Matcher {

  List<int[]> match(Graph database, Graph pattern);
}
