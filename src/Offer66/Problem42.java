package Offer66;

public class Problem42 {
    public static void main(String[] args){
        System.out.println("Problem 41");
        int [] arrays = {1,-2,3,1-0,-4,7,2,-5};
        System.out.println(findMaxSubArray(arrays));
    }
    public static int findMaxSubArray(int [] arrays){
        if(arrays==null)return -1;
        int curSum = 0;
        int maxSum =Integer.MIN_VALUE;
        for(int i=0;i<arrays.length;i++){
            if(curSum<=0){
                curSum = arrays[i];
            } else {
                curSum += arrays[i];
            }
            if(maxSum<curSum)
                maxSum = curSum ;
        }
        return maxSum;
    }

}
