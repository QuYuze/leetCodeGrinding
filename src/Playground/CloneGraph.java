package Playground;

import java.util.*;

//https://leetcode.com/problems/clone-graph/
public class CloneGraph {

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

            HashMap<Node, Node> map = new HashMap<>();
            Node clone = cloneNode(node, map);

            return clone;

        }

        private Node cloneNode(Node node, HashMap<Node, Node> map){
            if(node == null){
                return null;
            }

            if(!map.containsKey(node)){
                Node clone = new Node(node.val);
                map.put(node, clone);
                for(Node child : node.neighbors){
                    if(map.containsKey(child)){
                        clone.neighbors.add(map.get(child));
                    }else{
                        clone.neighbors.add(cloneNode(child, map));
                    }
                }

                return clone;
            }else{
                return map.get(node);
            }

        }
    }

    //without recurion approach
    class Solution2 {
        public Node cloneGraph(Node node) {

            if(node == null){
                return null;
            }

            Node result = null;
            Queue<Node> q = new LinkedList<>();
            HashMap<Node, Node> map = new HashMap<>();
            HashSet<Node> set = new HashSet<>();

            q.add(node);
            set.add(node);

            while(!q.isEmpty()){

                int size = q.size();

                while(size > 0){

                    Node n = q.remove();
                    Node clone = new Node(n.val);

                    for(Node neighbor : n.neighbors){

                        if(map.containsKey(neighbor)){
                            clone.neighbors.add(map.get(neighbor));
                            map.get(neighbor).neighbors.add(clone);
                        }else{
                            if(!set.contains(neighbor)){
                                q.add(neighbor);
                                set.add(neighbor);
                            }

                        }
                    }

                    map.put(n, clone);

                    size--;
                }

                result = map.get(node);
            }

            return result;



        }
    }
}
