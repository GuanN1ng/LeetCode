package com.guann1n9.leetcode.problems.slidingwindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class UniqueSubstring {

    /**
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s.length() == 1){
            return s.length();
        }
        int max = 0;
        List<Character> window = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if(window.contains(c)){
                Iterator<Character> iterator = window.iterator();
                while(iterator.hasNext()){
                    Character next = iterator.next();
                    iterator.remove();
                    if(next.charValue() == c){
                        break;
                    }
                }
            }
            window.add(c);
            max = window.size()> max ?  window.size() : max;


        }
        return max;

    }
}
