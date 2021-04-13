package com.guann1n9.leetcode.problems.backtrack;


import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteII {



    public static List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        boolean[] bitSet = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(bitSet,nums,new ArrayList<>(),res);
        return res;
    }


    public static void backtrack(boolean[] bitSet,int[] nums, List<Integer> path, List<List<Integer>> res){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //已使用过
            if(bitSet[i]){
                continue;
            }
            //去除重复组合，确保决策树同层不重复
            //第三个条件为下一层递归相等时, 前一个元素刚被撤销选择，则必定重复，所以剪枝
            if(i>0 && nums[i] == nums[i-1] && bitSet[i-1] == false){
                continue;
            }
            path.add(nums[i]);
            bitSet[i] = true;
            backtrack(bitSet,nums,path,res);
            bitSet[i] = false;
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,1};
        System.out.println(JSON.toJSONString(permuteUnique(a)));
    }
}
