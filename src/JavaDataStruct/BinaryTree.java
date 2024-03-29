package JavaDataStruct;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* 二叉搜索树的封装类
* 特点：根节点大于左子树 小于右子树
* 便于查找中位数
* 中序遍历序列是递增的
*
* 但是容易 左右子树不平衡
* 理论高度是logn但是实际在建立查找删除等操作后会逐渐改变树的形状
* 使树退化，估应建立平衡二叉树
* 平衡二叉树主要有两种：AVL树 和 红黑树
* */
//
public class BinaryTree {
    private Node root;  //根节点
    public Node node; //为其他类所用
    public BinaryTree(){
        root = null;
    }

    /*
    * 增删改查
    *
    * */
    //插入新节点
    public void insert(Node node){
        if(root == null){
            root = node;  //如果树为空，则新插入的节点为根节点
        }else{
            Node cur = root;

            while(true){
                if(node.age < cur.age){
                    if(cur.leftChild == null){  //找到了要插入节点的父节点
                        cur.leftChild = node;
                        return;
                    }
                    cur = cur.leftChild;
                }else{
                    if(cur.rightChild == null){  //找到了要插入节点的父节点
                        cur.rightChild = node;
                        return;
                    }
                    cur = cur.rightChild;
                }
            }
        }
    }
    //删除指定节点
    public boolean delete(Node node){
        if(root == null){
            return false;  //如果为空树，直接返回false
        }

        boolean isLeftChild = true;  //记录目标节点是否为父节点的左子节点
        Node cur= root;  //要删除的节点
        Node parent = null; //要删除节点的父节点

        while(cur.age != node.age){  //确定要删除节点和它的父节点
            parent = cur;
            if(node.age < cur.age){  //目标节点小于当前节点，跳转左子节点
                cur = cur.leftChild;
            }else{//目标节点大于当前节点，跳转右子节点
                isLeftChild = false;
                cur = cur.rightChild;
            }
            if(cur == null){
                return false;  //没有找到要删除的节点
            }
        }

        if(cur.leftChild == null && cur.rightChild == null){  //目标节点为叶子节点（无子节点）
            if(cur == root){  //要删除的为根节点
                root = null;
            }else if(isLeftChild){
                //要删除的不是根节点，则该节点肯定有父节点，该节点删除后，需要将父节点指向它的引用置空
                parent.leftChild = null;
            }else{
                parent.rightChild = null;
            }
        }else if(cur.leftChild == null){  //只有一个右子节点
            if(cur == root){
                root = cur.rightChild;
            }else if(isLeftChild){
                parent.leftChild = cur.rightChild;
            }else{
                parent.rightChild = cur.rightChild;
            }
        }else if(cur.rightChild == null){  //只有一个左子节点
            if(cur == root){
                root = cur.leftChild;
            }else if(isLeftChild){
                parent.leftChild = cur.leftChild;
            }else{
                parent.rightChild = cur.leftChild;
            }
        }else{  //有两个子节点
            //第一步要找到欲删除节点的后继节点
            Node successor = cur.rightChild;
            Node successorParent = null;
            while(successor.leftChild != null){
                successorParent = successor;
                successor = successor.leftChild;
            }
            //欲删除节点的右子节点就是它的后继，证明该后继无左子节点，则将以后继节点为根的子树上移即可
            if(successorParent == null){
                if(cur == root){  //要删除的为根节点，则将后继设置为根，且根的左子节点设置为欲删除节点的做左子节点
                    root = successor;
                    root.leftChild = cur.leftChild;
                }else if(isLeftChild){
                    parent.leftChild = successor;
                    successor.leftChild = cur.leftChild;
                }else{
                    parent.rightChild = successor;
                    successor.leftChild = cur.leftChild;
                }
            }else{ //欲删除节点的后继不是它的右子节点
                successorParent.leftChild = successor.rightChild;
                successor.rightChild = cur.rightChild;
                if(cur == root){
                    root = successor;
                    root.leftChild = cur.leftChild;
                }else if(isLeftChild){
                    parent.leftChild = successor;
                    successor.leftChild = cur.leftChild;
                }else{
                    parent.rightChild = successor;
                    successor.leftChild = cur.leftChild;
                }
            }
        }

        return true;
    }
    //创建新的二叉树
    public void create(int [] arrays){
        for(int ele:arrays){
            Node newNode = new Node(ele);
            insert(newNode);
        }
    }
    //按关键字查找节点
    public Node find(int key){
        Node cur = root;  //从根节点开始查找

        if(cur == null){  //如果树为空，直接返回null
            return null;
        }

        while(cur.age != key){
            if(key < cur.age){
                cur = cur.leftChild;  //如果关键字比当前节点小，转向左子节点
            }else{
                cur = cur.rightChild;  //如果关键字比当前节点大，转向右子节点
            }

            if(cur == null){  //没有找到结果，搜索结束
                return null;
            }
        }
        return cur;
    }
    //返回关键值最大的节点
    public Node findMax(){
        if(isEmpty()){
            return null;
        }
        Node cur = root;
        while(cur.rightChild != null){
            cur = cur.rightChild;
        }
        return cur;
    }
    //返回关键值最小的节点
    public Node findMin(){
        if(isEmpty()){
            return null;
        }
        Node cur = root;
        while(cur.leftChild != null){
            cur = cur.leftChild;
        }
        return cur;
    }
    //按关键字大小查找 第 k 大 元素
    public Node findKthNums(int k){
        if(this.root==null||k<=0)return null;
        return findKthNums(this.root,k);
    }
    private int count=0;
    private Node findKthNums(Node pRoot,int k){
        Node target = null;
        if(pRoot.leftChild!=null){
            target = findKthNums(pRoot.leftChild,k);
        }
        count++;
        if(target == null){
            if(count == k){
                target = pRoot;
                return target;
            }
        }
        if(target==null && pRoot.rightChild!=null)
            target = findKthNums(pRoot.rightChild,k);

        return target;
    }

