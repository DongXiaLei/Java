package Offer66;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class problem59 {
    public static void main(String [] args){
        System.out.println("Problem60");
        int [] arrays = {1,2,3,4,41,2,3,4,25,6};
        findMaxWindows(arrays,4);

        //题目2 详见 offer 30
    }
    public static void findMaxWindows(int[] arrays,int size){
        if(size==0)return;
        List<Integer> ans = new ArrayList<Integer>();
        Deque<Integer>  deque = new LinkedList<>();
        for(int i=0;i<arrays.length;i++){
            if(!deque.isEmpty()){
                while (!deque.isEmpty() &&  arrays[i]>arrays[deque.peekLast()]){
                    deque.pollLast();
                }
                if(!deque.isEmpty() && i>=deque.peekFirst()+size){   //// 如果当前数字大于队列尾，则删除队列尾，直到当前数字小于等于队列尾，或者队列
                    deque.pollFirst();
                }
            }
            deque.add(i);
            if(i>=size-1){
                ans.add(arrays[deque.peekFirst()]);
            }
        }
        System.out.println(ans);
    }
}
