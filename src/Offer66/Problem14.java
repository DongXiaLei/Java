package Offer66;

public class Problem14 {
    public static void main(String[] args){
        System.out.println("Problem 14");
        System.out.println(maxCuttingLineDP(10));
        System.out.println(maxCuttingLineGreedy(10));
    }
    public static int maxCuttingLineDP(int line){
        if(line<2) return 0;
        if(line ==2 )return 2;
        if(line==3) return 3;
        int [] ans = new int[line+1];
        ans[0] = 0;ans[1] =1 ;ans[2] =2 ;ans[3] =3 ;
        for(int i=4;i<=line;i++){
            int max = 0;
            for(int j=0;j<=i/2;j++){
                ans[i] = ans[j] *ans[i-j];
                if(ans[i]>max) max =ans[i];
            }
            ans[i] = max ;
        }
        return ans[line];
    }
    public static int maxCuttingLineGreedy(int line){
        if(line<2) return 0;
        if(line ==2) return 2;
        int count3 = 0,flag =0;
        count3 = line/3 ;
        if(line%3==1){
            count3 --;
            flag = 1;
        }
        int ans = 0;
        ans = (int)Math.pow(3,count3);
        if(flag==1)
            ans = ans*4;
        return ans;
    }
}
