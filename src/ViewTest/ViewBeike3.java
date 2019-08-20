package ViewTest;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/7 11:07
 */
public class ViewBeike3 {
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n<1000 || n>9000) {
            System.out.println(-1);
            return;
        }
        while (n!=Integer.MAX_VALUE){
            n++;
            String s = String.valueOf(n);
            char[] chars = s.toCharArray();
            Set<Integer> set = new HashSet<>();
            for(int i=0;i<chars.length;i++){
                int t = chars[i] - '0';
                set.add(t);
            }
            if(set.size()<=3){
                System.out.println(n);
                break;
            }
        }
    }
}
