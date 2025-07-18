package Playground;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class SearchSuggestionSystem {
    class Solution {
        public List<List<String>> suggestedProducts(String[] products, String searchWord) {
            TrieNode root = new TrieNode();
            List<List<String>> result = new ArrayList<>();

            for(String word : products){
                insert(root, word);
            }

            for(char c : searchWord.toCharArray()){
                TrieNode curr = root.children[c - 'a'];
                if(curr == null){
                    break;
                }
                result.add(curr.getTopThree());
                root = curr;
            }

            while(result.size() < searchWord.length()){
                result.add(new ArrayList<>());
            }

            return result;
        }

        private void insert(TrieNode root, String word){
            for(char c : word.toCharArray()){
                if(root.children[c-'a'] == null){

                    root.children[c-'a'] = new TrieNode();

                    //System.out.println(word);

                }

                root = root.children[c-'a'];
                root.addPQ(word);
            }
        }

        class TrieNode{
            public TrieNode[] children;
            public PriorityQueue<String> pq;

            public TrieNode(){
                pq = new PriorityQueue<>((a, b) -> b.compareTo(a));
                children = new TrieNode[26];
            }

            private void addPQ(String word){

                pq.add(word);
                if(pq.size() > 3){
                    pq.poll();
                }
            }

            private List<String> getTopThree(){
                List<String> result = new ArrayList<>();
                while(!pq.isEmpty()){
                    result.add(pq.remove());
                }
                Collections.reverse(result);
                return result;
            }
        }
    }
}
