package Offer66;

public class Problem21 {
    public static void main(String[] args){
        System.out.println("Problem 21");
        reOrder();
        for(int ele:datas){
            System.out.println(ele);
        }
    }
    public static int[] datas = new int[]{1,2,3,4,5,6,7,8};
    public static void reOrder(){
        int length = datas.length;
        int begin = 0,end = length-1;
        while (begin<end){
            while (begin<end && !isCheck(begin)){
                begin++;
            }
            while (begin<end && isCheck(end)){
                end--;
            }
            if(begin<end){
                int tmp = datas[begin];
                datas[begin] = datas[end];
                datas[end ] = tmp;
            }
        }
        for(int ele:datas){
            System.out.println(ele);
        }
    }
    public static boolean isCheck(int index){
        return (datas[index] & 1)==0;
    }
}
