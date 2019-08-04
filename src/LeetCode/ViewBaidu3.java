package LeetCode;

<<<<<<< HEAD
import java.util.*;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/2 16:33
 */
public class ViewBaidu3 {
    public static void main(String[] args){
        int[] preorder = {3,9,8,20,15,7};
        int[] inorder = {8,9,3,15,20,7};
        TreeNode root = buildTree(preorder,inorder);
        inOrder(root);
    }
    //建树
    private static TreeNode buildTree(int[] pre,int[] in){
        if(pre.length==0 || in.length==0)return null;
        int val = pre[0];
        int i ;
        for( i=0;i<in.length;i++){
            if(in[i] == val){
                break;
            }
        }
        TreeNode root = new TreeNode(val);
        root.left = buildTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
        root.right= buildTree( Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
        return root;
    }
    // 非递归二叉树实现三种遍历
    public static void inOrder(TreeNode root){
        Stack<TreeNode> queue = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        if(root!=null) queue.push(root);
        while (!queue.isEmpty()){
            while (root.left!=null){
                queue.push(root.left);
                root = root.left;
            }
            TreeNode tmp =queue.pop();
            ans.add(tmp.val);
            if(tmp.right!=null){
                queue.push(tmp.right);
                root = tmp.right;
            }
        }
        return;
    }
    public static void inOrder(TreeNode root){
        Stack<TreeNode> queue = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        if(root!=null) queue.push(root);
        while (!queue.isEmpty()){
            while (root.left!=null){
                queue.push(root.left);
                root = root.left;
            }
            TreeNode tmp =queue.pop();
            ans.add(tmp.val);
            if(tmp.right!=null){
                queue.push(tmp.right);
                root = tmp.right;
            }
        }
        return;
    }
=======
import java.util.Scanner;

public class ViewBaidu3 {
    static int[] nums = new int[26];
    static int[][] charOfnums = new int[26][2];//分别表示每个字母在开头的数量和结尾的数量
    public static void main(String[] args){
        for(int i =0;i<nums.length;i++){
            nums[i] = -1;
            charOfnums[i][0] = 0;
            charOfnums[i][1] = 0;
        }
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String [] strings = new String[n];
        for(int i=0;i<n;i++){
            strings[i] = in.next();
        }
        System.out.println(isCircle(strings));

    }
    public static boolean isCircle(String[] strings){
        for(String string :strings){
            int begin = string.charAt(0)-'a';
            int end = string.charAt(string.length()-1)-'a';
            charOfnums[begin][0]++;
            charOfnums[end][1]++;
            union(begin,end);
        }
        int root = find(0);
        for(int i=0;i<nums.length;i++){
            int nums =charOfnums[i][0]+charOfnums[i][1];
            if(nums %2 == 1 || charOfnums[i][0]!=charOfnums[i][1])return false;
            else if(nums>=2){
                if( root != find(i)){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean union(int k1,int k2 ){
        int root1 = find(k1);
        int root2 = find(k2);
        if(root1!= root2){
            nums[root1] = root2;
            return true;
        }else return false;
    }
    public static int find(int k){
        int i =k;
        while (nums[i]!=-1 && i != nums[i]) i = nums[i];
        return i;
    }

>>>>>>> b55e32c9533b9e1b26c26b0d7a841bdb840bddf3
}
