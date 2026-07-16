/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null)return null;

        Map<Node , Node> vis = new HashMap<>();

        return copygraph(node , vis);
    }

    public Node copygraph(Node node , Map<Node , Node> vis)
    {
        Node clone = new Node(node.val);

        vis.put(node , clone);

        for(Node neighbor : node.neighbors)
        {
            if(vis.containsKey(neighbor))
            {
                clone.neighbors.add(vis.get(neighbor));
            }
            else 
            {
                Node cloneneighbor = copygraph(neighbor , vis);

                clone.neighbors.add(cloneneighbor);
            }
        }
        return clone ;
    }
}