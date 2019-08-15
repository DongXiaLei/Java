package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/14 17:02
 */
public class LC240 {
    public static void main(String[] args){
        int [] nums ={1,2,3,4,7,9,10};
        System.out.println(binarySerach(nums,0,nums.length-1,10));
        int[][] matrix = new int[1][1];
        matrix[0][0] = -1;
        System.out.println(searchMatrix(matrix,-1));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length-1;
        if(m<0)return false;
        int n = matrix[0].length-1;
        int i=0,j=n;
        while (i<=m && j>=0){
            if(target<matrix[i][j]){
                j--;
            }else if(target>matrix[i][j]){
                i++;
            }else {
                return true;
            }
        }
        return false;
    }
    // 在递增数组搜素 二分
    public static boolean binarySerach(int[] nums ,int begin,int end,int target){
        while (begin<=end){
            int mid = (begin+end)>>1;
            if(nums[mid] == target)return true;
            else if(nums[mid]>target){
                end = mid-1;
            }else {
                begin = mid+1;
            }
        }
        return false;
    }
}
