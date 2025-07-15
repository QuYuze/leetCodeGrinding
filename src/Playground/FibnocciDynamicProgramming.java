package Playground;

import java.util.ArrayList;
import java.util.HashMap;

public class FibnocciDynamicProgramming {

    static int calculationTimes = 0;
    static HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args){
        FibnocciDynamicProgramming calulator = new FibnocciDynamicProgramming();
        calculationTimes = 0;
        System.out.println("Result: " + calulator.fib(20));
        System.out.println("Calculated Times: " + calculationTimes);

        calculationTimes = 0;
        System.out.println("Result: " + calulator.fibWithDynamicProgramming(20));
        System.out.println("Calculated Times: " + calculationTimes);
        System.out.println(map);
    }

    public int fib(int n){
        calculationTimes++;
        if(n < 2){
            return n;
        }else{
            return fib(n-1) + fib(n-2);
        }
    }

    public int fibWithDynamicProgramming(int n){
        calculationTimes++;
        if(map.containsKey(n)){
            return map.get(n);
        }
        if(n < 2){
            return n;
        }else{
                int result = fibWithDynamicProgramming(n-1) + fibWithDynamicProgramming(n-2);
                map.put(n, result);
                return result;

        }
    }

    class Solution {
        public int fib(int n) {
            if(n == 0){
                return 0;
            }else if(n == 1){
                return 1;
            }

            ArrayList<Integer> list = new ArrayList<>();
            int i = 2;
            list.add(0);
            list.add(1);

            while(i <= n){
                int size = list.size();
                list.add(list.get(size-1)+list.get(size-2));
                i++;
            }

            return list.get(list.size()-1);
        }
    }
}
