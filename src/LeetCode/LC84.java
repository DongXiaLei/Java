package LeetCode;

import java.util.Stack;

import java.util.Stack;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/26 18:03
 */
public class LC84 {
    public static void main(String[] args){
        int[] nums = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(nums));
    }
    public static int largestRectangleArea1(int[] heights) {
        int begin = 0 ,end =heights.length-1;
        return largestRectangleAreaCore(heights,begin,end);
    }
    public static int largestRectangleArea(int[] heights) {
        if(heights.length<=0)return 0;
        Stack<Integer> stack = new Stack();
        int i = 1,ans = heights[0];
        stack.push(0);
        while (i<heights.length|| (i ==heights.length && !stack.isEmpty())){
            // 栈保持递增顺序
            if(i!=heights.length && (stack.isEmpty() ||heights[i] >= heights[stack.peek()])){
                stack.push(i);
                i++;
            }else {
                int top = heights[stack.pop()];
                int curmax = stack.isEmpty()? top*i :(i-stack.peek()-1)*top;
                ans = Math.max(ans,curmax);
            }
        }
        return ans;
    }
    private static int largestRectangleAreaCore(int[] heights,int begin,int end){
        if(begin>end)return 0;
        int index =begin,i=0,ans=0;
        for( i=begin;i<=end;i++){
            if(heights[i]<=heights[index]){
                index = i;
            }
        }
        ans = (end-begin+1)*heights[index];
        int leftAns=0 ,rightAns=0;
        leftAns += largestRectangleAreaCore(heights,begin,index-1);
        rightAns += largestRectangleAreaCore(heights,index+1,end);
        ans = Math.max(ans,Math.max(leftAns,rightAns));

        return ans;
    }
}
