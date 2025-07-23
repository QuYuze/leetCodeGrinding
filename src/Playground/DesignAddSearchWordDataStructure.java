package Playground;

public class DesignAddSearchWordDataStructure {
    class WordDictionary {

        TrieNode root;

        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode curr = root;

            for(char c : word.toCharArray()){
                if(curr.children[c - 'a'] == null){
                    curr.children[c - 'a'] = new TrieNode();
                }

                curr = curr.children[c - 'a'];
            }

            curr.wordEnd = true;
        }

        public boolean search(String word) {
            return find(root, word);
        }

        private boolean find(TrieNode root, String word){
            TrieNode curr = root;

            for(int i=0; i<word.length(); i++){
                char c = word.charAt(i);
                if(c == '.'){
                    if(i < word.length()-1){
                        for(TrieNode child : curr.children){
                            if(child!=null && find(child, word.substring(i+1))){
                                return true;
                            }
                        }

                        return false;

                    }else{
                        for(TrieNode child : curr.children){
                            if(child!= null && child.wordEnd == true){
                                return true;
                            }
                        }

                        return false;
                    }
                }else{
                    if(curr.children[c - 'a'] == null){
                        return false;
                    }else{
                        curr = curr.children[c - 'a'];
                    }
                }
            }

            return curr.wordEnd;
        }

        class TrieNode{

            boolean wordEnd = false;
            TrieNode[] children;

            public TrieNode(){
                children = new TrieNode[26];
            }
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}
