package com.guann1n9.leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer diff = target - nums[i];
            if(map.containsKey(diff)){
                return new int[]{i,map.get(diff)};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }


    //变化 ，若有序 选择左右指针
    public int[] twoSum2(int[] nums, int target){
        int left = 0,right = nums.length-1;
        while (left < right){
            int sum = nums[left] + nums[right];
            if(sum == target){
                return new int[]{left,right};
            }
            if(sum > target){
                right--;
            }else {
                left ++;
            }
        }
        return new int[0];
    }
}
