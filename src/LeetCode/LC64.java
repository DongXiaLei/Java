package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/23 20:48
 */
public class LC64 {
    public static void main(String[] args){
        int[][] nums = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        minPathSum(nums);
    }
    public static int minPathSum(int[][] grid) {
        if(grid==null)return -1;
        int row = grid.length;
        int col = grid[0].length;
        int [][] f = new int[row][col];
        f[0][0] = grid[0][0];
        for(int j =1;j<col;j++){
            f[0][j] = f[0][j-1]+grid[0][j];
        }
        for(int i=1;i<row;i++){
            f[i][0] = f[i-1][0]+grid[i][0];
        }
        for(int i =1 ;i<row ; i++){
            for(int j = 1;j<col;j++){
                if(f[i-1][j]>f[i][j-1]){
                    f[i][j] = f[i][j-1]+grid[i][j];
                }else {
                    f[i][j] = f[i-1][j] +grid[i][j];
                }
            }
        }
        return f[row-1][col-1];
    }
}
