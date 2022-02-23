package 弱智一样的每日一题.不常见的模拟;

/**
 * @author yang 2022-02-23 10:16
 */
public class PushDominoes {
    public String pushDominoes(String dominoes) {
        dominoes = "L" + dominoes + "R";
        int l = 0;
        StringBuilder res = new StringBuilder();
        for (int r = 1; r < dominoes.length(); r++) {
            if (dominoes.charAt(r) == '.') {
                continue;
            }
            if (l != 0) { // 虚拟的牌不放入结果
                res.append(dominoes.charAt(l));
            }
            int mid = r - l - 1; //表示区间内有多少个 "."
            if (dominoes.charAt(l) == dominoes.charAt(r)) {
                for (int i = 0; i < mid; i++) {
                    res.append(dominoes.charAt(l));
                }
            } else if (dominoes.charAt(l) == 'L' && dominoes.charAt(r) == 'R') {
                for (int i = 0; i < mid; i++) {
                    res.append('.');
                }
            } else { //两边的牌都朝里倒
                for (int i = 0; i < mid / 2; i++) {
                    res.append('R');
                }
                if (mid % 2 == 1) {
                    res.append('.');
                }
                for (int i = 0; i < mid / 2; i++) {
                    res.append('L');
                }
            }
            l = r;
        }
        return res.toString();
    }
}

/*
838. 推多米诺
https://leetcode-cn.com/problems/push-dominoes/solution/fu-xue-ming-zhu-miao-dong-xi-lie-xiang-x-xkts/
n 张多米诺骨牌排成一行，将每张多米诺骨牌垂直竖立。在开始时，同时把一些多米诺骨牌向左或向右推。
每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。
如果一张垂直竖立的多米诺骨牌的两侧同时有多米诺骨牌倒下时，由于受力平衡， 该骨牌仍然保持不变。
就这个问题而言，我们会认为一张正在倒下的多米诺骨牌不会对其它正在倒下或已经倒下的多米诺骨牌施加额外的力。
给你一个字符串 dominoes 表示这一行多米诺骨牌的初始状态，其中：
dominoes[i] = 'L'，表示第 i 张多米诺骨牌被推向左侧，
dominoes[i] = 'R'，表示第 i 张多米诺骨牌被推向右侧，
dominoes[i] = '.'，表示没有推动第 i 张多米诺骨牌。
返回表示最终状态的字符串。

示例 1：
输入：dominoes = "RR.L"
输出："RR.L"
解释：第一张多米诺骨牌没有给第二张施加额外的力。
 */