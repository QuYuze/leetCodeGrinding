package Playground;

import java.util.HashSet;

public class firstRecurringNumber {

    int[] array1 = new int[]{2, 5, 1, 2, 3, 5, 1, 2, 4};
    int[] array2 = new int[]{2, 1, 1, 2, 3, 5, 1, 2, 4};
    int[] array3 = new int[]{2, 3, 4, 5};

    public static void main(String[] args){
        firstRecurringNumber f1 = new firstRecurringNumber();
        System.out.println(f1.firstRecurringNumber(f1.array3));
    }

    public Integer firstRecurringNumber(int[] input){
        Integer result = null;
        HashSet<Integer> set = new HashSet<Integer>();

        for(int i=0; i<input.length; i++){
            if(set.contains(input[i])){
                result = input[i];
                return result;
            }else{
                set.add(input[i]);
            }
        }

        return result;
    }
}
