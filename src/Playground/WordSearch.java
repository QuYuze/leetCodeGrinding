package Playground;
//https://leetcode.com/problems/word-search/solutions/4965052/96-45-easy-solution-with-explanation
public class WordSearch {

    class Solution {
        public boolean exist(char[][] board, String word) {

            boolean result = false;

            for(int i=0; i<board.length; i++){
                for(int j=0; j<board[0].length; j++){
                    if(board[i][j] == word.charAt(0)){
                        result = backtrack(board, word, i, j, 0);
                        if(result){
                            return result;
                        }
                    }

                }
            }

            return result;

        }

        private boolean backtrack(char[][] board, String word, int row, int col, int k){


            if(row<0||col<0||row>=board.length||col>=board[0].length||word.charAt(k) != board[row][col]||board[row][col]=='.'){
                return false;

            }else{
                if(k==word.length()-1){
                    return true;
                }

                char temp = board[row][col];
                board[row][col] = '.';

                boolean result =
                        backtrack(board, word, row+1, col, k+1) ||
                                backtrack(board, word, row-1, col, k+1) ||
                                backtrack(board, word, row, col+1, k+1) ||
                                backtrack(board, word, row, col-1, k+1);
                board[row][col] = temp;
                return result;
            }



        }
    }
}
