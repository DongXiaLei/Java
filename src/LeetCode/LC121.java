package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/27 15:29
 */
public class LC121 {
    public static int maxProfit(int[] prices) {
        int[] ans = new int[prices.length+1];
        ans[0] = 0;
        int min = Integer.MAX_VALUE,ansV =0 ;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<min){
                min = prices[i];
            }
            if(prices[i]>min){
                ans[i] = prices[i]-min;
            }else {
                ans[i] = 0;
            }
            if(ans[i]>ansV){
                ansV = ans[i];
            }
        }
        return ansV;
    }
    public static void main(String [] args){
        int[] nums= {7,1,5,3,6,4};
        System.out.println(maxProfit(nums));
    }
}
