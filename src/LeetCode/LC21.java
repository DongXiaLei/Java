package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/21 11:23
 */
public class LC21 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null || l2 == null)return l1==null? l2:l1;
        ListNode ans =  null,last=null;
        ListNode t1 = l1,t2= l2;
        while (t1!=null && t2!=null){
            ListNode newNode = null;
            if(t1.val<t2.val){
                newNode = t1;
                t1 = t1.next;
            }else {
                newNode = t2;
                t2= t2.next;
            }
            if(ans==null){
                ans = newNode;
                last =newNode;
            }else {
                last.next = newNode;
                last = last.next;
            }
        }
        if(t1==null){
           last.next =t2;
        }else {
            last.next =t1;
        }
        return ans;
    }
    public static void main(String [] args){
        ListNode l1 = createList(6);
        ListNode l2 = createList(3);
        mergeTwoLists(l1,l2);

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
