package g_贪心算法;

/**
 * @author yang 2021-12-17 15:31
 */
public class IntegerReplacement {
    public int integerReplacement(int n) {
        int count = 0;
        while (n != 1) {
            if ((n & 1) == 0) //如果二进制末尾是0，就除2
                n >>= 1;
            else {
                if ( n != 3 && ((n >> 1) & 1) == 1) //只要次低位为 1（存在连续段），应当优先使用 +1 操作
                    n++;
                else n--;
            }
            count++;
        }
        return count;
    }
}

/*
397. 整数替换
https://leetcode-cn.com/problems/integer-replacement/solution/gong-shui-san-xie-yi-ti-san-jie-dfsbfs-t-373h/
给定一个正整数 n ，你可以做如下操作：
如果 n 是偶数，则用 n / 2替换 n 。
如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
n 变为 1 所需的最小替换次数是多少？

示例 1：
输入：n = 8
输出：3
解释：8 -> 4 -> 2 -> 1

示例 2：
输入：n = 7
输出：4
解释：7 -> 8 -> 4 -> 2 -> 1
或 7 -> 6 -> 3 -> 2 -> 1

示例 3：
输入：n = 4
输出：2
 */