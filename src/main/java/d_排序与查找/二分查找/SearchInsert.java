package d_排序与查找.二分查找;

/**
 * @author yang 2022-01-12 15:13
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        if (target > nums[nums.length - 1])
            return nums.length;

        int l = 0, r = nums.length - 1;
        while (l <= r) { // 找第一个大于等于target的元素下标
            int m = (l + r) / 2;
            if (nums[m] >= target) {
                if (m == 0 || nums[m - 1] < target)
                    return m;
                else
                    r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    public int searchInsert2(int[] nums, int target) {
        int i = 0, j = nums.length;
        while (i < j) { // 找第一个大于等于target的元素下标
            int m = (i + j) / 2;
            if (nums[m] < target)
                i = m + 1;
            else j = m;
        }
        return i;
    }
}

/*
35. 搜索插入位置
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
请必须使用时间复杂度为 O(log n) 的算法。nums 为无重复元素的升序排列数组
https://leetcode-cn.com/problems/search-insert-position/solution/te-bie-hao-yong-de-er-fen-cha-fa-fa-mo-ban-python-/

示例 1:
输入: nums = [1,3,5,6], target = 5
输出: 2

示例 2:
输入: nums = [1,3,5,6], target = 2
输出: 1

示例 3:
输入: nums = [1,3,5,6], target = 7
输出: 4

示例 4:
输入: nums = [1,3,5,6], target = 0
输出: 0

示例 5:
输入: nums = [1], target = 0
输出: 0
 */