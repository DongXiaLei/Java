package ViewTest;

import java.util.Scanner;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/2 16:04
 */

public class ViewpinDuo {
    public static void main(String[] args){
        Scanner in  = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        String[] strings1 = s1.split(" ");
        String[] strings2 = s2.split(" ");
        int[] nums1 = new int[strings1.length];
        int[] nums2 = new int[strings2.length];
        int count =0;
        for(String ele: strings1){
            nums1[count++] = Integer.parseInt(ele);
        }
        count = 0;
        for(String ele: strings2){
            nums2[count++] = Integer.parseInt(ele);
        }
        makeSortedArray(nums1,nums2);
    }
    public static void  makeSortedArray(int[] nums1 ,int [] nums2){
        if(nums1.length<=1)return;
        int i,ans =Integer.MIN_VALUE;
        for( i=1 ;i<nums1.length;i++){
            if(nums1[i]<nums1[i-1]){
                break;
            }
        }
        int left = Integer.MIN_VALUE;
        int right = Integer.MAX_VALUE;
        if(i==0){  //左端点
            right = nums1[i+1];
        }
        else if(i==nums1.length-1){
            left = nums1[i-1];
        }else {
            left = nums1[i-1];
            right = nums1[i+1];
        }
        for(int j =0;j< nums2.length;j++){
            if(nums2[j]>=left && nums2[j]<=right && nums2[j]>ans){
                ans = nums2[j];
            }
        }
        nums1[i] = ans;
        return;
    }
}
