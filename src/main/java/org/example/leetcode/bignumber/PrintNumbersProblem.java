package org.example.leetcode.bignumber;

/**
 * 剑指 Offer 17. 打印从1到最大的n位数 https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 *
 * 参考：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/solution/mian-shi-ti-17-da-yin-cong-1-dao-zui-da-de-n-wei-2/
 *
 * @author lichuan
 */
public class PrintNumbersProblem {
    /**
     *  第一种情况
     *  由于返回值要求的时int[],所以可以不考虑大数
     */
    public int[] printNumbers(int n) {
        int end = (int)Math.pow(10, n) - 1;
        int[] result = new int[end];
        for (int i = 0; i < end; i++) {
            result[i] = i + 1;
        }

        return result;
    }

    /**
     * 此方法
     * 输入：n = 3
     * 输出："000,001,002,...,100,101,102,...,997,998,999"
     */
    StringBuilder result;
    int n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public String printNumbers2(int n) {
        this.n = n;
        result = new StringBuilder();
        //用来存储每个数字
        num = new char[n];
        //开启全排列递归
        dfs(0);
        //去掉末尾逗号返回
        return result.substring(0, result.length() - 1);
    }

    private void dfs(int x) {
        //终止条件，以固定完所有位
        if (n == x) {
            // 拼接 num 并添加至 res 尾部，使用逗号隔开
            result.append(String.valueOf(num)).append(',');
            return;
        }
        for (char c : loop) {
            //固定第一位
            num[x] = c;
            //开始固定下一位
            dfs(x + 1);
        }
    }


    /**
     * 此方法
     * 输入：n = 3
     * 输出："1,2,...,100,101,102,...,997,998,999"
     */
    StringBuilder result2;
    //几位数
    int n2;
    //9的个数
    int nine;
    //第一个非0数字的位置
    int start;
    char[] num2, loop2 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public String printNumbers3(int n) {
        this.n2 = n;
        result = new StringBuilder();
        //用来存储每个数字
        num = new char[n];
        //最开始只有个位非0
        start = n - 1;
        //开启全排列递归
        dfs2(0);
        //去掉末尾逗号返回
        return result.substring(0, result.length() - 1);
    }

    private void dfs2(int x) {
        //终止条件，以固定完所有位
        if (n == x) {
            String s = String.valueOf(num).substring(start);
            if (!"0".equals(s)) {
                // 拼接 num 并添加至 res 尾部，使用逗号隔开
                result.append(s).append(',');
            }
            //当输出数字的所有位都是 99 时，则下个数字需要向更高位进 11 ，此时左边界 startstart 需要减 11 （即高位多余的 00 减少一个）
            if (n - start == nine) {
                start--;
            }

            return;
        }
        for (char c : loop) {
            //固定第 x 位时, c为9时将9的个数加1
            if ('9'== c) {
                nine++;
            }
            //固定第一位
            num[x] = c;
            //开始固定下一位
            dfs(x + 1);
        }
        //回溯时9的个数减1
        nine--;
    }


}
