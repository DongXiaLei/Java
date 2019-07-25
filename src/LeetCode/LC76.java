package LeetCode;

import java.util.*;

public class LC76 {
    public static String minWindow(String s, String t) {
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();
        Map<Character, Queue<Integer>> map = new HashMap<>();
        for(int i = 0;i<S.length;i++){
            for(int j =0 ;j<T.length;j++){
                if(S[i] == T[j]){
                    if(map.containsKey(T[j])){
                        map.get(T[j]).add(i);
                    }else {
                        Queue<Integer> queuenew = new LinkedList<>();
                        queuenew.add(i);
                        map.put(T[j],queuenew);
                    }
                    break;
                }
            }
        }
        int ans = S.length,ansmin =0 ,ansmax =0 ,minIndex = S.length,maxIndex =-1,delIndex =0;
        while (true){
            minIndex = S.length;maxIndex =-1;
            for(int i =0;i<T.length;i++){
                Queue<Integer> queue = map.get(T[i]);
                if(queue!=null && queue.peek()<minIndex) {
                    minIndex = queue.peek();
                    delIndex = i;
                }
                if(queue!=null && queue.peek()>maxIndex) maxIndex = queue.peek();

            }
            if((maxIndex-minIndex)<ans) {
                ans =maxIndex -minIndex;
                ansmin = minIndex;
                ansmax = maxIndex;
            }
            map.get(T[delIndex]).poll();
            break;
        }

        return null;
    }
    public static void main(String[] args){
        String s = "ADOBECODEBANC";
        String t = "ABC";
        minWindow(s,t);
    }


}
