package ViewTest;


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n<=1)return;
        int [] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = in.nextInt();
        }
        System.out.println(maxMatchs(nums));
    }
    public static int maxMatchs(int[] nums){
        if(nums.length<=1) return 0;
        int n = nums.length;
        Arrays.sort(nums);
        int ans =0;
        int i;
        for(i =0;i<n;i++){ //将数据分为两部分部分
            if((double)nums[i]>=nums[n-1]*0.9){
                break;
            }
        }
        int r = n-1;
        for(int j=i-1;j>=0;j--){ //两部分的交集
            for(int k=i;k<=r;k++){
                if(nums[j]>=nums[k]*0.9){
                    ans ++;
                }else {
                    r = k;
                }
            }
        }
        int left =0,right =0; //前半部分和后半部分内部和
        right = (n-i)*(n-i-1)/2; //后半部分
        left = maxMatchs(Arrays.copyOfRange(nums,0,i));
        ans +=(left+right);
        return ans;
    }
}

/**
 * 思路如下：
 * 1，按照数组顺序和数组元素大小建立统计图
 *    统计图横坐标为数组下标
 *     纵坐标为元素大小
 * 2，找出最大的两个数
 *   判断这两个数位置之间 是否是凹形状的
 *   如果是凹形状就要补充填满（累加电荷）
 *   不是凹形状就继续找次最大的两个数同样判断
 *   注意：这里填满时相邻柱状不能相等
 * 3，重复2 直到消除凹形状
 */

/*
*
* if(n<=1)return;
        long [] nums = new long[n];
        for(int i=0;i<n;i++){
            nums[i] = in.nextLong();
        }
        int ansl=0,ansr=1;    // answerleft anwserright
        long sum = Long.MAX_VALUE;
        for(int i=1;i<n;i++){
            long tmp = Math.abs(nums[i]-nums[i-1]);
            if(tmp<sum){
                sum = tmp;
                ansl = i-1;
                ansr = i ;
            }
        }
        System.out.println(nums[ansl]+" "+nums[ansr]);
* */

/*
*
*
* if(i==0){
            return n*(n-1)/2;
        }else if(i==1){
            left = 1;
            right = (n-i)*(n-i-1)/2;
        }else if(i == n-1){
            left = i*(i-1)/2;
            right = 1;
        }else {
            left = i*(i-1)/2;
            right = (n-i)*(n-i-1)/2;
        }
*
* int n = in.nextInt();
        if(n<=0)return;
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = in.nextInt();
        }
        System.out.println(findMaxSubSeq(nums,n));
    }
    public static int findMaxSubSeq(int[] nums,int n){
        int ans =1 ;
        int[] dp = new int[n]; //到第i个最长的自增序列值
        dp[0] = 1;
        for(int i=1;i<n;i++){
            int maxBefore = 1;
            for(int j =0;j<i;j++){
                if(nums[j]<=nums[i] && dp[j]>=maxBefore){
                    maxBefore = dp[j]+1;
                }
            }
            dp[i] = maxBefore;
        }
        for(int i =0;i<n;i++){
            if(dp[i]>ans){
                ans = dp[i];
            }
        }
        return ans;
    }
* */