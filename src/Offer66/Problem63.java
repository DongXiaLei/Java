package Offer66;
public class Problem63 {
    public static void main(String[] args){
        System.out.println("Problem 63");
        int [] arrays ={12,9,11,8,5,13,16,14,3,12};
        System.out.println(MaxDiff(arrays));
    }
    public static int MaxDiff(int[] arrays){
        if(arrays.length<2)return -1;
        int min = arrays[0];
        int maxDiff = arrays[1]  -arrays[0];
        for(int i=1 ;i<arrays.length -1;i++){
            if(arrays[i]<min)
                min = arrays[i];
            int tmp = arrays[i] - min;
            if(tmp>maxDiff)
                maxDiff = tmp ;
        }
        return maxDiff;
    }
}
