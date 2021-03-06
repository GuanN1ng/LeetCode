package com.guann1n9.leetcode.problems;

/**
 * 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *  
 */
public class ReverseInt {


    public int reverse(int x) {
        long n = 0;
        while (x != 0){
            n = n*10 + x%10;
            x = x/10;
        }
        return  n == (int)n ? (int)n : 0;
    }



    public static void main(String[] args) {

        int a = -152;
        System.out.println(a % 10); //-2
        System.out.println(a / 10);  //-15
    }
}
