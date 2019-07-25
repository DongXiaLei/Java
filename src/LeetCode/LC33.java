package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/21 19:57
 */
public class LC33 {
    public static int search(int[] nums, int target) {
        if(nums.length<1)return -1;
        int ans = -1;
        int begin = 0;
        int end =nums.length-1;

        while (begin<=end){
            int mid = (begin+end)>>1;
            if(nums[mid] ==target)return mid;
            if(nums[begin]<=nums[mid]){ //begin-mid 递增
                if(nums[begin]<=target && nums[mid]>=target){
                    end = mid -1 ;
                }else {
                    begin = mid+1;
                }
            }
            else {  // mid - end递增
                if(nums[end]>=target && nums[mid]<=target){
                   begin = mid+1;
                }else {
                    end = mid-1;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int[] arrays ={4,5,6,0,1,2,3};
        System.out.println(search(arrays,3));
    }
}
