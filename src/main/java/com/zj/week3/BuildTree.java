package com.zj.week3;

import java.util.*;

/**
 * 给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
 *
 *  
 *
 * 示例 1:
 *
 *
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * 示例 2:
 *
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *  
 *
 * 提示:
 *
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均无重复元素
 * inorder 均出现在 preorder
 * preorder 保证为二叉树的前序遍历序列
 * inorder 保证为二叉树的中序遍历序列
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BuildTree {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    //利用map存储inorder中的值和位置的对应关系
    Map<Integer,Integer> map = new HashMap();

    //前序遍历可以确定root, 中序遍历可以确定左右子树
    //时间复杂度是O(n) 每一个元素都遍历了一次, 空间复杂度是 O(n) 使用一个map 以及递归栈
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        for(int i = 0; i < inorder.length; i ++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode dfs(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd){
        if(pStart > pEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pStart]);
        if(pStart == pEnd) {
            return root;
        }
        //找到左右子树分界处
        int index = map.get(preorder[pStart]) - iStart;
        root.left = dfs(preorder, pStart + 1, pStart + index, inorder, iStart, iStart + index - 1);
        root.right = dfs(preorder, pStart + index + 1, pEnd, inorder, iStart + index + 1, iEnd);
        return root;
    }

    public static void main(String[] args) {
        TreeNode result = new BuildTree().buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        assert Arrays.asList(3,9,20,"null","null",15,7,"null","null","null","null").equals(treeToList(result));
    }

    private static List treeToList(TreeNode root){
        List result = new ArrayList();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (node == null) {
                result.add("null");
                continue;
            }

            result.add(node.val);
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return result;
    }

}
