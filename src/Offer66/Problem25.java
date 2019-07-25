package Offer66;

import Offer66.lNode;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Problem25 {
    public static void main(String[] args){
        System.out.println("Problem 25");
        Calendar clock = Calendar.getInstance();
        //System.out.println(clock);
        Date day=new Date();
        System.out.println(day.toString());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(day));

        int [] arrays = new int[]{1,2,3,4,4,5,5,5,6};
        lNode head1 = new lNode();
        head1.createList(arrays);
        lNode l1 = head1.getHead();
        lNode head2 = new lNode();
        head2.createList(arrays);
        lNode l2 = head2.getHead();
        lNode head = Merge2List(l1,l2);
        head.print();
    }

    public static lNode Merge2List(lNode l1,lNode l2){
        if(l1==null)
            return l2;
        else if(l2==null)
            return l1;
        lNode mergeHead =null;
        if(l1.data<l2.data){
            mergeHead = l1;
            mergeHead.next = Merge2List(l1.next,l2);
        }else {
            mergeHead = l2;
            mergeHead.next = Merge2List(l1,l2.next);
        }
        return mergeHead;
    }
}
