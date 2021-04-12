package com.guann1n9.leetcode.problems.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 *给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permute {


    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums,new ArrayList<Integer>());
        return res;
    }


    public void backtrack(int[] nums,List<Integer> path){
        if(path.size() == nums.length){
            res.add(new ArrayList(path));
            return;
        }
        for(int i= 0;i< nums.length;i++){
            if(path.contains(nums[i])) continue;
            path.add(nums[i]);
            backtrack(nums,path);
            path.remove(path.size()-1);
        }
    }
}
