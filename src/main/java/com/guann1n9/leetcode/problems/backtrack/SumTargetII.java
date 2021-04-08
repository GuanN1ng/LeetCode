package com.guann1n9.leetcode.problems.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class SumTargetII {

    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //排序
        Arrays.sort(candidates);
        backtrack(0,new ArrayList(),target,candidates);
        return res;


    }



    public void backtrack(int idx,List<Integer> path,int target, int[] candidates){
        if(target == 0){
            res.add(new ArrayList(path));
            return;
        }
        for(int i=idx; i<candidates.length;i++){
            //保证本层不重复 但不同层可以重复,一次原生For循环，一次是递归。i>idx防止在i为0时后面出现错误
            if(i> idx && candidates[i] == candidates[i-1]){
                continue;
            }
            if(target - candidates[i] >= 0){
                path.add(candidates[i]);
                backtrack(i+1,path,target-candidates[i],candidates);
                path.remove(path.size()-1);
            }else{
                break;
            }
        }
    }
}
