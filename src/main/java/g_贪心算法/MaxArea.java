package g_贪心算法;

/**
 * @author yang 2021-12-13 16:32
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l <= r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) l++;
            else r--;
        }
        return ans;
    }
}

// 11. 盛最多水的容器
// https://leetcode-cn.com/problems/container-with-most-water/