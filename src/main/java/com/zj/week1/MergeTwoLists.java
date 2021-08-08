package com.zj.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示例 1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * 示例 2：
 *
 * 输入：l1 = [], l2 = []
 * 输出：[]
 *
 * 示例 3：
 *
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *  
 *
 * 提示：
 *
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoLists {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = listToNode(Arrays.asList(1,2,4));
        ListNode l2 = listToNode(Arrays.asList(1,3,4));
        ListNode result = new MergeTwoLists().mergeTwoLists(l1,l2);
        ListNode answer = listToNode(Arrays.asList(1,1,2,3,4,4));
        assert nodeToList(result).equals(nodeToList(answer));
    }

    private static List<Integer> nodeToList(ListNode node) {
        List<Integer> list = new ArrayList<Integer>();
        while(node != null){
            list.add(node.val);
            node = node.next;
        }
        return list;
    }

    private static ListNode listToNode(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ListNode head = new ListNode();
        ListNode tem = head;
        for(int num : list) {
            tem.next = new ListNode(num);
            tem = tem.next;
        }
        return head.next;
    }

}
