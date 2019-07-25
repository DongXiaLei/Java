package Offer66;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Queue;

public class Problem9 {
    public static void main(String[] args){
        System.out.println("Problem 9");
        QueueSelf q = new QueueSelf();
        System.out.println(q.delHead());
        q.addTail(1);
        q.addTail(2);
        q.addTail(3);
        System.out.println(q.delHead());
        q.addTail(4);
        q.addTail(5);
        System.out.println(q.delHead());

        Stack<Integer> s;
        List<Integer> ls = new Stack<>();
        Queue<Integer> que = new LinkedList<>();


        StackSelf ss = new StackSelf();
        ss.push(1);
        System.out.println(ss.pop());
        ss.push(2);
        ss.push(3);
        ss.push(4);
        System.out.println(ss.pop());
        System.out.println(ss.pop());
        ss.push(5);






    }
}
class QueueSelf{
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>(); //一定初始化 不然没法使用属性和方法

    public Integer delHead(){
        if(s1.size()==0&&s2.size()==0){
            System.out.println("Queue isEmpty");
            return -1;
        }
        else {
            if(s1.size()==0){
                while(s2.size()!=0){
                    s1.push(s2.pop());
                }
            }
            return s1.pop();
        }
    }
    public void addTail(int ele){
        s2.push(ele);
    }

}
class StackSelf{
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    public Integer pop(){
        if(q1.size()==0&&q2.size()==0){
            System.out.println("Stack isEmpty");
            return -1;
        }
        if(q1.size()!=0){
            while(q1.size()!=1){
                q2.offer(q1.poll());
            }
            return q1.poll();
        }
        else {
            while(q2.size()!=1){
                q1.offer(q2.poll());
            }
            return q2.poll();
        }
    }
    public void push(int ele){
        if(q1.size()!=0){
            q1.offer(ele);
        }
        else q2.offer(ele);
    }
}
