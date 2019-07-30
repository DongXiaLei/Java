package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/27 15:59
 */
public class LC141 {
    public static void main(String[] args){

    }
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next ==null)return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow!=fast){
            if(fast==null||fast.next==null){
                return false;
            }
            slow =slow.next;
            fast =fast.next.next;
        }
        return true;
    }
}
