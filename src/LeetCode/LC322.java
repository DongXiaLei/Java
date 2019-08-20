package LeetCode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/15 16:40
 */
public class LC322 {
    public static void main(String []args){
        int[] coins = {2,3,5};
        System.out.println(coinChange2(coins,11));
    }
    // 1 贪心 求不到局部最优
    public static int coinChange1(int[] coins, int amount) {
        Stack<Integer> stack = new Stack<>();
        if(coins.length==0 || amount<=0)return 0;
        Arrays.sort(coins);
        coinChangeCore(stack,coins,coins.length-1,amount);
        return stack.size()==0 ? -1: stack.size();
    }
    public static void coinChangeCore(Stack<Integer> stack ,int[] coins,int i,int amount){
        if(amount==0)return;
        if(i>=0){
            if(amount>=coins[i]){
                stack.add(coins[i]);
                coinChangeCore(stack,coins,i,amount-coins[i]);
            }else {
                coinChangeCore(stack,coins,i-1,amount);
            }
        }else {
            if(!stack.isEmpty()){
                int t = stack.pop();
                int j;
                for( j =0;j<coins.length;j++){
                    if(coins[j] == t){
                        break;
                    }
                }
                coinChangeCore(stack,coins,j-1,amount+t);
            }
        }
    }
    // dp
    public static int coinChange2(int[] coins, int amount){
        if(coins.length==0 || amount<=0)return 0;
        Arrays.sort(coins);
        int maxn = 1000000; // 判断该位置不可达
        int[] dp = new int[amount+1];
        for(int i =0;i<dp.length;i++){
            dp[i] = maxn;
        }
        for(int i =0;i<coins.length;i++){
            for(int j=0;j<=amount;j++){
                if(j==0){
                    dp[j] =0;
                }else {
                    if(j == coins[i]){
                        dp[j] = 1;
                    }
                    if(j>coins[i]){
                        dp[j] = Math.min(dp[j],1+dp[j-coins[i]]);
                    }
                }
            }
        }
        return dp[amount]==maxn? -1: dp[amount];
    }
}
