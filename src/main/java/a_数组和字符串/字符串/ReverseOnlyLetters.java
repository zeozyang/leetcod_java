package a_数组和字符串.字符串;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author yang 2022-02-23 8:54
 */
public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        StringBuilder charList = new StringBuilder();
        Deque<Integer> indexList = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                charList.append(s.charAt(i));
                indexList.addLast(i);
            }
        }
        StringBuilder reverse = charList.reverse();
        int i = 0;
        for (Integer index : indexList) {
            chars[index] = reverse.charAt(i);
            i++;
        }
        return String.valueOf(chars);
    }
}

/*
917. 仅仅反转字母
给你一个字符串 s ，根据下述规则反转字符串：
所有非英文字母保留在原有位置。
所有英文字母（小写或大写）位置反转。
返回反转后的 s 。

示例 1：
输入：s = "ab-cd"
输出："dc-ba"

示例 2：
输入：s = "a-bC-dEf-ghIj"
输出："j-Ih-gfE-dCba"

示例 3：
输入：s = "Test1ng-Leet=code-Q!"
输出："Qedo1ct-eeLg=ntse-T!"
 */