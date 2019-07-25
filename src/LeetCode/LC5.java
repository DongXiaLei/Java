package LeetCode;

import java.util.Arrays;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/16 14:38
 */
public class LC5 {
    public static String longestPalindrome(String s) {
        if(s.length()==0)return "";
        if(s.length()==1)return s;
        char[] chars = s.toCharArray();
        int ansBegin=0,ansEnd=0;
        boolean flag =true;
        for(int i=0;i<s.length();i++){
            for(int j=0;j<=i;j++){
                if(i+j<s.length() && chars[i-j] == chars[i+j]){
                    if(2*j>ansEnd-ansBegin){
                        ansBegin = i-j ;
                        ansEnd = i+j ;
                    }
                }
                else {
                    break;
                }
            }
        }
        for(int i=0;i<s.length();i++){
            for(int j=1;j<=i;j++){
               if(i+j-1<s.length() && chars[i-j] == chars[i+j-1]){
                    if(2*j-1>ansEnd-ansBegin){
                        ansBegin = i-j ;
                        ansEnd = i+j-1 ;
                    }
                }
                else {
                    break;
                }
            }
        }
        String  ans = new String(Arrays.copyOfRange(chars,ansBegin,ansEnd+1));
        System.out.println(ans);
        return ans;
    }
    public static void main(String[] args){
        String s = "cdddadddc";
        longestPalindrome(s);
    }

}
