package Offer66;

public class Problem24 {
    public static void main(String[] args){
        System.out.println("Problem 24");
        lNode head = new lNode();
        int [] arrays = new int[]{1,2,3,4,4,5,5,5,6};
        head.createList(arrays);
        head.reverseList(); //实现见  offer 22
        head.print();
    }
}
