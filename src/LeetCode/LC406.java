package LeetCode;

import java.util.*;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/15 21:52
 */
public class LC406 {
    public static void main(String [] args){
        int[][] people = {{4,4},{5,1},{5,0},{5,3},{6,1},{7,1},{7,2},{7,0}};
        reconstructQueue(people);
    }
    public  static int[][] reconstructQueue(int[][] people) {
        if(people.length<=0)return people;
        Comparator<int[]> comparator = (array1,array2)->{
            if(array1[0]!=array2[0]){
                return array2[0]-array1[0];
            }else {
                return array1[1]-array2[1];
            }
        };
        List<int[] > list = new ArrayList<>();
        for(int i=0;i<people.length;i++){
            list.add(people[i]);
        }
        Collections.sort(list,comparator);
        int[][]  ans = new int[people.length][];


        int count=0;
        for(int[] ele : list){
            if(ele[1]<count){
                for(int j = count;j>ele[1];j--){
                    swap(list,j,j-1);
                }
            }
            count++;
        }
        count=0;
        for(int[] ele:list){
            ans[count++] = ele;
        }
        return ans;
    }
    public static void swap(List<int[] > list,int i,int j){
        int[] array1 = list.get(i);
        int[] array2 = list.get(j);
        list.set(i,array2);
        list.set(j,array1);
    }
}
