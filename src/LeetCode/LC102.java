package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/27 14:02
 */
public class LC102 {
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        levelOrder(root);
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root ==null){
            return  ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);queue.offer(new TreeNode(Integer.MIN_VALUE));
        List<Integer> ls = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode tmp = queue.poll();
            if(tmp.left!=null)queue.offer(tmp.left);
            if(tmp.right!=null)queue.offer(tmp.right);
            if(tmp.val!=Integer.MIN_VALUE){
                ls.add(tmp.val);
            }else {
                queue.offer(new TreeNode(Integer.MIN_VALUE));
                if(ls.size()>0){
                    ans.add(new ArrayList<>(ls));
                }else {
                    break;
                }
                ls.clear();
            }
        }
        return ans;
    }
}
