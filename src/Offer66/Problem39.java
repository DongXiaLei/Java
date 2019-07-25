package Offer66;

public class Problem39 {
    public static void main(String[] args){
        System.out.println("Problem 39");
        //数组中2超过一半的数
        int [] arrays = {1,2,2,2,3,4,5,6,2,2,2};
        System.out.println(findMoreHalfNum(arrays));
        System.out.println(findMoreHalfNum2(arrays));
    }
    public static int findMoreHalfNum2(int [] arrays){
        if(arrays.length==0)return -1;
        int ans = arrays[0],times =1;
        for(int i=0;i<arrays.length-1;i++){
            if(times == 0){
                ans = arrays[i];
                times =1;
            }
            else if(ans == arrays[i])
                times++;
            else times--;
        }
        //判断是否数量超过一半
        int count =0;
        for(int i =0;i<arrays.length;i++){
            if(arrays[i] == ans)
                count++;
        }
        if(count*2<=arrays.length)
            return -1;
        else return ans;
    }
    public static int  findMoreHalfNum(int[] arrays){
        if(arrays.length==0)return -1;
        int mid = arrays.length>>1;
        int begin =0;
        int end = arrays.length-1;
        int index = split(arrays,begin,end);
        while (index!=mid){
            if(index>mid){
                end = index -1 ;
                index = split(arrays,begin,end);
            }
            else {
                begin = index +1 ;
                index =split(arrays,begin,end);
            }
        }
        //判断是否数量超过一半
        int count =0;
        for(int i =0;i<arrays.length;i++){
            if(arrays[i] == arrays[index])
                count++;
        }
        if(count*2<=arrays.length)
            return -1;
        else return arrays[index];

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
