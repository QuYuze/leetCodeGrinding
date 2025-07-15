package Playground;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestPalindromeByConcatenatingTwoLetterWords {
    class Solution {
        public int longestPalindrome(String[] words) {
            int result = 0;

            HashMap<String, Integer> freq = new HashMap<>();
            HashSet<String> visited = new HashSet<>();
            boolean centered = false;

            for(String word : words){
                freq.putIfAbsent(word, 0);
                freq.put(word, freq.get(word)+1);
            }

            for(Map.Entry<String, Integer> entry : freq.entrySet()){
                String word = entry.getKey();
                int count = entry.getValue();
                int extension = 0;

                //System.out.println(word + " : " + count);

                if(word.charAt(0) == word.charAt(1)){
                    if(count%2 == 1){
                        if(centered){
                            extension += (count-1) * 2;
                        }else{
                            centered = true;
                            extension += count * 2;
                        }
                    }else{
                        extension += count * 2;
                    }



                }else if(!visited.contains(word)){
                    String mirror = getMirror(word);
                    if(freq.containsKey(mirror) && !visited.contains(mirror)){
                        visited.add(word);
                        visited.add(mirror);
                        count = Math.min(count, freq.get(mirror));
                        extension += count * 4;
                    }
                }

                if(extension == 0){
                    //System.out.println(word + " : "+count);
                }

                result += extension;



            }

            return result;

        }

        private String getMirror(String word){
            String result = ""+word.charAt(1)+word.charAt(0);
            return result;
        }
    }
}
