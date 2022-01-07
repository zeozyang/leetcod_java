package i_回溯算法.困难;

import java.util.*;

/**
 * @author yang 2021-11-15 14:08
 */
public class NQueens {
    private int n;
    private Set<Integer> col; //记录某一列是否放置了皇后
    private Set<Integer> main; //记录主对角线上的单元格是否放置了皇后
    private Set<Integer> sub; //记录了副对角线上的单元格是否放置了皇后
    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        if (n == 0) return res;

        // 设置成员变量，减少参数传递，具体作为方法参数还是作为成员变量，请参考团队开发规范
        this.n = n;
        col = new HashSet<>();
        main = new HashSet<>();
        sub = new HashSet<>();
        Deque<Integer> path = new ArrayDeque<>(); //一个解，path[i]表示第i行的皇后放在第i行第path[i]列

        dfs(0, path);
        return res;
    }

    void dfs(int row, Deque<Integer> path) {
        if (row == n) {
            // 深度优先遍历到下标为 n，表示 [0.. n - 1] 已经填完，得到了一个结果
            List<String> board = convert2board(path);
            res.add(board);
            return;
        }

        // 针对每一列，尝试是否可以放置
        for (int i = 0; i < n; i++) {
            if (!col.contains(i) && !main.contains(row - i) && !sub.contains(row + i)) {
                path.addLast(i);
                col.add(i);
                main.add(row - i);
                sub.add(row + i);

                dfs(row + 1, path);

                sub.remove(row + i);
                main.remove(row - i);
                col.remove(i);
                path.removeLast();
            }
        }
    }

    List<String> convert2board(Deque<Integer> path) {
        List<String> board = new ArrayList<>();
        for (Integer num : path) {
            StringBuilder row = new StringBuilder();
            row.append(".".repeat(Math.max(0, n)));
            row.replace(num, num + 1, "Q");
            board.add(row.toString());
        }
        return board;
    }
}

/*
51. N 皇后
n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
每一种解法包含一个不同的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

示例 1：
输入：n = 4
输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
解释：如上图所示，4 皇后问题存在两个不同的解法。

示例 2：
输入：n = 1
输出：[["Q"]]

提示：
1 <= n <= 9
皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 */