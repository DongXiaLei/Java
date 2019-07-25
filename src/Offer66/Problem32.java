package Offer66;

public class Problem32 {
    public static void main(String[] args){
        System.out.println("Problem 32");
        TreeNode root = new TreeNode();
        int[] preOrder= {1,2,4,7,3,5,6};
        int[] inOrder = {4,7,2,1,5,3,6};

        TreeNode node  = root.createTree(preOrder,inOrder);   //  offer 26
        root.printPreOrder(node);
        System.out.println();
        root.printPostOrder(node);
        System.out.println();
        root.printLevelOrder(node);
        System.out.println();
        root.printLevelOrder2(node);
    }
}
