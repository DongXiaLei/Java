package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/21 15:46
 */
public class LC31 {
    public static void nextPermutation(int[] nums) {
        int length = nums.length;
        int i = length-1;
        while (i>0){
            if(nums[i]<=nums[i-1]){
                i--;
            }else {
                break;
            }
        }
        if(i==0){  //反转整个
            i=length-1;
            while (i>(length-1)/2){
                swap(nums,i,length-1-i);
                i--;
            }
        }else {
            int index = i -1 ;
            int j ;
            for( j= i;j<length;j++){
                if(nums[j]<=nums[index] && nums[j-1]>nums[index]){
                    break;
                }
            }
            swap(nums,j-1,index);
            j=i;
            for(int k =0;k<(length-i)>>1;k++){
                swap(nums,j,length-1+i-j);
                j++;
            }
        }
    }
    public static void swap(int[] nums,int i1,int i2){
        int tmp =nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }
    public static void main(String[] args){
        int[] arrays ={1,5,1};
        nextPermutation(arrays);
    }
}
