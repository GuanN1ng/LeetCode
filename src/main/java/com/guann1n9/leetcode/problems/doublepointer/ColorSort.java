package com.guann1n9.leetcode.problems.doublepointer;

/**
 * 根据颜色排序
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 *
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[0]
 */
public class ColorSort {

    public void sortColors(int[] nums) {

        if(nums.length == 1){
            return;
        }
        int left = 0,right = nums.length -1;
        for(int i = 0; i <= right; i++){
            if(nums[i] == 0){
                int temp =  nums[left];
                nums[left] = nums[i];
                nums[i] = temp;
                left++;
            }
            if(nums[i] == 2){
                int temp =  nums[right];
                nums[right] = nums[i];
                nums[i] = temp;
                right--;
                if(temp != 1){
                    --i;
                }
            }
        }
    }
}
