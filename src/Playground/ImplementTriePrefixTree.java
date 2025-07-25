package Playground;

public class ImplementTriePrefixTree {
    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode curr = root;

            for(char c : word.toCharArray()){
                if(curr.children[c -'a'] == null){
                    curr.children[c -'a'] = new TrieNode();
                }
                curr = curr.children[c -'a'];
            }

            curr.wordEnd = true;
        }

        public boolean search(String word) {
            TrieNode curr = root;

            for(char c : word.toCharArray()){
                if(curr.children[c -'a'] == null){
                    return false;
                }
                curr = curr.children[c -'a'];
            }

            if(curr.wordEnd == false){
                return false;
            }

            return true;
        }

        public boolean startsWith(String prefix) {

            TrieNode curr = root;

            for(char c : prefix.toCharArray()){
                if(curr.children[c -'a'] == null){
                    return false;
                }
                curr = curr.children[c -'a'];
            }

            return true;
        }

        private class TrieNode{
            TrieNode[] children;
            Boolean wordEnd;

            public TrieNode(){
                children = new TrieNode[26];
                wordEnd = false;
            }

        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
