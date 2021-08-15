package com.zj.week2;

/**
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 *
 *  
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:  
 *
 * 1 是丑数。
 * n 不超过1690。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/chou-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NthUglyNumber {

    //动态规划 设定三个指针 分别是 a（*2） b（*3） c（*5）
    //从 a,b,c中选出最小的丑数放入队列，同时指针前移一步
    //时间复杂度 O(n),空间复杂度O(n)
    public int nthUglyNumber(int n) {
        if(n <= 1) {
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0;
        int b = 0;
        int c = 0;

        int av = dp[a] * 2;
        int bv = dp[b] * 3;
        int cv = dp[c] * 5;

        for(int i = 1; i < n; i ++) {
            dp[i] = av;
            if(dp[i] > bv) {
                dp[i] = bv;
            }
            if(dp[i] > cv) {
                dp[i] = cv;
            }
            if(dp[i] == av) {
                av = dp[++a] * 2;
            }
            if(dp[i] == bv) {
                bv = dp[++b] * 3;
            }
            if(dp[i] == cv) {
                cv = dp[++c] * 5;
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int result = new NthUglyNumber().nthUglyNumber(10);
        assert  result== 12;
    }

}
