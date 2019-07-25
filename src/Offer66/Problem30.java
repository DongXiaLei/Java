package Offer66;

import java.util.*;

public class Problem30 {
    public static void main(String[] args){
        System.out.println("Problem 30");
        StackMinSelf sms = new StackMinSelf();
        sms.push(5);
        sms.push(7);
        sms.push(4);
        sms.push(2);
        sms.push(3);
        sms.push(8);

        sms.pop();
        System.out.println(sms.min());
        sms.pop();
        System.out.println(sms.min());
        sms.pop();
        System.out.println(sms.min());
        sms.pop();
        System.out.println(sms.min());
        sms.pop();
        System.out.println(sms.min());
        sms.pop();
        System.out.println(sms.min());

        QueueMaxSelf qs = new QueueMaxSelf();
        qs.push_back(1);
        qs.push_back(2);
        qs.push_back(6);
        qs.push_back(5);
        qs.push_back(3);
        qs.push_back(4);

        System.out.println(qs.max());
        qs.pop_head();
        System.out.println(qs.max());
        qs.pop_head();
        System.out.println(qs.max());
        qs.pop_head();
        System.out.println(qs.max());
        qs.pop_head();
        System.out.println(qs.max());
        qs.pop_head();
        System.out.println(qs.max());
        qs.pop_head();
        System.out.println(qs.max());


    }
}
class StackMinSelf{
    private Stack<Integer> stack ;
    private Stack<Integer> stackMin;
    private int minValue ;
    public StackMinSelf(){
        stack = new Stack<>();
        stackMin = new Stack<>();
        minValue = Integer.MAX_VALUE;
    }
    public void push(int data){
        stack.push(data);
        if(data<minValue)
            minValue = data;
        stackMin.push(minValue);
    }
    public int pop(){
        if(!stack.isEmpty()){
            stackMin.pop();
            return stack.pop();
        }
        return -1;
    }
    public int min(){
        if(!stackMin.isEmpty())
            return stackMin.peek();
        return -1;
    }
}
class QueueMaxSelf{
    private Deque<InnerData> queue;
    private Deque<InnerData> maxQueue;
    private int maxValue ;
    public QueueMaxSelf(){
        queue = new LinkedList<>();
        maxQueue = new LinkedList<>();
        maxValue = Integer.MIN_VALUE;
    }
    public int max(){
        if(maxQueue.isEmpty())return -1;
        return maxQueue.peekFirst().data;
    }
    private int indexCur =0;
    public void push_back(int data){
        InnerData idata = new InnerData(data,indexCur);
        while (!maxQueue.isEmpty()&& data>maxQueue.peekLast().data){
            maxQueue.pollLast();
        }
        maxQueue.offerLast(idata);
        queue.offerLast(idata);
        indexCur++;
    }
    public int pop_head(){
        if(queue.isEmpty())return -1;
        if(queue.peekFirst().index == maxQueue.peekFirst().index){
            maxQueue.pollFirst();
        }
        return queue.pollFirst().data;
    }
}
class InnerData{
    public int data;
    public int index;
    public InnerData(int data,int index){
        this.data = data;
        this.index =  index;
    }
}
