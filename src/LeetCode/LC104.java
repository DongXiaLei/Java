package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/27 14:32
 */
public class LC104 {
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        maxDepth(root);
    }
    public static int maxDepth(TreeNode root) {
        int ans =0 ;
        ans =maxDepthCore(root,1);
        return ans ;
    }
    private static int maxDepthCore(TreeNode root, int depth){
        if(root==null)return depth-1;
        int left =0,right =0;
        left = Math.max(left,maxDepthCore(root.left,depth+1));
        right = Math.max(right,maxDepthCore(root.right,depth+1));

        return Math.max(left,right);
    }
}
