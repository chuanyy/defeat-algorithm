package org.example.leetcode.string;

/**
 * 剑指 Offer 58 - I. 翻转单词顺序 https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 *
 * 参考：https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/solution/mian-shi-ti-58-i-fan-zhuan-dan-ci-shun-xu-shuang-z/
 */
public class ReverseWordsProblem {
    /**
     * 倒序 + 双指针
     */
    public String reverseWords(String s) {
        s = s.trim();
        int j = s.length() - 1, i = j;
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            //找到第一个空格的位置
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            sb.append(s.substring(i + 1, j + 1)).append(" ");
            //找到第一个非空格字符位置
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            //将 j 与 i 对齐
            j = i;
        }

        return sb.toString().trim();
    }
}
