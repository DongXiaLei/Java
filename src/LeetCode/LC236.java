package LeetCode;

import java.util.Stack;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/14 14:33
 */
public class LC236 {
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        TreeNode p = root.right.left;
        TreeNode q = root.right.right;
        lowestCommonAncestor(root,p,q);
    }
    private static TreeNode ans;
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recurseTree(root, p, q);
        return ans;
    }
    private static boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
        if (currentNode == null) {
            return false;
        }
        int left = recurseTree(currentNode.left, p, q) ? 1 : 0;
        int right = recurseTree(currentNode.right, p, q) ? 1 : 0;
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;

        // If any two of the flags left, right or mid become True
        if (mid + left + right >= 2) {
            ans = currentNode;
        }
        return (mid + left + right > 0);
    }



}
