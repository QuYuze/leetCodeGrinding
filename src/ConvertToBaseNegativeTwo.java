public class ConvertToBaseNegativeTwo {

    //https://leetcode.com/problems/convert-to-base-2/
    class Solution {
        public String baseNeg2(int n) {

            String binary = "";
            if(n == 0){
                return "0";
            }

            while(n!=0){
                int last = n%(-2);
                if(last < 0){
                    last += 2;
                    n--;
                }
                binary = last + binary;
                n /= (-2);
            }

            return binary;

        }
    }
}
