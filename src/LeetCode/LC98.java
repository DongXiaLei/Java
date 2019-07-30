package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/27 10:28
 */
public class LC98 {
    public static void main(String [] agrs){

    }
    public boolean isValidBST(LC94.TreeNode root) {
        return  isValidBSTCore(root,null,null);
    }
    private static boolean isValidBSTCore(LC94.TreeNode root,Integer min,Integer max){
        if(root==null)return true;
        int val = root.val ;
        if(min!=null && val<=min)return false;
        if(max!=null && val>=max)return false;

        if(!isValidBSTCore(root.left,min,val))return false;
        if(!isValidBSTCore(root.right,val,max))return false;

        return true;
    }
}
