package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/20 14:29
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class LC19 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)return null;
        ListNode first =head,second = head;
        for(int i =0;i<n;i++){
            if(first.next!=null){
                first = first.next;
            }else {
                return head.next;
            }
        }
        while (first.next!=null){
            first = first.next;
            second = second.next;
        }
        second.next =second.next.next;
        return head;
    }
    public static void main(String[] args){
        ListNode head=null,last=null;
        for(int i =1 ;i<6;i++){
            ListNode node = new ListNode(i);
            if(head==null){
                head = node;
                last = node;
            }else {
                last.next = node;
                last = last.next;
            }
        }
        removeNthFromEnd(head,5);
    }
}

