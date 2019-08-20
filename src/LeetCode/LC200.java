package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/13 15:20
 */
public class LC200 {
    public static void main(String[] args){
        int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,1,0,0},{0,0,0,0,1}};
        System.out.println(numIslands(grid));
    }
    public static int numIslands(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int ans =0;
        for(int i =0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] ==1 ){
                    ans++;
                    numIslandsCore(grid,i,j,rows,cols);
                }
            }
        }
        return ans;
    }
    public static void numIslandsCore(int[][] grid,int i,int j,int rows,int cols){
        if(i>=0 && i<rows && j>=0 && j<cols && grid[i][j] == 1){
            grid[i][j] = 0;
        }else {
            return;
        }
        numIslandsCore(grid,i-1,j,rows,cols);
        numIslandsCore(grid,i+1,j,rows,cols);
        numIslandsCore(grid,i,j-1,rows,cols);
        numIslandsCore(grid,i,j+1,rows,cols);
    }
}
