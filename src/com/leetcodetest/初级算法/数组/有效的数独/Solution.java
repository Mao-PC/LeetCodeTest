package com.leetcodetest.初级算法.数组.有效的数独;

class Solution {
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            char[] chars = board[i];
            char[] otherChars = getOtherChars(chars);
            for (int j = 0; j < chars.length; j++) {

            }
        }

        return false;
    }

    private char[] getOtherChars(char[] chars) {
        char[] allChars = new char[] {'1','2','3','4','5','6','7','8','9'};

        for (int i = 0; i < chars.length; i++) {
            if ('.' != chars[i]) {
                allChars[chars[i]-48] = '0';
            }
        }

        String allStr = "";

        for (int i = 0; i < allChars.length; i++) {
            allStr += allChars[i] + "";
        }

        return allStr.replace("0", "").toCharArray();
    }
}

class Test {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        Solution solution = new Solution();
        System.out.println(solution.isValidSudoku(board));

        board = new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(solution.isValidSudoku(board));
    }
}