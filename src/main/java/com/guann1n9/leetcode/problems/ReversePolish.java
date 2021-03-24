package com.guann1n9.leetcode.problems;

import java.util.Stack;

/**
 *根据 逆波兰表示法，求表达式的值。
 *
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 *  
 *
 * 说明：
 *
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *  
 *
 * 示例 1：
 *
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 *
 * 输入：tokens = ["4","13","5","/","+"]
 * 输出：6
 * 解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 *
 */
public class ReversePolish {


    /**
     * 按顺序，操作符置于操作数后方
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer>  stack = new Stack<>();
        int result;
        for (String token : tokens) {

            switch (token){
                case "+":
                    result = stack.pop() + stack.pop();
                    stack.push(result);
                    break;
                case "-":
                    Integer p1 = stack.pop();
                    Integer p2 = stack.pop();
                    result = p2 - p1;
                    stack.push(result);
                    break;
                case "*":
                    result = stack.pop() * stack.pop();
                    stack.push(result);
                    break;
                case "/":
                    //除法出栈顺序  先出的是除数
                    Integer p3 = stack.pop();
                    Integer p4 = stack.pop();
                    result = p4 / p3;
                    stack.push(result);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();

    }
}
