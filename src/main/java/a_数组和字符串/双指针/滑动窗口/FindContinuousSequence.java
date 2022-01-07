package a_数组和字符串.双指针.滑动窗口;

import java.util.ArrayList;

/**
 * @author yang 2021-08-03 18:13
 */
public class FindContinuousSequence {
    public int[][] findContinuousSequence(int target) { //滑动窗口
        int i = 1, j = 1, sum = 0;
        ArrayList<int[]> res = new ArrayList<>();

        while (i <= target / 2) {
            if (sum < target) {
                sum += j;
                j++; // 滑动窗口右边界右移
            } else if (sum > target) {
                sum -= i;
                i++; // 滑动窗口左边界右移
            } else {
                int[] arr = new int[j - i];
                for (int k = i; k < j; k++)
                    arr[k - i] = k;
                res.add(arr);
                sum -= i;
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}

/*
剑指 Offer 57 - II. 和为s的连续正数序列
输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

示例 1：
输入：target = 9
输出：[[2,3,4],[4,5]]

示例 2：
输入：target = 15
输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 */