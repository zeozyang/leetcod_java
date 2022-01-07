package c_栈和队列.栈;

import java.util.Stack;

/**
 * @author yang 2021-10-13 8:58
 */
public class BackspaceCompare {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != '#') stackS.push(c);
            else if (!stackS.isEmpty()) stackS.pop();
        }
        for (char c : t.toCharArray()) {
            if (c != '#') stackT.push(c);
            else if (!stackT.isEmpty()) stackT.pop();
        }
        return stackS.equals(stackT);
    }
}


/*
主站 844. 比较含退格的字符串
给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，请你判断二者是否相等。# 代表退格字符。
如果相等，返回 true ；否则，返回 false 。
注意：如果对空文本输入退格字符，文本继续为空。

示例 1：
输入：s = "ab#c", t = "ad#c"
输出：true
解释：S 和 T 都会变成 “ac”。

示例 2：
输入：s = "ab##", t = "c#d#"
输出：true
解释：s 和 t 都会变成 “”。
 */