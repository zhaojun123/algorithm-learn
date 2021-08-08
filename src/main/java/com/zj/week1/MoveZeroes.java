package com.zj.week1;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }
        int left = 0;
        int right = 0;
        while(right < nums.length) {
            if(nums[right] != 0) {
                //如果left 和 right 同位置就不交换值了
                if(right != left) {
                    nums[left] = nums[right];
                    nums[right] = 0;
                }
                left ++;
            }
            right ++;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0,1,0,3,12};
        new MoveZeroes().moveZeroes(nums);
        int[] answer = new int[] {1,3,12,0,0};
        assert nums.length == answer.length;
        for(int i = 0; i < answer.length; i ++) {
            assert nums[i] == answer[i];
        }
    }
}
