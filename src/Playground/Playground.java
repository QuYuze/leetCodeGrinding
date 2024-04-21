package Playground;

import java.util.ArrayList;

public class Playground {

    public static void main(String[] args){

        ArrayList<ArrayList<Integer>> test = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(1);

        ArrayList<Integer> temp2 = new ArrayList<>();
        temp2.add(1);

        test.add(temp);

        System.out.println(test.contains(temp2));
        System.out.println(temp);
        System.out.println(temp2);
    }
}
