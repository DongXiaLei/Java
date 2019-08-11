package ViewTest;

import java.util.Scanner;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/11 20:33
 */

/*
* 问题描述：
* 给定一个固定长度的数组
* 数组的每个元素都是正整数
* 只能对数组的元素进行增大不能减小
* 问把数组转换为一个先递增后递减的最小增加次数
*
* */
public class Viewbeikefinal4 {

    /*
     *  * 思路如下：
     * 1，按照数组顺序和数组元素大小建立统计图
     *    统计图横坐标为数组下标
     *     纵坐标为元素大小
     * 2，找出最大的两个数
     *   判断这两个数位置之间 是否是凹形状的
     *   如果是凹形状就要补充填满（累加电荷）
     *   不是凹形状就继续找次最大的两个数同样判断
     *   注意：这里填满时相邻柱状不能相等
     * 3，重复2 直到消除凹形状
     * */
    public static void main(String[] args){
        Scanner in  = new Scanner (System.in);
        int n = in.nextInt();
        if(n<=1)return;
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = in.nextInt();
        }
    }
    public static void minTimesOfIncrease(int[] nums ){
        int n = nums.length;

    }
}
