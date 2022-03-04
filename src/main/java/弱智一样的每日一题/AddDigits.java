package 弱智一样的每日一题;

/**
 * @author yang 2022-03-03 9：02
 */
public class AddDigits {
    public int addDigits(int num) {
        if (num < 10) return num;

        String digits = String.valueOf(num);
        int procedure = 0;
        for (int i = 0; i < digits.length(); i++) {
            procedure += Character.getNumericValue(digits.charAt(i));
        }

        return addDigits(procedure);
    }
}

/*
258. 各位相加    简单
给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。

示例 1:
输入: num = 38
输出: 2
解释: 各位相加的过程为：
38 --> 3 + 8 --> 11
11 --> 1 + 1 --> 2
由于 2 是一位数，所以返回 2。

示例 2:
输入: num = 0
输出: 0
 */