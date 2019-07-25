package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/23 16:25
 */
public class LC55 {
    public static boolean canJump(int[] nums) {
        if(nums.length<=0)return false;
        if(nums.length==1)return true;
        int i;
        for(i = nums.length-1 ;i>=0;i--){
            if(nums[i] == 0){
                int j;
                for(j = i-1; j>=0;j--){
                    if(nums[j]>(i-j))break;
                    if(i == nums.length-1 && nums[j]>=(i-j))return true;
                }
                if(j==-1)return false;
            }
        }
        if(i==-1)return true;
        return false;
    }
    public static void main(String[] args){
        int [] nusm = {3,2,1,0};
        System.out.println( canJump(nusm));
    }
}
