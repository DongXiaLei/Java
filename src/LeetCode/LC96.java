package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/27 10:12
 */
public class LC96 {
    public static void main(String[] args){
        numTrees(3);
    }
    public static int numTrees(int n) {
        /*
        * Catalan数列
        * f(n) = f(n-i-1)*f(i) 0<=i<=n-1
        * 例如 f(3) = f(2)*f(0)+f(1)*f(1)+f(0)*f(2)
        * f(0) =1 f(1) =1
        * */
        int ans = 0;
        if(n<=0)return 0;
        long[] f =new long[n+1];
        f[1] = 1;f[0] =1;
        for(int i =2;i<=n;i++){
            for(int j = 0;j<i;j++){
                f[i] += f[i-j-1] * f[j];
            }
        }
        return (int)f[n];
    }
}
