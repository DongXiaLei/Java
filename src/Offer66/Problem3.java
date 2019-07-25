package Offer66;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args){
        System.out.println("Problem 3");
        /*
        * 寻找数组中重复的数
        * 数据范围1 - n-1
        * 1，排序后遍历 最快nlogn 空间 1
        * 2，交换arr[i]和arr[arr[i]] 最快n 空间 n
        * 3，分治求数组前一半在n/2中的数 然后递归求解 最快n 空间1
        * */
        Init();
        //System.out.println(solution1());
        System.out.println(solution2());
    }
    public static Integer[] arr ;
    public static int size ;
    public static void Init(){
        List<Integer> ll = List.of(1,2,3,43,455,7);
        List<Integer> ls = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int i=0;
        //while(scan.hasNextInt()){
        //    arr[i++] = scan.nextInt();
        //}
        String s = scan.nextLine();
        String[] c = s.split(" ");
        for(i=0;i<c.length;i++){
            int e = Integer.parseInt(c[i]);
            ls.add(e);
        }
        size = ls.size();
        arr = ls.toArray(new Integer[size]);
        List<Integer> l = Arrays.asList(arr);//Arrays 和 ArrayList相互转换
        for(int e:arr) {
            System.out.println(e);
        }
    }
    public static boolean solution1(){
        for(int e:arr){
            if(e>size-1){
                System.out.println("Error Input");
                return false;
            }
        }
        int i =0 ;
        List<Integer> ls = new ArrayList<>();
        while(i<size){
            if(i!=arr[i]){
                if(arr[i] == arr[arr[i]])
                    ls.add(arr[i++]);
                else{
                    int tmp = arr[arr[i]];
                    arr[arr[i]] =arr[i];
                    arr[i] = tmp;
                }
            }
            else i++;
        }
        if(!ls.isEmpty()){
            for(int e:ls)
                System.out.println(e);
            return true;
        }
        return false;
    }
    public static int solution2(){
        for(int e:arr){
            if(e>size-1){
                System.out.println("Error Input");
                return -1;
            }
        }
        int begin =1 ,end = size -1 ;
        while(begin<=end){
            int count =0 ;
            int mid = (begin+end)>>1;
            for(int i=0;i<size;i++){
                if(arr[i]>=begin&&arr[i]<=mid)
                    count++;
            }
            if(begin == end){
                if(count>1)
                    return begin;
                else break;
            }
            if(count>(mid-begin+1))
                end = mid;
            else begin = mid+1;
        }
        return -1;
    }
}
