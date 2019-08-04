package LeetCode;

import java.util.*;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/2 16:33
 */
public class ViewBaidu3 {
    public static void main(String[] args){
        int[] preorder = {3,9,8,20,15,7};
        int[] inorder = {8,9,3,15,20,7};
        TreeNode root = buildTree(preorder,inorder);
        inOrder(root);
    }
    //建树
    private static TreeNode buildTree(int[] pre,int[] in){
        if(pre.length==0 || in.length==0)return null;
        int val = pre[0];
        int i ;
        for( i=0;i<in.length;i++){
            if(in[i] == val){
                break;
            }
        }
        TreeNode root = new TreeNode(val);
        root.left = buildTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
        root.right= buildTree( Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
        return root;
    }
    // 非递归二叉树实现三种遍历
    public static void inOrder(TreeNode root){
        Stack<TreeNode> queue = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        if(root!=null) queue.push(root);
        while (!queue.isEmpty()){
            while (root.left!=null){
                queue.push(root.left);
                root = root.left;
            }
            TreeNode tmp =queue.pop();
            ans.add(tmp.val);
            if(tmp.right!=null){
                queue.push(tmp.right);
                root = tmp.right;
            }
        }
        return;
    }
    public static void inOrder(TreeNode root){
        Stack<TreeNode> queue = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        if(root!=null) queue.push(root);
        while (!queue.isEmpty()){
            while (root.left!=null){
                queue.push(root.left);
                root = root.left;
            }
            TreeNode tmp =queue.pop();
            ans.add(tmp.val);
            if(tmp.right!=null){
                queue.push(tmp.right);
                root = tmp.right;
            }
        }
        return;
    }
}
