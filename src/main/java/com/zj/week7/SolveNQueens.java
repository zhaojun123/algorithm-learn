package com.zj.week7;

import java.util.*;

/**
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[["Q"]]
 *  
 *
 * 提示：
 *
 * 1 <= n <= 9
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolveNQueens {

    /**
     * 使用回溯
     * 第一行有 n 种解法 第二行因为同一列只能有一个皇后 所以最多n-1种解法（不算斜线）
     * 所以总的时间复杂度是 O（n！） 空间复杂度主要是缓存 O（n）不计算最后那种很怪异的输出
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList();
        //存储列有皇后的位置
        Set<Integer> c = new HashSet();
        //存储右上到左下斜线有皇后的位置
        Set<Integer> s1 = new HashSet();
        //存储左上到右下斜线有皇后的位置
        Set<Integer> s2 = new HashSet();
        dfs(n, 0, new LinkedList(), c, s1, s2, result);
        return result;
    }

    public void dfs(int n, int row, LinkedList<Integer> list, Set<Integer> c, Set<Integer> s1, Set<Integer> s2, List<List<String>> result) {
        //说明已经循环到底部了
        if(row >= n) {
            List<String> params = new ArrayList();
            for(int num : list) {
                char[] arrays = new char[n];
                Arrays.fill(arrays, '.');
                arrays[num] = 'Q';
                params.add(new String(arrays));
            }
            result.add(params);
            return;
        }
        for(int i =0; i < n; i ++) {
            //如果位置不符合
            if(c.contains(i) || s1.contains(row + i) || s2.contains(i - row)) {
                continue;
            }
            c.add(i);
            s1.add(row + i);
            s2.add(i - row);
            list.add(i);
            dfs(n, row+1, list, c, s1, s2, result);
            //回溯
            c.remove(i);
            s1.remove(row + i);
            s2.remove(i - row);
            list.pollLast();
        }
    }

}
