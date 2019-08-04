package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/*
* 对于没有括号的序列
* 直接从左往右遍历
* 找到重复的单字母和后边的数字输出，
* 遇到
* */
public class ViewYTK {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] strings = new String[n];
        for(int i=0;i<n;i++) {
            strings[i] = in.next();
        }
        unZip(strings);
    }
    public static void unZip(String[] strings){
        int n = strings.length;
        for(int i =0;i<n;i++){
            String string = strings[i];
            int len = string.length();
            char[] s = string.toCharArray();
            Stack<Character> stack = new Stack();
            List<Character>  ans = new ArrayList<>();
            List<Character> num =new ArrayList<>() ;
            int j =0;
            boolean flag = true;
            while (j<len){
                char tmp= '@' ;
                while (flag && j<len){ // 乜有括号
                    if(s[j]>='A' && s[j]<='Z'){
                        System.out.print(s[j]);
                        tmp = s[j];
                        j++;
                    }
                    else if(s[j]>='0' && s[j]<='9'){
                        num.add(s[j]);
                        j++;
                        if(j<len && s[j]>='A' && s[j]<='Z'){
                            break;
                        }
                    }else {
                        flag = false;
                    }
                }
                int nums =0;
                for(Character ele:num){
                    nums *= 10;
                    nums += ele-'0';
                }
                for(int t =0;t<nums;t++){
                    if(tmp!='@'){
                        System.out.print(tmp);
                    }
                }
            }


        }
    }
}
/*
* 5
A11B
(AA)2A
((A2B)2)2G
(YUANFUDAO)2JIAYOU
A2BC4D2
*
* AAAAAAAAAAAB
AAAAA
AABAABAABAABG
YUANFUDAOYUANFUDAOJIAYOU
AABCCCCDD
*
* if( s[j]!= ')'){
                    stack.push(s[j]);
                    j++;
                }else {
                    Stack<Character> stack2 = new Stack();
                    while (stack.peek()!='('){
                        stack2.push(stack.pop());
                    }

                }
* */