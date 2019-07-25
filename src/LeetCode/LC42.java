package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/22 14:27
 */
public class LC42 {
    public static int trap(int[] height) {
        return trapCore(height,0,height.length-1);
    }
    public static int trapCore(int[] height ,int left ,int right){
        if((right-left)<2)return 0;
        int index1 =left,index2 = left+1; // 最大的两个数的索引
        for(int i = left+2 ;i<=right;i++){
            if(height[i]>height[index1] || height[i]>height[index2]){
                int minIndex = height[index1]>height[index2]? index2:index1;
                if(index1 == minIndex) index1 = i;
                else index2 = i;
            }
        }
        int ans;
        if(index1<index2){
            ans =trapCoreCal(height,index1,index2);
            return ans+trapCore(height,left,index1) + trapCore(height,index2,right);
        }
        else {
            ans = trapCoreCal(height,index2,index1);
            return ans+trapCore(height,left,index2) + trapCore(height,index1,right);
        }

    }
    private static int trapCoreCal(int[] height ,int begin ,int end){
       if((end-begin)<2)return 0;
       int ans = 0;
       int t = Math.min(height[begin],height[end]);
       for(int i =begin ;i<=end;i++){
           if((t-height[i])>0)
               ans += t - height[i];
       }
       return ans;
    }

    public static void main(String [] args){
        int[] nums ={5,2,1,2,1,5};
        System.out.println(trap(nums));
    }
}
