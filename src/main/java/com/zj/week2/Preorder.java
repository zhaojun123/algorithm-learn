package com.zj.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的 前序遍历 。
 *
 * N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 *
 *  
 *
 * 进阶：
 *
 * 递归法很简单，你可以使用迭代法完成此题吗?
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[1,3,5,6,2,4]
 * 示例 2：
 *
 *
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 *  
 *
 * 提示：
 *
 * N 叉树的高度小于或等于 1000
 * 节点总数在范围 [0, 10^4] 内
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Preorder {

    static class Node {
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

    //使用迭代法完成遍历
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList();
        LinkedList<Node> stack = new LinkedList();
        if(root == null) {
            return result;
        }
        stack.push(root);
        while(!stack.isEmpty()) {
            root = stack.poll();
            result.add(root.val);
            List<Node> children = root.children;
            if(children != null) {
                for(int i = children.size() - 1; i >= 0; i --) {
                    stack.push(children.get(i));
                }
            }
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
        List<Integer> result = new Preorder().preorder(root1);
        assert result.equals(Arrays.asList(1,3,5,6,2,4));
    }

}
