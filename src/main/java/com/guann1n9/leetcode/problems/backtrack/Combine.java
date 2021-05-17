package com.guann1n9.leetcode.problems.backtrack;


import java.util.ArrayList;
import java.util.List;

public class Combine {

    public static List<List<Integer>> combine(int n, int k) {

        if(n==0 || k==0){
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(path,n,result,k,1);
        return result;

    }



    private static void backtrack(List<Integer> path,int n,List<List<Integer>> result,int k,int begin){
        if(path.size() == k){
            List<Integer> temp = new ArrayList(path);
            result.add(temp);
            return;
        }
        //剩余参数已不够
        if(k-path.size() > n-begin+1){
            return;
        }
        for(int i = begin; i<= n;i++){
            path.add(i);
            backtrack(path,n,result,k,i+1);
            path.remove(path.size()-1);
        }

    }


    public static void main(String[] args) {

    }
}
