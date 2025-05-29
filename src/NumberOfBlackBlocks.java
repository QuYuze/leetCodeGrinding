import java.util.HashMap;

public class NumberOfBlackBlocks {

    //https://leetcode.com/problems/number-of-black-blocks/
    class Solution {
        public long[] countBlackBlocks(int m, int n, int[][] coordinates) {
            long[] result = new long[]{(m-1L)*(n-1L), 0, 0, 0, 0};
            HashMap<Long, Integer> map = new HashMap<>();

            for(int[] coor : coordinates){
                int x = coor[0];
                int y = coor[1];


                if(x <= m-2 && y <= n-2){
                    long prod = (long) x * 100000 + y;
                    map.putIfAbsent(prod, 0);
                    int currCount = map.get(prod);

                    result[currCount]--;
                    map.put(prod, currCount+1);
                    result[currCount+1]++;
                }


                if(x-1 >= 0 && y <= n-2){
                    long prod = (long) (x-1) * 100000 + y;
                    map.putIfAbsent(prod, 0);
                    int currCount = map.get(prod);
                    result[currCount]--;
                    map.put(prod, currCount+1);
                    result[currCount+1]++;

                }

                if(y-1 >= 0 && x <= m-2){
                    long prod = (long) x * 100000 + y-1;
                    map.putIfAbsent(prod, 0);
                    int currCount = map.get(prod);
                    result[currCount]--;
                    map.put(prod, currCount+1);
                    result[currCount+1]++;

                }
                if(x-1 >= 0 && y-1 >= 0){
                    long prod = (long) (x-1) * 100000 + y-1;
                    map.putIfAbsent(prod, 0);
                    int currCount = map.get(prod);
                    result[currCount]--;
                    map.put(prod, currCount+1);
                    result[currCount+1]++;
                }
            }

            return result;
        }
    }
}
