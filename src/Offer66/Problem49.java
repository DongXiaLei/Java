package Offer66;

import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Math.min;

public class Problem49 {
    public static void main(String[] args) {
        // 丑数 3,5,7
        System.out.println("Problem 49");
        System.out.println();
        System.out.println(kthPrimeNumber(5));
        System.out.println(GetUglyNumber(6));
    }
    public static  long kthPrimeNumber(int k) {

        long [] num = new long[k+1];
        int p3,p5,p7;
        p3=p5=p7=0;
        num[0]=1;
        for(int i = 1;i<k;i++){
            num[i] = min(num[p3]*3,min(num[p5]*5,num[p7]*7));
            if(num[i] == num[p3]*3)
                p3++;
            if(num[i] == num[p5]*5)
                p5++;
            if(num[i] == num[p7]*7)
                p7++;
        }
        return num[k-1];
    }
    public static int GetUglyNumber(int index) {
        /*
        * 每次从三个队里取出最小的元素
        * 然后把最小的分别乘以2,3,5分别加到三个队
        * */
        if(index==1)return 1;
        Queue<Integer> queue2 = new LinkedList<>();
        Queue<Integer>queue3 = new LinkedList<>();
        Queue<Integer>queue5 = new LinkedList<>();
        queue2.offer(2);queue3.offer(3);queue5.offer(5);
        int count = 1;
        int min=0;
        while(count<index){
            min = Math.min(Math.min(queue2.peek(), queue3.peek()), queue5.peek());
            if(min==queue2.peek()){
                queue2.offer(min*2);
                queue3.offer(min*3);
                queue5.offer(min*5);
                queue2.poll();
            }else if (min==queue3.peek()) {
                queue3.offer(min*3);
                queue5.offer(min*5);
                queue3.poll();
            }else {
                queue5.offer(min*5);
                queue5.poll();
            }
            count++;
        }//while
        return min;
    }

}
