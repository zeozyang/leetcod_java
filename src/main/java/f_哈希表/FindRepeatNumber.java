package f_哈希表;

import java.util.HashSet;

/**
 * @author yang 2021-07-10 16:04
 */
public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        int res = -1;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                res = num;
                break;
            }
        }
        return res;
    }
}

/*
    剑指 Offer 03. 数组中重复的数字
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 */