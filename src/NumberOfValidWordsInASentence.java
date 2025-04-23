import java.util.Arrays;

//https://leetcode.com/problems/number-of-valid-words-in-a-sentence/description/

public class NumberOfValidWordsInASentence {
    class Solution {
        public int countValidWords(String sentence) {
            int result = 0;

            String[] tokens = sentence.split("\\s+");

            System.out.println(Arrays.toString(tokens));

            for(String token: tokens){
                boolean isWord = true;

                if(check(token)){
                    result++;
                    //System.out.println(token);
                }
            }

            return result;
        }

        private boolean check(String token){

            if(token.length() == 0){
                return false;
            }

            boolean hypen = false;

            for(int i=0; i<token.length(); i++){

                char c = token.charAt(i);


                if(Character.isDigit(c)){
                    return false;
                }else if(c == '-'){

                    if(hypen){
                        return false;
                    }else if(i==0 || i == token.length()-1){
                        return false;
                    }else if(!Character.isLetter(token.charAt(i-1))){
                        return false;
                    }else if(!Character.isLetter(token.charAt(i+1))){
                        return false;
                    }

                    hypen = true;

                }else if((c == '!' || c == ',' || c == '.') && i != token.length()-1){
                    return false;
                }

            }

            return true;
        }
    }
}
