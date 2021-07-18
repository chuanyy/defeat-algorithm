package org.example.leetcode.string;

/**
 * 5. 最长回文子串 https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * @author lichuan
 */
public class LongestPalindromeProblem {


    //解法二, 中心扩散法
    public String longestPalindrome2(String s) {
        if (null == s || s.isEmpty()) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
//            由于存在奇数的字符串和偶数的字符串，所以我们需要从一个字符开始扩展，或者从两个字符之间开始扩展，所以总共有 n+n-1 个中心
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int maxLength = Math.max(len1, len2);
            if (maxLength > end - start) {
                start = i - (maxLength - 1) / 2;
                end = i + maxLength / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    //牛客网 https://www.nowcoder.com/practice/b4525d1d84934cf280439aeecc36f4af?tpId=190&&tqId=35207&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
    public int getLongestPalindrome2(String A, int n) {
        if (null == A || A.isEmpty()) {
            return 0;
        }
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
//            由于存在奇数的字符串和偶数的字符串，所以我们需要从一个字符开始扩展，或者从两个字符之间开始扩展，所以总共有 n+n-1 个中心
            int len1 = expandAroundCenter(A, i, i);
            int len2 = expandAroundCenter(A, i, i + 1);
            maxLength = Math.max(Math.max(len1, len2), maxLength);
        }

        return maxLength;
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right <s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        //由于最后一次循环范围扩大了2 所以right - left + 1 - 2
        return right - left - 1;
    }





    //解法一：暴力解法
    public String longestPalindrome(String s) {
        int len = s.length();
        if (2 > len) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        //s.charAt(i)每次否会检查数组越界，因此转化成数组
        char[] charArray = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLen && validPalindromic(charArray, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    //牛客网 https://www.nowcoder.com/practice/b4525d1d84934cf280439aeecc36f4af?tpId=190&&tqId=35207&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
    public int getLongestPalindrome(String A, int n) {
        if (null == A) {
            return 0;
        }
        if (2 > n) {
            return n;
        }

        int maxLen = 1;

        //s.charAt(i)每次否会检查数组越界，因此转化成数组
        char[] charArray = A.toCharArray();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (j - i + 1 > maxLen && validPalindromic(charArray, i, j)) {
                    maxLen = j - i + 1;
                }
            }
        }
        return maxLen;
    }

    //判断一个字符串是不是回文串
    public boolean validPalindromic(char[] arr, int begin, int end) {
        while (begin < end) {
            if (arr[begin++] != arr[end--]) {
                return false;
            }
        }
        return true;
    }
}
