package org.example.leetcode.dp;

/**
 * NC87 丢棋子问题 https://www.nowcoder.com/practice/d1418aaa147a4cb394c3c3efc4302266?tpId=190&&tqId=35592&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
 * 参考 https://www.cnblogs.com/willwuss/p/12256475.html
 * @author lichuan
 */
public class ThrowPiecesProblem {

    /**
     * 解法一：暴力法
     * 会栈溢出
     */
    public int solutionOne(int n, int k) {
        if (n < 0 || k < 1) {
            return 0;
        }
        return helper(n, k);
    }

    private int helper(int n, int k) {
        //如果N==0，棋子在第0层肯定不会碎,不用扔棋子;
        if (n == 0) {
            return 0;
        }
        //如果K==1，楼层有N层，只有1个棋子，最差的情况就是每层都尝试
        if (k == 1) {
            return n;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            min = Math.min(min, Math.max(helper(i - 1, k - 1), helper(n - i, k)));
        }

        //+1 是第一次扔棋子
        return min + 1;
    }


    /**
     * 方法二： 动态规划
     * <p>
     * 超过限制内存
     */
    public int solutionTwo(int n, int k) {
        if (n < 0 || k < 1) {
            return 0;
        }
        if (k == 1) {
            return n;
        }

        //dp[i][j] 表示i层楼，j颗棋子在最差的情况下扔的最小次数
        int[][] dp = new int[n + 1][k + 1];
        //初始化 dp[i][1] = 1
        //如果k==1，楼层有i层，只有1个棋子，最差的情况就是每层都尝试
        for (int i = 1; i <= n; i++) {
            dp[i][1] = i;
        }

        //第一层循环 表示楼层总数
        for (int i = 1; i <= n; i++) {
            //第二层循环 表示棋子总数
            for (int j = 2; j <= k; j++) {
                int min = Integer.MAX_VALUE;
                //第三层循环 负责填充dp[1=< m <= i][j]区间内的dp值，供后续使用
                for (int m = 1; m <= i; m++) {
                    min = Math.min(min, Math.max(dp[m - 1][j - 1], dp[i - m][j]));
                }
                //+1 是第一次扔棋子
                dp[i][j] = min + 1;
            }
        }

        return dp[n][k];
    }

    /**
     * 方法三： 最优解
     * 最优解比一上各种方法都快。首先我们换个角度来看这个问题，以上各种方法解决问题是N层楼有K个棋子最少仍多少次。
     * 现在反过来看K个棋子如果可以仍M次，最多可以解决多少楼层这个问题。
     *
     * 棋子数\次数        0    1    2    3     4     5     6      7     8     9        10
     *     0            0    0    0    0     0     0     0      0     0     0         0
     *     1            0    1    2    3     4     5     6      7     8     9        10
     *     2            0    1    3    6    10    15    21     28     36    45      55
     *     3            0    1    3    7    14    25    41     63     92    129      175
     *     4            0    1    3    7    15    30    56     98     162    255     385
     *     5            0    1    3    7    15    31    62     119    218    381     637
     *
     * map[i][j]的意义为i个棋子仍j次最多搞定的楼层数。
     * map[i][j] == map[i][j-1] + map[i-1][j-1] + 1
     * 将设i个棋子仍j次最多搞定m层楼，“搞定最多”说明每次仍的位置都是最优的且在棋子肯定够用的情况下，若第1个棋子仍在a层楼是最优的。
     * 1. 如果第1个棋子以碎，那么就向下，看i-1个棋子扔j-1次最多搞定多少层楼；
     * 2. 如果第1个棋子没碎，那么就向上，看i个棋子扔j-1次最多搞定多少层楼；
     * 3. a层楼本身也是被搞定的1层；
     *  1、2、3的总楼数就是i个棋子扔j次最多搞定的楼数，map表的生成过程极为简单，同时数值增长的极快。原始问题可以通过map表得到很好的解决。
     */
    public int solutionThree(int n, int k) {
        if (n < 0 || k < 1) {
            return 0;
        }
        //n层楼完全用二分的方式扔logN+1次就直接可以确定哪层楼是会碎的最低层楼，所以当棋子数k大于logN+1时，我们就可以返回logN+1.
        int bsTimes = log(n, 2) + 1;
        if (k >= bsTimes) {
            return bsTimes;
        }
        //dp[i]表示i个棋子扔m次，最多解决楼层.每一轮for循环代表+1次
        //初始时dp[i]全为0，表示i个棋子扔0次，不管棋子数时多少，最多解决楼层数都时0
        int[] dp = new int[k + 1];
        //用来存储结果
        int res = 0;
        //表示楼层无限
        while (true) {
            //多扔一次
            ++res;
            //表示如果第1个棋子已碎，那么向下找map[i-1][j-1]
            //初始时表示 0层楼，无论有多少颗棋子扔多少次，最多解决楼层数都时0
            int previous = 0;
            for (int i = 1; i <= k; i++) {
                int temp = dp[i];
                //如果第1个棋子没碎，那么向上找 dp[i]即为map[i][j-1]
                dp[i] = previous + dp[i] + 1;
                //保存下一次循环的map[i-1][j-1]
                previous = temp;
                if (dp[i] >= n) {
                    return res;
                }
            }
        }
    }

    public int log(double value, double base) {
        //换底公式
        return (int)(Math.log(value) / Math.log(base));
    }
}