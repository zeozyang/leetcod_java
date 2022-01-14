package g_贪心算法.优先队列;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author yang 2022-01-14 9:16
 */
public class KSmallestPairs {  //多路归并
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> nums1[a[0]] + nums2[a[1]]));
        for (int i = 0; i < Math.min(k, nums1.length); i++)
            pq.add(new int[]{i, 0});

        List<List<Integer>> ans = new ArrayList<>();
        while (pq.size() > 0 && k-- > 0) {
            int[] index = pq.remove();
            ans.add(new ArrayList<>() {{
                add(nums1[index[0]]);
                add(nums2[index[1]]);
            }});
            if (index[1] < nums2.length - 1)
                pq.add(new int[]{index[0], index[1] + 1});
        }
        return ans;
    }
}

/*
373. 查找和最小的K对数字
给定两个以升序排列的整数数组 nums1 和 nums2 , 以及一个整数 k 。
定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。

示例 1:
输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
输出: [1,2],[1,4],[1,6]
解释: 返回序列中的前 3 对数：
     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

示例 2:
输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
输出: [1,1],[1,1]
解释: 返回序列中的前 2 对数：
     [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]

示例 3:
输入: nums1 = [1,2], nums2 = [3], k = 3
输出: [1,3],[2,3]
解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
 */