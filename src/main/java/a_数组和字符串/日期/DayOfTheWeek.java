package a_数组和字符串.日期;

import java.time.LocalDate;

/**
 * @author yang 2022-01-04 10:06
 */
public class DayOfTheWeek {
    public String dayOfTheWeek(int day, int month, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        int dayOfWeek = date.getDayOfWeek().getValue();
        String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        return week[dayOfWeek % 7];
    }
}

/*
1185. 一周中的第几天
给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
输入为三个整数：day、month 和 year，分别表示日、月、年。
您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。

示例 1：
输入：day = 31, month = 8, year = 2019
输出："Saturday"

示例 2：
输入：day = 18, month = 7, year = 1999
输出："Sunday"

示例 3：
输入：day = 15, month = 8, year = 1993
输出："Sunday"
 */