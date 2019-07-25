package Offer66;

public class Problem44 {
    public static void main(String [] args){
        System.out.println("Problem 44");
        System.out.println(findNthDigit(1001));
    }
    public static int findNthDigit(int n) {
        if(n<=0)return 0;
        long base = 9,digits = 1;
        // 1 计算这个数是几位数
        while(n - base * digits > 0){
            n -= base * digits;
            base *= 10;
            digits++;
        }
        //2 计算这个数是多少
        long index = n % digits;
        boolean flag =false;
        if(index == 0)
            flag = true;
        long num = 1;
        for(int i = 1; i < digits; i++){
            num *= 10;
        }
        num += flag? n / digits -1 : n / digits;
        //3 找到这个数的第几位是我们想要的
        for(long i = index; i < digits; i++)
            num /= 10;
        return (int)num % 10;
    }

}
