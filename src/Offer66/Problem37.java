package Offer66;

import java.util.Scanner;

/*
 * 编写两个函数
 * 分别实现
 * 序列化和反序列化二叉树的功能
 * 序列化：将二叉树转化为一个序列
 * */
public class Problem37 {
    public static void main(String[] args){
        System.out.println("Problem 37");
        Scanner scan = new Scanner(System.in);
        String name = new String();
        //name = scan.nextLine();
        System.out.println();

        TreeNode root = new TreeNode();
        int[] preOrder= {1,2,4,11,3,5,6,8};
        int[] inOrder = {4,11,2,1,5,3,8,6};
        TreeNode node  = root.createTree(preOrder,inOrder);   //  offer 26
        SerializeTree(node);

        int [] arrays = {1,2,4,-1,11,-1,-1,-1,3,5,-1,-1,6,8,-1,-1,-1};
        node = unSerializeTree(arrays);
    }
    public static void SerializeTree(TreeNode root){
        if(root==null){
            System.out.print(-1+" ");
            return;
        }
        System.out.print(root.data+" ");
        SerializeTree(root.left);
        SerializeTree(root.right);
    }


    /*
    * 有问题
    * */
    public static int index=0;
    public static TreeNode unSerializeTree(int[] arrays){
        if(arrays.length==0||index>=arrays.length)return null;
        TreeNode root =null;
        if(arrays[index]!=-1){
            root = new TreeNode(arrays[index]);
        }
        if(index+1<arrays.length && root!=null)
            root.left = unSerializeTree(arrays);
        if(index+2<arrays.length && root!=null)
            root.right = unSerializeTree(arrays);
        return root;
    }
    public static void unSerializeTreeCore(TreeNode root,int [] arrays,int index){
        int number;
        TreeNode newNode =null;
        if(arrays[index]!=-1){
            newNode = new TreeNode(arrays[index]);
        }
        if(root==null){
            root= newNode;
            return;
        }
        if(index+1<arrays.length)
            unSerializeTreeCore(root.left,arrays,index+1);
        if(index+2<arrays.length)
            unSerializeTreeCore(root.right,arrays,index+2);

    }
}
