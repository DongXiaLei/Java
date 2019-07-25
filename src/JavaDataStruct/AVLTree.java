package JavaDataStruct;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/14 16:07
 */
/**
 * @author Xialei Dong
 */
/*
* AVL树也是一棵二叉查找树
* 自平衡二叉查找树，也被称为高度平衡树。
* 相比于二叉查找树，它的特点是：任何节点的两个子树的最大高度差为1。
*
* */
public class AVLTree {

    private AVLTreeNode root; // 根结点

    /**
     * 插入操作的入口
     * @author Xialei Dong
     * @param insertValue
     */
    public void insert(long insertValue) {
        root = insert(root, insertValue);
    }

    /**
     * 插入的地递归实现
     * @author Xialei Dong
     * @param subTree
     * @param insertValue
     * @return
     */
    private AVLTreeNode insert(AVLTreeNode subTree, long insertValue) {
        if (subTree == null) {
            return new AVLTreeNode(insertValue, null, null);
        }

        if (insertValue < subTree.value) { // 插入左子树

            subTree.left = insert(subTree.left, insertValue);
            if (unbalanceTest(subTree)) { // 插入后造成失衡
                if (insertValue < subTree.left.value) { // LL型失衡
                    subTree = leftLeftRotation(subTree);
                } else { // LR型失衡
                    subTree = leftRightRotation(subTree);
                }
            }

        } else if (insertValue > subTree.value) { // 插入右子树

            subTree.right = insert(subTree.right, insertValue);
            if (unbalanceTest(subTree)) { // 插入后造成失衡
                if (insertValue < subTree.right.value) { // RL型失衡
                    subTree = rightLeftRotation(subTree);
                } else { // RR型失衡
                    subTree = rightRightRotation(subTree);
                }
            }

        } else {
            throw new RuntimeException("duplicate value: " + insertValue);
        }

        return subTree;
    }

    /**
     * RL型旋转
     * @author Xialei Dong
     * @param k1 子树根节点
     * @return
     */
    private AVLTreeNode rightLeftRotation(AVLTreeNode k1) {
        k1.right = leftLeftRotation(k1.right);

        return rightRightRotation(k1);
    }

    /**
     * RR型旋转
     * @author Xialei Dong
     * @param k1 k1 子树根节点
     * @return
     */
    private AVLTreeNode rightRightRotation(AVLTreeNode k1) {
        AVLTreeNode k2;

        k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;

        return k2;
    }

    /**
     * LR型旋转
     * @author Xialei Dong
     * @param k3
     * @return
     */
    private AVLTreeNode leftRightRotation(AVLTreeNode k3) {
        k3.left = rightRightRotation(k3.left);

        return leftLeftRotation(k3);
    }

    /**
     * LL型旋转
     * @author Xialei Dong
     * @param k2
     * @return
     */
    private AVLTreeNode leftLeftRotation(AVLTreeNode k2) {
        AVLTreeNode k1;

        k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;

        return k1;
    }

    /**
     * 获取树的深度
     * @author Xialei Dong
     * @param treeRoot 根节点
     * @param initDeep 初始深度
     * @return
     */
    private static int getDepth(AVLTreeNode treeRoot, int initDeep) {
        if (treeRoot == null) {
            return initDeep;
        }
        initDeep++;
        int leftDeep = initDeep;
        int rightDeep = initDeep;
        if (treeRoot.left != null) {
            leftDeep = getDepth(treeRoot.left, initDeep);
        }
        if (treeRoot.right != null) {
            rightDeep = getDepth(treeRoot.right, initDeep);
        }

        return Math.max(leftDeep, rightDeep);
    }


    /**
     * 判断是否失衡
     * @author Xialei Dong
     * @param treeRoot
     * @return
     */
    private boolean unbalanceTest(AVLTreeNode treeRoot) {
        int leftHeight = getDepth(treeRoot.left, 0);
        int righHeight = getDepth(treeRoot.right, 0);
        int diff = Math.abs(leftHeight - righHeight);
        return diff > 1;
    }

    /**
     * 删除操作的入口
     * @param value
     */
    public void remove(long value) {
        root = remove(root, value);
    }

