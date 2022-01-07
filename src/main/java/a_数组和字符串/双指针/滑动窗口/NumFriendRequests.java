package a_数组和字符串.双指针.滑动窗口;

import java.util.Arrays;

/**
 * @author yang 2021-12-27 11:32
 */
public class NumFriendRequests { //滑动窗口
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int i = 0, j = 0, res = 0;
        for (int age : ages) {
            if (age <= 14) //难点
                continue;

            while (ages[i] <= 0.5 * age + 7) //条件1：不能比自己小太多
                i++;

            while (j < ages.length && ages[j] <= age) //条件2：不能比自己大
                j++;

            res += j - i - 1; //窗口内的所有人数减自己
        }

        return res;
    }
}

/*
825. 适龄的朋友
https://leetcode-cn.com/problems/friends-of-appropriate-ages/solution/gua-ling-de-peng-you-by-leetcode-solutio-v7yk/
在社交媒体网站上有 n 个用户。给你一个整数数组 ages ，其中 ages[i] 是第 i 个用户的年龄。
如果下述任意一个条件为真，那么用户 x 将不会向用户 y（x != y）发送好友请求：
age[y] <= 0.5 * age[x] + 7      太小了不行
age[y] > age[x]                 比自己大不行
age[y] > 100 && age[x] < 100
否则，x 将会向 y 发送一条好友请求。
注意，如果 x 向 y 发送一条好友请求，y 不必也向 x 发送一条好友请求。另外，用户不会向自己发送好友请求。
返回在该社交媒体网站上产生的好友请求总数。

示例 1：
输入：ages = [16,16]
输出：2
解释：2 人互发好友请求。

示例 2：
输入：ages = [16,17,18]
输出：2
解释：产生的好友请求为 17 -> 16 ，18 -> 17 。

示例 3：
输入：ages = [20,30,100,110,120]
输出：3
解释：产生的好友请求为 110 -> 100 ，120 -> 110 ，120 -> 100 。
 */