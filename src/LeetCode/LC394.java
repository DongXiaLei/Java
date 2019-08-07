package LeetCode;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/4 15:53
 */
public class LC394 {
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        System.out.println(decodeString(s));
    }
    public static String decodeString(String s) {
        String res = "";
        Stack <Integer> nums  = new Stack<>();
        Stack <String> strs = new Stack<>();
        int num = 0;
        int len = s.length();
        for(int i = 0; i < len; ++ i)
        {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9')
            {
                num = num * 10 + s.charAt(i) - '0';
            }
            else if((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') ||(s.charAt(i) >= 'A' &&s.charAt(i) <= 'Z'))
            {
                res = res + s.charAt(i);
            }
            else if(s.charAt(i) == '[') //将‘[’前的数字压入nums栈内， 字母字符串压入strs栈内
            {
                nums.push(num);
                num = 0;
                strs.push(res);
                res = "";
            }
            else //遇到‘]’时，操作与之相配的‘[’之间的字符，使用分配律
            {
                int times = nums.peek();
                nums.pop();
                for(int j = 0; j < times; ++ j)
                    strs.push(strs.peek()+res);
                res = strs.peek(); //之后若还是字母，就会直接加到res之后，因为它们是同一级的运算
                //若是左括号，res会被压入strs栈，作为上一层的运算
                strs.pop();
            }
        }
        return res;
    }

}


/*
3[a2[c]]
3[a]2[bc]
2[abc]3[cd]ef
/*

public static String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        String tempStr = null;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (s.charAt(i) == ']') {
                String str = strStack.pop();
                int num = numStack.pop();
                String nowStr = repeatStr(str, num);
                if (!numStack.isEmpty()) {
                    StringBuilder  builder = new StringBuilder();
                    builder.append(strStack.peek());
                    builder.append(nowStr);
                    int m = i + 1;//2[3[ad]aaa]
                    while (s.charAt(m) != ']' && !('0' < s.charAt(m) && '9' >= s.charAt(m))) {
                        m++;
                    }
                    builder.append(s.substring(i + 1, m));
                    strStack.set(strStack.size() - 1, builder.toString()); // 将字符串顶字符串设置
                    i = m - 1;
                } else {
                    tempStr = null;
                    res.append(nowStr);
                }
            }else if(ch<='9' && ch>='0'){
                int m = i +1 ;
                while (s.charAt(m)<='9' && s.charAt(m)>='0'){
                    m++;
                }
                numStack.push(Integer.parseInt(s.substring(i,m)));
                i = m-1;
                int k = i+2;
                while (s.charAt(k)!=']' &&!(s.charAt(k)<='9' && s.charAt(k)>='0')){
                    k++;
                }
                strStack.push(s.substring(i+2,k));
                i = k -1 ;
            }else if(numStack.isEmpty()){
                res.append(s.charAt(i));
            }
        }

        return res.toString();
    }

    private static String repeatStr(String str, int num) {
        StringBuilder sb = new StringBuilder();
        if (num <= 0) {
            return "";
        }
        for (int i = 0; i < num; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
 */
