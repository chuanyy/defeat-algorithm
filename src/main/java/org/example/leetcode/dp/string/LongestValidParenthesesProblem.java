package org.example.leetcode.dp.string;

import java.util.Stack;

/**
 * NC49 最长的括号子串 https://www.nowcoder.com/practice/45fd68024a4c4e97a8d6c45fc61dc6ad?tpId=190&&tqId=35191&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
 *
 * 参考：https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode-solution/
 * @author lichuan
 */
public class LongestValidParenthesesProblem {
    /**
     * 方法一、动态和规划
     * @param s string字符串
     * @return int整型
     */
    public int longestValidParentheses (String s) {
        if (null == s || s.length() <= 1) {
            return 0;
        }

        char[] str = s.toCharArray();

        int maxLength = 0;
        int sLength = s.length();
        //dp[i] 表示下标为i的字符结尾的最长有效括号的长度
        //dp 数组全部初始化为 0 。
        int[] dp = new int[sLength];
        for (int i = 1; i < sLength; i++) {
            if (str[i] == ')') {
                if (str[i -1] == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }
                /**
                 * 如果倒数第二个 ‘)’ 是一个有效子字符串的一部分（记作 sub_s），对于最后一个 ‘)’ ，
                 * 如果它是一个更长子字符串的一部分，那么它一定有一个对应的 ‘(’，且它的位置在倒数第二个 ‘)’所在的有效子字符串的前面
                 * （也就是 sub_s的前面）。因此，如果子字符串 sub_s的前面恰好是‘(’，那么我们就用 2 加上 sub_s的长度
                 * （dp[i-1]）去更新 dp[i]。同时，我们也会把有效子串 “(sub_s)” 之前的有效子串的长度也加上，
                 * 也就是再加上dp[i−dp[i−1]−2]。
                 */
                else if (i - dp[i - 1] > 0 && str[i - dp[i - 1] - 1] == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }

    /**
     * 方法2：栈
     *
     */
    public int longestValidParentheses2 (String s) {
        if (null == s || s.length() <= 1) {
            return 0;
        }

        int maxLength = 0;
        /*
            我们始终保持栈底元素为当前已经遍历过的元素中「最后一个没有被匹配的右括号的下标」，
            这样的做法主要是考虑了边界条件的处理，栈里其他元素维护左括号的下标：
                对于遇到的每个 ‘(’ ，我们将它的下标放入栈中
                对于遇到的每个 ‘)’ ，我们先弹出栈顶元素表示匹配了当前右括号：
                如果栈为空，说明当前的右括号为没有被匹配的右括号，我们将其下标放入栈中来更新我们之前提到的「最后一个没有被匹配的右括号的下标」
                如果栈不为空，当前右括号的下标减去栈顶元素即为「以该右括号为结尾的最长有效括号的长度」
         */
        Stack<Integer> stack = new Stack<>();
        /*
            如果一开始栈为空，第一个字符为左括号的时候我们会将其放入栈中，这样就不满足提及的「最后一个没有被匹配的右括号的下标」，
            为了保持统一，我们在一开始的时候往栈中放入一个值为 -1 的元素。
         */
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                   maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }
}
