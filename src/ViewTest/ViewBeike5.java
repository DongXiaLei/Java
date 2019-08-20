package ViewTest;

import java.util.Scanner;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/7 12:54
 */
public class ViewBeike5 {
    public static  double[] p = new  double[10000001];
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        long n = in.nextInt();
        p[1] = 0;
        p[2] = 0.5;
        for(int i = 3; i <= 1000000; ++ i)
            p[i] = p[i - 1] * (i - 1) / i + p[i - 2] / i;

        n = Math.min(n, 1000000l);
        System.out.printf("%.4f\n", 1 - p[(int)n]);
    }


}
