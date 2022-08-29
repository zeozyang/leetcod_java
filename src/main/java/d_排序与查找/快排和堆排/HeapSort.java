package d_排序与查找.快排和堆排;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {-3, 5, -34, 2, 8, -31, 0, 99, 7, 2, 2};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }

        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heaping(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    /**
     * 将数据从尾部加入堆
     * @param arr   大顶堆数组
     * @param index 要插入的节点在数组中的下标
     */
    static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /**
     * 堆化，保持大顶堆
     * @param arr       大顶堆数组
     * @param index     不符合堆结构的那个值的下标
     * @param heapSize  代表堆的范围，而不是之前的整个数组范围
     */
    static void heaping(int[] arr, int index, int heapSize) {
        int l = index * 2 + 1;
        while (l < heapSize) {
            int r = l + 1;
            int largest = r < heapSize && arr[r] > arr[l] ? r : l; // largest是左右孩子中较大的那个值的下标
            largest = arr[largest] > arr[index] ? largest : index; // largest现在是index及其子节点中最大值的下标

            if (largest == index) {
                break;
            } else {
                swap(arr, index, largest);
                index = largest;
                l = index * 2 + 1;
            }
        }
    }

    static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}

