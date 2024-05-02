package Playground;

public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(bs.binarySearch(nums, 4));


    }

    public int binarySearch(int[] nums, int key){
        int result = -1;
        int low = 0;
        int high = nums.length-1;

        while(low <= high){
            int mid = low + (high -low)/2;

            if(nums[mid]==key){
                result = mid;
                break;
            }else{
                if(key > nums[mid]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }

        }

        return result;
    }
}


