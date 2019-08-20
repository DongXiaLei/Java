package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/13 21:39
 */
public class LC226 {
    public static void  main(String []args){

    }
    public static TreeNode invertTree(TreeNode root) {
        if(root==null)return null;
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
