package Offer66;

public class Problem33 {
    public static void main(String[] args){
        System.out.println("Problem 33");
        int [] arrays = {5,7,6,9,11,10,8};
        boolean ans = isSubArrayOfBST(arrays);
    }
    public static boolean isSubArrayOfBST(int [] arrays){
        if(arrays==null) return false;
        return isSubArrayOfBST(arrays,0,arrays.length-1);
    }
    private static boolean isSubArrayOfBST(int [] arrays ,int begin ,int end){
        if(end<begin) return false;
        if(end == begin) return true;
        int i = begin;
        for(;i<end;i++){
            if(arrays[i]>arrays[end])
                break;;
        }
        for(int j=i;j<end;j++){
            if(arrays[j]<arrays[end])
                return false;
        }
        return isSubArrayOfBST(arrays,begin,i-1) && isSubArrayOfBST(arrays,i,end-1);
    }
}
