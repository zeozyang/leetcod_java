package f_哈希表;

import java.util.HashMap;

/**
 * @author yang 2022-01-19 8:47
 */
public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); //某个数最后出现的下标
        for (int i = 0; i < nums.length; i++) {
            Integer lastIndex = map.getOrDefault(nums[i], i);
            if (i != lastIndex && i - lastIndex <= k)
                return true;
            map.put(nums[i], i);
        }
        return false;
    }
}

/*
219. 存在重复元素 II 简单
给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。

示例 1：
输入：nums = [1,2,3,1], k = 3
输出：true

示例 2：
输入：nums = [1,0,1,1], k = 1
输出：true

示例 3：
输入：nums = [1,2,3,1,2,3], k = 2
输出：false
 */