    /**
     * 删除操作的递归实现
     * @param tree
     * @param value
     * @return
     */
    private AVLTreeNode remove(AVLTreeNode tree, long value) {
        if (tree == null) {
            return tree;
        }

        if (value < tree.value) { //要删除的节点在左子树

            tree.left = remove(tree.left, value);

        } else if (value > tree.value){  //要删除的节点在右子树

            tree.right = remove(tree.right, value);

        } else if (tree.value == value) {  //要删除的节点就是本身

            if (tree.left != null && tree.right != null) { // 左右子树都存在

                if (getDepth(tree.left, 1) > getDepth(tree.right, 1)) {
                    /**
                     * 如果tree的左子树比右子树高:
                     * 1. 找出tree的左子树中的最大节点
                     * 2. 将该最大节点的值赋值给tree。
                     * 3. 删除该最大节点。
                     * 这类似于用"tree的左子树中最大节点"做"tree"的替身
                     * 采用这种方式的好处是：删除"tree的左子树中最大节点"之后，AVL树仍然是平衡的
                     */
                    AVLTreeNode max = getMaxNode(tree.left);
                    tree.value = max.value;
                    tree.left = remove(tree.left, max.value);
                } else {
                    /**
                     * 如果tree的左子树不高于右子树:
                     * 1. 找出tree的右子树中的最小节点
                     * 2. 将该最小节点的值赋值给tree。
                     * 3. 删除该最小节点。
                     * 这类似于用"tree的右子树中最小节点"做"tree"的替身
                     * 采用这种方式的好处是：删除"tree的左子树中最大节点"之后，AVL树仍然是平衡的
                     */
                    AVLTreeNode min = getMinNode(tree.right);
                    tree.value = min.value;
                    tree.right = remove(tree.right, min.value);

                }

            } else {

                tree = tree.left == null ? tree.right : tree.left;

            }
        } else {
            System.out.println("no node matched value: " + value);
        }

        return tree;
    }


    /**
     * 获取值最大的节点
     * @param node
     * @return
     */
    private AVLTreeNode getMaxNode(AVLTreeNode node) {
        if (node == null) {
            return null;
        }

        if (node.right != null) {
            return getMaxNode(node.right);
        } else {
            return node;
        }
    }

    /**
     * 获取值最小的节点
     * @param node
     * @return
     */
    private AVLTreeNode getMinNode(AVLTreeNode node) {
        if (node == null) {
            return null;
        }

        if (node.left != null) {
            return getMinNode(node.left);
        } else {
            return node;
        }
    }

    // AVL树的节点
    class AVLTreeNode {
        long value; // 节点存储的数值
        AVLTreeNode left; // 左孩子
        AVLTreeNode right; // 右孩子

        public AVLTreeNode(long value, AVLTreeNode left, AVLTreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public long getValue() {
            return this.value;
        }

        public void setValue(long value) {
            this.value = value;
        }

        public AVLTreeNode getLeft() {
            return this.left;
        }

        public void setLeft(AVLTreeNode left) {
            this.left = left;
        }

        public AVLTreeNode getRight() {
            return this.right;
        }

        public void setRight(AVLTreeNode right) {
            this.right = right;
        }

    }


    /**
     * 前序遍历
     * @param currentRoot
     */
    public static void preorder(AVLTreeNode currentRoot) {
        if (currentRoot != null) {
            System.out.print(currentRoot.value + "\t");
            preorder(currentRoot.left);
            preorder(currentRoot.right);
        }
    }
    public static void inorder(AVLTreeNode currentRoot) {
        if (currentRoot != null) {

            inorder(currentRoot.left);
            System.out.print(currentRoot.value + "\t");
            inorder(currentRoot.right);
        }
    }

    public static void main(String [] args) {
        AVLTree tree = new AVLTree();
        int arr[]= {3,2,1,4,5,6,7,16,15,14,13,12,11,10,8,9};
        for (int a : arr) {
            tree.insert(a);

        }
        System.out.println(getDepth(tree.root,0));
        preorder(tree.root);
        System.out.println();
        inorder(tree.root);
    }

}

