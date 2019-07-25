package Offer66;

public class Problem12 {
    public static void main(String[] args){
        System.out.println("Problem 12");
        int[] arr = {2,3,4,5,6,7,1,1,1,2,2,2,2};
        quickSort(arr,0,arr.length-1);
        for(int ele : arr){
            System.out.print(ele+" ");
        }
    }

    public static void quickSort(int [] arrays,int low ,int high){
        if(low>high) return;
        int index = split(arrays,low,high);
        quickSort(arrays,low,index-1);
        quickSort(arrays,index+1,high);
    }
    public static int split(int [] arrays,int low, int high){
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
/*
* public static void quickSort(int[] datas,int low, int high){
        if(low>high) return;
        int index = split(datas,low,high);
        quickSort(datas,low,index-1);
        quickSort(datas,index+1,high);

    }
    private static int split(int[] array,int low ,int high){
        int key = array[low];
        while(low<high){
            while (array[high]>=key && high>low) high--;
            array[low] = array[high];
            while (array[low]<=key && low<high) low++;
            array[high]  = array[low];
        }
        array[high] = key ;
        return high;
    }
*
* */
