package LeetCode;


import java.util.Arrays;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/12 15:44
 */
public class LC148 {
    public static void main(String []args){
       NODE [] t= new NODE[5];
       for(int i = 1;i<=5;i++){
           t[i-1] = new NODE((int)Math.pow(-1,i));
       }
       Arrays.sort(t);
       System.out.println();

        ListNode head = new ListNode(4);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(1);
        ListNode head3 = new ListNode(3);
        head.next = head1;head1.next = head2;head2.next =head3;
        sortList(head);
    }
    public static ListNode sortList(ListNode head) {
        if(head==null || head.next==null)return head;
        ListNode fast = head.next,slow = head; //找到中间节点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmpNode = slow.next;
        slow.next =null;
        ListNode left = sortList(head);
        ListNode right =  sortList(tmpNode);
        //合并
        ListNode newHead = new ListNode(0);
        ListNode ans = newHead;
        while (left!=null && right!=null){
            if(left.val<right.val){
                newHead.next = left;
                left = left.next;
            }else {
                newHead.next = right;
                right = right.next;
            }
            newHead = newHead.next;
        }
        newHead.next = left!=null ? left:right;
        return ans.next;
    }

}
class NODE extends ListNode implements Comparable<NODE>{
    public NODE(int x){
        super(x);
    }
    @Override
    public int compareTo(NODE arg){
        // TODO Auto-generated method stub  //逆字典序排列
        NODE n = (NODE) arg;
        return this.val-n.val;
    }

}
