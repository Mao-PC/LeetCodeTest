package com.leetcodetest.初级算法.数组.有效的数独;

import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {

        char[][][] probableChars = new char[9][9][];

        for (int i = 0; i < board.length; i++) {
            char[] boardRow = board[i];
            for (int j = 0; j < boardRow.length; j++) {
                if ('.' == boardRow[j]) {
                    // 横向
                    char[] rowOthers = getOtherChars(board[j]);
                    // 竖向
                    char[] colNums = new char[9];
                    for (int k = 0; k < 9; k++) {
                        colNums[k] = board[k][j];
                    }
                    char[] colOthers = getOtherChars(colNums);
                    // 3*3
                    char[] nightOthers = getOtherChars(get33Chars(i, j, board));
                    char[] sameChars = getSameChars(rowOthers, colOthers, nightOthers);
                    if (sameChars.length == 0) {
                        return false;
                    } else if (sameChars.length == 1) {
                        reduceProbobles(board, i, j, sameChars[0], probableChars);
                    } else {
                        probableChars[i][j] = sameChars;
                        if (!checkArr(i, j, probableChars)) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    /**
     * 减少可能性, 去除掉已经可以确定的值
     *
     * @param board
     * @param i
     * @param j
     * @param sameChar
     * @param probableChars
     */
    private void reduceProbobles(char[][] board, int i, int j, char sameChar, char[][][] probableChars) {
        board[i][j] = sameChar;

        // 横向
        char[][] row = probableChars[i];
        if (row != null) {
            for (int n = 0; n < row.length; n++) {
                if (row[n] != null && row[n].length > 0) {
                    String res = "";
                    for (int k = 0; k < row[n].length; k++) {
                        if (row[n][k] != sameChar) {
                            res += row[n][k];
                        }
                    }
                    if (res.length() == 1) {
                        probableChars[i][n] = null;
                        reduceProbobles(board, i, n, res.toCharArray()[0], probableChars);
                    } else {
                        probableChars[i][n] = res.toCharArray();
                    }
                }
            }
        }

        // 纵向
        for (int m = 0; m < probableChars.length; m++) {
            if (probableChars[m][j] == null) continue;
            for (int n = 0; n < probableChars[m][j].length; n++) {
                if (probableChars[m][n] != null && probableChars[m][n].length > 0) {
                    String res = "";
                    for (int k = 0; k < probableChars[m][n].length; k++) {
                        if (probableChars[m][n][k] != sameChar) {
                            res += probableChars[m][n][k];
                        }
                    }
                    if (res.length() == 1) {
                        probableChars[m][j] = null;
                        reduceProbobles(board, m, j, res.toCharArray()[0], probableChars);
                    } else {
                        probableChars[m][j] = res.toCharArray();
                    }
                }
            }
        }

        // 3*3
        for (int m = 0; m < getIndex(i); m++) {
            for (int n = 0; n < getIndex(j); n++) {
                if (probableChars[m][n] != null && probableChars[m][n].length > 0) {
                    String res = "";
                    for (int k = 0; k < probableChars[m][n].length; k++) {
                        if (probableChars[m][n][k] != sameChar) {
                            res += probableChars[m][n][k];
                        }
                    }
                    if (res.length() == 1) {
                        probableChars[m][n] = null;
                        reduceProbobles(board, m, n, res.toCharArray()[0], probableChars);
                    } else {
                        probableChars[m][n] = res.toCharArray();
                    }
                }
            }
        }
    }

    /**
     * 如果本行/列/3*3 所包含所有数字可能性比位置要少的话, 说明不是有效的数独, 如, 所有不重复的数字有 1,2,4 但是有 4 个位置需要填写的情况
     *
     * @param i
     * @param j
     * @param probableChars
     * @return
     */
    private boolean checkArr(int i, int j, char[][][] probableChars) {
        HashSet<Character> set = new HashSet<>();

        int emptyNums = 0;

        // 横向
        for (int m = 0; m < probableChars[i].length; m++) {
            if (probableChars[i][m] != null && probableChars[i][m].length > 0) {
                emptyNums++;
                for (int n = 0; n < probableChars[i][m].length; n++) {
                    set.add(probableChars[i][m][n]);
                }
            }
        }
        if (set.size() < emptyNums) return false;

        set.clear();
        emptyNums = 0;

        // 纵向
        for (int m = 0; m < probableChars.length; m++) {
            if (probableChars[m][j] != null && probableChars[m][j].length > 0) {
                emptyNums++;
                for (int n = 0; n < probableChars[m][j].length; n++) {
                    set.add(probableChars[m][j][n]);
                }
            }
        }
        if (set.size() < emptyNums) return false;

        set.clear();
        emptyNums = 0;

        // 3*3
        for (int m = getIndex(i); m < getIndex(i) + 3; m++) {
            for (int n = getIndex(j); n < getIndex(j) + 3; n++) {
                if (probableChars[m][n] != null && probableChars[m][n].length > 0) {
                    emptyNums++;
                    for (int k = 0; k < probableChars[m][n].length; k++) {
                        set.add(probableChars[m][n][k]);
                    }
                }
            }
        }
        if (set.size() < emptyNums) return false;

        return true;
    }

    private char[] getSameChars(char[] rowOthers, char[] colOthers, char[] nightOthers) {
        String res = "";
        String res1 = "";
        for (int i = 0; i < rowOthers.length; i++) {
            for (int j = 0; j < colOthers.length; j++) {
                if (rowOthers[i] == colOthers[j]) {
                    res1 += rowOthers[i];
                }
            }
        }
        if (res1.length() > 0) {
            for (int i = 0; i < nightOthers.length; i++) {
                for (int j = 0; j < res1.length(); j++) {
                    if (nightOthers[i] == res1.charAt(j)) {
                        res += nightOthers[i];
                    }
                }
            }
        }
        return res.toCharArray();
    }

    private char[] get33Chars(int i, int j, char[][] board) {
        char[] res = new char[9];
        int k = 0;
        int i1 = getIndex(i);
        int j1 = getIndex(j);
        for (int m = i1; m < i1 + 3; m++) {
            for (int n = j1; n < j1 + 3; n++) {
                res[k] = board[n][m];
                k++;
            }
        }
        return res;
    }

    private int getIndex(int i) {
        if (i < 3) {
            return 0;
        } else if (i >= 3 && i < 6) {
            return 3;
        } else {
            return 6;
        }
    }

    private char[] getOtherChars(char[] chars) {
        char[] allChars = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};

        for (int i = 0; i < chars.length; i++) {
            if ('.' != chars[i] && '\u0000' != chars[i]) {
                allChars[chars[i] - 49] = '0';
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