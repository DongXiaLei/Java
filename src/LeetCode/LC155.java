package LeetCode;

import java.util.Stack;

import java.util.Stack;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/12 21:12
 */
public class LC155 {
    public static void main(String[] args){
        System.out.println(Integer.MAX_VALUE);
        MinStack minStack = new MinStack();
        minStack.push(-10);
        minStack.push(14);
        minStack.push(-20);
        minStack.push(-10);
        minStack.push(-15);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println( minStack.top());
        System.out.println(minStack.getMin());


    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
class MinStack {
    Stack<Integer> stack ;
    Stack<Integer> minStack;
    Integer min = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if( x<=min){
            min = x;
            minStack.push(min);
        }

    }

    public void pop() {
        int t = stack.pop();
        if(t == minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {
        return  stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

