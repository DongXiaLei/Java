package Offer66;

public class Problem40 {
    public static void main(String[] args){
        System.out.println("Problem 40");
        int [] arrays = {1,2,2,2,3,4,5,6,2,2,2};
        getMinKnumbers(arrays,5);

    }
    public static void getMinKnumbers(int[] arrays, int k ){
        if(arrays.length==0||arrays.length<k)return;
        int begin = 0;
        int end = arrays.length-1;
        int index = split(arrays,begin,end);
        while (index!= k - 1){
            if(index>k-1){
                end = index-1;
                index = split(arrays,begin,end);
            }
            else {
                begin = index+1;
                index = split(arrays,begin,end);
            }
        }
        for(int i =0 ;i<k;i++ ){
            System.out.print(arrays[i]+" ");
        }
    }
    private static int split(int [] arrays,int low, int high){  // offer 12
        int key = arrays[low];
        while (low<high){
            while (low<high && arrays[high]>=key){
                high--;
            }
            arrays[low ] =arrays[high];
            while (low<high && arrays[low]<=key){
                low++;
            }
            arrays[high] = arrays[low];
        }
        arrays[low] = key ;
        return low;
    }
}
