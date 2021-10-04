package com.zj.week9;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 *
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 *
 * 输入：s = ""
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestValidParentheses {

    //每个字符判断一次时间复杂度是O（n）， 空间复杂度看匹配情况，最坏的情况下都是左括号复杂度为O(n)
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        //当栈为空的时候 标记有效括号的起始位置
        int start = -1;
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                //跟新有效括号的起始位置
                if(stack.isEmpty()) {
                    start = i;
                }else {
                    stack.poll();
                    if(stack.isEmpty()) {
                        result = Math.max(i - start, result);
                    }else{
                        result = Math.max(i - stack.peek(), result);
                    }
                }
            }
        }
        return result;
    }

}
