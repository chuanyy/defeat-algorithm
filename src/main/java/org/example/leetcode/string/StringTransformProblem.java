package org.example.leetcode.string;

/**
 * NC89 字符串变形 https://www.nowcoder.com/practice/c3120c1c1bc44ad986259c0cf0f0b80e?tpId=190&&tqId=36937&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
 *
 * @author lichuan
 */
public class StringTransformProblem {
    /**
     * 只需要一个stringBuffer
     * 需要在每个空格处记录下上一个单词的长度,然后从上一个单词长度后继续添加字符
     */
    public String trans(String s, int n) {
        //非法参数判断
        if (null == s || n < 0) {
            throw new IllegalArgumentException();
        }

        StringBuffer str = new StringBuffer();
        int start=0;
        for (int i = n-1; i >= 0; i--) {
            if(s.charAt(i)==' '){
                str.append(" ");
                //记录下一次添加字符的位置
                start=n-i;
            }else {
                char sss = (char) (s.charAt(i) < 97 ? s.charAt(i) + 32 : s.charAt(i) - 32);
                str.insert(start, sss);
            }
        }
        return str.toString();
    }

    /**
     * 反转字符串
     * @param str string字符串
     * @return string字符串
     */
    public String reverse (String str) {
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
