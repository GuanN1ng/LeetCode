package com.guann1n9.leetcode.problems;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 *  
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 */
public class PhoneChar {


    /**
     * 回溯算法实际上一个类似枚举的搜索尝试过程，主要是在搜索尝试过程中寻找问题的解，当发现已不满足求解条件时，就 “回溯” 返回，尝试别的路径
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        //边界处理
        if(digits == null || digits.length() == 0){
            return list;
        }
        //数字字符映射
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        //从第0个字符回溯
        backTrack(0,map,digits,new StringBuilder(),list);
        return list;

    }


    /**
     *
     * @param idx 回溯的位置
     * @param map  映射集
     * @param digits 号码
     * @param builder 正在回溯的字符串
     */
    private static void backTrack(int idx, Map<Character, String> map,String digits, StringBuilder builder,List<String> list){
        //已遍历完号码
        if(idx == digits.length()){
            list.add(builder.toString());
            return;
        }
        char c = digits.charAt(idx);
        //遍历所有可能
        String chars = map.get(c);
        for (char temp : chars.toCharArray()) {
            builder.append(temp);
            //递归 下一个数字的映射
            backTrack(idx+1,map,digits,builder,list);
            //移除递归拼接的字符，开始下一轮
            builder.deleteCharAt(idx);
        }
    }



    public static void main(String[] args) {

        List<String> list = letterCombinations("23");
        System.out.println(JSON.toJSONString(list));

    }
}
