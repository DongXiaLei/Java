package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/23 21:04
 */
public class LC70 {
    public static int climbStairs(int n) {
        /*
        * f(n) = f(n-1)+f(n-2)
        *
        * */
        if(n<=0)return 0;
        if(n==1)return 1;
        if(n==2)return 2;
        int t1 = 1 ,t2 =2 ;
        int ans =0;
        for(int i = 3;i<=n;i++){
            int tmp = t1+t2;
            t1 = t2 ;
            t2 = tmp;
            ans =t2;
        }
        return ans;

    }
    public static void main(String[] args){
        climbStairs(4);
    }
}
