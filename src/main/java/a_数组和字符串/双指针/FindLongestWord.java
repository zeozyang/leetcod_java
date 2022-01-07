package a_数组和字符串.双指针;

import java.util.List;

/**
 * @author yang 2021-12-23 9:52
 */
public class FindLongestWord {
    public String findLongestWord(String s, List<String> dictionary) {
        dictionary.sort((x, y) -> {
            if (x.length() != y.length()) return -(x.length() - y.length());
            return x.compareTo(y);
        });

        for (String word : dictionary) { // 上下双指针
            int i = 0, j = 0;
            while (i < s.length() && j < word.length()) {
                if (s.charAt(i) == word.charAt(j)) j++;
                i++;
            }
            if (j == word.length()) return word;
        }
        return "";
    }
}

/*
524. 通过删除字母匹配到字典里最长单词
给你一个字符串 s 和一个字符串数组 dictionary ，找出并返回 dictionary 中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
如果答案不止一个，返回长度最长且字母序最小的字符串。如果答案不存在，则返回空字符串。

示例 1：
输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
输出："apple"

示例 2：
输入：s = "abpcplea", dictionary = ["a","b","c"]
输出："a"
 */