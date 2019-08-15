package LeetCode;

import java.util.*;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/14 15:48
 */

/*
8 3
1 3 -1 13 5 8 6 7
* */
public class LC239 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n<=1)return;
        int k = in.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = in.nextInt();
        }
        for(int ele:maxSlidingWindow(nums,k)){
            System.out.println(ele);
        }
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length<=0 || k<=0 || k>nums.length)return new int[0];
        int[] outputs = new int[nums.length-k+1];
        int count =0;
        Deque<Integer> window = new LinkedList<>();
        /*Init K integers in the list*/
        for (int i = 0; i < k; i++) {
            //保证队列是递减的
            while (!window.isEmpty()  && nums[i] > nums[window.peekLast()]) {
                window.pollLast();
            }
            window.offerLast(i);
        }
        outputs[count++] = nums[window.peekFirst()];

        for (int i = k; i < nums.length; i++) {
            if (!window.isEmpty() && window.peekFirst() <= i - k) {
                window.pollFirst();
            }
            while (!window.isEmpty() && nums[i] > nums[window.peekLast()]) {
                window.pollLast();
            }
            window.offerLast(i);
            outputs[count++] = nums[window.peekFirst()];
        }
        return outputs;
    }

}
