package org.example.leetcode.string;

/**
 * 165. 比较版本号 https://leetcode-cn.com/problems/compare-version-numbers/
 *
 * 参考： https://leetcode-cn.com/problems/compare-version-numbers/solution/bi-jiao-ban-ben-hao-by-leetcode/
 *
 * @author lichuan
 */
public class CompareVersionProblem {
    public int compareVersion(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int n1 = nums1.length, n2 = nums2.length;

        int i1, i2;
        for (int i = 0; i < Math.max(n1, n2); i++) {
            i1 = i < n1 ? Integer.parseInt(nums1[i]) : 0;
            i2 = i < n2 ? Integer.parseInt(nums2[i]) : 0;

            if (i1 != i2) {
                return i1 > i2 ? 1 : -1;
            }
        }

        return 0;
    }

    /**
     * 方法2，双指针，一次遍历，常数空间
     *
     * @param version 输入字符串
     * @param n 字符串长度
     * @param p 要检索块的第一个字符
     */
    public Pair<Integer, Integer> getNextChunk(String version, int n, int p) {
        //如果指针已经到输入字符串的结尾，直接new一个新块0
        if (p > n - 1) {
            return new Pair<>(0, p);
        }

        //寻找块的结尾
        int i, pEnd = p;
        while (pEnd < n && version.charAt(pEnd) != '.') {
            ++pEnd;
        }

        //截取块
        if (pEnd != n - 1) {
            i = Integer.parseInt(version.substring(p, pEnd));
        } else {
            i = Integer.parseInt(version.substring(p, n));
        }

        //将指针指向下一个块的第一个字符
        p = pEnd + 1;

        return new Pair<>(i, p);
    }

    public int compareVersion2(String version1, String version2) {
        int p1 = 0, p2 = 0;
        int n1 = version1.length(), n2 = version2.length();

        // compare versions
        int i1, i2;
        Pair<Integer, Integer> pair;
        //遍历，直到找到最长version的末尾
        while (p1 < n1 || p2 < n2) {
            pair = getNextChunk(version1, n1, p1);
            i1 = pair.getT();
            p1 = pair.getK();

            pair = getNextChunk(version2, n2, p2);
            i2 = pair.getT();
            p2 = pair.getK();
            if (i1 != i2) {
                return i1 > i2 ? 1 : -1;
            }
        }
        return 0;
    }


    public static class Pair<T, K> {
        private final T t;
        private final K k;

        public Pair(T t, K k) {
            this.t = t;
            this.k = k;
        }

        public T getT() {
            return t;
        }

        public K getK() {
            return k;
        }
    }
}
