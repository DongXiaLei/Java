package LeetCode;

import java.util.Stack;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/14 15:11
 */
public class LC221 {
    public static void main(String [] args){
        char[][] matrix = {{'1', '0', '1', '1', '1'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        System.out.println(maximalSquare(matrix));
    }
    public static int maximalSquare(char[][] matrix) {
        int rows= matrix.length;
        if(rows<=0)return 0;
        int cols =matrix[0].length;
        int[][] w = new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j] == '0'){
                    w[i][j] =0;
                }else {
                    w[i][j] =1;
                }
            }
        }
        int ans =largestRectangleArea(w[0]);
        for(int i=1;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(w[i][j] ==1 && w[i-1][j] != 0){
                    w[i][j]  = w[i][j] +w[i-1][j];
                }
            }
            int tmp =  largestRectangleArea(w[i]);
            ans = Math.max(ans,tmp);
        }
        return ans;
    }
    public static int largestRectangleArea(int[] heights) {
        if(heights.length<=0)return 0;
        Stack<Integer> stack = new Stack();
        int i = 1,ans = 1;
        stack.push(0);
        while (i<heights.length|| (i ==heights.length && !stack.isEmpty())){
            // 栈保持递增顺序
            if(i!=heights.length && (stack.isEmpty() ||heights[i] >= heights[stack.peek()])){
                stack.push(i);
                i++;
            }else {
                int top = heights[stack.pop()];
                double curmax = stack.isEmpty()? Math.pow(Math.min(top,i),2) :Math.pow(Math.min((i-stack.peek()-1),top),2);
                ans = Math.max(ans,(int)curmax);
            }
        }
        return ans;
    }
}
