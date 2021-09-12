package com.zj.week6;

/**
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *  
 *
 * 示例 1：
 *
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 *
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 *  
 *
 * 提示：
 *
 * 0 <= word1.length, word2.length <= 500
 * word1 和 word2 由小写英文字母组成
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinDistance {

    //增，dp[i][j] = dp[i][j - 1] + 1
    //删，dp[i][j] = dp[i - 1][j] + 1
    //改，dp[i][j] = dp[i - 1][j - 1] + 1
    //当 word1[i] == word2[j]，dp[i][j] = dp[i-1][j-1]；
    //当 word1[i] != word2[j]，dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1])
    //时间复杂度O(mn) m和n是word1和word2的长度  用了int[m+1][n+1]的二维数组，空间复杂度是O(mn)
    public int minDistance(String word1, String word2) {
        char[] array1 = word1.toCharArray();
        char[] array2 = word2.toCharArray();
        int m = array1.length;
        int n = array2.length;
        if(m == 0) {
            return n;
        }
        if(n == 0) {
            return m;
        }
        //这里包括了空字符串的情况
        int[][] dp = new int[m+1][n+1];
        //初始化基础状态, 左边一列 和 上面一行
        for(int i = 0; i <= m; i ++) {
            dp[i][0] = i;
        }
        for(int i = 0; i <= n; i ++) {
            dp[0][i] = i;
        }
        for(int i = 1; i <= m; i ++) {
            for(int j = 1; j <= n; j ++) {
                if(array1[i-1] == array2[j-1]) {
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+1;
                }
            }
        }
        return dp[m][n];
    }

}
