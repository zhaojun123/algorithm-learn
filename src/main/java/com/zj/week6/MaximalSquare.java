package com.zj.week6;

public class MaximalSquare {

    /**
     * 动态规划 dp[i][j] = min(dp[i-1][j],dp[i-1][j-1],dp[i][j-1])+1
     * dp[i][j] 表示 正方形的边长
     * 时间复杂度为O(mn) 创建了一个新的和原二维数组等大小的二维数组 空间复杂度为O(mn)
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int result = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                if(matrix[i][j] == '1') {
                    //左边和上边的边界处判断
                    if(i == 0 || j == 0) {
                        dp[i][j] = 1;
                        result = Math.max(result, dp[i][j]);
                        continue;
                    }
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]))+1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result * result;
    }

}
