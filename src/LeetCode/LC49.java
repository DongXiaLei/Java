package LeetCode;

import java.util.*;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/22 17:06
 */
public class LC49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String ,List<String>> map = new HashMap<>();
        for(String s : strs){
            String value = new String(s);
            char [] ss = s.toCharArray();
            Arrays.sort(ss);
            String key = new String(ss);
            if(map.containsKey(key)){
                List list = map.get(key);
                list.add(value);
                map.put(key,list);
            }else {
                List<String> list = new ArrayList();
                list.add(value);
                map.put(key,list);
            }

        }
        map.forEach((K,V)->{ ans.add(V); });
        return ans;
    }
    public static void main(String[] args){
        String [] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strings);
    }
}
