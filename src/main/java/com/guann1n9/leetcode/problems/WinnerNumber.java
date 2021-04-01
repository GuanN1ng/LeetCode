package com.guann1n9.leetcode.problems;

/**
 * 给你一个由 不同 整数组成的整数数组 arr 和一个整数 k 。
 *
 * 每回合游戏都在数组的前两个元素（即 arr[0] 和 arr[1] ）之间进行。比较 arr[0] 与 arr[1] 的大小，较大的整数将会取得这一回合的胜利并保留在位置 0 ，较小的整数移至数组的末尾。当一个整数赢得 k 个连续回合时，游戏结束，该整数就是比赛的 赢家 。
 *
 * 返回赢得比赛的整数。
 *
 * 题目数据 保证 游戏存在赢家。
 *
 * 示例 2：
 *
 * 输入：arr = [3,2,1], k = 10
 * 输出：3
 * 解释：3 将会在前 10 个回合中连续获胜。
 * 示例 3：
 *
 * 输入：arr = [1,9,8,2,3,7,6,4,5], k = 7
 * 输出：9
 * 示例 4：
 *
 * 输入：arr = [1,11,22,33,44,55,66,77,88,99], k = 1000000000
 * 输出：99
 */
public class WinnerNumber {


    public int getWinner(int[] arr, int k) {
        int max = arr[0];  //数组中的最大值
        int count = 0; //胜利轮数
        //模拟比较，无需移动数组
        for (int i = 1; i < arr.length; i++) {
            if(max > arr[i]){
                count++;
            }else {
                count = 1;
                max = arr[i];
            }
            //次数已够
            if(count == k){
                return max;
            }
        }
        //max最大，即使次数当前未到k，结果已确定
        return max;
    }


}
