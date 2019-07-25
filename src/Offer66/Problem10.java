package Offer66;

public class Problem10 {
    public static void main(String[] args){
        System.out.println("Problem 10");
        System.out.println(fibonaci(2));
        System.out.println(fibonacci(1));
    }
    public static int Fib(int n) {
        return n < 2 ? 1 : (Fib(n-1) + Fib(n-2));
    }
    public static long fibonacci(int n){
        if(n<=0)
            return 0;
        if(n==1)
            return 1;
        return fibonacci(n-1)+fibonacci(n-2);
    }
    public static long fibonaci(int n){
        if(n<=0)
            return 0;
        if(n==1)
            return 1;
        long s1 = 0,s2 =1,s=0 ;
        for(int i=2;i<=n;i++){
            s = s1 +s2 ;
            s1 = s2;
            s2 = s;
        }
        return s2;
    }
    public static long fragJump(int n){
        //蛙一次可以跳上1—n级台阶。青蛙跳上一个n级的台阶总共有多少种跳法
        // f(n) = f(n-1) + f(n-2)+ ... + f(0)
        int count =0 ;
        if(n<2)
            return 1;
        for(int i = n-1;i>=0;i--){
            count += fragJump(i);
        }
        return count ;
    }
}
