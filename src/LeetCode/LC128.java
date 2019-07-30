package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/27 20:04
 */
public class LC128 {
    public static void main(String[] args){

    }
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set =new HashSet<>();
        for(int ele:nums){
            set.add(ele);
        }
        int ans = 0;
        for(int ele :nums){
            if(!set.contains(ele-1)){
                int tmpAns = 1;
                int tmpNum = ele;
                while (set.contains(tmpNum+1)){
                    tmpNum += 1;
                    tmpAns += 1;
                }
                if(tmpAns>ans) ans =tmpAns;
            }
        }
        return ans;
    }
}
