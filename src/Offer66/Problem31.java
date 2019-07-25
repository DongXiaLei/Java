package Offer66;

import java.util.Stack;

public class Problem31 {
    public static void main(String[] args){
        System.out.println("Problem 31");
        int [] in ={1,2,3,4,5,6};
        int[] out ={4,5,6,3,1,2};
        boolean ans = isPopOrder(in,out);

    }
    public static boolean isPopOrder(int[] in, int [] out){
        if(out==null)return true;
        if(in==null)return false;

        Stack<Integer> stack = new Stack<>();
        int popIndex =0;
        for(int i=0;i<in.length;i++){
            stack.push(in[i]);
            while (!stack.isEmpty() && stack.peek() == out[popIndex]){
                stack.pop();
                popIndex++;
            }
        }
    return  stack.isEmpty();
    }
}
