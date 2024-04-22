package Playground;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    class Solution {
        public List<String> letterCasePermutation(String s) {

            List<String> result = new ArrayList<>();

            perm(result, 0, "", s);

            return result;
        }

        private void perm(List<String> result, int index, String temp, String s){

            if(temp.length()==s.length()){
                result.add(new String(temp));
            }else{
                char c = s.charAt(index);
                if(Character.isDigit(c)){
                    perm(result, index+1, new String(temp+c), s);
                }else{
                    perm(result, index+1, new String(temp+Character.toUpperCase(c)), s);
                    perm(result, index+1, new String(temp+Character.toLowerCase(c)), s);
                }


            }


        }
    }
}
