package com.guann1n9.leetcode.problems;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 糖果交换 leetcode_888
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
 * 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 */
public class CandySwap {


    /**
     * x = y+(sumA-sumB)/2
     *
     * @param a
     * @param b
     * @return
     */
    public static int[] find(int[] a, int[] b) {

        int sumA = Arrays.stream(a).sum();
        int sumB = Arrays.stream(b).sum();
        int diff = (sumA - sumB)/2;
        HashSet<Integer> condition = new HashSet<>();
        Arrays.stream(a).forEach(condition::add);
        int[] result = new int[2];
        for (int y : b) {
            if (condition.contains(y + diff)) {
                result[0] = y + diff;
                result[1] = y;
                break;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] a = {1,1};
        int[] b = {2,2};
        int[] ints = find(a, b);
    }


}
