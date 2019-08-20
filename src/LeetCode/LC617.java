package LeetCode;

import com.sun.source.tree.Tree;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/20 16:06
 */
public class LC617 {
    public static void main(String[] args){
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.left.left = new TreeNode(5);
        root1.right = new TreeNode(2);
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.left.right = new TreeNode(4);
        root2.right = new TreeNode(3);
        root2.right.right = new TreeNode(7);
        TreeNode root = mergeTrees(root1,root2);
    }
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode root ;
        if(t1 == null && t2 == null ){
            root = null;
        }
        else if(t1 != null && t2 !=null ){
            root = new TreeNode(t1.val+t2.val);
            root.left = mergeTrees(t1.left,t2.left);
            root.right = mergeTrees(t1.right,t2.right);
        }
        else if(t1!=null){
            root = t1;
        }else {
            root = t2;
        }
        return root;
    }
}
