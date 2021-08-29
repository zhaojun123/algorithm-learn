package com.zj.week4;

/**
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 *
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 *  
 *
 * 提示:
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Jump {

    //时间复杂度是 O(n), 空间复杂度是O（1）
    //类似于bfs,不断的改变end的值,在end边界范围内寻找跳的最远的值,然后扩充end的边界
    public int jump(int[] nums) {
        int result = 0;
        int maxPosition = 0;
        int end = 0;
        //不考虑最后一个位置,因为必定会跳到,如果考虑了 边界不好处理
        for(int i = 0; i < nums.length -1; i ++) {
            maxPosition = Math.max(nums[i] + i, maxPosition);
            //说明到边界了 准备下一跳
            if(i == end) {
                result ++;
                end = maxPosition;
            }
        }
        return result;
    }

}
