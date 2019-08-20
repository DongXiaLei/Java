package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/13 15:34
 */
public class LC206 {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        head.next = head1;head1.next =head2;head2.next = head3;
        reverseList(head);

    }
    public static ListNode reverseList(ListNode head) {
        if(head==null || head.next == null )return head;
        ListNode p = head,q = head.next;
        ListNode tmp =p;tmp.next =null;
        while (q!=null){
            p = q;
            q = q.next;
            p.next = tmp;
            tmp = p;
        }
        return p;
    }
}
