package g_贪心算法;

/**
 * @author yang 2021-12-13 16:58
 */
public class Jump {
    public int jump(int[] nums) {
        int end = 0; //最少每一步所在位置能跳的到的边界
        int maxPosition = 0; //在当前位置 和 当前所在位置能跳的到的边界 中能跳到最远的边界。
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) { //遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}

// 45. 跳跃游戏 II
// https://leetcode-cn.com/problems/jump-game-ii/