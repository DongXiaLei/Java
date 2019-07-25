package Offer66;

import JavaDataStruct.BinaryTree;

public class Problem55 {
    public static void main(String[] args) {
        System.out.println("Problem 55");
        BinaryTree bst = new BinaryTree();
        int [] arrays = {2,3,7,4,1,8,5};
        bst.create(arrays);
        bst.preorder(bst.getRoot());
        int depth = bst.getTreeDepth();
        System.out.println("Depth:"+depth);
    }
}
