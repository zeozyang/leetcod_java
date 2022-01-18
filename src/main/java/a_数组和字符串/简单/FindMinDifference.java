package a_数组和字符串.简单;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yang 2022-01-18 9:06
 */
public class FindMinDifference {
    public int findMinDifference(List<String> timePoints) {
        ArrayList<Integer> minutes = new ArrayList<>();
        for (String timePoint : timePoints) {
            String[] split = timePoint.split(":");
            int minute = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
            minutes.add(minute);
        }
        Collections.sort(minutes);

        int res = 24 * 60;
        for (int i = 0; i < minutes.size() - 1; i++)
            res = Math.min(res, minutes.get(i + 1) - minutes.get(i));
        res = Math.min(res, minutes.get(0) + 24 * 60 - minutes.get(minutes.size() - 1));
        return res;
    }
}

/*
539. 最小时间差 中等
给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。

示例 1：
输入：timePoints = ["23:59","00:00"]
输出：1

示例 2：
输入：timePoints = ["00:00","23:59","00:00"]
输出：0
 */