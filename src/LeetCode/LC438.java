package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/19 15:24
 */
public class LC438 {
    public static void main(String[] args){
        String s = "cbaebabacd";
        String p = "abc";
        findAnagrams(s,p);
    }
    public static List<Integer> findAnagrams(String s, String p) {
        if(s.length()<=0 || p.length()<=0 || s.length()< p.length())return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int[] chars_s = new int[26];
        int[] chars_p = new int[26];
        for(int i=0;i<p.length();i++){
            chars_s[s.charAt(i)-'a'] ++;
            chars_p[p.charAt(i)-'a'] ++;
        }
        int i =0,j = p.length();
        while (j<s.length()){
            if(isSame(chars_s,chars_p)){
                ans.add(i);
            }
            chars_s[s.charAt(i++)-'a']--;
            chars_s[s.charAt(j++)-'a']++;
        }
        if(isSame(chars_s,chars_p)){
            ans.add(i);
        }
        return  ans;
    }
    public static boolean isSame(int[] chars_s,int[] chars_p){
        boolean flag =true;
        for(int i=0;i<26;i++){
            if(chars_s[i] != chars_p[i]){
                flag = false;
                break;
            }
        }
        return flag;
    }

}
