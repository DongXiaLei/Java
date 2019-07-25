package JavaBasic;


import java.util.*;

public class MapDemo {
    public static void main(String[] args){
        for(double i =1;i!=10;i+=0.5)
            System.out.println(i); //不会终止循环 0.1无法精确地 用浮点数表示 二进制浮点数1/2 1/4 1/8...等
        /**
         *
         * @author Xialei Dong
         *红黑树在操作时，无法保证每次操作完成之后都是一棵平衡的二叉树
         * String 比较器
         * @date 2019/7/13 19:37
         */
        Comparator<String> comparatorString = new Comparator<String>() { //大根堆
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()<=0||o2.length()<=0)return -1;
                int i =0;
                while (o1.charAt(i)==o2.charAt(i)){
                    if(o1.length()-1>i&&o2.length()-1>i){
                        i++;
                    }else {
                        break;
                    }
                }
                return o2.charAt(i)-o1.charAt(i);
            }
        };

        Map<String ,Integer > map = new HashMap();
        Map map1 = new HashMap(32);
        Map map2 = new HashMap(32,0.8f);
        map.put("dong",100);
        map.put("xia",90);
        map.put("lei",80);
        map.put("shuai",70);
        map.forEach((K,V)->System.out.println(K+" "+V));

        Map<String ,Integer > mapp = new TreeMap();
        Map mapp1 = new TreeMap(comparatorString);
        mapp1.put("dong",100);
        mapp1.put("xia",90);
        mapp1.put("lei",80);
        mapp1.put("shuai",70);
        mapp1.forEach((K,V)->System.out.println(K+" "+V));

        Set set = mapp1.keySet();
        Collection set1 = mapp1.values();
        Set<Map.Entry> set3 = mapp1.entrySet();
        Map.Entry entry = new Map.Entry() {
            @Override
            public Object getKey() {
                return null;
            }

            @Override
            public Object getValue() {
                return null;
            }

            @Override
            public Object setValue(Object value) {
                return null;
            }
        };





        String str1 = "abefcdgiescdfimde";
        String str2 =  "ab*cd?i*de";
        System.out.println(isMatch(str1,str2));
    }
    /**
     *
     * @author Xialei Dong
     * 对于两个字符串 只有第二个 有？*号
     * 其中*好可以匹配任意多个字符
     * ？号只能匹配任意一个字符
     * 求两个字符串能不能完全匹配
     *
     * @date 2019/7/13 19:27
     */


    public static boolean isMatch(String str1,String str2){
        if(str1.length()==0 || str2.length()==0)return false;
        int len1 = str1.length();
        int len2 = str2.length();
        return isMatch(str1.toCharArray(),0,str2.toCharArray(),0);
    }
    public static boolean isMatch(char[] str1,int begin1 ,char[] str2 ,int begin2){
        int i = begin1,j = begin2;
        for(;i<str1.length && j<str2.length; i++,j++){
            if(j == str2.length-1){
                if(str2[j]=='*'||str1[i] == str2[j] && i == str1.length-1)
                    return true;
                else return false;
            }
            if(str2[j]=='?'||str1[i]==str2[j]){
                continue;
            }
            else {
                if(str2[j]!='*')
                    return false;
                else break;
            }
        }
        char ch;
        if(j+1>str2.length-1 && i!=str1.length)
            return true;
        else {
            ch = str2[j+1];
        }

        boolean flag =false;
        for(int k = i;k<str1.length;k++){
            if(str1[k] == ch){
                flag = flag||isMatch(str1,k,str2,j+1);
            }
        }
         return flag;
    }
}
