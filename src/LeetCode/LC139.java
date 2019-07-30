package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/27 16:43
 */
public class LC139 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        if(s.length()<=0)return false;
        boolean [] ans = new boolean[s.length()];
        Set<String> set = new HashSet<>(wordDict);
         //List<String> ls = new ArrayList<>(set); //true
        for(int i = 0;i<s.length();i++){
            String tmp = s.substring(0,i+1);
            if(set.contains(tmp)){
                ans[i] = true;
            }else {
                ans[i] =false;
                for(int j =0;j<i ;j++){
                    if(ans[j] == true){
                        String tmp2 = s.substring(j+1,i+1);
                        if(set.contains(tmp2)){
                            ans[i] = true;
                            break;
                        }
                    }
                }
            }
        }
        return ans[s.length()-1];
    }
    public static void main(String[]args){
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");wordDict.add("coe");
        wordBreak(s,wordDict);
    }
}
