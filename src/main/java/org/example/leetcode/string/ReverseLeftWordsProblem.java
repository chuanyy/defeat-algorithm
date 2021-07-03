package org.example.leetcode.string;

/**
 * 剑指 Offer 58 - II. 左旋转字符串 https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 *
 * 参考：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/solution/mian-shi-ti-58-ii-zuo-xuan-zhuan-zi-fu-chuan-qie-p/
 * @author lichuan
 */
public class ReverseLeftWordsProblem {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }

    /**
     *  若面试规定不允许使用 切片函数 ，则使用此方法。
     */
    public String reverseLeftWords2(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < n + s.length(); i++) {
            sb.append(s.charAt(i % s.length()));
        }

        return sb.toString();
    }

    public String reverseLeftWords3(String s, int n) {
       s += s;
       return s.substring(n, n + s.length() / 2);
    }
}
