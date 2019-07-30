package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/27 15:09
 */
public class LC114 {
    public static void main(String[] args){

    }
    static TreeNode last = null;
    public static void flatten(TreeNode root) {
        if (root == null) return;
        // 前序：注意更新last节点，包括更新左右子树
        if (last != null) {
            last.left = null;
            last.right = root;
        }
        last = root;
        // 前序：注意备份右子节点，规避下一节点篡改
        TreeNode copyRight = root.right;
        flatten(root.left);
        flatten(copyRight);
    }


}
