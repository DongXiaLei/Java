package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/27 11:09
 */
public class LC101 {
    public static boolean isSymmetric(LC94.TreeNode root) {
        return isSymmetricCore(root,root);
    }
    public static boolean isSymmetricCore(LC94.TreeNode root1,LC94.TreeNode root2){
        if(root1==null && root2==null)return true;
        else if(root1==null || root2==null)return false;
        else {
            if(root1.val==root2.val){
                return isSymmetricCore(root1.left,root2.right) && isSymmetricCore(root1.right,root2.right);
            }else return false;
        }

    }
    public static void main(String[] args){

    }
}
