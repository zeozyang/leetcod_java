package i_回溯算法.DFS;

/**
 * @author yang 2021-07-16 20:38
 */
public class Exist {
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, chars, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    /**
     * @param board 单词矩阵
     * @param word  要查找的是否在字符串中的单词
     * @param i     当前行索引
     * @param j     当前纵索引
     * @param k     当前目标字符在 word 中的索引
     * @return      word是否存在于网格中
     */
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word[k])
            return false;
        if (k == word.length - 1)
            return true;
        board[i][j] = '\0';
        boolean res = dfs(board, word, i - 1, j, k + 1)
                || dfs(board, word, i + 1, j, k + 1)
                || dfs(board, word, i, j - 1, k + 1)
                || dfs(board, word, i, j + 1, k + 1); // 上下左右
        board[i][j] = word[k]; // 回溯
        return res;
    }
}

/*
剑指 Offer 12. 矩阵中的路径
https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/solution/mian-shi-ti-12-ju-zhen-zhong-de-lu-jing-shen-du-yo/
给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word存在于网格中，返回 true ；否则，返回 false 。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。

示例 1：
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
输出：true

示例 2：
输入：board = [["a","b"],["c","d"]], word = "abcd"
输出：false
 */
