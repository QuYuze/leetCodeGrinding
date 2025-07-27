public class RandomPickWithWeight {
    class Solution {

        int[] prefix;
        int total;

        public Solution(int[] w) {
            total = 0;
            prefix = new int[w.length];
            for(int i=0; i<w.length; i++){
                total += w[i];
                prefix[i] = total;
            }
        }

        public int pickIndex() {
            int target = (int) (Math.random() * total) + 1;
            int left = 0;
            int right = prefix.length - 1;

            while(left < right){
                int mid = left + (right - left) / 2;

                if(prefix[mid] >= target){
                    right = mid;
                }else{
                    left = mid + 1;
                }
            }

            return left;

        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
}
