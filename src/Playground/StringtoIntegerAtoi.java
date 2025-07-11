package Playground;

public class StringtoIntegerAtoi {
    class Solution {
        public int myAtoi(String s) {
            long result = 0;

            boolean leading = true;
            int sign = 1;

            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if(leading){
                    if(Character.isDigit(c)){
                        leading = false;
                        result = result * 10 + (c - '0');
                    }else if(c == '-'){
                        leading = false;
                        sign = -1;
                    }else if(c == '+'){
                        leading = false;
                        sign = 1;
                    }else if(c == ' '){
                        continue;
                    }else{
                        break;
                    }
                }else{
                    if(Character.isDigit(c)){


                        result = result * 10 + (c - '0');
                        if(result * sign <= Integer.MIN_VALUE){
                            return Integer.MIN_VALUE;
                        }else if(result * sign  >= Integer.MAX_VALUE){
                            return Integer.MAX_VALUE;
                        }
                    }else{
                        break;
                    }
                }



            }

            result *= sign;

            return (int) result;


        }
    }
}
