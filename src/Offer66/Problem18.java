package Offer66;

public class Problem18 {
    public static void main(String[] args){
        System.out.println("Problem 18");
        lsNode head = new lsNode();
        head.addNode(1);
        head.addNode(1);
        head.addNode(2);
        head.addNode(2);
        head.addNode(2);
        head.addNode(2);
        head.addNode(3);
        head.addNode(4);
        head.addNode(4);
        head.addNode(5);

        //head.delNextNode(head.head.next.next.next);

        head.delSameNode();
        //head.delSameNodeReCur(head.head);
        head.print();

    }
}
class lsNode{
    int data;
    lsNode next;
    public lsNode(){}
    public lsNode(int data ){
        this.data = data;
        this.next = null;
    }

    public lsNode head,last;
    public lsNode getHeadNode(){
        return head;
    }
    public void addNode(int data){
        lsNode newNode = new lsNode(data);
        this.addNode(newNode);
    }
    public void addNode(lsNode node){
        if(head == null){
            head = node;
            last = node;
        }
        else {
            last.next = node ;
            last = node ;
        }
    }
    public void delNextNode(lsNode delNode){
        if(head==null||delNode==null)
            return ;
        if(delNode.next!=null){  //不是尾结点
            lsNode pNext = delNode.next;
            delNode.data = pNext.data;
            delNode.next = pNext.next;
        }
        else if(delNode == this.head){  //是头结点且只有一个节点
            this.head = null;
        }
        else {  //是尾结点
            lsNode pTmp = this.head;
            if(pTmp.next!=null){
                while(pTmp.next.next!=null){
                    pTmp = pTmp.next;
                }
                pTmp.next = null;
            }
        }
    }
    public void delSameNode(){
        if(head==null||head.next==null){
            return;
        }
        lsNode preNode = null;
        lsNode pNode = this.head;
        while(pNode!=null){
            lsNode pNext = pNode.next;
            boolean flag = false ;
            if(pNext!=null&&pNode.data == pNext.data){
                flag =true;
            }
            if(flag) {
                //头结点重复
                while (pNext!=null && pNext.data== pNode.data){
                    pNode = pNext;
                    pNext = pNode.next;
                }
                if(preNode==null)
                    this.head= pNext;
                else preNode.next = pNext;
                pNode = pNext;
            }
            else {
                preNode = pNode;
                pNode = pNext ;
            }
        }
    }
    public lsNode delSameNodeReCur(lsNode head){
        if(head == null || head.next==null)
            return head;
        lsNode current = head.next;
        if(current.data == head.data){
            //头结点是重复元素
            current = current.next;
            while (current!=null && current.data == head.data){
                current = current.next;
            }
            head = current;
            return delSameNodeReCur(head);
        }else {
            // 头结点不是重复元素
            head.next = delSameNodeReCur(current);
            return head;
        }
    }
    public lsNode findLastKNode(int k){
        if(this.head==null||k<=0)return null;
        lsNode pTmp1= this.head;
        lsNode pTmp2= this.head;
        while (k>0){
            if(pTmp1.next!=null){
                pTmp1 = pTmp1.next;
            }
            else return null;
            k--;
        }
        while (pTmp1!=null){
            pTmp1 = pTmp1.next;
            pTmp2 = pTmp2.next;
        }
        return pTmp2;
    }
    public void print(){
        lsNode tmp = this.head;
        while(tmp!=null){
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }
}
