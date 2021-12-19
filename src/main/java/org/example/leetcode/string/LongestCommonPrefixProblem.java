package org.example.leetcode.string;

/**
 * 14. 最长公共前缀 https://leetcode-cn.com/problems/longest-common-prefix/
 *
 * 参考 https://leetcode-cn.com/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode-solution/
 *
 * @author lichuan
 */
public class LongestCommonPrefixProblem {

    /**
     * 方法1：横向扫描
     */
    public String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int length =  Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }

        return str1.substring(0, index);
    }


    /**
     * 方法2：纵向扫描
     */
    public String longestCommonPrefix2(String[] strs) {
        if (null == strs || strs.length == 0) {
            return "";
        }

        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                //利用i == strs[j].length()判断i是否越界
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        //如果strs[0]的所有字符与剩余左右字符串的前缀匹配，则strs[0]就是最长公共前缀
        return strs[0];
    }
}