    /*
     * 遍历
     *
     * */
    public static final int PREORDER = 1;   //前序遍历
    public static final int INORDER = 2;    //中序遍历
    public static final int POSTORDER = 3;  //中序遍历

    //遍历
    public void traverse(int type){
        switch(type){
            case 1:
                System.out.print("前序遍历：\t");
                preorder(root);
                System.out.println();
                break;
            case 2:
                System.out.print("中序遍历：\t");
                inorder(root);
                System.out.println();
                break;
            case 3:
                System.out.print("后序遍历：\t");
                postorder(root);
                System.out.println();
                break;
        }
    }
    //前序遍历
    public void preorder(Node currentRoot){
        if(currentRoot != null){
            System.out.print(currentRoot.age+"\t");
            preorder(currentRoot.leftChild);
            preorder(currentRoot.rightChild);
        }
    }
    //中序遍历，这三种遍历都用了迭代的思想
    public void inorder(Node currentRoot){
        if(currentRoot != null){
            inorder(currentRoot.leftChild);  //先对当前节点的左子树对进行中序遍历
            System.out.print(currentRoot.age+"\t"); //然后访问当前节点
            inorder(currentRoot.rightChild);  //最后对当前节点的右子树对进行中序遍历
        }
    }
    //后序遍历
    public void postorder(Node currentRoot){
        if(currentRoot != null){
            postorder(currentRoot.leftChild);
            postorder(currentRoot.rightChild);
            System.out.print(currentRoot.age+"\t");
        }
    }

    /*
     * 获取最大深度
     *
     * */

