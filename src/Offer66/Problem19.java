package Offer66;

public class Problem19 {
    public static void main(String[] args){
        System.out.println("Problem 19");
        /*
         * 属于一个整数n
         * 对于 n = 任意多个整数的平方和
         * 求最小的整数个数
         * 对于 n=12=4+4+4  输出3
         * */
        System.out.println(minBestSumN(1366));
        System.out.println(minBestSumN2(1366));
    }
    public static int minBestSumN(int n){
        if(n<1)
            return 0;
        int[] ans = new int[n+1];
        ans[0] =0 ;
        for(int i=1;i<=n;i++){
            int minNum  = Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++){
                minNum  = Math.min(minNum,ans[i-j*j]+1);
            }
            ans[i] = minNum;
        }
        return ans[n];
    }
    public static int minBestSumN2(int n){
        while (n%4==0)
            n = n/4;
        if(n%8==7)
            return 4;
        for(int i = 0 ;i*i<=n;i++){
            if(i*i == n)
                return 1;
            int j = (int)Math.sqrt(n-i*i);
            if((i*i+j*j)==n && i>=0 && j>=0)
                return 2;
        }
        return 3;
    }
}
