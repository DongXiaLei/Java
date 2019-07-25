public class Problem57 {
    public static void main(String[] args){
        System.out.println("Problem57");
        int[] arrays = {1,2,4,7,11,15};
        findSumK(15,arrays);
        findSumKlist(21);
    }
    public static void findSumK(int k,int[] arrays){
        if(arrays.length==0)return;
        int begin = 0;
        int end = arrays.length-1;
        while(begin<end){
            int curSum = arrays[begin]+arrays[end];
            if(curSum==k){
                System.out.println(arrays[begin]+" "+arrays[end]);
                return;
            }
            if(curSum>k){
                end--;
            }
            else {
                begin++;
            }
        }
    }
    public static void findSumKlist(int k){
        if(k<3)return;
        int begin = 1;
        int end = 2;
        int mid = (1+k)>>1;
        int curSum = 3;
        while (begin<mid){
            if(curSum==k){
                for(int i = begin ;i<=end;i++){
                    System.out.print(i+" ");
                }
                System.out.println(" ");
                end++;
                curSum += end;
            }
            if(curSum<k){
                end++;
                curSum+= end;
            }
            else {
                curSum -= begin;
                begin ++;
            }
        }
    }
}
