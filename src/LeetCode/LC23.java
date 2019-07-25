package LeetCode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/21 15:03
 */
public class LC23 {
    public static ListNode mergeKLists(ListNode[] lists) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (ListNode ln:lists){
            while (ln!=null){
                queue.add(ln.val);
                ln = ln.next;
            }
        }
        ListNode ans = null,last =null;
        while (!queue.isEmpty()){
            int val = queue.poll();
            ListNode newNode = new ListNode(val);
            if(ans==null){
                ans = newNode ;
                last = newNode ;
            }else {
                last.next = newNode;
                last =last.next;
            }
        }
        return ans;
    }
    public static void main(String [] args){
        ListNode[] ls = {createList(6),createList(5)};
        mergeKLists(ls);
    }
    public static ListNode createList(int n){
        ListNode head =null,last= null;
        for(int i =1 ;i<n;i++){
            ListNode node = new ListNode(i);
            if(head==null){
                head = node;
                last= node;
            }else {
                last.next = node;
                last = last.next;
            }
        }
        return head;
    }
}
