package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/16 10:59
 */
public class LC4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int [] nums = new int[nums1.length+nums2.length];
        int i=0,j=0,k=0;
        while (i<nums1.length || j<nums2.length){
            int x = i<nums1.length ? nums1[i]:Integer.MAX_VALUE;
            int y = j<nums2.length ? nums2[j]:Integer.MAX_VALUE;
            if(x<y){
                nums[k++] = x;
                i++;
            }
            else {
                nums[k++] = y;
                j++;
            }
        }
        double ans = 0.0;
        if(nums.length%2==1){
            ans = nums[nums.length/2];
        }else {
            ans = nums[nums.length/2]+nums[nums.length/2-1];
            ans = ans/2;
        }
        return ans;
    }
    public static void main(String[] args){
        int [] arr1= {1,3,5,6,8};
        int [] arr2={1,3,5,6,8,9,11};
        findMedianSortedArrays(arr1,arr2);
    }
}
