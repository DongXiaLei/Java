package Offer66;

public class Problem22 {
    public static void main(String[] args){
        System.out.println("Problem 22");
        lNode head = new lNode();
        int [] arrays = new int[]{1,2,3,4,4,5,5,5,6};
        head.createList(arrays);
        head.print();
        //System.out.println(head.findLastKNode(1).data);

    }
}
class lNode{
    int data;
    lNode next;
    public lNode(){}
    public lNode(int data){
        this.data = data;
        next = null;
    }
    public lNode head,last;
    public lNode getHead(){
        return this.head;
    }
    public void addNode(lNode node){
        if(head==null){
            head = node;
            last = node;
        }
        else {
            last.next = node ;
            last = node ;
        }
    }
    public void addNode(int data){
        lNode newNode = new lNode(data);
        this.addNode(newNode);
    }
    public void createList(int [] arrays){
        for(int i=0;i<arrays.length;i++){
            this.addNode(arrays[i]);
        }
    }
    public void print(){
        lNode pTmp = this.head;
        while (pTmp!=null){
            System.out.println(pTmp.data);
            pTmp = pTmp.next;
        }
    }
    public lNode findLastKNode(int k){  // offer 22 找到倒数第K个节点
        if(k<=0||head==null)
            return null;
        lNode pTmp1 = this.head;
        lNode pTmp2 = this.head;
        while (k>0){
            if(pTmp1!=null){
                pTmp1 = pTmp1.next;
            }else {
                return null;
            }
            k--;
        }
        while (pTmp1!=null){
            pTmp1 = pTmp1.next;
            pTmp2 = pTmp2.next;
        }
        return pTmp2;
    }
    public void makeCircleList(lNode meetNode){
        // offer 23_1
        this.last.next = meetNode ;
    }
    public lNode findMeetingNode(){ // offer 23_2
        if(this.head==null)
            return null;
        lNode pFast = this.head.next;
        lNode pSlow = this.head;
        while (pFast!=null&&pSlow!=null){
            if(pFast==pSlow)
                return pFast;
            pSlow = pSlow.next;
            pFast = pFast.next;
            if(pFast!=null)
                pFast = pFast.next;
        }
        return null;
    }
    public lNode findCircleEntry(){ // offer 23_3
        lNode meetingNode = this.findMeetingNode();
        if(meetingNode == null)
            return null;

        int count = 1 ;
        lNode pTmp1 = meetingNode;
        lNode pTmp2 = this.head;
        while (pTmp1.next!=meetingNode){
            pTmp1 = pTmp1.next;
            count++;
        }
        pTmp1 = this.head;
        while (count-- != 0){
            pTmp1 = pTmp1.next;
        }
        while (pTmp1!=pTmp2){
            pTmp1 = pTmp1.next;
            pTmp2 = pTmp2.next;
        }
        return pTmp1;
    }
    public lNode reverseList(){
        if(this.head==null)
            return null;
        lNode pTmp = this.head;
        lNode preNode = null;
        lNode pHead = null;
        while (pTmp!=null){
            lNode pNext = pTmp.next;
            if(pNext == null)
                pHead = pTmp;
            pTmp.next = preNode ;
            preNode = pTmp;
            pTmp = pNext ;
        }
        this.head = pHead;
        return pHead;
    }


}
