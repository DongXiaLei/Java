package ViewTest;

import java.util.Scanner;

public class ViewBeikeB2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int sum = a+b+c;
        int max = Math.max(a,Math.max(b,c));
        int min = Math.min(a,Math.min(b,c));
        int mid = sum - max-min;
        int ans1 = (min+mid) * max;
        int ans2 = min* mid * max;
        System.out.println(ans1>ans2? ans1:ans2);

    }
}
