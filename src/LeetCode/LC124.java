package LeetCode;


/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/27 20:29
 */
public class LC124 {
    int max_sum = Integer.MIN_VALUE;//全局最优

    public int max_gain(TreeNode node) {
        if (node == null) return 0;

        int left_gain = Math.max(max_gain(node.left), 0);
        int right_gain = Math.max(max_gain(node.right), 0);
        int price_newpath = node.val + left_gain + right_gain;

        max_sum = Math.max(max_sum, price_newpath);

        return node.val + Math.max(left_gain, right_gain); //当前节点和子节点能组成的最大的
    }

    public int maxPathSum(TreeNode root) {
        max_gain(root);
        return max_sum;
    }

}
