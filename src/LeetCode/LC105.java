package LeetCode;

import java.util.Arrays;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/27 14:48
 */
public class LC105 {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeCore(preorder,inorder);
    }
    private static TreeNode buildTreeCore(int[] pre,int[] in){
        if(pre.length==0 || in.length==0)return null;
        int val = pre[0];
        int i ;
        for( i=0;i<in.length;i++){
            if(in[i] == val){
                break;
            }
        }
        TreeNode root = new TreeNode(val);
        root.left = buildTreeCore(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
        root.right= buildTreeCore( Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
        return root;
    }
    public static void main(String[] args){
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        buildTree(preorder,inorder);
    }
}
