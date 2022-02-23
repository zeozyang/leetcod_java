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
