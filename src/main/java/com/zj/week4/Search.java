package com.zj.week4;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：nums = [1], target = 0
 * 输出：-1
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums 中的每个值都 独一无二
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -10^4 <= target <= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Search {

    //时间复杂度是O(logn), 空间复杂度是O(1)
    //使用二分法, 多了一个判断条件 需要判断哪边有序 在有序的一边做分析
    public int search(int[] nums, int target) {
        if(nums == null) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int middle = start + (end - start)/2;
            if(nums[middle] == target) {
                return middle;
            }
            //判断哪边有序
            //左边有序
            if(nums[0] <= nums[middle]) {
                if(target < nums[middle] && target >= nums[0]) {
                    end = middle - 1;
                }else {
                    start = middle + 1;
                }
                //右边有序
            }else {
                if(target > nums[middle] && target <= nums[nums.length - 1]) {
                    start = middle + 1;
                }else {
                    end = middle - 1;
                }
            }
        }
        return -1;
    }

}
