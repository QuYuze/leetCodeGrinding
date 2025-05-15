package Playground;

//https://leetcode.com/problems/minimum-time-to-repair-cars/

public class MinimumTimeToRepairCar {
    class Solution {
        public long repairCars(int[] ranks, int cars) {
            long result = 0;
            int max = 0;

            for(int r : ranks){
                max = max < r ? r : max;
            }

            long left = 1;
            long right = (long) max * (long) Math.pow(cars, 2);

            while(left < right){
                long mid = left + (right - left)/2;
                int repaired = cars(ranks, mid);

                if(repaired >= cars){
                    right = mid;
                }else if(repaired < cars){
                    left = mid+1;
                }
            }



            return (long) left;
        }

        private int cars(int[] ranks, long min){
            int result = 0;

            for(int r: ranks){
                result += Math.sqrt(min/r);
            }
            return result;
        }
    }
}
