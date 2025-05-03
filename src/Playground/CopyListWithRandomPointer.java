package Playground;

import java.util.ArrayList;
import java.util.HashMap;

public class CopyListWithRandomPointer {

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


    class Solution {
        public Node copyRandomList(Node head) {
            Node result =  null;
            Node pre = null;
            HashMap<Node, ArrayList<Node>> map = new HashMap<>();
            HashMap<Node, Node> visited = new HashMap<>();

            while(head!=null){
                Node node = new Node(head.val);
                visited.put(head, node);

                if(pre == null){
                    result = node;
                }else{
                    pre.next = node;
                }

                if(map.containsKey(head)){
                    ArrayList<Node> list = map.get(head);
                    for(Node parent : list){
                        parent.random = node;
                    }
                }

                if(head.random !=null){
                    if(visited.containsKey(head.random)){
                        node.random = visited.get(head.random);
                    }else{
                        map.putIfAbsent(head.random, new ArrayList<Node>());
                        map.get(head.random).add(node);
                    }

                }

                head = head.next;
                pre = node;
            }

            return result;
        }
    }
}
