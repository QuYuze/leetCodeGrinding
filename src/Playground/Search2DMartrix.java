package Playground;

//https://leetcode.com/problems/search-a-2d-matrix/description/
public class Search2DMartrix {
    class Solution {

        public boolean searchMatrix(int[][] matrix, int target) {

            int m = matrix.length;
            int n = matrix[0].length;
            int low = 0;
            int high = m*n-1;

            while(low <= high){
                int mid = low + (high -low)/2;
                int midRow = mid/n;
                int midCol = mid%n;

                int curr = matrix[midRow][midCol];

                if(curr == target){
                    return true;
                }else if(curr < target){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }


            return false;

        }
    }
}
