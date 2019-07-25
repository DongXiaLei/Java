package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/20 9:33
 */
public class LC11 {
    public static int maxArea(int[] height) {
        if(height.length<2)return 0;
        int l = 0 ,r = height.length-1;
        int ans = Integer.MIN_VALUE;
        while (l<r){
            if((r-l)*Math.min(height[r],height[l])>ans){
                ans = (r-l)*Math.min(height[r],height[l]);
            }
            int key =0;
            if(height[l]<height[r]){
                key = height[l];l++;
                while (l<r && height[l]<=key){
                    l++;
                }
            }else {
                key = height[r];r--;
                while (r>l && height[r]<=key){
                    r--;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int [] arrays = {1,8,6,2,5,4,8,3,7,11};
        System.out.println(maxArea(arrays));
    }
}
