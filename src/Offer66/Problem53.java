package Offer66;

public class Problem53 {
    public static void main(String[] args) {
        System.out.println("Problem 53");
        int [] array1 = {1,2,2,2,3,3,3,3,4,4,4,4,4,4,4,4,4,5,5,5,5,6,6,7};
        System.out.println(findKNUms(array1,4));
        int [] array2 = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(findMissNum(array2));
        int [] array3 = {1,2,3,4,5,6,7,7,10};
        System.out.println(findIndexSameValue(array3));
    }
    public static int findKNUms(int[] arrays,int k){
        if(arrays.length==0)return -1;
        int begin =  0;
        int end = arrays.length -1 ;
        int firstK = findFirstKth(arrays,k,begin,end);
        int lastK = findLastKth(arrays,k,begin,end);
        if(firstK>0 && lastK>0)
            return lastK-firstK +1 ;
        return -1;
    }
    private static int findFirstKth(int[] arrays ,int k ,int begin ,int end){
        if(begin>end)return -1;
        int midIndex = (begin+end)>>1;
        if(arrays[midIndex]==k){
            if(midIndex>0 && arrays[midIndex-1]!=k){
                //前一个不是k
                return midIndex;
            }else {
                end = midIndex -1;
            }
        }
        else if(arrays[midIndex]>k){
            end = midIndex-1 ;
        }else {
            begin = midIndex+1;
        }
        return findFirstKth(arrays,k,begin,end);
    }
    private static int findLastKth(int[] arrays ,int k ,int begin ,int end){
        if(begin>end)return -1;
        int midIndex = (begin+end)>>1;
        if(arrays[midIndex]==k){
            if(midIndex>0 && arrays[midIndex+1]!=k){
                //后一个不是k
                return midIndex;
            }else {
                begin = midIndex + 1;
            }
        }
        else if(arrays[midIndex]>k){
            end = midIndex-1 ;
        }else {
            begin = midIndex+1;
        }
        return findLastKth(arrays,k,begin,end);
    }
    public static int findMissNum(int [] arrays){
        if(arrays.length==0)return -1;
        int left = 0;
        int right = arrays.length-1;
        while (left<=right){
            int mid = (left+right)>>1;
            if(arrays[mid]==mid){
                left = mid+1 ;
            }
            else{
                if(mid == 0|| arrays[mid-1] == mid -1){
                    return mid;
                }
                right = mid -1 ;
            }
        }
        return -1;
    }
    public static int findIndexSameValue(int [] arrays){
        /*
        * 求数组中下标和值相等的元素
        * 思路：所求下标左边的元素的值小于对应的下标
        *         右边则相反
        * */
        if(arrays.length==0)return -1;
        int left = 0 ;
        int right = arrays.length-1;
        while(left<=right){
            int mid = (left+right)>>1;
            if(arrays[mid] == mid)
                return mid;
            if(arrays[mid]>mid){
                left = mid+1;
            }else {
                right = mid -1 ;
            }
        }
        return -1;
    }
}
