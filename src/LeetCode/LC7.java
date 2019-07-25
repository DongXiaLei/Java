package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/19 10:24
 */
public class LC7 {
    public static void main(String[] args){
        System.out.println(reverse(1534236469));
    }
    public static int reverse(int x) {
        // 2^31  =2147483648  可能反转后大于
        if(x<=-Math.pow(2,31) || x>=Math.pow(2,31)-1)return 0;
        Queue<Integer> queue = new LinkedList<>();
        long ans= 0 ;
        while (x!=0){
            queue.offer(x%10);
            x = x/10;
        }
        while (!queue.isEmpty()){
            long tmp = ans*10+queue.peek();
            if(tmp>=Math.pow(2,31)-1 ||tmp<=-Math.pow(2,31) )
                return 0;
            else  ans = ans *10 + queue.poll();
        }
        return (int)ans;
    }
}
