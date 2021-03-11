package com.guann1n9.leetcode.problems;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 *
 *按顺序排列的一组数据中居于中间位置的数,有偶数个，通常取最中间的两个数值的平均数作为中位数
 */
public class Median {


    /**
     * 暴力  合并查找  0(m+n)
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = Arrays.asList(nums1, nums2).stream().flatMap(i -> Arrays.stream(i).boxed()).sorted(Integer::compareTo).collect(Collectors.toList());
        if(list.size()%2==0){
            return (list.get(list.size()/2-1)+list.get(list.size()/2))/2.0;
        }else {
            return list.get(list.size()/2);
        }
    }


    /**
     * O(log(m+n))
     * @param nums1
     * @param nums2
     * @return
     */
   /* public double findMedianSortedArrays2(int[] nums1, int[] nums2) {

    }*/
}
