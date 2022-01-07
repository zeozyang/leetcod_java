package a_数组和字符串;

/**
 * @author yang 2021-07-17 10:02
 */
public class MajorityElement {
    //摩尔投票法：核心理念为 票数正负抵消。此方法时间和空间复杂度分别为 O(N)和 O(1)，为本题的最佳解法。
    public int majorityElement(int[] nums) {
        int x = 0, votes = 0; //初始化：票数统计 votes = 0 ， 众数 x
        for (int num : nums) {
            if (votes == 0)
                x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }
}

/*
剑指offer39.出现次数超过一半的数字
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。

示例1:
输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
输出: 2
 */