    //私有方法，用迭代方法来获取左子树和右子树的最大深度，返回两者最大值
    private int getDepth(Node currentNode){
        if(currentNode==null)return 0;
        int leftDeep = getDepth(currentNode.leftChild);
        int rightDeep = getDepth(currentNode.rightChild);
        return (leftDeep>rightDeep? leftDeep:rightDeep)+1;
    }
    //获取树的深度
    public int getTreeDepth(){
        if(root == null){
            return 0;
        }
        return getDepth(root);
    }
    private int getDepth2(Node root) {
        if(root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        int depth = 0;//深度
        int firstcount = 0;//该层的最左节点
        int lastcount = 1;//该层的最右节点
        while(queue.size() != 0) {
            Node head = queue.poll();//将队列中的节点弹出，并将其左右节点放入
            count++;
            if(head.leftChild != null) {
                queue.add(head.leftChild);
            }

            if(head.rightChild != null) {
                queue.add(head.rightChild);
            }
            if(firstcount == lastcount) {//弹出该层的最后一个节点
                lastcount = queue.size();//当前队列的长度就是下一层的最后节点
                depth++;
                count = 0;//重置最左节点
            }
        }
        return depth;
    }

    //以树的形式打印出该树
    public void displayTree(){
        int depth = getTreeDepth();
        ArrayList<Node> currentLayerNodes = new ArrayList<Node> ();
        currentLayerNodes.add(root);  //存储该层所有节点
        int layerIndex = 1;
        while(layerIndex <= depth){
            int NodeBlankNum = (int)Math.pow(2, depth-layerIndex)-1;  //在节点之前和之后应该打印几个空位
            for(int i = 0;i<currentLayerNodes.size();i++){
                Node node = currentLayerNodes.get(i);
                printBlank(NodeBlankNum);   //打印节点之前的空位

                if(node == null){
                    System.out.print("*\t");  //如果该节点为null，用空位代替
                }else{
                    System.out.print("*  "+node.age+"\t");  //打印该节点
                }

                printBlank(NodeBlankNum);  //打印节点之后的空位
                System.out.print("*\t");   //补齐空位
            }
            System.out.println();
            layerIndex++;
            currentLayerNodes = getAllNodeOfThisLayer(currentLayerNodes);  //获取下一层所有的节点
        }
    }

    //获取指定节点集合的所有子节点
    private ArrayList getAllNodeOfThisLayer(List parentNodes){
        ArrayList list = new ArrayList<Node>();
        Node parentNode;
        for(int i=0;i<parentNodes.size();i++){
            parentNode = (Node)parentNodes.get(i);
            if(parentNode != null){
                if(parentNode.leftChild != null){  //如果上层的父节点存在左子节点，加入集合
                    list.add(parentNode.leftChild);
                }else{
                    list.add(null);  //如果上层的父节点不存在左子节点，用null代替，一样加入集合
                }
                if(parentNode.rightChild != null){
                    list.add(parentNode.rightChild);
                }else{
                    list.add(null);
                }
            }else{  //如果上层父节点不存在，用两个null占位，代表左右子节点
                list.add(null);
                list.add(null);
            }
        }
        return list;
    }

    //打印指定个数的空位
    private void printBlank(int num){
        for(int i=0;i<num;i++){
            System.out.print("*\t");
        }
    }

    //判空
    public boolean isEmpty(){
        return (root == null);
    }
    //判断是否是二叉平衡树
    public boolean isBalence(Node currentRoot){
        if(currentRoot == null)return true;
        int left = getDepth(currentRoot.leftChild);
        int right = getDepth(currentRoot.rightChild);
        if(Math.abs(left-right)>1){
            return false;
        }
        return isBalence(currentRoot.leftChild) && isBalence(currentRoot.rightChild);
    }

    //判断是否为叶子节点
    public boolean isLeaf(Node node){
        return (node.leftChild != null || node.rightChild != null);
    }

    //获取节点
    public Node getRoot(){
        return root;
    }
    public int getNodeData(){
        return node.getAge();
    }

}
//树节点的封装类
class Node {
    int age;
    String name;
    Node leftChild;  //左子节点的引用
    Node rightChild; //右子节点的引用
    public Node(){ }
    public Node(int age){
        this.age = age;
    }
    public Node(int age,String name){
        this.age = age;
        this.name = name;
    }
    public int getAge(){
        return this.age;
    }
    //打印该节点的信息
    public void displayNode(){
        System.out.println(",age:"+age);
    }
}

