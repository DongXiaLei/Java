package Offer66;

public class Problem8 {
    public static void main(String[] args){
        System.out.println("Problem 8");
        TreeNODE root = new TreeNODE();
        int[] in = {4,7,2,1,5,3,8,6};
        int[] pre= {1,2,4,7,3,5,6,8};
        int[] post= {7,4,2,5,8,6,3,1};
        root = root.reConstrucTree(null,pre,in);
        root.postOrder(root);

        System.out.println(getNextInOrder(root,root.left.left.right).data);
        System.out.println(getNextPreOrder(root,root.left.left.right).data);
    }
    public static TreeNODE  getNextInOrder(TreeNODE root,TreeNODE target){ //中序遍历的下一个节点
        if(root==null||target==null){
            return null;
        }
        else {
            TreeNODE pTmp = null;
            if(target.right!=null){  //当前节点的右节点不为空
                pTmp = target.right;
                while(pTmp.left!=null){
                    pTmp = pTmp.left;
                }
                return pTmp;
            }
            else if(target.father!=null){ // 是父节点左子节点则返回父节点
                                            // 是右子节点则上移直到找到第一个是父节点的左子节点
                TreeNODE pFather = target.father;
                pTmp = target;
                while(pFather!=null&&pFather.right == pTmp){
                    pFather = pFather.father;
                    pTmp = pTmp.father ;
                }
                return pFather;
            }
        }
        return null;
    }
    public static TreeNODE getNextPreOrder(TreeNODE root,TreeNODE target){ // 前序遍历的后一个节点
        if(root==null||target==null)
            return null;
        else{
            TreeNODE pTmp = target;
            TreeNODE pFather = null;
            if(pTmp.left!=null||pTmp.right!=null){ //子节点不为空
                return pTmp.left!=null ? pTmp.left:pTmp.right;
            }
            else {
                pFather = pTmp.father;
                while (pFather!=null) {
                    if(pFather.left==pTmp && pFather.right!=null)
                        return pFather.right;
                    else {
                        pFather = pFather.father;
                        pTmp = pTmp.father;
                    }
                    /*
                    * if(pFather.right==pTmp){   //是父节点的右子节点
                        pFather = pFather.father;
                        pTmp = pTmp.father;
                    }
                    else {    //是父节点的左子节点
                        if(pFather.right!=null){
                            return pFather.right;
                        }
                        else {
                            pFather = pFather.father;
                            pTmp = pTmp.father;
                        }
                    }
                    *
                    *
                    * */
                }
            }
        }
        return null;
    }
}

