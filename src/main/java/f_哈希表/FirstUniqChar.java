package f_哈希表;

import java.util.HashMap;

/**
 * @author yang 2021-07-25 9:30
 */
public class FirstUniqChar {
    public char firstUniqChar(String s) {
        HashMap<Character, Integer> dic = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
            dic.put(s.charAt(i), dic.getOrDefault(s.charAt(i), 0) + 1);
        for (int i = 0; i < s.length(); i++) {
            if (dic.get(s.charAt(i)) == 1)
                return s.charAt(i);
        }
        return ' ';
    }
}

/*
剑指 Offer 50. 第一个只出现一次的字符
在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

示例:

s = "abaccdeff"
返回 "b"

s = ""
返回 " "
 */