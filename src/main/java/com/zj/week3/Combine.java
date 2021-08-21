package com.zj.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * 示例 2：
 *
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 *  
 *
 * 提示：
 *
 * 1 <= n <= 20
 * 1 <= k <= n
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Combine {

    //使用递归
    //TODO 这里的时间复杂度不会计算  空间复杂度是 O(n)
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList();
        if(k > n) {
            return result;
        }
        LinkedList<Integer> list = new LinkedList();
        dfs(n, k, 1, list, result);
        return result;
    }

    public void dfs (int n, int k, int begin, LinkedList list, List result) {
        if(list.size() == k) {
            result.add(new ArrayList(list));
            return;
        }
        //通过list.size()可以判断出 该层是k中第几个元素, 可以循环到哪个位置
        for(int i = begin; i <= n - (k - list.size()) + 1; i ++) {
            list.add(i);
            dfs(n, k, i + 1, list, result);
            //清理现场
            list.pollLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new Combine().combine(4, 2);
        assert result.equals(Arrays.asList(
                Arrays.asList(2,4),
                Arrays.asList(3,4),
                Arrays.asList(2,3),
                Arrays.asList(1,2),
                Arrays.asList(1,3),
                Arrays.asList(1,4)
        ));
    }

}
