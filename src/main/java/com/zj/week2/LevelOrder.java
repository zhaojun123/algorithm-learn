package com.zj.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 *
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 *
 *  
 *
 * 示例 1：
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[[1],[3,2,4],[5,6]]
 * 示例 2：
 *
 *
 *
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 *  
 *
 * 提示：
 *
 * 树的高度不会超过 1000
 * 树的节点总数在 [0, 10^4] 之间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LevelOrder {

    static  class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    /**
     * 广度优先遍历，时间复杂度是O(n),空间复杂度看树的深度
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList();
        if(root == null){
            return result;
        }
        int index = 1;
        LinkedList<Node> floor = new LinkedList();
        floor.add(root);
        while(!floor.isEmpty()) {
            List<Integer> list = new ArrayList(index);
            for(int i = 0; i < index; i++) {
                root = floor.poll();
                list.add(root.val);
                if(root.children != null) {
                    for(Node child : root.children) {
                        floor.add(child);
                    }
                }
            }
            result.add(list);
            index = floor.size();
        }
        return result;
    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        Node root2 = new Node(2);
        Node root3 = new Node(3);
        Node root4 = new Node(4);
        Node root5 = new Node(5);
        Node root6 = new Node(6);
        root3.children = Arrays.asList(root5, root6);
        root1.children = Arrays.asList(root3, root2, root4);
        List<List<Integer>> result = new LevelOrder().levelOrder(root1);
        assert result.equals(Arrays.asList(Arrays.asList(1),Arrays.asList(3,2,4),Arrays.asList(5,6)));
    }

}
