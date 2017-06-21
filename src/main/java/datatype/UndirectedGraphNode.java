package datatype;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by spzhang on 6/20/17.
 */
public class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
