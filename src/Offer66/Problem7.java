package Offer66;

import java.util.*;

public class Problem7 {
    public static void main(String[] args){
        System.out.println("Problem 7 ");
        String[] strs = {"AAA","BBB","CCC","DDD","EEE"};
        BTreeNode root = new BTreeNode();
        root.creaTree(strs);
        root.preOrder(root.root);
        root.levelOrder(root.root);

        TreeNODE rot = new TreeNODE();
        int[] pre= {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        int[] m = Arrays.copyOfRange(pre,1,5);
        rot = rot.reConstrucTree(null,pre,in);
        rot.postOrder(rot);

    }
}
class BTreeNode{  // 顺序数组构建二叉树
    private String name;
    private BTreeNode left;
    private BTreeNode right;
    public BTreeNode(){}
    public BTreeNode(String name){
        this.name = name ;
        left = right = null;
    }

    List<BTreeNode> datas ;
    BTreeNode root;
    public void creaTree(String[] names){
        datas = new ArrayList<>();
        for(String name:names){
            BTreeNode newNode = new BTreeNode(name);
            datas.add(newNode);
        }
        root = datas.get(0);
        for(int i=0;i<datas.size()/2;i++){
            datas.get(i).left = datas.get(2*i+1);
            if((i*2+2)<datas.size()){ // 2*i+2 防止最后一个子树不完全
                datas.get(i).right = datas.get(2*i+2);
            }
        }
    }
    int counter =0;
    public BTreeNode creaTree(String[] names ,BTreeNode root,int i){
        if(i<names.length){
            if(names[i]==" ")  //晦涩难懂  没必要掌握
                root = null;
            else {
                BTreeNode l = new BTreeNode();
                BTreeNode r = new BTreeNode();
                root.name = names[i];
                root.left = creaTree(names,l,counter++);
                root.right = creaTree(names,r,counter++);
            }
        }
        return root;
    }
    public void preOrder(BTreeNode root){
        if(root!=null){
            System.out.println(root.name);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    public void inOrder(BTreeNode root){
        if(root!=null){
            inOrder(root.left);
            System.out.println(root.name);
            inOrder(root.right);
        }
    }
    public void postOrder(BTreeNode root){
        if(root!=null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.name);
        }
    }
    public void levelOrder(BTreeNode root){
        Queue<BTreeNode> queue = new LinkedList<>();
        if(root!=null){
            queue.offer(root);
            while(!queue.isEmpty()){
                BTreeNode tmpNode = queue.poll();
                System.out.println(tmpNode.name);
                if(tmpNode.left!= null){
                    queue.offer(tmpNode.left);
                }
                if(tmpNode.right!=null){
                    queue.offer(tmpNode.right);
                }
            }
        }
    }

}

class TreeNODE{  //前序中序遍历序列构建二叉树
    int data;
    TreeNODE left;
    TreeNODE right;
    TreeNODE father ;
    public TreeNODE(){}
    public TreeNODE(int data){
        this.data = data ;
        left = right = father = null;
    }
    public TreeNODE reConstrucTree(TreeNODE father ,int[] pre ,int[] in){
        if(pre.length==0||in.length==0||pre.length!=in.length)
            return null;
        TreeNODE root = new TreeNODE(pre[0]);
        for(int i=0;i<in.length;i++){
            if(pre[0] == in[i]) {
                root.left = reConstrucTree(root, Arrays.copyOfRange(pre,1,i+1), Arrays.copyOfRange(in,0,i));
                root.right = reConstrucTree(root, Arrays.copyOfRange(pre,i+1,pre.length), Arrays.copyOfRange(in,i+1,in.length));
                root.father = father;
            }
        }
        return root;
    }
    public void postOrder(TreeNODE root){
        if(root!=null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.data+" ");
            if(root.father!=null){
               // System.out.println(root.father.data+" ");
            }
        }
    }

}


