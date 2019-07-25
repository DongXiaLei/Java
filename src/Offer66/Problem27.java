package Offer66;

public class Problem27 {
    public static void main(String [] args){
        System.out.println("Problem 27");
        TreeNode root = new TreeNode();
        int[] pre= {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode node  = root.createTree(pre,in);

        node = MirrorTree(node);


    }
    public static TreeNode MirrorTree(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return null;
        TreeNode pTmp = root.left;
        root.left = root.right;
        root.right = pTmp;
        MirrorTree(root.left);
        MirrorTree(root.right);
        return root;
    }
}
