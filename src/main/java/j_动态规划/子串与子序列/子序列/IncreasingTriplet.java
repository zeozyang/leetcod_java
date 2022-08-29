package j_动态规划.子串与子序列.子序列;

/**
 * @author yang 2022-01-12 8:47
 */
public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        int[] tails = new int[nums.length]; // tails[i]：长度为 i + 1 的最长上升子序列的末尾元素的最小值

        int res = 0; // res 为 tails 当前长度
        for (int num : nums) {
            int i = 0, j = res;
            while (i < j) { // 二分查找，在tails[]中查找第一个比num大的元素下标。如果没有，i就等于tails的有效下标的下一位
                int m = (i + j) / 2;
                if (tails[m] < num)
                    i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if (res == j)
                res++;
        }
        return res >= 3;
    }
}

/*
334. 递增的三元子序列
给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。

示例 1：
输入：nums = [1,2,3,4,5]
输出：true
解释：任何 i < j < k 的三元组都满足题意

示例 2：
输入：nums = [5,4,3,2,1]
输出：false
解释：不存在满足题意的三元组

示例 3：
输入：nums = [2,1,5,0,4,6]
输出：true
解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6
 */