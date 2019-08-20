package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/13 21:49
 */
public class LC234 {
    public static void main(String[] args){

    }
    public static boolean isPalindrome(ListNode head) {
        if(head==null || head.next == null )return true;
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && fast.next!=null){ //slow为中间节点
            fast = fast.next.next;
            slow =slow.next;
        }
        //反转后部分链表
        ListNode iter = slow;
        ListNode pre= null;
        while (iter!=null){
            ListNode p = iter.next;
            iter.next = pre;
            pre  =iter;
            iter = p;
        }
        //开始对比
        iter = head;
        ListNode tail = pre;
        boolean flag =true;
        while (tail!=null){
            if(tail.val != iter.val){
                flag =false;
                break;
            }
            tail = tail.next;
            iter = iter.next;
        }
        // 反转后边的
        iter = pre;
        ListNode pree = null;
        while (iter!=null){
            ListNode p = iter.next;
            iter.next = pree;
            pree = iter;
            iter = p;
        }
        return flag;
    }


}
