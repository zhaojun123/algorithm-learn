package com.zj.week9;

/**
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 *
 * 你需要返回给定数组中的重要翻转对的数量。
 *
 * 示例 1:
 *
 * 输入: [1,3,2,3,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [2,4,3,5,1]
 * 输出: 3
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReversePairs {

    //使用归并排序, 在归并的过程中计算反转对，归并算法的时间复杂度是O(nlogn)反转对计算的复杂度是n
    //所以整体的时间复杂度是O（nlogn） 空间复杂度是O(n)
    public int reversePairs(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        return mergeSort(nums, 0, nums.length - 1);
    }

    public int mergeSort(int[] nums, int left, int right) {
        if(left >= right) {
            return 0;
        }
        int mid = left + ((right - left) >> 1);
        int result = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
        //计算反转对
        int i = left;
        int j = mid + 1;
        while(i <= mid) {
            while(j <= right && (long)nums[i] > 2 * (long)nums[j]) {
                j ++;
            }
            result = result + j - mid - 1;
            i++;
        }
        //归并
        int l = left;
        int r = mid + 1;
        int[] tem = new int[right - left + 1];
        int index = 0;
        while (l <= mid && r <= right) {
            tem[index++] = nums[l] < nums[r] ? nums[l++] : nums[r++];
        }
        while(l <= mid) {
            tem[index++] = nums[l++];
        }
        while(r <= right) {
            tem[index++] = nums[r++];
        }
        //将归并的结果复制到nums中
        System.arraycopy(tem, 0, nums, left, right - left + 1);
        return result;
    }

}
