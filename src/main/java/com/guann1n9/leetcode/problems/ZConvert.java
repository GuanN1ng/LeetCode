package com.guann1n9.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Z 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 */
public class ZConvert {


    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        int down = -1;
        List<StringBuilder> rows = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int i= 0;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if( i == 0 || i== numRows -1){
                down = -down;
            }
            i+=down;
        }
        StringBuilder builder = new StringBuilder();
        rows.forEach(e->builder.append(e.toString()));
        return builder.toString();
    }
}
