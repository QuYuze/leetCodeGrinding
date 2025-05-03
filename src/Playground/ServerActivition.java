package Playground;

import java.awt.*;

public class ServerActivition {
    /*
    In a cloud infrastructure system, there are n servers, each with a performance score and activation status, represented by the arrays performanceScores and activationStatus. If the activation status is 1, the server is active, and 0 indicates an inactive server.

Implement a function that calculates the maximum possible total performance value of active servers by activating at most k consecutive servers.

The function getMaxPerformanceSum takes the following inputs:

int performanceScores[n]: the performance scores of the servers
int activationStatus[n]: the activation status of the servers
int k: the maximum number of consecutive servers that can be activated
The function should return the maximum possible total performance score sum by activating the servers optimally.

     */

    public static class ServerCount{
        private int count(int[] statusCode, int[] performance, int k){
            int result = 0;
            int currSum = 0;

            for(int i=0; i<k; i++){
                if(statusCode[i] == 0){
                    currSum += performance[i];
                }
            }

            int max = currSum;
            int left = 0;
            //System.out.println(max);

            for(int i=k; i<performance.length; i++){
                if (statusCode[left] == 0) {
                    currSum -= performance[left];
                    //System.out.println(currSum);

                }
                left++;
                if(statusCode[i] == 0){
                    currSum += performance[i];
                }

                max = max < currSum ? currSum : max;
            }

            //System.out.println(max);

            for (int i=0; i<statusCode.length; i++){
                if(statusCode[i]==1){
                    result += performance[i];

                }
            }

            result += max;


            return result;
        }
    }

    public static void main(String[] args){
        int[] performceScores = new int[]{7, 4, 1, 5};
        int[] activationStatus = new int[]{1, 0, 0, 0};
        int k = 2;
        ServerCount serverCount = new ServerCount();
        int result = serverCount.count(activationStatus, performceScores, k);
        assert result == 13;
        System.out.println(result);
    }
}
