package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/23 19:33
 */
public class LC62 {
    public static int uniquePaths(int mm, int nn) {
        /*
        * C(m+n,n)  只需要取m个数置0 或者1 组合问题
        * 注意：放置中间过程越界
        * */
        int n=nn-1,m=mm-1;
        long ans = 1;
        int minV = m>n ? n:m;
        for(int i = 1 ; i<=minV ;i++){
            ans = ans * (m+n+1-i);
            ans /= i ;
        }
        return (int)ans;
    }
    public static void main(String[] args){
        uniquePaths(51,9);
    }
}
