package a_数组和字符串.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yang 2021-11-19 10:25
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重，这句我自己没想起来，抄的

            int towSum = -nums[i]; // 两数之和
            int L = i + 1, R = nums.length - 1; // 两数之和的左右指针

            while (L < R) {
                if (nums[L] + nums[R] < towSum) L++;
                else if (nums[L] + nums[R] > towSum) R--;
                else {
                    res.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    // 找到了一个解之后，将左指针往右移到第一个与当前值不同的值上，去找其他的解
                    while (L < R && nums[L] == nums[L + 1]) L++; // L < R 抄的
                    L++;
                }
            }
        }
        return res;
    }
}

/*
15. 三数之和
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
注意：答案中不可以包含重复的三元组。

示例 1：
输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]

示例 2：
输入：nums = []
输出：[]

示例 3：
输入：nums = [0]
输出：[]
 */