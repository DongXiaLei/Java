package LeetCode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/13 20:58
 */
/*
*
6 6
3 2 1 5 6 4
*  9 4
3 2 3 1 2 4 5 5 6
* */
public class LC215 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        if (n <= 1) return;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        System.out.println(findKthLargest(nums,k));
    }
    public  static int findKthLargest(int[] nums, int k) {
        // init heap 'the smallest element first' 小根堆 默认就是小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
        //大根堆
        //PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> n2 - n1);
        // keep k largest elements in the heap
        for (int n: nums) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // output
        return heap.poll();
    }

    public static int findKthLargest2(int[] nums, int k) {
        int index = nums[0];
        int begin =0;
        int end =nums.length-1;
        int ans ;

        while (begin<end){
            while (begin<end && nums[end]>=index){
                end--;
            }
            nums[begin] = nums[end];
            while (begin<end && nums[begin]<=index){
                begin++;
            }
            nums[end] = nums[begin];
        }
        nums[begin] = index;
        if((nums.length-begin)>k){
            ans = findKthLargest(Arrays.copyOfRange(nums,begin+1,nums.length),k);
        }else if((nums.length-begin)<k){
            ans = findKthLargest(Arrays.copyOfRange(nums,0,begin),k-(nums.length-begin));
        }else {
            ans = nums[begin];
        }
        return ans;
    }
}
