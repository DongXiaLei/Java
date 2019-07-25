package Offer66;

public class Problem11 {
    public static void main(String[] args){
        System.out.println("Problem 11 ");
        int[] arr1 = {2,3,4,5,6,7,1,1,1,2,2,2,2};
        int[] arr3 = {};
        int[] arr2 = {0,0,1,1,1};
        System.out.println(findMin(arr1));
    }
    public static int findMin(int[] array){
        if(array==null||array.length==0)
            return -1;

        int ind1=0 ,ind2 = array.length-1,ind =0;
        ind = (ind1+ind2)>>1;
        if(array[ind1]<array[ind2])
            return array[ind1];
        while ((ind1+1) != ind2){
            if(array[ind1] == array[ind] && array[ind2] == array[ind]){
                int min =  999;  //如果下标ind1 ind2 ind对应的数一样  类似于 例子2 就只能顺序查找
                for(int i=ind1;i<ind2;i++){
                    if(array[i]<min)
                        min = array[i];
                }
                return min;
            }
            if(array[ind1]<=array[ind]){
                ind1 = ind;
            }
            else if(array[ind]<=array[ind2]){
                ind2 = ind;
            }
            ind = (ind1+ind2)>>1;
        }
        return array[ind1]<array[ind2]? array[ind1]:array[ind2];
    }
}
