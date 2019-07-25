package Offer66;

import java.util.ArrayList;
import java.util.List;

public class Problem34 {
    public static void main(String [] args){
        System.out.println("Problem 34 ");
        TreeNode root = new TreeNode();
        int[] preOrder= {1,2,4,11,3,5,6,8};
        int[] inOrder = {4,11,2,1,5,3,8,6};
        TreeNode node  = root.createTree(preOrder,inOrder);   //  offer 26
        findPath(node,18);
    }
    public static void findPath(TreeNode root, int target){
        if(root==null)return;
        List<Integer> ls = new ArrayList<>();
        int currentNum = 0;
        findPath(root,target,ls,currentNum);
    }
    public static void findPath(TreeNode root,int target,List<Integer> ls,int currentNum){
        currentNum += root.data ;
        ls.add(root.data);
        boolean isLeaf = root.left==null && root.right==null; //节点是是否是叶子节点
        if(target == currentNum && isLeaf){
            for(int ele:ls){
                System.out.print(ele+" ");
            }
            System.out.println();
        }
        if(currentNum<target && root.left!=null)
            findPath(root.left,target,ls,currentNum);
        if(currentNum<target && root.right!=null)
            findPath(root.right,target,ls,currentNum);

        ls.remove(ls.size()-1);
    }
}
