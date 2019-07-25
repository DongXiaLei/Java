package Offer66;

import java.util.Arrays;

public class Problem51 {
    public static void main(String[] args) {
        System.out.println("Problem 51");
        String string  ="dongxileidongxileityuiop"  ;
        System.out.println(maxIncreaseSub(string));
        System.out.println(maxIncreaseSub2(string));

        int[] arrays = {7,6,5,4,9,7,5,1,2,6,9,4};
        System.out.println(inverseParis(arrays));
    }
    public static int maxIncreaseSub(String string ){
        /*
        *先对string排序 后
        * 求两个序列的最大公共子序列
        * */
        char[]  string1 = string.toCharArray();
        char[]  string2 = string.toCharArray();
        Arrays.sort(string2);
        int  [][]ans = new int[string.length()+1][string.length()+1];
        for(int i=0;i<=string1.length;i++){
            for(int j =0;j<=string2.length;j++){
                if(i==0||j==0)ans[i][j] = 0;
                else {
                    if(string1[i-1]== string2[j-1]) ans[i][j] = ans[i-1][j-1] +1 ;
                    else ans[i][j] = Math.max(ans[i-1][j],ans[i][j-1]);
                }
            }
        }
        return ans[string.length()][string.length()];
    }
    public static int maxIncreaseSub2(String string){
        /*
        * 以dp[i]表示以i位结尾的最长递增子序列的长度。
        * 那么dp[i] = max(dp[i], dp[j]+1), j = 1, 2, 3,...,i-1。
        * 对于每个j<i遍历求出最大的dp[i]
        * */
        char[]  string1 = string.toCharArray();
        int [] ans = new int[string.length()+1];
        ans[0] = 1;
        for(int i = 1;i<string.length();i++){
            ans[i] = 1;
            for(int j=0;j<i;j++){
                if(string1[i]>string1[j]){
                    ans[i] = Math.max(ans[i],ans[j]+1);
                }
            }
        }
        return ans[string.length()];
    }
    public static int inverseParis(int [] arrays){  // 尚未完全会写
        if(arrays.length==0)
            return 0;
        int[] copy = new int[arrays.length];
        for(int i=0;i<arrays.length;++i){
            copy[i] = arrays[i] ;
        }
        int ans = inverseParis(arrays,copy,0,arrays.length-1);
        return ans;
    }
    private static int inverseParis(int[] arrays,int[] copy,int begin,int end){
        if(begin == end){
            copy[begin] = arrays[end];
            return 0;
        }
        int length = (end-begin)>>1;
        int leftCount = inverseParis(copy,arrays,begin,begin+length);
        int rightCount = inverseParis(copy,arrays,begin+length+1,end);

        // i 为前半段最后一位下标
        int i = begin +length ;
        //j 为后半段最后一位下标
        int j =end ;
        int indexCopy = end;
        int count = 0;
        while(i>=begin && j>=begin+length+1){
            if(arrays[i]>arrays[j]){
                copy[indexCopy--] = arrays[i--];
                count += j - (begin + length); // 对应的逆序数
            }else {
                copy[indexCopy--] = arrays[j--];
            }
        }
        for(;i>=begin;i--){
            copy[indexCopy--] = arrays[i];
        }
        for(;j>=begin+length+1;j--){
            copy[indexCopy--] = arrays[j];
        }
        return leftCount+rightCount+count;
    }
}
