package com.guann1n9.leetcode.problems;

import java.util.HashSet;

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
        if(s == null || s.length() == 0){
            return 0;
        }
        //前指针 后指针  最大长度
        int front = 0,back = 0,max = 0;
        HashSet<Character> set = new HashSet<>();
        while (front < s.length()){
            char currentChar = s.charAt(front);
            if(!set.contains(currentChar)){
                set.add(currentChar);
                int tempMax = front - back + 1;
                if(tempMax > max){
                    max = tempMax;
                }
            }else {
                char backChar = s.charAt(back);
                while (backChar != currentChar){
                    set.remove(backChar);
                    ++back;
                    backChar = s.charAt(back);
                }
                ++back;
            }
            ++front;
        }
        return max;

    }
}
