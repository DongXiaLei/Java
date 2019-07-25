package JavaDataStruct;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HuffmanTree {
    private HuffmanNode root;
    private Map codeSet = new HashMap();  //该霍夫曼树对应的字符编码集

    public HuffmanTree(HuffmanNode root){
        this.root = root;
        buildCodeSet(root,"");  //初始化编码集
    }

    //生成编码集的私有方法，运用了迭代的思想
    //参数currentNode表示当前节点，参数currentCode代表当前节点对应的代码
    private void buildCodeSet(HuffmanNode currentNode,String currentCode){
        if(currentNode.getKey() != null){
            //霍夫曼树中，如果当前节点包含关键字，则该节点肯定是叶子节点，将该关键字和代码放入代码集
            codeSet.put(currentNode.getKey(),currentCode);
        }else{//如果不是叶子节点，必定同时包含左右子节点，这种节点没有对应关键字
            //转向左子节点需要将当前代码追加0
            buildCodeSet(currentNode.getLeft(),currentCode+"0");
            //转向右子节点需要将当前代码追加1
            buildCodeSet(currentNode.getRight(),currentCode+"1");
        }
    }

    //获取编码集
    public Map getCodeSet(){
        return codeSet;
    }
    public static void main(String[] args) throws Exception{
        PriorityQueueHuffman queue = new PriorityQueueHuffman();
        HuffmanNode n1 = new HuffmanNode(1,"if");
        HuffmanNode n2 = new HuffmanNode(1,"U");
        HuffmanNode n3 = new HuffmanNode(1,"T");
        HuffmanNode n4 = new HuffmanNode(2,"Y");
        HuffmanNode n5 = new HuffmanNode(2,"E");
        HuffmanNode n6 = new HuffmanNode(2,"A");
        HuffmanNode n7 = new HuffmanNode(3,"I");
        HuffmanNode n8 = new HuffmanNode(4,"sp");
        HuffmanNode n9 = new HuffmanNode(5,"S");
        queue.insert(n3);
        queue.insert(n2);
        queue.insert(n1);
        queue.insert(n6);
        queue.insert(n5);
        queue.insert(n4);
        queue.insert(n7);
        queue.insert(n8);
        queue.insert(n9);
        queue.display();

        HuffmanTree tree =queue.buildHuffmanTree();
        Map map = tree.getCodeSet();
        Iterator it =map.entrySet().iterator();
        System.out.println("霍夫曼编码结果：");
        while(it.hasNext()){
            Map.Entry<String,String> entry = (Map.Entry)it.next();
            System.out.println(entry.getKey()+"——>"+entry.getValue());
        }
    }

}
//节点类
class HuffmanNode{
    private String key;           //树节点存储的关键字，如果是非叶子节点为空
    private int frequency;        //关键字词频
    private HuffmanNode left;            //左子节点
    private HuffmanNode right;           //右子节点
    private HuffmanNode next;            //优先级队列中指向下一个节点的引用

    public HuffmanNode(int fre,String str){  //构造方法1
        frequency = fre;
        key = str;
    }
    public HuffmanNode(int fre){  //构造方法2
        frequency = fre;
    }

    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public HuffmanNode getLeft() {
        return left;
    }
    public void setLeft(HuffmanNode left) {
        this.left = left;
    }
    public HuffmanNode getRight() {
        return right;
    }
    public void setRight(HuffmanNode right) {
        this.right = right;
    }
    public HuffmanNode getNext() {
        return next;
    }
    public void setNext(HuffmanNode next) {
        this.next = next;
    }
    public int getFrequency() {
        return frequency;
    }
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}
//用于辅助创建霍夫曼树的优先级队列
class PriorityQueueHuffman{
    private HuffmanNode first;
    private int length;

    public PriorityQueueHuffman(){
        length = 0;
        first = null;
    }

    //插入节点
    public void insert(HuffmanNode node){
        if(first == null){  //队列为空
            first = node;
        }else{
            HuffmanNode cur = first;
            HuffmanNode previous = null;
            while(cur.getFrequency()< node.getFrequency()){  //定位要插入位置的前一个节点和后一个节点
                previous = cur;
                if(cur.getNext() ==null){  //已到达队尾
                    cur = null;
                    break;
                }else{
                    cur =cur.getNext();
                }

            }
            if(previous == null){  //要插入第一个节点之前
                node.setNext(first);
                first = node;
            }else if(cur == null){  //要插入最后一个节点之后
                previous.setNext(node);
            }else{  //插入到两个节点之间
                previous.setNext(node);
                node.setNext(cur);
            }
        }
        length++;
    }

    //删除队头元素
    public HuffmanNode delete(){
        HuffmanNode temp = first;
        first = first.getNext();
        length--;
        return temp;
    }

    //获取队列长度
    public int getLength(){
        return length;
    }

    //按顺序打印队列
    public void display(){
        HuffmanNode cur = first;
        System.out.print("优先级队列：\t");
        while(cur != null){
            System.out.print(cur.getKey()+":"+cur.getFrequency()+"\t");
            cur = cur.getNext();
        }
        System.out.println();
    }

    //构造霍夫曼树
    public HuffmanTree buildHuffmanTree(){
        while(length > 1){
            HuffmanNode hLeft = delete();  //取出队列的第一个节点作为新节点的左子节点
            HuffmanNode hRight = delete(); //取出队列的第二个节点作为新节点的右子节点
            //新节点的权值等于左右子节点的权值之和
            HuffmanNode hRoot = new HuffmanNode(hLeft.getFrequency()+hRight.getFrequency());
            hRoot.setLeft(hLeft);
            hRoot.setRight(hRight);
            insert(hRoot);
        }
        //最后队列中只剩一个节点，即为霍夫曼树的根节点
        return new HuffmanTree(first);
    }

}


