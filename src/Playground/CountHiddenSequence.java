package Playground;

//https://leetcode.com/problems/count-the-hidden-sequences/
public class CountHiddenSequence {
    class Solution {
        public int numberOfArrays(int[] differences, int lower, int upper) {
            long min = 0;
            long sum = 0;
            long max = 0;

            for(int i=0; i<differences.length; i++){
                sum += differences[i];
                min = min < sum ? min : sum;
                max = max < sum ? sum : max;
            }

            if(lower-min > upper-max){
                return 0;
            }

            return (int)((upper -lower) - (max - min) + 1);
        }
    }
}
