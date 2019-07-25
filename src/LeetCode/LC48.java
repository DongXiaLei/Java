package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/22 16:31
 */
public class LC48 {
    public static void rotate(int[][] matrix) {
        //先转置 再对称
        int row = matrix.length;
        int col = matrix[0].length;
        if(row<=1 || col<=1 )return;
        for(int i = 0 ;i<row;i++){
            for(int j = i+1 ;j<col;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for(int j = 0 ;j<col/2 ;j++){
            for(int i= 0 ;i<row;i++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][col-1-j];
                matrix[i][col-1-j] =tmp;
            }
        }

    }

    public static void main(String [] args){
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rotate(matrix);
    }
}
