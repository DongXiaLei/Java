package ViewTest;

import java.util.Scanner;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/7 14:13
 */
/*
* 6
1 2
2 3
3 5
4 5
4 6
5 1
* true
* 3
1 2
2 3
4 5
* */
public class ViewBeike6 {
    public static int[] a=new int[200000+1];
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int [][] nums = new int[n][2];
        for(int i =0;i<n;i++){
            nums[i][0]=in.nextInt();
            nums[i][1]=in.nextInt();
        }

        for(int i=0;i<a.length;i++){
            a[i] = i;
        }
        int []count = new int[a.length];
        for(int i=0;i<n;i++){
            union(nums[i][0],nums[i][1]);
            count[nums[i][0]]++;
            count[nums[i][1]]++;
        }
        int odd=0;
        for(int i=0;i<a.length;i++){
            if(count[i]%2==1){
                odd++;
            }
        }
        boolean flag =true;
        int root = find(nums[0][0]);
        for(int i =0;i< n;i++){
            int root1 = find(nums[i][0]);
            int root2 = find(nums[i][1]);
            if(root1!=root || root2 != root){
                flag = false;
                break;
            }
        }
        if(odd%2 == 0 && flag)
            System.out.println(true);
        else System.out.println(false);

    }
    public static int find(int n){
        int i =n;
        while (i!=a[i]) i =a[i];
        return i;
    }
    public static boolean union(int m,int n){
        int root1 = find(m);
        int root2 = find(n);
        if(root1==root2)return true;
        else {
            a[root1] = root2;
            return false;
        }
    }
}
