package a_数组和字符串;

import java.util.HashSet;

/**
 * @author yang 2021-08-04 15:19
 */
public class IsStraight {
    public boolean isStraight(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int min = 14, max = 0;
        for (int num : nums) {
            if (num == 0) continue;
            max = Math.max(max, num);
            min = Math.min(min, num);
            if (!set.add(num)) return false;
        }
        return max - min < 5;
    }
}

/*
剑指 Offer 61. 扑克牌中的顺子
从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。

示例 1:
输入: [1,2,3,4,5]
输出: True

示例 2:
输入: [0,0,1,2,5]
输出: True
 */