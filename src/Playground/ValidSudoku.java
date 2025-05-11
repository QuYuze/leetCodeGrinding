package Playground;

import java.util.HashSet;

//https://leetcode.com/problems/valid-sudoku/solutions/6592260/valid-sudoku-a-hashmap-approach-with-matrix-flattening-technique/

public class ValidSudoku {
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            HashSet<Character>[] colSets = new HashSet[9];
            HashSet<Character>[] rowSets = new HashSet[9];
            HashSet<Character>[] boxSets = new HashSet[9];

            //System.out.println(colSets[0]);

            for(int i=0; i<board.length; i++){
                for(int j=0; j<board[0].length; j++){
                    char c = board[i][j];

                    if(c == '.'){
                        continue;
                    }

                    if(colSets[j]==null){
                        colSets[j] = new HashSet<>();
                    }

                    if(colSets[j].contains(c)){
                        return false;
                    }else{
                        colSets[j].add(c);
                    }

                    if(rowSets[i]==null){
                        rowSets[i] = new HashSet<>();
                    }

                    if(rowSets[i].contains(c)){
                        return false;
                    }else{
                        rowSets[i].add(c);
                    }

                    int subBoxNum = 3*(i/3) + j/3;

                    if(boxSets[subBoxNum]==null){
                        boxSets[subBoxNum] = new HashSet<>();
                    }

                    if(boxSets[subBoxNum].contains(c)){
                        return false;
                    }else{
                        boxSets[subBoxNum].add(c);
                    }
                }
            }

            return true;

        }
    }
}
