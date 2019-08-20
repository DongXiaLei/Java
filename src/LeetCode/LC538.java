package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/19 20:54
 */
public class LC538 {
    public static void main(String[] args){
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        //root.left.left = new TreeNode(0);
        //root.left.right = new TreeNode(2);
        root.right = new TreeNode(3);
        //root.right.left = new TreeNode(4);
        //root.right.right = new TreeNode(7);
        LC538 solution = new LC538();
        solution.convertBST(root);

    }
    static int sum =0;
    public TreeNode convertBST(TreeNode root) {

        backOrder(root);
        return root;
    }
    public void backOrder(TreeNode root) {
        if(root == null) {
            return ;
        }
        backOrder(root.right);
        root.val += sum;
        sum = root.val;
        backOrder(root.left);
    }


}
/*
*
* public TreeNode convertBST(TreeNode root) {

        backOrder(root);
        return root;
    }
    public void backOrder(TreeNode root) {
        if(root == null) {
            return ;
        }
        backOrder(root.right);
        root.val += sum;
        sum = root.val;
        backOrder(root.left);
    }
* */