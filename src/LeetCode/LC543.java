package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/20 10:37
 */
public class LC543 {
    public static void main(String[] args){
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.right = new TreeNode(6);

        System.out.println(diameterOfBinaryTree(root));
    }
    public static int ans =0;
    public static int diameterOfBinaryTree(TreeNode root) {
        getDepth(root);
        return ans;
    }
    public static int getDepth(TreeNode root){
        if(root == null) return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        ans = Math.max(left+right,ans);
        return Math.max(left,right)+1;
    }
}
