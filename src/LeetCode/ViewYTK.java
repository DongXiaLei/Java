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
            Stack<Character> stack = new Stack(); // 括号栈
            int j =0;boolean flag = false; //是否遇见括号
            while (j<len){
                List<Character> chars = new ArrayList<>();
                List<Character> num =new ArrayList<>() ;
                //遇到括号
                if(flag){
                    while (s[j]!=')'){
                        stack.push(s[j]);
                        j++;
                    }
                    while (stack.peek()!='('){
                        chars.add(stack.pop());
                    }
                    ++j;stack.pop();  // 跳过右括号和删除栈中的左括号
                    while (s[j]<='9' && s[j]>='0'){
                        num.add(s[j]);
                        j++;
                        if(j<len-1 && s[j]>='A' && s[j]<='Z'){
                            break;
                        }
                    }
                    if(stack.isEmpty()){
                        flag = false;
                        if(!chars.isEmpty() && !num.isEmpty()){ //如果第一层括号内输出
                            Stack<Character> ls = new Stack<>();
                            for(Character c:chars){
                                ls.push(c);
                            }
                            chars.clear();
                            while (!ls.isEmpty()){
                                chars.add(ls.pop());
                            }
                            unZipCore(chars,num);
                        }
                    }else {  //如果第二层括号内输出到栈
                        Stack<Character> ls = new Stack<>();
                        for(Character c:chars){
                            ls.push(c);
                        }
                        chars.clear();
                        while (!ls.isEmpty()){
                            chars.add(ls.pop());
                        }
                        int nums =0;
                        for(Character ele:num){
                            nums *= 10;
                            nums += ele-'0';
                        }
                        for(int t =0;t<nums;t++){
                            for(Character ele:chars){
                                stack.push(ele);
                            }
                        }
                    }
                }
                while (!flag && j<len){ //没遇到括号
                    if(s[j]>='A' && s[j]<='Z'){
                        if(j<len-1 && s[j+1]>='0' && s[j+1]<='9'){
                            chars.add(s[j]);
                        }else {
                            System.out.print(s[j]);
                        }
                        j++;
                    }
                    else if(s[j]>='0' && s[j]<='9'){
                        num.add(s[j]);
                        j++;
                        if(j<len-1 && s[j]>='A' && s[j]<='Z'){
                            break;
                        }
                    }else {
                        flag = true;
                        if(!chars.isEmpty() && !num.isEmpty()){
                            unZipCore(chars,num);
                        }
                        break;
                    }
                }
            }
            System.out.println();
        }
    }
    public static void unZipCore(List<Character> chars,List<Character> num){ // ad 3 相当于 adadad
        int nums =0;
        for(Character ele:num){
            nums *= 10;
            nums += ele-'0';
        }
        for(int i =0;i<nums;i++){
            for(Character ele:chars){
                System.out.print(ele);
            }
        }
    }
}
/*
* 6
A11B
AA12(BCD)12DF
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