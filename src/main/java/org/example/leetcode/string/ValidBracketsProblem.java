package org.example.leetcode.string;


import java.util.LinkedList;
import java.util.Stack;

/**
 * NC52 括号序列 https://www.nowcoder.com/practice/37548e94a270412c8b9fb85643c8ccc2?tpId=190&&tqId=35194&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
 */
public class ValidBracketsProblem {
    /**
     *
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid (String s) {
        if(null == s || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for(Character c : s.toCharArray()) {
            if(c.equals('(')) {
                stack.push(')');
            } else if(c.equals('[')) {
                stack.push(']');
            } else if(c.equals('{')) {
                stack.push('}');
            } else if (stack.isEmpty() || !c.equals(stack.pop())) {
                return false;
            }

        }

        return stack.isEmpty();
    }
}
