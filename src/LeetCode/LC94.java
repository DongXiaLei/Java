package LeetCode;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/26 20:25
 */

public class LC94 {
    public static void main(String [] args){
        inorderTraversal(root);
    }
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right ;
        public TreeNode(int val ){this.val = val;}
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root,ans);
        return ans;
    }
    private static void inorder(TreeNode root,List<Integer> ans){
        if(root!=null){
            inorder(root.left,ans);
            ans.add(root.val);
            inorder(root.right,ans);
        }
    }

}
