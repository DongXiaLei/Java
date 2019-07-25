package Offer66;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Problem6 {
    public static void main(String[] args){
        System.out.println("Problem 6");
        listNode head1 = new listNode();
        listNode head2 = new listNode();
        listNode head = new listNode();

        String[] names = {"AAA","BBB","CCC"};
        head1.createList(names);

        head2.addNode("DDD");
        head2.addNode("EEE");
        head2.addNode("FFF");
        head2.addNode("TTT"); // 不能在 getHead之后再调用addNode 因为会加到第一个节点的head属性上
        head2 = head2.getHead();
        head1.addNode(head2);
        head = head1.getHead();


        head.print();
        head.rePrint();//栈反向输出链表
        //reCurPrint(head);//递归实现输出链表
    }
    public static void reCurPrint(listNode head){
        listNode pHead = head ;
        if(pHead!=null&&pHead.next!=null){
            reCurPrint(pHead.next);
        }
        System.out.println(pHead.name);
    }
}
class listNode{  // 数组创建链表
    public String name;
    public listNode next;
    listNode(){}
    listNode(String name){
        this.name = name ;
        next = null;
    }

    private listNode head,last ;
    public listNode getHead(){
        return this.head;
    }
    public void addNode(listNode node){
        if(this.head== null){
            this.head = node ;
            this.last = node ;
        }
        else {
            this.last.next = node ;
            this.last = node ;
        }
    }
    public void addNode(String name){
        listNode node = new listNode(name);
        this.addNode(node);
    }
    public void createList(String[] names){
        for(String name : names){
            listNode node = new listNode(name);
            this.addNode(node);
        }
    }
    public void print(){
        listNode p = this ;
        while(p!=null){
            System.out.println(p.name);
            p = p.next ;
        }
    }
    public void rePrint(){  //反向输出链表
        listNode pHead = this ;
        Stack<listNode> stack = new Stack<>();
        while(pHead!=null){
            stack.push(pHead);
            pHead = pHead.next ;
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop().name);
        }
    }
}
class ReverseList{  // 递归创建链表
    private LinkedList<Integer> ll = new LinkedList<>();
    public ReverseList(int e){
        for(int i=0;i<e;++i){
            ll.add(i+1);
        }
    }
    public void printReverseLinkedList(){
        List<Integer> ls = new ArrayList<>();
        for(int i= ll.size()-1;i>=0;--i){
            ls.add(ll.get(i));
        }
        int i =0;
        while(i<ls.size()){
            System.out.println(ls.get(i++));
        }
    }
    class Node{
        private String name;
        private Node next;
        public Node(String name){
            this.name = name;
            next =null;
        }
        public void addNode(Node newnode){
            if(this.next==null){
                this.next =newnode ;
            }else {
                this.next.addNode(newnode);
            }
        }
        public void printNode(){
            System.out.println(name);
            if(this.next!=null)
                this.next.printNode();

        }
    }
    public Node root ;
    public void add(String name){
        Node node = new Node(name);
        if(root==null){
            root =node;
        }else {
            root.addNode(node);
        }
    }
    public void print(){
        if(root!=null){
            root.printNode();
        }
    }
}
