package LeetCode;

import java.util.Stack;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/26 19:09
 */
public class LC85 {
    public static int maximalRectangle1(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[] heights = new int[matrix[0].length + 1]; //小技巧后边讲
        int maxArea = 0;
        for (int row = 0; row < matrix.length; row++) {
            Stack<Integer> stack = new Stack<Integer>();
            heights[matrix[0].length] = 0;
            //每求一个高度就进行栈的操作
            for (int col = 0; col <= matrix[0].length; col++) {
                if (col < matrix[0].length) { //多申请了 1 个元素，所以要判断
                    if (matrix[row][col] == '1') {
                        heights[col] += 1;
                    } else {
                        heights[col] = 0;
                    }
                }
                if (stack.isEmpty() || heights[col] >= heights[stack.peek()]) {
                    stack.push(col);
                } else {
                    //每次要判断新的栈顶是否高于当前元素
                    while (!stack.isEmpty() && heights[col] < heights[stack.peek()]) {
                        int height = heights[stack.pop()];
                        int leftLessMin = stack.isEmpty() ? -1 : stack.peek();
                        int RightLessMin = col;
                        int area = (RightLessMin - leftLessMin - 1) * height;
                        maxArea = Math.max(area, maxArea);
                    }
                    stack.push(col);
                }
            }

        }
        return maxArea;
    }
    public static int maximalRectangle(char[][] matrix){
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
    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '1', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        System.out.println(maximalRectangle(matrix));
    }
}
