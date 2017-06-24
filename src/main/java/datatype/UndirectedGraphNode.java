package datatype;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by spzhang on 6/20/17.
 */
public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
