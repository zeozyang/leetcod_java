/**
 * @author yang 2021-10-25 10:38
 */
public class AgainSort {
    // 变体一：查找第一个值等于给定值的元素
    public int binarySearch1(int[] a, int value) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (value < a[mid]) {
                low = mid + 1;
            } else if (value > a[mid]) {
                high = mid - 1;
            } else {
                if (mid == 0 || a[mid - 1] < value) return mid;
                else high = mid - 1;
            }
        }
        return -1;
    }
}
