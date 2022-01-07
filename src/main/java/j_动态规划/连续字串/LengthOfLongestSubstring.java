package j_动态规划.连续字串;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yang 2021-07-20 10:18
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> dic = new HashMap<>(); //每个字符最后出现的位置
        int[] dp = new int[s.length()]; //dp[i]：以 chars[i] 结尾的最长不重复的子字符串长度。

        dp[0] = 1;
        dic.put(s.charAt(0), 0);
        for (int j = 1; j < s.length(); j++) {
            int i = dic.getOrDefault(s.charAt(j), -1); // 获取此字符串的上一个索引 i
            dic.put(s.charAt(j), j); // 更新哈希表
            if (dp[j - 1] < j - i) // 上一个重复的字符串不在 以 chars[j - 1] 结尾的最长不重复的子字符串中
                dp[j] = dp[j - 1] + 1;
            else dp[j] = j - i;
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}

/*
剑指 Offer 48. 最长不含重复字符的子字符串
https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/solution/mian-shi-ti-48-zui-chang-bu-han-zhong-fu-zi-fu-d-9/
请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。

示例 1:
输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

示例 2:
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

示例 3:
输入:  "pwwkew"
memo[]=121231
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */