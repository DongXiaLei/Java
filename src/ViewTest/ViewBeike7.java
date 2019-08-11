package ViewTest;

import java.util.Scanner;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/7 15:01
 */
/*
2
sequence subsequence
persion pressionpersion
* */
public class ViewBeike7 {
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[][] strings = new String[n][2];
        for(int i=0;i<n;i++){
            strings[i][0] = in.next();
            strings[i][1] = in.next();
        }
        for(int i=0;i<n;i++){
            String s = strings[i][0];
            String t = strings[i][1];

            System.out.println(compare(s,t));
            System.out.println(isSubSequence(s,t));
        }
    }
    public static boolean compare(String s,String t){
        int tlen = t.length();
        int slen = s.length();
        if(slen>tlen)return false;
        int i=0,j=0;
        while (i<slen && j<tlen){
            if(s.charAt(i) == t.charAt(j)){
                i++;j++;
            }else {
                j++;
            }
        }
        if(i==slen)return true;
        else return false;
    }
    public static boolean isSubSequence(String sub,String mString){
        //用来记录母序列游标移动到哪里了
        int ptr = 0;
        //外层循环遍历子序列
        for(int i = 0;i<sub.length();i++){
            char currentChar = sub.charAt(i);
            //判断游标已经出了母序列了，则代表不是其子序列
            if (ptr>=mString.length()){
                return false;
            }
            for (int j = ptr;j<mString.length();j++ ){
                //找到了一个子序列对应的字符了，游标继续移动
                if (currentChar==mString.charAt(j)){
                    ptr = j+1;
                    break;
                }
                //找到了最后一位了，却没有break，说明没有找到
                if (j==mString.length()-1){
                    return false;
                }
            }
        }
        return true;
    }

}
