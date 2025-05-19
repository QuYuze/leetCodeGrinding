package Playground;

import java.util.Arrays;

public class MaxSwap {
    class Solution {
        public int maximumSwap(int num) {
            int result = 0;

            String str = Integer.toString(num);
            int[] suffix = new int[str.length()];


            int currMax = -1;
            int maxIndex = -1;

            for(int i=str.length()-1; i>=0; i--){
                char c = str.charAt(i);
                int curr = Character.getNumericValue(c);
                if(curr > currMax){
                    currMax = curr;
                    maxIndex = i;
                    suffix[i] = maxIndex;
                }else if(curr == currMax){
                    suffix[i] = i;
                }else{
                    suffix[i] = maxIndex;
                }

            }

            String output= "";
            int i= 0;
            System.out.println(Arrays.toString(suffix));

            while(output.length() < str.length()){
                char c = str.charAt(i);
                if(suffix[i] == i){
                    output += c;
                    i++;
                }else{
                    int position = suffix[i];

                    output += str.charAt(position);
                    //System.out.println(output);
                    char swapped = c;
                    i++;
                    while(output.length() < str.length()){
                        if(i==position){
                            output += swapped;
                        }else{
                            output += str.charAt(i);
                        }
                        i++;
                    }
                }
            }

            result = Integer.parseInt(output);

            return result;
        }
    }
}
