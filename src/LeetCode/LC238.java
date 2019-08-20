package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/14 15:36
 */
public class LC238 {
    public static void main(String[] args){
        int[] nums ={2,3,4,5};
        productExceptSelf(nums);
    }
    public static int[] productExceptSelf(int[] nums) {
        if(nums.length==0)return null;
        int n= nums.length;
        int [] outputs = new int[n];
        outputs[n-1] = nums[n-1];
        int k =1;
        for(int i =n-2;i>=0;i--){
            outputs[i] = outputs[i+1]*nums[i];
        }
        for(int i=0;i<n-1;i++){
            outputs[i] = k * outputs[i+1];
            k *= nums[i];
        }
        outputs[n-1] = k;
        return outputs;
    }
}
