package Offer66;

public class Problem47 {
    public static void main(String[] args){
        System.out.println("Problem 47");
        System.out.println();
        int [] arrays = {1,10,3,8,12,2,9,6,5,7,4,11,3,7,16,5};
        System.out.println(findMaxValue2(arrays,4,4));
    }
    public static int findMaxValue(int[] arrays,int rows,int cols){
        /*
        *  f(i,j) = max( f(i-1,j) ,f(i,j-1) )+ arrays(i,j)
        * */

        if(arrays.length==0 || arrays.length!= rows * cols)return -1;
        int [][] maxValue = new int[rows][cols];

        for(int i=0;i<rows;i++){
            for(int j =0;j<cols;j++){
                int up = 0 ;
                int left = 0 ;
                if(i>0)
                    up = maxValue[i-1][j];
                if(j>0)
                    left = maxValue[i][j-1];
                maxValue[i][j] = (left>up? left:up)+ arrays[i*rows+j];
            }
        }
        return maxValue[rows-1][cols-1] ;
    }
    public static int findMaxValue2(int[] arrays,int rows,int cols) {
        /*
         * f(j) 在 j 之前保存的是 f(i,0) f(i,1)...f(i,j-1)
         *      在 j 之后开始保存 f(i-1,j) f(i-1,j+1) ...f(i-1,n-1)
         * */
        if (arrays.length == 0 || arrays.length != rows * cols) return -1;
        int [] maxValue = new int[cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                int up =0;
                int left = 0;
                if(i>0)
                    up = maxValue[j];
                if(j>0)
                    left = maxValue[j-1];

                maxValue[j] = (left>up? left:up)+ arrays[i*rows+j];
            }
        }
        return maxValue[cols-1];
    }
}
