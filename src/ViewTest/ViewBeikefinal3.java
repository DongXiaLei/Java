package ViewTest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/11 20:32
 */
public class ViewBeikefinal3 {
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
