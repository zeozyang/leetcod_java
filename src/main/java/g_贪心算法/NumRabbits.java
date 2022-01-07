package g_贪心算法;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yang 2021-12-23 10:55
 */
public class NumRabbits {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>(); //key：各种答案。value：回答此答案的兔子只数。
        for (int answer : answers)
            map.put(answer, map.getOrDefault(answer, 0) + 1);

        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int x = entry.getKey(), y = entry.getValue();
            if (y % (x + 1) == 0)
                ans += y;
            else ans += (y / (x + 1) + 1) * (x + 1);
        }
        return ans;
    }
}

/*
781. 森林中的兔子
森林中有未知数量的兔子。提问其中 若干只 兔子 "还有多少只兔子与你（指被提问的兔子）颜色相同?" ，将答案收集到一个整数数组 answers 中，其中 answers[i] 是第 i 只兔子的回答。
给你数组 answers ，返回森林中兔子的最少数量。
[0,0,0] 3种颜色，3只兔子
[1,1,1] 2种颜色，3只兔子
[2,2,2,2] 2种颜色，6只兔子

示例 1：
输入：answers = [1,1,2]
输出：5
解释：
两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
设回答了 "2" 的兔子为蓝色。
此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
因此森林中兔子的最少数量是 5 只：3 只回答的和 2 只没有回答的。

示例 2：
输入：answers = [10,10,10]
输出：11
 */
