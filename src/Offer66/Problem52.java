package Offer66;

public class Problem52 {
    public static void main(String[] args) {
        System.out.println("Problem 51");

        int[] arrays1 = {7,6,5,4,9,7};
        lNode head1 = new lNode();
        head1.createList(arrays1);
        head1 = head1.getHead();
        int [] arrays2 = new int[]{1,2,3,4,5,6};
        lNode head2 = new lNode();
        head2.createList(arrays2);
        head2 = head2.getHead();

        System.out.println(findFirstSameNode(head1,head2).data);

    }
    public static lNode findFirstSameNode(lNode h1,lNode h2){
        if(h1==null || h2 == null)
            return null;
        //将h1 h2 联合成有公共节点的链表
        lNode h = h1 ;
        while(h.next!=null){
            h = h.next;
        }
        h.next = h2.next.next.next ;

        //计算两个链表的长度
        int length1 = 0;
        int length2 = 0;
        h = h1;
        while (h!=null){
            h = h.next;
            length1 ++ ;
        }
        h = h2;
        while (h!=null){
            h = h.next;
            length2 ++ ;
        }
        //长链表先走 length1 - length2  步
        int length =0;
        if(length1<length2){   //保持h1 为长链表
            h = h1 ; length = length1;
            h1 = h2; length1 = length2;
            h2 = h;  length2 = length ;
        }
        h = h1;
        length = Math.abs(length1-length2);
        while (length-->0){
            h = h.next;
        }
        while (length2-->0){
            if(h==h2 )
                return h ;
            h = h.next;
            h2 = h2.next;
        }

        return null;
    }
}
