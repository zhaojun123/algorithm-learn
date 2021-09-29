package com.zj.week8;

/**
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：n = 4
 * 输出：2
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= n <= 9
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TotalNQueens {

    //将棋盘的每行转换成二进制
    int size = 0;
    int count = 0;

    //使用过位运算，时间复杂度和使用set缓存是一样的，低于O(n!)，空间复杂度是O(1)
    public int totalNQueens(int n) {
        size = (1 << n) - 1;
        dfs(0, 0, 0);
        return count;
    }

    public void dfs(int row, int l, int r) {
        //终止条件 皇后已经放满
        if(row == size) {
            count ++;
        }
        //1的位置表示该行能放皇后的位置
        int p = size & (~(row | l | r));
        //判断是否还有位置放皇后
        while(p != 0) {
            //拿到最后一个1的位置,表示要在这里放皇后
            int queen = p & -p;
            //将该位置改为0
            p = p & (p -1);
            //将queen的位置加入到 row、l、r 中,然后进入下一层递归
            dfs(row | queen, (l | queen)<<1, (r | queen) >>> 1);
        }
    }

}
