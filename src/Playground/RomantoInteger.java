package Playground;

public class RomantoInteger {
    class Solution {
        public int romanToInt(String s) {

            int result = 0;
            int i=s.length()-1;

            while(i>=0){
                char c = s.charAt(i);

                if(c == 'I'){
                    result++;
                }else if(c == 'V'){
                    result += 5;
                    if(i-1 >=0 && s.charAt(i-1) == 'I'){
                        result--;
                        i--;
                    }

                }else if(c == 'X'){
                    result += 10;
                    if(i-1 >=0 && s.charAt(i-1) == 'I'){
                        result--;
                        i--;
                    }
                }else if(c == 'L'){
                    result += 50;
                    if(i-1 >=0 && s.charAt(i-1) == 'X'){
                        result-=10;
                        i--;
                    }
                }else if(c == 'C'){
                    result += 100;
                    if(i-1 >=0 && s.charAt(i-1) == 'X'){
                        result-=10;
                        i--;
                    }
                }else if(c == 'D'){
                    result += 500;
                    if(i-1 >=0 && s.charAt(i-1) == 'C'){
                        result-=100;
                        i--;
                    }
                }else if(c == 'M'){
                    result += 1000;
                    if(i-1 >=0 && s.charAt(i-1) == 'C'){
                        result-=100;
                        i--;
                    }
                }
                i--;
            }

            return result;
        }
    }
}
