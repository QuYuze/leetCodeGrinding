package Playground;

import java.util.HashSet;

public class CountVowelsStringInRange {

    //https://leetcode.com/problems/count-vowel-strings-in-ranges/

    class Solution {
        public int[] vowelStrings(String[] words, int[][] queries) {
            int[] result = new int[queries.length];
            int[] prefixSum = new int[words.length];

            HashSet<Character> vowels = new HashSet<>();
            vowels.add('a');
            vowels.add('e');
            vowels.add('i');
            vowels.add('o');
            vowels.add('u');


            for(int i=0; i<words.length; i++){

                if(i>0){
                    prefixSum[i] += prefixSum[i-1];
                }

                String word = words[i];

                if(vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length()-1)) ){
                    prefixSum[i]++;
                }
            }

            for(int i=0; i<queries.length; i++){
                int[] q = queries[i];
                int count = prefixSum[q[1]];
                if(q[0]>0){
                    count -= prefixSum[q[0]-1];
                }
                result[i] = count;
            }

            return result;
        }
    }
}
