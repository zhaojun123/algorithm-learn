package com.zj.week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Permute {

    //使用回溯法,从第一位开始分别将自己和后面进行交换
    //时间复杂度是O(n! * n) 空间复杂度是 O(n)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        if(nums == null || nums.length == 0) {
            return result;
        }
        List<Integer> list = new ArrayList();
        for(int i = 0; i < nums.length; i ++) {
            list.add(nums[i]);
        }
        dfs(list, 0, result);
        return result;
    }

    public void dfs(List<Integer> list, int index, List<List<Integer>> result) {
        if(index == list.size() - 1) {
            result.add(new ArrayList(list));
        }
        for(int i = index; i < list.size(); i ++) {
            if(i != index){
                Collections.swap(list, i, index);
            }
            dfs(list, index + 1, result);
            if(i != index){
                Collections.swap(list, i, index);
            }
        }
    }

}
