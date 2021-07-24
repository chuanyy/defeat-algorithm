package org.example.leetcode.string;

/**
 * NC142 最长重复子串 https://www.nowcoder.com/practice/4fe306a84f084c249e4afad5edf889cc?tpId=190&&tqId=37423&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
 *
 * @author lichuan
 */
public class LongestRepeatedSubstringProblem {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param a string字符串 待计算字符串
     * @return int整型
     */
    public int solve (String a) {
        if (null == a || a.length() < 2) {
            return 0;
        }
        char[] chars = a.toCharArray();
        int len = chars.length;
        //滑动窗口最大长度，最大为字符长度的一半
        int maxWindowSize = len / 2;
        for (int windowSize = maxWindowSize; windowSize >= 1; windowSize--) {
            //start表示每个滑动窗口的起始索引
            for (int start = 0; start <= len - 2 * windowSize; start++) {
                if (isRepeat(chars, start, windowSize)) {
                    return windowSize * 2;
                }
            }
        }
        return 0;
    }

    /**
     *
     * @param chars 字符数组
     * @param i
     * @param j
     * @return 布尔值
     */
    public boolean isRepeat(char[] chars, int j, int i) {
       for (int t = j; t < j + i; t++) {
           if (chars[t] != chars[t + i]) {
               return false;
           }
       }
       return true;
    }
}
