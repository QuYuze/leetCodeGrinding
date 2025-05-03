package Playground;

public class KokoEatsBanana {
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int left = 1;
            int right = 0;

            for(int pile: piles){
                right = Math.max(pile, right);
            }

            while(left < right){
                int mid = left + (right - left) / 2;
                if(canEat(piles, h, mid)){
                    right = mid;
                }else{
                    left = mid+1;
                }
            }

            return left;

        }

        private boolean canEat(int[] piles, int h, int k){
            int hours = 0;
            for(int pile : piles){
                hours += (pile + k -1) / k;
            }
            return hours <= h;
        }
    }
}
