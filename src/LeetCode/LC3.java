package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/16 9:53
 */
public class LC3 {
    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==1)return 1;
        char[] chars = s.toCharArray();
        int i=0,j=1;
        Set<Character> set = new HashSet<>();
        set.add(chars[0]);
        int ans=1;
        while (j<chars.length && i<chars.length){
            if(!set.contains(chars[j])){
                set.add(chars[j]);
                j++;
            }else {
                int t = s.indexOf(chars[j],i)+1;
                char[] ch = Arrays.copyOfRange(chars,i,t);
                for(char ele :ch)
                    set.remove(ele);
                i =t;
            }
            if(ans<set.size())ans = set.size();
        }
        return ans;
    }
    public static void main(String[] args){
        String s= "aabaab!bb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
