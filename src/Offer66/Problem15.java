package Offer66;

public class Problem15 {
    public static void main(String[] args){
        System.out.println("Problem 15");
        System.out.println(count1Nums1(15));
        System.out.println(count1Nums2(15));
    }
    public static int count1Nums1(int target){ //计算n中的1的个数，负数连符号位也统计
        int count = 0 ;
        int flag = 1 ;
        while (flag!=0){
            if((flag & target)!=0)
                count ++;
            flag = flag<<1 ; // int型左移32次
        }
        return count;
    }
    public static int count1Nums2(int target){ // 减1 并
        int count = 0 ;
        while(target!=0){
            count++;
            target = target & (target -1) ;
        }
        return count ;
    }
}
