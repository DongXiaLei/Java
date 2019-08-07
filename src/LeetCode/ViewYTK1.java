package LeetCode;

import java.util.Scanner;
import java.util.Stack;


public class ViewYTK1 {
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
            Stack<String> strStack = new Stack();
            Stack<Integer> numSatck = new Stack<>();
            String res = "";
            for(int j =0;j<len;j++){
                // 3[2[s]c2[r]]
                if(string.charAt(j) ==']'){
                    StringBuffer sb  = new StringBuffer();
                    String s= strStack.pop();
                    int num = numSatck.pop();
                    for(int k = 0;k<num;k++){
                        sb.append(s);
                    }
                    int t =j+1;
                    if(t<len){
                        while (string.charAt(t)<='z' && string.charAt(t)>='a'){
                            t++;
                        }
                        sb.append(string.substring(j+1,t));
                    }
                    if(strStack.isEmpty()){
                        strStack.push(sb.toString());
                    }else {
                        strStack.push(strStack.pop()+sb.toString());
                    }

                    if(numSatck.isEmpty()){
                        System.out.println(strStack);
                    }
                    j = t-1;
                }else if(string.charAt(j)>='0' && string.charAt(j)<='9'){
                    int m = j+1;
                    while (string.charAt(m)>='0' && string.charAt(m)<='9'){
                        m++;
                    }
                    numSatck.push(Integer.parseInt(string.substring(j,m)));
                    int k =m+1;
                    while (string.charAt(k)!=']' && !(string.charAt(k)>='0' && string.charAt(k)<='9')){
                        k++;
                    }
                    j = k-1;
                    strStack.push(string.substring(m+1,k));
                }else {

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
