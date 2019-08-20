package ViewTest;

import java.util.Scanner;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/7 10:56
 */
public class ViewBeike2 {
    public static void main(String[] args){
        Scanner in  = new Scanner(System.in);
        String s = in.next();
        char[] arrays = s.toCharArray();
        int ans = arrays.length;
        int [] falg = new int[arrays.length];
        for(int i =0;i<arrays.length;i++){
            if(Character.isUpperCase(arrays[i])){
                falg[i ] =1 ;
            }else {
                falg[i] = 0;
            }
        }

        for(int i=1;i<falg.length;i++){
            ans += Math.abs(falg[i]-falg[i-1]);
        }
        System.out.println(ans);
    }
}
