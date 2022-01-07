package a_数组和字符串.双指针;

/**
 * @author yang 2021-08-03 17:19
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) { //首尾双指针
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            if (nums[i] + nums[j] < target) i++;
            else if (nums[i] + nums[j] > target) j--;
            else return new int[]{nums[i], nums[j]};
        }
        return new int[0];
    }
}

/*
剑指 Offer 57. 和为s的两个数字
输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。

示例 1：
输入：nums = [2,7,11,15], target = 9
输出：[2,7] 或者 [7,2]
 */