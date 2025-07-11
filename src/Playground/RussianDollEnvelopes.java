package Playground;

import java.util.ArrayList;
import java.util.Arrays;

public class RussianDollEnvelopes {
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            Arrays.sort(envelopes, (a, b) -> a[0]==b[0] ? b[1]-a[1] : a[0]-b[0]);
            ArrayList<Integer> result = new ArrayList<>();

            for(int[] pair : envelopes){
                binarySearch(result, pair[1]);
            }



            return result.size();

        }

        private void binarySearch(ArrayList<Integer> list, int val){
            if(list.isEmpty()){
                list.add(val);
                return;
            }else if(list.get(list.size()-1) < val){
                list.add(val);
                return;
            }else{
                int left = 0;
                int right = list.size()-1;

                while(left <= right){
                    int mid = left + (right - left) / 2;
                    if(list.get(mid)  == val){
                        return;
                    }else if(list.get(mid) > val){
                        right = mid - 1;
                    }else{
                        left = mid + 1;
                    }
                }

                list.set(left, val);
            }



        }
    }
}
