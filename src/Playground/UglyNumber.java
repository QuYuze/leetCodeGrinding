package Playground;

import java.util.ArrayList;
import java.util.HashSet;

public class UglyNumber {
    class Solution {
        public int nthUglyNumber(int n) {
            int result = 0;
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);

            int i = 0;
            int j = 0;
            int k = 0;
            HashSet<Integer> set = new HashSet<>();


            while(list.size()<n){
                int product2 = list.get(i)*2;
                int product3 = list.get(j)*3;
                int product5 = list.get(k)*5;
                int curr = Math.min(product2, Math.min(product3, product5));

                if(!set.contains(curr)){
                    list.add(curr);
                    set.add(curr);
                }


                if(curr == product2){
                    i++;
                }else if(curr == product3){
                    j++;
                }else{
                    k++;
                }
            }

            result = list.get(list.size()-1);
            System.out.println(list.toString());

            return result;
        }
    }
}
