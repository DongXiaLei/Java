package ViewTest;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/7 10:40
 */
public class ViewBeike1 {
    public static void main(String[]args){
        int [] nums ={1 ,5 ,-6, 7, 9,2,-16 ,0 ,-2};
        int all =0,ans =0;
        for (int ele: nums){
            all += ele;
        }
        int tmp =0;
        for(int i=0;i<nums.length-1;i++){
            tmp += nums[i];
            if(2*tmp == all){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
