package Playground;


//https://leetcode.com/problems/determine-color-of-a-chessboard-square/description/

public class DeterminColorOfChessboardSquare {
    class Solution {
        public boolean squareIsWhite(String coordinates) {

            int row = Character.getNumericValue(coordinates.charAt(1)) - 1;
            char colName = coordinates.charAt(0);
            int col = colName - 'a';

            if(row%2 == 0){
                if(col%2==0){
                    return false;
                }else{
                    return true;
                }
            }else{
                if(col%2==0){
                    return true;
                }else{
                    return false;
                }
            }
        }
    }
}
