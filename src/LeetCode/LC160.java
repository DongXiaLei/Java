package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/13 10:54
 */
public class LC160 {
    public static void main(String[] args){

    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len_A  =0,len_B=0;
        ListNode head_A = headA;
        ListNode head_B = headB;
        while (headA!=null){
            len_A++;
            head_A = head_A.next;
        }
        while (head_B!=null){
            len_B++;
            head_B = head_B.next;
        }
        int t =len_A>len_B ? len_A -len_B : len_B-len_A;
        if(len_A>len_B){
            while ((t--)>0){
                headA = headA.next;
            }
        }else {
            while ((t--)>0){
                headB = headB.next;
            }
        }
        while (headA!=null && headB!=null){
            if(headA== headB){
                return headA;
            }else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }
}
