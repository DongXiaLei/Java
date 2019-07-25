package Offer66;

import java.util.HashMap;
import java.util.Map;

public class Problem50 {
    public static void main(String[] args) {
        System.out.println("Problem 49");
        String string  ="dongxileidongxileityuiop"  ;
        Character cha = string.charAt(firstChar5Repeating(string));
        System.out.println(cha);
    }
    public static int firstChar5Repeating(String string){
        if(string.length()==0)
            return -1;
        Map<Character,Integer> map = new HashMap();
        int ans = -1 ;
        for(int i=0;i<string.length();i++){
            if(map.get(string.charAt(i))==null){
                map.put(string.charAt(i),1);
            }else {
                Integer tmp = map.get(string.charAt(i));
                map.put(string.charAt(i),++tmp);
            }
        }
        for(int i=0;i<string.length();i++){
            if(map.get(string.charAt(i))==1){
                ans = i;
                break;
            }
        }
        return ans;
    }
    public static  int firstChar5Repeating2(String string){
        if(string.length()==0)
            return -1;
        Map<Character,Integer> map = new HashMap();
        int ans = -1;
        for(int i=0;i<string.length();i++){
            if(map.get(string.charAt(i))==null){
                map.put(string.charAt(i),1);
            }else {
                Integer tmp = map.get(string.charAt(i));
                map.put(string.charAt(i),++tmp);
            }
            for(int j=0;j<i;j++){
                if(map.get(string.charAt(j))==1){
                    ans = j;
                }
            }
        }

        return ans;
    }
}
/*
* Map的一般用法
1.声明一个Map :
Map map = new HashMap();
2 .向map中放值 ，注意： map是key-value的形式存放的，如：
map.put("sa","dd");
3 .从map中取值 :
String str = map.get("sa").toString,
结果是： str = "dd'
4 .遍历一个map,从中取得key和value :
Map m= new HashMap();
for(Object obj : map.keySet()){
Object value = map.get(obj );
}
*
* */