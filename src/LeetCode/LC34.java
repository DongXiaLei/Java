package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/22 10:20
 */
public class LC34 {
    public static int[] searchRange(int[] nums, int target) {
        int begin =0,end =nums.length-1;
        int [] ans = {-1,-1};
        while (begin <= end){
            int mid = (begin+end) >> 1;
            if (nums[mid] == target){
                int l = mid ,r = mid ;
                while ((l-1)>=0 && nums[l-1] == target){
                    l--;
                }
                while ((r+1)<nums.length && nums[r+1]==target){
                    r++;
                }
                ans[0] = l;  ans[1] = r ;
                return ans;
            }else if (nums[mid] < target){
                begin = mid + 1 ;
            }else {
                end = mid - 1 ;
            }
        }
        return ans;
    }
    public static void main(String [] args){
        int[] nums ={5,7,7,8,8,10};
        searchRange(nums,6);
    }
}
