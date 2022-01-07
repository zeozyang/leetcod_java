package g_贪心算法.优先队列;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yang 2021-12-24 9:07
 */
public class EatenApples {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int n = apples.length, time = 0, ans = 0; //time 为当前时间，ans 为吃到的苹果数量

        while (time < n || !q.isEmpty()) { //「还有苹果未被生成」对应前n天，或者「未必吃掉」对应n天之后，继续模拟。
            if (time < n && apples[time] > 0) // 二元组表示 (最后食用日期, 当日产生苹果数量)
                q.add(new int[]{time + days[time] - 1, apples[time]});

            while (!q.isEmpty() && q.peek()[0] < time) // 如果这一批苹果已过期，则抛弃
                q.poll();
            if (!q.isEmpty()) { // 如果吃掉cur一个苹果后，仍有剩余，将cur重新入堆；
                int[] cur = q.poll();
                if (--cur[1] > 0) // i++是先访问i然后再自增,而++i则是先自增然后再访问i的值
                    q.add(cur);
                ans++;
            }
            time++;
        }

        return ans;
    }
}

/*
1705. 吃苹果的最大数目
https://leetcode-cn.com/problems/maximum-number-of-eaten-apples/solution/chi-ping-guo-de-zui-da-shu-mu-by-leetcod-93ka/
有一棵特殊的苹果树，一连 n 天，每天都可以长出若干个苹果。在第 i 天，树上会长出 apples[i] 个苹果，这些苹果将会在 days[i] 天后（也就是说，第 i + days[i] 天时）腐烂，变得无法食用。也可能有那么几天，树上不会长出新的苹果，此时用 apples[i] == 0 且 days[i] == 0 表示。
你打算每天 最多 吃一个苹果来保证营养均衡。注意，你可以在这 n 天之后继续吃苹果。
给你两个长度为 n 的整数数组 days 和 apples ，返回你可以吃掉的苹果的最大数目。

示例 1：
输入：apples = [1,2,3,5,2], days = [3,2,1,4,2]
输出：7
解释：你可以吃掉 7 个苹果：
- 第一天，你吃掉第一天长出来的苹果。
- 第二天，你吃掉一个第二天长出来的苹果。
- 第三天，你吃掉一个第二天长出来的苹果。过了这一天，第三天长出来的苹果就已经腐烂了。
- 第四天到第七天，你吃的都是第四天长出来的苹果。

示例 2：
输入：apples = [3,0,0,0,0,2], days = [3,0,0,0,0,2]
输出：5
解释：你可以吃掉 5 个苹果：
- 第一天到第三天，你吃的都是第一天长出来的苹果。
- 第四天和第五天不吃苹果。
- 第六天和第七天，你吃的都是第六天长出来的苹果。
 */