package Offer66;

public class Problem29 {
    public static void main(String[] args){
        System.out.println("Problem 29");
        int [][] datas = new int[5][4];
        int count =1 ;
        for(int i=0;i<5;i++){
            for(int j =0;j<4;j++){
                datas[i][j] = count++;
            }
        }
        printMatrix(datas,datas.length,datas[0].length);
    }
    public static void printMatrix(int [][] matrix ,int row ,int col){
        if(matrix==null||row<=0||col<=0) return;
        int start =0;
        while(start*2<row && start*2 <col){
            printMatrixCore(matrix,row,col,start);
            start++;
        }
    }
    private static void printMatrixCore(int [][] matrix ,int row  ,int col ,int start ) {
        int endRow = row-1-start;
        int endCol = col -1 -start;
        for(int i=start;i<=endCol;i++){
            System.out.print(matrix[start][i]+" ");
        }
        if(start<endRow){
            for(int i = start+1 ;i<=endRow;i++){
                System.out.print(matrix[i][endCol]+" ");
            }
        }
        if(start<endCol && start<endRow){
            for(int i=endCol-1;i>=start;i--){
                System.out.print(matrix[endRow][i]+" ");
            }
        }
        if(start<endRow-1 && start<endCol){
            for(int i =endRow -1 ;i>=start+1;i--){
                System.out.print(matrix[i][start]+" ");
            }
        }
    }
}
