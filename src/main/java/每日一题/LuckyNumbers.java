package 每日一题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yang 2022-02-15 9:41
 */
public class LuckyNumbers {
    // public List<Integer> luckyNumbers (int[][] matrix) { //retainAll api解法
    //     int m = matrix.length;
    //     int n = matrix[0].length;
    //     List<Integer> minInLine = new ArrayList<>();
    //     List<Integer> maxInRow = new ArrayList<>();
    //
    //     for (int i = 0; i < m; i++) {
    //         int min = Integer.MAX_VALUE;
    //         for (int j = 0; j < n; j++) {
    //             min = Math.min(min, matrix[i][j]);
    //         }
    //         minInLine.add(min);
    //     }
    //     for (int j = 0; j < n; j++) {
    //         int max = Integer.MIN_VALUE;
    //         for (int i = 0; i < m; i++) {
    //             max = Math.max(max, matrix[i][j]);
    //         }
    //         maxInRow.add(max);
    //     }
    //
    //     minInLine.retainAll(maxInRow);
    //     return minInLine;
    // }

    public List<Integer> luckyNumbers (int[][] matrix) { //自己用map实现的复杂度更低的解法
        int m = matrix.length;
        int n = matrix[0].length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                min = Math.min(min, matrix[i][j]);
            }
            map.put(min, 1);
        }
        for (int j = 0; j < n; j++) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                max = Math.max(max, matrix[i][j]);
            }
            map.put(max, map.getOrDefault(max, 0) + 1);
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key) == 2) {
                res.add(key);
            }
        }
        return res;
    }
}

/*
1380. 矩阵中的幸运数
给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
幸运数是指矩阵中满足同时下列两个条件的元素：
在同一行的所有元素中最小
在同一列的所有元素中最大

示例 1：
输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
输出：[15]
解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。

示例 2：
输入：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
输出：[12]
解释：12 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。

示例 3：
输入：matrix = [[7,8],[1,2]]
输出：[7]
 */