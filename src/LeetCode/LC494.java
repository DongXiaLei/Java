package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/19 17:03
 */
public class LC494 {
    public static void main(String[] args){
        int[] nums ={7,9,3,8,0,2,4,8,3,9};
        System.out.println(findTargetSumWays(nums,0));
    }
    public  static int findTargetSumWays(int[] nums, int S) {
        if(nums.length<=0)return 0;
        int nZeros =0,sum =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                nZeros ++;
            }
            sum += nums[i];
        }
        if(sum< S || (sum+S & 1) == 1  )return 0;
        int[] newNums = new int[nums.length-nZeros];
        int len = 0;
        for(int i =0;i<nums.length;i++){
            if(nums[i] != 0){
                newNums[len++] = nums[i];
            }
        }
        int C = (S+sum)>>1 ;
        int[][] dp = new int[newNums.length+1][C+1];
        dp[0][0] = 1;
        for(int i=0;i<newNums.length;i++){
            for(int j=0;j<=C;j++){
                if(j == 0 ){
                    dp[i+1][j] = 1;
                }else {
                    if(j>=newNums[i]){
                        dp[i+1][j] = dp[i][j] + dp[i][j-newNums[i]];
                    }else {
                        dp[i+1][j] = dp[i][j];
                    }
                }
            }
        }
        return dp[newNums.length][C]* (1<<nZeros);
    }
}
/*
* for(int i=0;i<newNums.length;i++){
            dp[i+1][0]=1;//注意第一列初始为1，表示容量为0时，有一种方式，即每个数值都不选
            for(int j=0;j<C;j++){
                if(nums[i]<=j+1) dp[i+1][j+1]=dp[i][j+1]+dp[i][j+1-nums[i]];//选不选这个数
                else dp[i+1][j+1]=dp[i][j+1];//放不下这个数，只能不选
            }
        }
* */
