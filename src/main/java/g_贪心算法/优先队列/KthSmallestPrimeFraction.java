package g_贪心算法.优先队列;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yang 2022-01-14 12:17
 */
public class KthSmallestPrimeFraction { //373. 查找和最小的K对数字 的我自己理解版，写的比较简单
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> (double) arr[a[0]] / arr[a[1]]));

        for (int j = 1; j < arr.length; j++)
            for (int i = 0; i < j; i++)
                pq.add(new int[]{i, j});

        int[] index = new int[]{0, 0};
        for (int i = 0; i < k; i++)
            index = pq.remove();
        return new int[]{arr[index[0]], arr[index[1]]};
    }
}

/*
786. 第 K 个最小的素数分数
给你一个按递增顺序排序的数组 arr 和一个整数 k 。数组 arr 由 1 和若干 素数 组成，且其中所有整数互不相同。
对于每对满足 0 <= i < j < arr.length 的 i 和 j ，可以得到分数 arr[i] / arr[j] 。
那么第 k 个最小的分数是多少呢?  以长度为 2 的整数数组返回你的答案, 这里 answer[0] == arr[i] 且 answer[1] == arr[j] 。

示例 1：
输入：arr = [1,2,3,5], k = 3
输出：[2,5]
解释：已构造好的分数,排序后如下所示:
1/5, 1/3, 2/5, 1/2, 3/5, 2/3
很明显第三个最小的分数是 2/5

示例 2：
输入：arr = [1,7], k = 1
输出：[1,7]
 */