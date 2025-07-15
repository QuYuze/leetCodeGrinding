package Playground;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LoggerRateLimiter {



    public static void main(String[] args){
        Limiter limiter = new Limiter();
        List<Pair<Integer, String>> list = new ArrayList<>();
        list.add(new Pair<Integer, String>(1, "foo"));
        list.add(new Pair<Integer, String>(2, "boo"));
        list.add(new Pair<Integer, String>(3, "foo"));
        list.add(new Pair<Integer, String>(11, "foo"));
        for(Pair<Integer, String> pair : list){
            System.out.println(limiter.shouldPrintMessage(pair.getKey(), pair.getValue()));
        }
    }
}

class Limiter{
    HashMap<String, Integer> map = new HashMap<>();
    public boolean shouldPrintMessage(int time, String message){

        if(map.containsKey(message)){
            if(map.get(message) + 10 > time){
                return false;
            }
        }
        //System.out.println(map.get(message));
        map.put(message, time);

        return true;
    }
}
