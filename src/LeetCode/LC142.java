package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/12 14:29
 */
public class LC142 {
    public static void main(String[] args){

    }
    public static ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null)return null;
        ListNode first = head,last = head.next;
        while (first!=last){ //在环中的相遇点
            if(last==null ||last.next==null){
                return null;
            }
            first = first.next;
            last = last.next.next;
        }
        int count =1;//环的大小n
        first = first.next;
        while (last!=first){
            first = first.next;
            count++;
        }
        last = head;  // 让其中一个指针从头先走n步
        while ((count--)!=0){
            last = last.next;
        }
        first = head;
        while (first!=last){ //相遇点即为环的入口
            first = first.next;
            last = last.next;
        }
        return first;
    }
}
