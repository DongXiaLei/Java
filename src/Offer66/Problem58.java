package Offer66;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Problem58 {
    public static void main(String[] args){
        System.out.println("Problem 58");
        Scanner in = new Scanner(System.in);
        String string = "dong xia lei. ";
        System.out.println(string.indexOf('d'));
        reverseString(string);
        Reverse(string);
        reverseLeft("dongxialei",4);
    }

    public static void reverseString(String string){
        /*
         *倒序输出字符串 其中单词不反转
         * */
        if(string.length()==0)return;
        String ss = string;
        String[] s = string.split(" ");

        Stack<String> stack = new Stack<>();
        for(int i=0; i<s.length;i++){
            stack.push(s[i]);
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }
    public static void Reverse(String string){
        //反转所有的字符
        if(string.length()==0)return;
        int begin = 0;
        int end = string.length()-1;
        char[] str = string.toCharArray();
        while (begin<end){
            char ch = str[end];
            str[end] = str[begin];
            str[begin] = ch;
            begin++ ;end --;
        }
        System.out.println(str);
    }
    public static char[] Reverse(String string,int begin,int end){
        //反转所有的字符
        if(string.length()==0)return null;
        char[] str = string.toCharArray();
        while (begin<end){
            char ch = str[end];
            str[end] = str[begin];
            str[begin] = ch;
            begin++ ;end --;
        }
        return str;
    }
    public static void reverseLeft(String string, int k){
        char[]  s1 =Reverse(string,0,k-1);
        char[]  s2 = Reverse(string,k,string.length()-1);
        StringBuffer sb  = new StringBuffer();
        sb.append(Arrays.copyOfRange(s1,0,k));
        sb.append(Arrays.copyOfRange(s2,k,string.length()));
        sb = sb.reverse();
        System.out.println(sb);
    }
}
