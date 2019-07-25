package Algorithm;

import java.util.Scanner;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/16 15:55
 */

/*
* Problem Description
2007年到来了。经过2006年一年的修炼，数学神童zouyu终于把0到100000000的Fibonacci数列
(f[0]=0,f[1]=1;f[i] = f[i-1]+f[i-2](i>=2))的值全部给背了下来。
接下来，CodeStar决定要考考他，于是每问他一个数字，他就要把答案说出来，不过有的数字太长了.
* 所以规定超过4位的只要说出前4位就可以了，可是CodeStar自己又记不住。于是他决定编写一个程序来测验说的是否正确。

* */
/*
* Fibonacci数列 https://blog.csdn.net/zwj1452267376/article/details/50490990
* Catalan数列 https://blog.csdn.net/ACdreamers/article/details/7628667
* */
public class fibonacci {
    public static void main(String [] args){
        double cnt=(1+Math.sqrt(5))/2;
        int [] a =new int[21];
        a[0] = 0;
        a[1] = 1;
        int n,i;
        for(i=2;i<21;++i)
            a[i]=a[i-1]+a[i-2];
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        if(n<21)
            System.out.println(a[n]);
        else
        {
            double ans=-0.5*Math.log10(5.0)+n*Math.log10(cnt);
            ans=ans-Math.floor(ans);//取到小数部分
            ans=Math.pow(10,ans);
            ans=Math.floor(ans*1000);
            System.out.println((int)ans);
        }

    }
}
