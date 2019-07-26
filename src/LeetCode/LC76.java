package LeetCode;

import java.util.*;

public class LC76 {
    public static String minWindow(String s, String t) {
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();
        if(s.length()<t.length())return ""; // s<t

        Map<Character,Integer> mapT = new HashMap<>();
        mapT = countNums(T,0,T.length-1);
        int left = 0,right =0,ans=S.length,ansLeft =-1,ansRight=-1;
        Map<Character,Integer> tmpMap = countNums(S,left,right);
        while (left<S.length){
            if(isMatch(mapT,tmpMap)){
                if((right-left)<ans){
                    ans = right-left;
                    ansLeft = left;
                    ansRight = right;
                }
                char c =S[left];//将左边的删除
                left++;
                if(tmpMap.get(c)>1){
                    int tmp = tmpMap.get(c);
                    tmpMap.put(c,--tmp);
                }else {
                    tmpMap.remove(c);
                }
            }else {
                if(right<S.length-1) {
                    right++;
                    char c = S[right];//将右边的添加
                    if(tmpMap.containsKey(c)){
                        int tmp = tmpMap.get(c);
                        tmpMap.put(c,++tmp);
                    }else {
                        tmpMap.put(c,1);
                    }

                }else {
                    if(!isMatch(mapT,tmpMap)){
                        break;
                    }
                }
            }
        }
        if(ansLeft!= -1 && ansRight!=-1){
            return new String(Arrays.copyOfRange(S,ansLeft,ansRight+1));
        }else return "";
    }
    public static Map<Character,Integer> countNums(char[] nums, int begin,int end){
        Map<Character,Integer> map = new HashMap<>();
        for(int i =begin;i<=end;i++){
            if(map.containsKey(nums[i])){
                int tmp = map.get(nums[i]);
                map.put(nums[i],++tmp);
            }
            else{
                map.put(nums[i],1);
            }
        }
        return map;
    }
    public static boolean isMatch(Map<Character,Integer> mapT, Map<Character,Integer> mapS){
        boolean flag = true;
        for(char ele:mapT.keySet()){
            if(mapS.containsKey(ele) && mapS.get(ele)>=mapT.get(ele)){
                flag =true;
            }else {
                flag = false;
                break;
            }
        }
        return flag;
    }
    public static void main(String[] args){
        String s = "ABC";
        String t = "CBA";
        String ss= minWindow(s,t);
    }


}
