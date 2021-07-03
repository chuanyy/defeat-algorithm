package org.example.leetcode.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 剑指 Offer 38. 字符串的排列 https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 *
 * 参考：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/solution/mian-shi-ti-38-zi-fu-chuan-de-pai-lie-hui-su-fa-by/
 */
public class PermutationProblem {
    List<String> res = new ArrayList<>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    private void dfs(int x) {
        //递归终止条件
        if(x == c.length - 1) {
            res.add(String.valueOf(c));
            //别忘了返回
            return;
        }
        //用来去重，也被称为剪枝
        Set<Character> set = new HashSet<>();
        //此处包括了与自身的交换，但是这点计算量对计算机来说九牛一毛
        for(int i = x; i < c.length; i++) {
            if(set.contains(c[i])) {
                continue;
            }
            //加入去重集合
            set.add(c[i]);
            swap(i, x);
            dfs(x+1);
            //复原
            swap(i,x);
        }
    }

    private void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
}
