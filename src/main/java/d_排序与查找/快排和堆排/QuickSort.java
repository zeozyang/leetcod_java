package d_排序与查找.快排和堆排;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-3, 5, -34, 2, 8, -31, 0, 99, 7, 2, 2};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] arr, int left, int right) {
        int l = left, r = right, pivot = arr[(left + right) / 2]; // 这里pivot必须是中间值，而不是中间下标，因为中间值可能移动
        while (l < r) {
            while (arr[l] < pivot)
                l += 1;
            while (arr[r] > pivot)
                r -= 1;
            if (l >= r || arr[l] == arr[r]) { // 如果已经排好序了，就退出
                break;
            } else {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }

        if (r > left)
            quickSort(arr, left, r - 1);
        if (l < right)
            quickSort(arr, l + 1, right);
    }
}
