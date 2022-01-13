package 每日一题;

/**
 * @author yang 2022-01-13 9:11
 */
public class DominantIndex {
    public int dominantIndex(int[] nums) { // 本题难点在于之前并没有在找数组最大值的过程中记录下标过
        int max1 = -1, max2 = -1; //最大值和次大值
        int index = -1; //最大值下标
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max1) {
                max2 = max1;
                max1 = nums[i];
                index = i;
            } else if (nums[i] > max2) {
                max2 = nums[i];
            }
        }
        return max1 >= max2 * 2 ? index : -1;
    }
}

/*
747. 至少是其他数字两倍的最大数    简单题
给你一个整数数组 nums ，其中总是存在 唯一的 一个最大整数 。
请你找出数组中的最大元素并检查它是否 至少是数组中每个其他数字的两倍 。如果是，则返回 最大元素的下标 ，否则返回 -1 。

示例 1：
输入：nums = [3,6,1,0]
输出：1
解释：6 是最大的整数，对于数组中的其他整数，6 大于数组中其他元素的两倍。6 的下标是 1 ，所以返回 1 。

示例 2：
输入：nums = [1,2,3,4]
输出：-1
解释：4 没有超过 3 的两倍大，所以返回 -1 。

示例 3：
输入：nums = [1]
输出：0
解释：因为不存在其他数字，所以认为现有数字 1 至少是其他数字的两倍。
 */