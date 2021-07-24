package org.example.leetcode.string;

/**
 * NC31 第一个只出现一次的字符 https://www.nowcoder.com/practice/1c82e8cf713b4bbeb2a5b31cf5b0417c?tpId=190&&tqId=38446&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
 *
 * @author lichuan
 */
public class FirstNotRepeatingCharProblem {
    public int firstNotRepeatingChar(String str) {
        if (null == str || str.isEmpty()) {
            return -1;
        }
        //ASCII编码 共计128个字符
        //在java中，无论是一个字符，还是一个字符型变量，实则也是一个数字，
        // 所以，可以直接将一个（不超过char的范围的）数字赋值给一个char变量，即可输出其结果
        int[] bitMap = new int[128];
        for (int i = 0; i < str.length(); i++) {
            bitMap[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (bitMap[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
}
