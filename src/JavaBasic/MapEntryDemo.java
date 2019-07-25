package JavaBasic;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/13 20:59
 */

import java.util.*;

/**
 * Map是java中的接口，Map.Entry是Map的一个内部接口。
 * Map提供了一些常用方法，如keySet()、entrySet()等方法，keySet()方法返回值是Map中key值的集合；
 * entrySet()的返回值也是返回一个Set集合，此集合的类型为Map.Entry。
 * Map.Entry是Map声明的一个内部接口，此接口为泛型，定义为Entry<K,V>。它表示Map中的一个实体（一个key-value对）。
 * 接口中有getKey(),getValue方法。
 */
public class MapEntryDemo {
    public static void main(String[] args){

        Map<String, String> map = new TreeMap<>();

        map.put("ddd", "444");
        map.put("ccc", "333");
        map.put("bbb", "222");
        map.put("aaa", "111");

        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> each : entrySet) {
            System.out.println(each.getKey()+"::"+each.getValue());
        }


        //第一种：普遍使用，二次取值
        /**
         * Map中取得关键字之后，我们必须每次重复get(i)返回到Map中取得相对的值，这是很繁琐和费时的
         */
        System.out.println("通过Map.keySet遍历key和value：");
        for (String key : map.keySet()) {
            System.out.println("key= "+ key + " and value= " + map.get(key));
        }

        //第二种
        /**
         * Map类提供了一个称为entrySet()的方法，这个方法返回一个Map.Entry实例化后的对象集。
         * 接着，Map.Entry类提供了一个getKey()方法和一个getValue()方法
         */
        System.out.println("通过Map.entrySet使用iterator遍历key和value：");
        Set<Map.Entry<String, String>> mapEntry = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = mapEntry.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        //第三种：推荐，尤其是容量大时
        System.out.println("通过Map.entrySet遍历key和value");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        //第四种
        System.out.println("通过Map.values()遍历所有的value，但不能遍历key");
        for (String v : map.values()) {
            System.out.println("value= " + v);
        }
    }


}
