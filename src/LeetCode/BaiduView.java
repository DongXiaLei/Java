package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/30 15:45
 */
public class BaiduView {
    public static void main(String[] args){
        int [] array1 = {-2,56,12,3,78,19};
        int [] array2 = {-34,23,19,45,28,12};
        int n =array1.length;//数组大小

        findMinDiff(array1,array2,n);
    }
    public static int findMinDiff(int[] array1 ,int[] array2,int n){
        /*
         *  问题等价于从array1，array2两个数组2n个数中取n个数
         *  使其n个数的值最接近去两个数组的元素之和的均值
         *
         *  DP思路
         *   1，将数组合并为一个数组，对合并的数组最小值进行判断
         *   如果大于0，什么也不做，如果小于0，将所有元素增大同样的数为正数
         *
         *
         *  求解思路:使用动态规划的思路
            *   外阶段：在前i个数中进行选择，i=1,2...2*n。
            *   内阶段：从这i个数中任意选出j个数，j=1,2...i。
            *   状态：这j个数的和为s，s=1,2...sum/2。
            *   决策：决定这j个数的和有两种决策，一个是这j个数中包含第i个数，另一个是不包含第i个数。
            *   dp[k][s]表示从前k个数中取任意个数，且这些数之和为s的取法是否存在。
            *   在程序中我们给出S(k)的所有可能取值v和arr[k],去寻找v-arr[k]是否在S(k-1)={Vi}中，
            *   由于S(k)的可能取值的集合的大小与k无关，
            *   所以这样设计的动态规划算法其第k步的时间复杂度与k无关
         *
         * */
        //1 合并
        int[] arrays =new int[2*n+1];int count =1;
        for(int i =0;i<n;i++){
            arrays[count++] = array1[i];
            arrays[count++] = array2[i];
        }
        // 是否要平移
        int minValue = 0;
        for(int ele:arrays){
            if(ele<minValue) minValue =ele;
        }
        if(minValue<0){
            for(int i=1;i<arrays.length;i++){
                arrays[i] -= minValue ;
            }
        }

        //求出两个数组的平均值
        int average = 0,sum =0 ;
        for(int ele:arrays){
            sum += ele;
        }
        average = sum>>1;

        //int[] arrays= new int[]{3,2,0,6,5,4};//测试所用
        boolean [][] dp = new boolean[2*n+1][average+1];

        dp[0][0] = true;
        for(int i = 1;i <= 2*n;++i)//外阶段i
        {
            for(int j = Math.min(i,n);j >=1;--j)//内阶段j
            {
                for(int k = 1;k <= average;++k)//S(k)的所有可能取值s
                {
                    if((k >= arrays[i]) && dp[j-1][k-arrays[i]])//j个数中是否包含第i个数
                    {
                        dp[j][k]=true;
                    }
                }
            }
        }
        // 4 ,求解最小值 ans；
        int s ;
        for(s = average;s>=1 && !dp[n][s];s--)
            ;
        int ans = sum - 2*s;

        return ans;
    }
}
