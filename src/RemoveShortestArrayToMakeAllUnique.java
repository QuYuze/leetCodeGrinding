public class RemoveShortestArrayToMakeAllUnique {
    /*
    Given an array arr[] containing N elements,
    the task is to remove a subarray of minimum possible length from the given array
    such that all remaining elements are distinct.
    Print the minimum possible length of the subarray.
     */
    public static class Solution{

        private int shortestArray(int[] nums){
            int result = 0;

            return  result;
        }

    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] a = new int[]{1, 2, 1, 2, 3};
        System.out.println("expected: 2, actual: " + solution.shortestArray(a));
        int[] b = new int[]{1, 2, 3, 4, 5};
        System.out.println("expected: 0, actual: " + solution.shortestArray(b));
    }
}
