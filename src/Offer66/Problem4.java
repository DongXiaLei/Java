package Offer66;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
    public static void main(String[] args){
        System.out.println("Problem 4 ");
        Init();
        System.out.println(solution());
    }
    public static List<List<Integer>> arr2arr = new ArrayList<>(); //必须要写后边的定义
    public static int target = 1;
    public static void Init(){
        for(int i=0;i<4;i++){
            List<Integer> ls = new ArrayList<>();
            for(int j =0;j<4;j++){
                ls.add(i*4+j+1);
            }
            arr2arr.add(ls);
        }
        for(int i=0;i<4;i++){
            List<Integer> ls = arr2arr.get(i);
            for(int e : ls){
                System.out.println(e);
            }
        }
    }
    public static boolean solution(){
        int row = arr2arr.size();
        int col = arr2arr.get(0).size();
        if(target<arr2arr.get(0).get(0)||target>arr2arr.get(row-1).get(col-1))
            return false;
        int r = 0,c = col -1;
        while(r<row&&c>=0){
            if(arr2arr.get(r).get(c)==target){
                return true;
            }
            else if(arr2arr.get(r).get(c)>target){
                c -- ;
            }
            else r++;
        }
        return false;
    }
}
