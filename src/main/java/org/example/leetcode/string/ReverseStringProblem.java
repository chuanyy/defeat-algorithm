package org.example.leetcode.string;

/**
 * NC103 反转字符串 https://www.nowcoder.com/practice/c3a6afee325e472386a1c4eb1ef987f3?tpId=190&&tqId=35226&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
 *
 * @author lichuan
 */
public class ReverseStringProblem {
    /**
     * 反转字符串
     * @param str string字符串
     * @return string字符串
     */
    public String solve (String str) {
        if (null == str || str.length() < 2) {
            return str;
        }

        char[] arr = str.toCharArray();
        for (int i = 0; i < str.length()/2; i++) {
            char temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        return new String(arr);
    }
}
