package org.example.leetcode.string;

import java.util.Arrays;

/**
 * @author lichuan
 */
public class KMPProblem {

    public static void main(String[] args) {
       String str = "ABCDABD";
        System.out.println(Arrays.toString(getNext(str)));
    }

    public int kmp (String S, String T) {
        int[] next = getNext(S);
        char[] sChars = S.toCharArray();
        char[] tChars = T.toCharArray();
        int ans = 0;
        //j表示子串当前已匹配相等的位置
        for (int i = 0, j = 0; i < tChars.length; i++) {
            while (j > 0 && sChars[j] != tChars[i]) {
                j = next[j];
            }

            if (sChars[j] == tChars[i]) {
                j++;
            }

            if (j == sChars.length) {
                ans++;
                j = next[j];
            }
        }

        return ans;
    }

    /**
     * 此方法比第二个方法更好理解一点
     *
     */
    public static int[] getNext(String dest) {
        char[] chars = dest.toCharArray();
        //next[i]表示前i个字符串”前缀”和”后缀”的最长的共有元素的长度
        int[] next = new int[chars.length + 1];
        next[1] = 0;
        //j有双重含义
        //1、表示当前前i个字符串”前缀”和”后缀”的最长的共有元素的长度
        //2、表示下一次进行比较中的最长前缀的最后一个字符的位置
        for (int i = 2, j = 0; i <= chars.length; i++) {
            // 每一轮循环是在求前i个字符串的所有”前缀”和”后缀”中的最长的共有元素的长度
            // 当 dest.charAt(i - 1) != dest.charAt(j) ，我们需要从 next[j-1]获取新的 j
            //直到我们发现 有 dest.charAt(i - 1) == dest.charAt(j)成立才退出
            //这是 kmp 算法的核心点
            if (j > 0 && chars[i - 1] != chars[j]) {
                j = next[j - 1];
            }

            if (chars[i - 1] == chars[j]) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public int kmp2 (String S, String T) {
        // write code here
        int[] next = getNext2(S);
        char[] str =T.toCharArray();
        char[] t = S.toCharArray();
        int si =0;
        int ti =0;

        int ans =0;
        while(si < str.length){
            if(ti==-1 || str[si] == t[ti]){
                si++;
                ti++;
            }else{
                ti = next[ti];
            }
            if(ti == t.length){
                ans++;
                ti=next[ti];
            }
        }
        return ans;
    }

    public int[] getNext2(String dest){
        char[] str = dest.toCharArray();
        //next数组多算一格，易于理解
        //next[i]表示前i个字符串”前缀”和”后缀”的最长的共有元素的长度
        int[] next =  new int[str.length + 1];
        next[0] = -1;
        next[1] = 0;
        //x有双重含义
        //1、表示当前前i个字符串”前缀”和”后缀”的最长的共有元素的长度
        //2、表示下一次进行比较中的最长前缀的最后一个字符的位置
        int x = next[1];
        //next数组下标
        int cur = 2;
        while(cur <= str.length){
            if(x == -1 || str[cur - 1] == str[x]){
                next[cur++] = ++x;
            }else{
                x = next[x];
            }
        }
        return next;
    }
}
