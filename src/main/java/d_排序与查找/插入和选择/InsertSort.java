package d_排序与查找.插入和选择;

/**
 * @author yang 2021-10-20 11:23
 */
public class InsertSort {
    public void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i]; //待插入的数
            int index = i - 1; //初始化为待插入的数的前面数的下标

            while (index >= 0 && val < arr[index]) {
                arr[index] = arr[index + 1];
                index--;
            }
            arr[index + 1] = val;
        }
    }
}
