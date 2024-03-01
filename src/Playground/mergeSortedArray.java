package Playground;

import java.util.Arrays;
import java.util.PriorityQueue;

public class mergeSortedArray {

    int[] array1 = new int[]{0, 3, 4, 31};
    int[] array2 = new int[]{4, 6, 30};

    public static void main(String[] args){
        mergeSortedArray p1 = new mergeSortedArray();
        int[] result = p1.mergeSortedArray(p1.array1, p1.array2);
        System.out.println(Arrays.toString(result));

        result = p1.mergeSortedArrayWithPriorityQueue(p1.array1, p1.array2);
        System.out.println(Arrays.toString(result));

    }

    public void appendTheRest(int[] result, int[] array, int i, int j){
        while(i<result.length){
            result[i] = array[j];
            j++;
            i++;
        }
    }

    public int[] mergeSortedArray(int[] array1, int[] array2){
        int lengthOfResult = array1.length + array2.length;
        int[] result = new int[lengthOfResult];

        int i = 0; //index for result array
        int j = 0;
        int k = 0;
        while(i<result.length){
            if(j<array1.length){
                if(k<array2.length){
                    if(array1[j]<array2[k]){
                        result[i] = array1[j];
                        i++;
                        j++;
                    }else{
                        result[i] = array2[k];
                        i++;
                        k++;
                    }
                }else{
                    appendTheRest(result, array1, i, j);
                    break;
                }
            }else{
                appendTheRest(result, array2, i, k);
                break;
            }

        }

        return result;
    }

    //the idea is to use priorty Queue, poll and add operations are all O(logn)
    public int[] mergeSortedArrayWithPriorityQueue(int[] array1, int[] arr2){
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        int[] result = new int[array1.length+array2.length];
        int i=0;
        int j=0;
        while(i<array1.length){
            queue.add(array1[i]);
            i++;
        }
        while(j<array2.length){
            queue.add(array2[j]);
            j++;
        }
        int k=0;
        while(!queue.isEmpty()){

            result[k] = queue.poll();
            k++;
        }
        return  result;
    }
}
