package g_贪心算法.优先队列;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yang 2021-12-24 9:07
 */
public class EatenApples {
    public int eatenApples(int[] apples, int[] days) {
        //pq:优先队列，存放着某天生产的苹果个数，和这些按苹果的最后食用日期。
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int now = 0, ans = 0; //now:当前时间。ans:吃到的苹果数量。

        while (now < days.length || !pq.isEmpty()) { //一次循环代表一天
            if (now < days.length && apples[now] > 0) //入队,收集当天的苹果
                pq.add(new int[]{apples[now], now + days[now] - 1});

            //出队，吃苹果
            while (!pq.isEmpty() && pq.peek()[1] < now) //先把过期的苹果扔掉
                pq.remove();
            if (!pq.isEmpty()) {
                int[] cur = pq.remove();
                if (--cur[0] > 0) // 如果吃掉cur一个苹果后，仍有剩余，将cur重新入堆
                    pq.add(cur);
                ans++;
            }
            now++;
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