package com.zj.week3;

public class LowestCommonAncestor {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
   }

    /**
     * 自顶向下的遍历
     *  两个节点 p,q 分为两种情况：
     *   p 和 q 在相同子树中
     *   p 和 q 在不同子树中
     *   从根节点遍历，递归向左右子树查询节点信息
     *   递归终止条件：如果当前节点为空或等于 p 或 q，则返回当前节点
     *   递归遍历左右子树，如果左右子树查到节点都不为空，则表明 p 和 q 分别在左右子树中，因此，当前节点即为最近公共祖先；
     *   如果左右子树其中一个不为空，则返回非空节点。
     *   时间复杂度是O(n), 空间复杂度看树的高度 最差情况是一个链表 O(n)
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }
        //分别寻找左右子树,如果俩个子树都不为空,说明 p 和 q在不同子树中,那么该节点就是最近祖先
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) {
            return root;
        }
        //否则 就说明q和p 同侧, 那么继续向下找
        if(left != null) {
            return left;
        }
        if(right != null) {
            return right;
        }
        //如果不在同侧 说明就是没有
        return null;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node0 = new TreeNode(0);
        node3.left = node5;
        node3.right = node1;
        node5.left = node6;
        node5.right = node2;
        node2.left = node7;
        node2.right = node4;
        node1.left = node0;
        node1.right = node8;
        TreeNode result = new LowestCommonAncestor().lowestCommonAncestor(node3, node5, node1);
        assert result == node3;
    }

}
