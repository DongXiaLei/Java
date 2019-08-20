package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/15 20:18
 */
public class LC337 {

    /*
    * 对每一个棵树
    * 只考虑根节点取不取
    * */
    public int rob(TreeNode root){
        return doRob(root);
    }
    private int doRob(TreeNode node){
        if (node == null)
            return 0;
        int include = node.val; // 根节点取
        int exclude = doRob(node.left) + doRob(node.right);// 根节点不取
        if (node.left != null)
        {
            include += doRob(node.left.left);
            include += doRob(node.left.right);
        }
        if (node.right != null){
            include += doRob(node.right.left);
            include += doRob(node.right.right);
        }
        return Math.max(include,exclude);
    }

}
