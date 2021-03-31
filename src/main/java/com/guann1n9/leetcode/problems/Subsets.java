package com.guann1n9.leetcode.problems;


import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 */
public class Subsets {


    /**
     * 长度为3
     * 000 001 010 011 100 101 110 111  2^n次
     *
     * java中有三种移位运算符
     *
     * <<      :     左移运算符，num << 1,相当于num乘以2
     *
     * >>      :     右移运算符，num >> 1,相当于num除以2
     *
     * >>>    :     无符号右移，忽略符号位，空位都以0补齐
     */
    public static List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        int n = nums.length;
        //Java中i++语句是需要一个临时变量取存储返回自增前的值，而++i不需要
        for (int mask = 0;mask < (1 << n); ++mask){
            //循环 000  001 010 011 100
            //000时 空集合
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                //找到对应的位置
                int idx = mask & (1 << i);
                if(idx > 0 ){
                    temp.add(nums[i]);
                }
            }
            lists.add(temp);
        }
        return lists;
    }


    public static void main(String[] args) {

        for (int mask = 0;mask < (1 << 3); ++mask){
            //Java中i++语句是需要一个临时变量取存储返回自增前的值，而++i不需要
            for (int i = 0; i < 3; ++i) {
                int idx = mask & (1 << i);
                System.out.println(idx);
            }
            System.out.println("----");
        }

    }
}
