package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/14 20:11
 */
public class LC279 {
    public static void main(String[] args){
        System.out.println(numSquares(12));
    }
    public static int numSquares(int n) {
        //dp[i] = min{dp[i - j*j]}, 1<= j <= sqrt(i);
        if(n<=0) return 0;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            int min = Integer.MAX_VALUE;
            for(int j =1;j<=Math.sqrt(i);j++){
                if(min>dp[i-j*j]){
                    min = dp[i-j*j];
                }
            }
            dp[i] = min+1;
        }
        return dp[n];
    }
}
