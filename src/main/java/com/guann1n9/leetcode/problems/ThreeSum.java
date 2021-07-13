package com.guann1n9.leetcode.problems;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.bcel.internal.generic.NEW;
import jdk.nashorn.internal.ir.CallNode;

import java.io.FileReader;
import java.math.BigDecimal;
import java.util.*;

/**
 * 三数之和
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 */
public class ThreeSum {

    static List<List<Integer>> result = new ArrayList<>();



    /*public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        backtrack(new ArrayList<Integer>(),0,nums);
        return result;
    }


    public static void backtrack(List<Integer> path,int begin,int[] nums){

        int sum = path.stream().mapToInt(Integer::intValue).sum();
        if(sum == 0 && path.size() == 3){
            result.add(new ArrayList<>(path));
            return;
        }
        //已经大于0，或加上下一个数大于0  不再继续
        if(begin > nums.length-1 || sum > 0 || nums[begin] + sum > 0 || path.size() >= 3){
            return;
        }
        //遍历选择
        for (int i = begin; i < nums.length; i++) {
            //存在重复整数，剪枝
            if(i>begin && nums[i] == nums[i-1]){
                continue;
            }
            path.add(nums[i]);
            backtrack(path,i+1,nums);
            path.remove(path.size()-1);
        }
    }*/



    public List<List<Integer>> threeSum(int[] nums) {
        //边界判断
        if(nums == null || nums.length < 3){
            return Collections.EMPTY_LIST;
        }
        List<List<Integer>> result =  new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i< nums.length; i++){
            if(nums[i] > 0){
                //已排序，若num[i]大于0 则后续不会再有三数之和为0
                break;
            }
            if(i>0 && nums[i] == nums[i-1]){
                //与上一个元素相同，重复跳过
                continue;
            }
            //双指针查找
            int left = i+1;
            int right = nums.length -1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    //符合条件后，去除左右重复值
                    while(left < right && nums[left] == nums[left+1]){
                        ++left;
                    }
                    while(right > left && nums[right] == nums[right-1]){
                        --right;
                    }
                    //移动左右指针，找下一组不重复的解
                    ++left;
                    --right;
                }else if(sum > 0){
                    --right;
                }else{
                    ++left;
                }
            }
        }
        return result;
    }


}
