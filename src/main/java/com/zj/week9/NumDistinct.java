package com.zj.week9;

/**
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 *
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 *
 * 题目数据保证答案符合 32 位带符号整数范围。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "rabbbit", t = "rabbit"
 * 输出：3
 * 解释：
 * 如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
 * rabbbit
 * rabbbit
 * rabbbit
 * 示例 2：
 *
 * 输入：s = "babgbag", t = "bag"
 * 输出：5
 * 解释：
 * 如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/distinct-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumDistinct {

    //i表示s中字符的下标 j表示t中字符的下标,则有以下dp方程
    //当s[i] == t[j] 时  dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
    //当s[i] != t[j] 时  dp[i][j] = dp[i-1][j]
    //时间复杂度为 O（mn） 空间复杂度为 O（mn）
    public int numDistinct(String s, String t) {
        if(t == null || t.length() == 0) {
            return 1;
        }
        if(s == null || s.length() == 0) {
            return 0;
        }
        char[] arrays = s.toCharArray();
        char[] arrayt = t.toCharArray();
        int m = arrays.length;
        int n = arrayt.length;
        //算上空字符串
        int[][] dp = new int[m+1][n+1];
        //初始化
        for(int i = 0; i < m; i ++) {
            dp[i][0] = 1;
        }
        for(int i = 1; i <= m; i ++) {
            for(int j = 1; j <= n; j ++) {
                if(arrays[i-1] == arrayt[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }

}
