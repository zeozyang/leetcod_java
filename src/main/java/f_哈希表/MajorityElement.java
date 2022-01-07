package f_哈希表;

import java.util.HashMap;

/**
 * @author yang 2021-07-17 10:06
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = -1;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) * 2 >= nums.length)
                res = num;
        }
        return res;
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