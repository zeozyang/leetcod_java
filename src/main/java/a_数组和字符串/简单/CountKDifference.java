package a_数组和字符串.简单;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yang 2022-02-09 11:22
 */
public class CountKDifference {
    public int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); //不同数值出现的频率
        int res = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            res += map.getOrDefault(num - k, 0) + map.getOrDefault(num + k, 0);
        }
        return res;
    }
}

/*
2006. 差的绝对值为 K 的数对数目
给你一个整数数组 nums 和一个整数 k ，请你返回数对 (i, j) 的数目，满足 i < j 且 |nums[i] - nums[j]| == k 。
 */