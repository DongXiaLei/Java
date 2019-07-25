package Offer66;

import JavaDataStruct.BinaryTree;
public class Problem54 {
    public static void main(String[] args) {
        System.out.println("Problem 54");
        BinaryTree bst = new BinaryTree();
        int [] arrays = {2,3,7,4,1,8,5};
        bst.create(arrays);
        bst.preorder(bst.getRoot());
        bst.node = bst.findKthNums(2);
        System.out.println();
        System.out.println(bst.getNodeData());

    }
}


