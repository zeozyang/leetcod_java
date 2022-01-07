import java.util.HashSet;
import java.util.Set;

/**
 * @author yang 2021-11-12 10:26
 */
public class AgainArray {
    public boolean isStraight(int[] nums) {
        int min = 14 ,max = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num == 0) continue;
            if (!set.add(num)) return false;
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return max - min < 5;
    }

    /*
    剑指 Offer 61. 扑克牌中的顺子
    从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。

    示例 1:
    输入: [1,2,3,4,5]
    输出: True

    示例 2:
    输入: [0,0,1,2,5]
    输出: True
     */

    public int[] twoSum(int[] nums, int target) { //前后双指针
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] < target) i++;
            else if (nums[i] + nums[j] > target) j--;
            else return new int[]{nums[i], nums[j]};
        }
        return new int[0];
    }

    /*
    剑指 Offer 57. 和为s的两个数字
    输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。

    示例 1：
    输入：nums = [2,7,11,15], target = 9
    输出：[2,7] 或者 [7,2]
     */
}
