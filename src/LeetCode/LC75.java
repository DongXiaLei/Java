package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/23 21:58
 */
public class LC75 {
    public static void sortColors(int[] nums) {
        /*
        * 定义三个指针 第一个指针指向第一个不为0的数
        * 最后一个指针指向倒数第一个不为2的数
        * 中间一个遍历
        * */
        if(nums.length<=1)return;
        int index1 = 0,index2=0,index3 =nums.length-1;

        while (index2<=index3) {
            if (index2 < nums.length && nums[index2] == 0) {
                swap(nums, index1, index2);
                index1++;
                index2++;
            } else if (index2 < nums.length && nums[index2] == 2) {
                swap(nums, index3, index2);
                index3--;
            }
            else index2++;
        }

    }
    public static void swap(int [] nums ,int ind1 ,int ind2){
        if(ind1>=nums.length || ind2>=nums.length)return;
        int tmp =nums[ind1];
        nums[ind1] =nums[ind2];
        nums[ind2] =tmp;
    }
    public static void main(String[] args){
        int [] nums = new int[]{0,0};
        sortColors(nums);
    }
}
