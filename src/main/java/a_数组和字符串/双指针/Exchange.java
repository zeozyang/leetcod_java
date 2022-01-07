package a_数组和字符串.双指针;

/**
 * @author yang 2021-07-12 21:51
 */
public class Exchange {
    public int[] exchange(int[] nums) { //首尾双指针
        int left = 0, right = nums.length -1, temp;
        while (left <= right) {
            if (nums[left] % 2 == 1) { //如果是奇数，就继续找
                left++;
                continue;
            }
            if (nums[right] % 2 == 0) {
                right--;
                continue;
            }
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }

    public int[] exchange2(int[] nums) { //快慢双指针
        int slow = 0, fast = 0, temp;
        while (fast < nums.length) {
            if (nums[fast] % 2 == 1) {
                temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
            fast++;
        }
        return nums;
    }
}

/*
剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。

示例：

输入：nums = [1,2,3,4]
输出：[1,3,2,4]
注：[3,1,2,4] 也是正确的答案之一。
 */
