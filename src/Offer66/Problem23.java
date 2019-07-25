package Offer66;

public class Problem23 {
    public static void main(String[] args){
        System.out.println("Problem 23");
        lNode head = new lNode();
        int [] arrays = new int[]{1,2,3,4,4,5,5,5,6};
        head.createList(arrays);  //实现见  offer 22
        head.makeCircleList(head.head.next.next);

        System.out.println(head.findCircleEntry().data);
    }
}
