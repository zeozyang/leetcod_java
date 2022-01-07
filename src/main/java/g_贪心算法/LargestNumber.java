package g_贪心算法;

import java.util.Arrays;

/**
 * @author yang 2021-12-17 14:06
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strings[i] = Integer.toString(nums[i]);

        Arrays.sort(strings, (x, y) -> (y + x).compareTo(x + y));
        StringBuilder sb = new StringBuilder();
        for (String string : strings)
            sb.append(string);
        String res = sb.toString();
        return res.toCharArray()[0] == '0' ? "0" : res;
    }
}


/*
179. 最大数
给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。

示例 1：
输入：nums = [10,2]
输出："210"

示例 2：
输入：nums = [3,30,34,5,9]
输出："9534330"

示例 3：
输入：nums = [1]
输出："1"

示例 4：
输入：nums = [10]
输出："10"
 */