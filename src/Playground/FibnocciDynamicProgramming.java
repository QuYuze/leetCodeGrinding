package Playground;

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
}
