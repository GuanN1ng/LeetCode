package com.guann1n9.leetcode.problems;


/**
 * 74 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 */
public class MatrixSearch {


    /**
     * 作为一个数组处理
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        //元素个数
        int rows = matrix.length;
        int columns = matrix[0].length;
        int  count = rows * columns - 1;
        int low = 0;
        while (low <= count){
            int mid = (count - low) / 2 + low;
            //?
            int midVal = matrix[mid/columns][mid%columns];
            if(midVal == target){
                return true;
            }
            if(midVal > target){
                count = mid + 1;
            }else {
                low = mid - 1;
            }

        }
        return false;
    }




    /**
     * 先找行 再找列
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        int rowIndex = rowIndex(matrix, target);
        if(rowIndex < 0){
            return false;
        }
        return columnIdx(matrix[rowIndex],target);
    }

    private boolean columnIdx(int[] matrix, int target) {
        int low = 0,high =  matrix.length - 1;
        while (low <= high){
            int mid = (high - low) / 2 + low;
            if(matrix[mid] == target){
                return true;
            }
            if(matrix[mid] < target){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return false;
    }


    public int rowIndex(int[][] matrix,int target){
        int idx = -1, max = matrix.length -1;

        while (idx < max){
            int mid = (max - idx + 1)/2 + idx;
            if(matrix[mid][0] <= target){
                idx = mid;
            }else {
                max = mid - 1;
            }
        }
        return idx;
    }

    public static void main(String[] args) {

        int[][] temp={{1,2},{3,4},{5,6}};
        //行数
        System.out.println(temp.length);
        //列
        System.out.println(temp[0].length);
    }


}
