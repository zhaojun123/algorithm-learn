package com.zj.week8;

/**
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 *
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 *
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 *
 * 返回矩阵中 省份 的数量。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * 输出：2
 * 示例 2：
 *
 *
 * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * 输出：3
 *  
 *
 * 提示：
 *
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] 为 1 或 0
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-provinces
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindCircleNum {

    //使用并查集
    //因为并查集的find部分用了路径压缩，可以认为是接近O(1)的复杂度
    //所以时间复杂度是O(n*n) 空间复杂度是O(n)
    public int findCircleNum(int[][] isConnected) {
        UnionFind union = new UnionFind(isConnected.length);
        for(int i = 0; i < isConnected.length; i ++) {
            for(int j = 0; j < isConnected.length; j ++) {
                if(i != j && isConnected[i][j] == 1) {
                    union.union(i,j);
                }
            }
        }
        return union.count;
    }

    class UnionFind {
        int count = 0;
        int[] parent;

        UnionFind(int nums){
            count = nums;
            parent = new int[nums];
            for(int i = 0; i < parent.length; i ++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            while(p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            p = find(p);
            q = find(q);
            if(p == q) {
                return;
            }
            parent[p] = q;
            count --;
        }
    }

}
