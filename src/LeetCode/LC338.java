package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/15 20:28
 */
public class LC338 {
    public static void main(String[] args){
        System.out.println((2^1));
        countBits(12);
    }
    public static int[] countBits(int num) {
        if(num<0)return null;
        int[] ans = new int[num+1];
        int k =0;
        ans[0] = 0;
        for(int i=1;i<=num;i++){
            if(i == (int)Math.pow(2,k)){
                ans[i] = 1;
                k++;
            }else {
                ans[i] = ans[i-((int)Math.pow(2,k-1))]+1;
            }
        }
        return ans;
    }
}
