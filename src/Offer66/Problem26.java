package Offer66;

import java.util.*;

public class Problem26 {
    public static void main(String[] args){
        System.out.println("Problem 26");
        TreeNode root = new TreeNode();
        int[] pre= {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode node  = root.createTree(pre,in);
        //root = root.root;
        root.printPreOrder(node);
        root.printPostOrder(node);
        root.printLevelOrder(node);
        boolean ans = HasSubTree(node,node.right);
    }
    public static boolean HasSubTree(TreeNode root1,TreeNode root2){
        boolean ans = false;
        if(root1!=null && root2!=null){
            if(root1.data == root2.data)
                ans = isTree1HasTree2(root1,root2);
            if(!ans){
                ans = HasSubTree(root1.left,root2);
            }
            if(!ans)
                ans = HasSubTree(root1.right,root2);
        }
        return ans;
    }
    private static boolean isTree1HasTree2(TreeNode root1,TreeNode root2){
        if(root2==null)return true;
        if(root1==null)return false;
        if(root1.data!= root2.data)return false;
        return isTree1HasTree2(root1.left,root2.left) && isTree1HasTree2(root1.right,root2.right);
    }
}
class TreeNode{
    int data ;
    TreeNode left;
    TreeNode right;
    TreeNode father;
    public TreeNode(){}
    public TreeNode(int data){
        this.data = data;
        left = right = father =null;
    }
    private TreeNode root;
    public TreeNode createTree(int[] datas){
        if(datas.length==0)return null;
        List<TreeNode> ls = new ArrayList<>();
        for(int data:datas){
            TreeNode tmp = new TreeNode(data);
            ls.add(tmp);
        }
        this.root = ls.get(0);
        root.father =null;
        for(int i=0;i<ls.size()/2;i++){
            ls.get(i).left = ls.get(i*2+1);
            if(2*i+2<=ls.size()){
                ls.get(i).right =ls.get(2*i+2);
            }
            ls.get(i).father = ls.get((i-1)/2);
        }
        return root;
    }
    public TreeNode createTree(int [] pre, int [] in){
        this.root = reCreateTree(null,pre,in);
        return this.root;
    }
    private TreeNode reCreateTree(TreeNode father,int [] pre, int [] in){
        if(pre.length==0||in.length==0||pre.length!=in.length)
            return null;
        TreeNode root = new TreeNode(pre[0]);
        for(int i =0 ;i<pre.length;i++){
            if(pre[0] == in[i]){
                root.left = reCreateTree(root, Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                root.right =reCreateTree(root,Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
                root.father = father;
            }
        }
        return root;
    }
    public void printPreOrder(TreeNode root){
        if(root!=null){
            System.out.print(root.data+" ");
            printPreOrder(root.left);
            printPreOrder(root.right);
            if(root.father!=null){
               //System.out.println(" "+root.father.data);
            }
        }
    }
    public void printPostOrder(TreeNode root){
        if(root!=null){
            printPostOrder(root.left);
            printPostOrder(root.right);
            System.out.print(root.data+" ");
        }
    }
    public void printLevelOrder(TreeNode root){
        if(root==null)return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode pTmp = queue.poll();
            System.out.print(pTmp.data+" ");
            if(pTmp.left!=null)
                queue.offer(pTmp.left);
            if(pTmp.right!=null)
                queue.offer(pTmp.right);
        }
    }
    public void printLevelOrder2(TreeNode root){
        if(root==null)return;
        Queue<TreeNode > queue = new LinkedList<>();
        queue.offer(root);
        int nextLevel = 0, currLevel =1 ;
        while (!queue.isEmpty()){
            TreeNode pTmp = queue.poll();
            currLevel -- ;
            System.out.print(pTmp.data+" ");
            if(pTmp.left!=null){
                queue.offer(pTmp.left);
                nextLevel++;
            }
            if(pTmp.right!=null){
                queue.offer(pTmp.right);
                nextLevel++;
            }
            if(currLevel==0){
                System.out.println("");
                currLevel = nextLevel ;
                nextLevel = 0;
            }
        }
    }
}
