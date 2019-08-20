package Algorithm;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/15 12:09
 */
public class NumsSplit {
    public static void main(String [] args){
        System.out.println(numSquare(10));
        System.out.println(numSplit(10)+" "+numSplit2(10));
    }

    // 完全平方数
    /*
    * 1, 任何 一个正整数 最多只能被四个平方数相加得到
    * 例如 12 = 4 +4 +4
    * 递推公式 ：dp[i] = min{dp[i - j*j]}, 1<= j <= sqrt(i);
    * */
    public static int numSquare(int n){
        if(n<=0)return 0;
        int [] dp = new int[n+1];
        dp[0] =0;dp[1] =1;
        for (int i=2;i<=n;i++){
            int min =Integer.MAX_VALUE;
            for(int j=1;j<=Math.sqrt(i);j++){
                if(min>dp[i-j*j]){
                    min = dp[i-j*j];
                }
            }
            dp[i] = min+1;
        }
        return dp[n];
    }
    // 正整数划分
    /*
    一个正整数可以被划分为不同的数和，问有多少种划分方法
    f[i,j] = f[i,j-1] + f[i-j,j-1]  1<=j<=i
    * */
    public static int numSplit(int n){
        // 计算出maxn的所有的
        int maxn = 500+1;
        int[][] dp = new int[maxn][maxn];
        dp[0][0] = 1;
        for(int i=0;i<maxn;i++){
            for(int j=1;j<=i;j++){
                dp[i][j] = dp[i][j-1] + dp[i-j][j-1];
            }
            for(int j=i+1;j<maxn;j++){
                dp[i][j] = dp[i][i];
            }
        }
        if(n<maxn){
            return dp[n][n]-1;
        }else return 0;
    }
    // 降低空间复杂度
    public static int numSplit2(int n){
        // 计算出maxn的所有的
        int maxn = 500+1;
        int[] dp = new int[maxn];
        dp[0] = 1;
        for(int i=1;i<maxn;i++){
            for(int j=maxn-1;j>=i;j--){
                dp[j] = dp[j] + dp[j-i];
            }
        }
        if(n<maxn){
            return dp[n]-1;
        }else return 0;
    }
    // 平分为可以相同的数
    /*
    * dp[i,j] 将i分为不大于j的数的划分数
    *  1  i=1/j=1
    *  dp[i,j-1]+1  i=j
    *  dp[i,j-1]+dp[i-j,j] i>j>1
    * */
    public static int numSplit3(int n,int m){
        int[][] ww = new int[n+1][m+1];
        for(int i=1;i<=n;i++)
            for(int j=1;j<=i;j++) {
                if(j==1|| i==1) {
                    ww[i][j]=1;
                }
                else {
                    if(j==i)
                        ww[i][j]=ww[i][j-1]+1;
                    else if((i-j)<j)
                        ww[i][j]=ww[i-j][i-j]+ww[i][j-1];
                    else
                        ww[i][j]=ww[i-j][j]+ww[i][j-1];
                }
            }
        return ww[n][m];
    }
}
