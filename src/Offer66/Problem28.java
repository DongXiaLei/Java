package Offer66;

public class Problem28 {
    public static void main(String [] args){
        System.out.println("Problem 28");
        TreeNode root = new TreeNode();
        int[] pre= {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        int[] arrays = {8,6,6,5,7,7,5} ;
        TreeNode root1  = root.createTree(pre,in);
        TreeNode root2  = root.createTree(arrays);
        boolean ans = isSymmetrical(root1);
        ans = isSymmetrical(root2);
    }
    public static boolean isSymmetrical(TreeNode root){
        return isSymmetrical(root,root);
    }
    private static boolean isSymmetrical(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null)return true;
        if(root1==null || root2==null)return false;
        if(root1.data != root2.data)return false;
        return isSymmetrical(root1.left,root2.right) && isSymmetrical(root1.right,root2.left);
    }


}
