package ViewTest;

import java.util.Scanner;

public class ViewBeikeB1 {
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        while (true){
            String t = in.next();
            String s = in.next();
            isSubSequence(s,t);
        }
    }
    /*
    * sequence subsequence
person compression
VERDI vivaVittorioEmanueleReDiItalia
caseDoesMatter CaseDoesMatter

    * */

    public static boolean isSubSequence(String s,String t){ // s>t
        int slen = s.length();
        int tlen = t.length();
        int i =0,j=0;
        while (i<slen && j<tlen){
            if(s.charAt(i) == t.charAt(j)){
                i++; j++;
            }else {
                i++;
            }
        }
        if(j == tlen){
            System.out.println("YES");
            return true;
        }else {
            System.out.println("NO");
            return false;
        }
    }

}
