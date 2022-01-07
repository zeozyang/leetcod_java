package j_动态规划.dp数组;

/**
 * @author yang 2021-08-04 16:29
 */
public class ConstructArr {
    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) return a;

        int[] lDP = new int[a.length]; //ldp[i]: a[i]左边所有元素的乘积
        int[] rDP = new int[a.length]; //rdp[i]: a[i]右边所有元素的乘积

        lDP[0] = 1;
        rDP[a.length - 1] = 1;
        for (int i = 1; i < a.length; i++)
            lDP[i] = lDP[i - 1] * a[i - 1];
        for (int i = a.length - 2; i >= 0; i--)
            rDP[i] = rDP[i + 1] * a[i + 1];

        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++)
            res[i] = lDP[i] * rDP[i];
        return res;
    }
}

/*
剑指 Offer 66. 构建乘积数组
给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。

示例:
输入: [1,2,3,4,5]
输出: [120,60,40,30,24]
 */