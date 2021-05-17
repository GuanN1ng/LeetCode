package com.guann1n9.leetcode.problems.backtrack;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetWithDup {

    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        //注意如果有重复元素且又要做排列或者子集的话我们一般先排序，方便后面剪枝
        Arrays.sort(nums);
        backtrack(new ArrayList<Integer>(),nums,0);
        return result;
    }

    private static void backtrack(List<Integer> path,int[] nums,int begin){
        System.out.println(JSON.toJSONString(path)+":"+begin);
        result.add(new ArrayList(path));
        for(int i = begin;i<nums.length;i++){
            if(i>begin && nums[i] == nums[i-1]){
                continue;
            }
            path.add(nums[i]);
            backtrack(path,nums,i+1);
            path.remove(path.size()-1);
        }

    }


    public static void main(String[] args) {

        int[] a= {1,2,2,2};

        subsetsWithDup(a);

    }
}
