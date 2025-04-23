package Playground;

import java.util.HashMap;

//https://leetcode.com/problems/lru-cache/
public class LRUCache {
        public class Node {
            int key;
            int val;
            Node pre;
            Node next;

            public Node(int key, int val){
                this.key = key;
                this.val = val;
            }
        }

        int cap;
        HashMap<Integer, Node> map;
        Node head;
        Node tail;

        public LRUCache(int capacity) {
            this.cap = capacity;
            map = new HashMap<>();
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            tail.pre = head;
            head.next = tail;
        }

        private void add(Node node){
            Node temp = head.next;
            node.next = temp;
            node.pre = head;

            temp.pre = node;
            head.next = node;
        }

        private void delete(Node node){
            Node tempPre = node.pre;
            Node tempNext = node.next;

            tempPre.next = tempNext;
            tempNext.pre = tempPre;
        }

        public int get(int key) {

            if(map.containsKey(key)){
                Node curr = map.get(key);
                delete(curr);
                //map.remove(key);
                add(curr);
                //map.put(key, curr);
                //System.out.println(head.next.val);
                return curr.val;
            }



            return -1;

        }

        public void put(int key, int value) {

            if(map.containsKey(key)){
                Node curr = map.get(key);
                map.remove(key);
                delete(curr);
            }else{
                if(map.size() == cap){
                    map.remove(tail.pre.key);
                    delete(tail.pre);
                    //System.out.println(tail.pre.val);
                }
            }

            Node newNode = new Node(key, value);
            add(newNode);
            map.put(key, newNode);

        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

