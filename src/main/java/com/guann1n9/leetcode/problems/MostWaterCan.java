package com.guann1n9.leetcode.problems;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器。
 */
public class MostWaterCan {


    /**
     * 水量最多->面积最大  找出两个点 max((j-i)min(aj,ai))
     * int[] 下标 x轴   数值 y轴
     *
     * 双指针
     * 左（x1,y1） 右 (x2,y2)
     * area = min(y1,y2)*(x2-x1)
     * 设  y1<y2  area = y1*(x2-x1)
     * 则无论右边界如何向左移动，则面积始终小于当前值
     * 若 y3>y2
     *
     * area = min(y1,y3)*(x3-x1) = y1*(x3-x1) < y1*(x2-x1)
     *
     * 若 y3<=y2  ...
     *
     *
     *
     *
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int l = 0,r = height.length-1,maxArea = 0;
        while (l<r){
            int temp = (r-l)*Math.min(height[r],height[l]);
            maxArea = Math.max(temp, maxArea);
            if(height[l] < height[r]){
                l++;
            }else {
                r--;
            }
        }
        return maxArea;
    }
}
