package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/16 9:36
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class LC2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1,q = l2;
        ListNode ans =null,last =null;
        int carry=0,sum=0;
        while (p!=null || q!=null){
            int x = p!=null? p.val:0;
            int y = q!=null? q.val:0;
            sum = x+y+carry;
            carry = sum/10;
            if(ans==null){
                ans = new ListNode(sum%10);
                last = ans;
            }else {
                last.next = new ListNode(sum%10);
                last = last.next;
            }
            if(p!=null)p =p.next;
            if(q!=null)q= q.next;
        }
        return ans;
    }
}
