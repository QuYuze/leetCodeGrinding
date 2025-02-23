package Playground;

import java.util.ArrayList;

public class Playground {

    public static void main(String[] args){

        int hare = 5;
        int tortoise = 11;
        int j = 0;

        for(j=0;j<20;j++)
        {
            if(hare < tortoise)
                hare *= 2;
            else if(hare == tortoise)
                break;
            else
                tortoise += 1;
        }
        //return

        System.out.println(hare);
    }
}
