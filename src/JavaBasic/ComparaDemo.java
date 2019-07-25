package JavaBasic;

import java.util.*;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/18 11:49
 */
public class ComparaDemo {
    public static void main(String [] args){
        /*
         * 两种方法
         * 第一：新类实现Comparable接口里面的 compareTo（）
         * 第二：定义比较器 实现Comparator接口的compare方法 匿名内部类的方法
         *       如下 相当于lambad式相当于compare函数
         * */
        Comparator<String> comparator = (o1, o2)-> { return o2.compareTo(o1); };
        Comparator<node> comparator1 = new Comparator<node>() {
            @Override          //字典序排列
            public int compare(node o1, node o2) {
                return o1.name.compareTo(o2.name);
            }
        };
        Comparator<node> comparator2 = (o1, o2)->{return o1.name.compareTo(o2.name);};

        Set<node> set = new TreeSet<node>();
        set.add(new node("Bob"));
        set.add(new node("Alice"));
        set.add(new node("Dave"));
        set.add(new node("Candy"));
        set.add(new node("Candy"));
        Iterator iterator = set.iterator();
        set.forEach(ele->System.out.println(ele.toString()));
        iterator.forEachRemaining(ele->System.out.println(ele.toString()));

        node[] nodes = {new node("dong "),new node("xia"),new node("lei")};
        Arrays.sort(nodes);
        for(node n:nodes){
            System.out.println(n.toString());
        }

        String [] strings = {"111","222","444","222","666"};
        Arrays.sort(strings,new ComparatorString());
        for (String string:strings) {
            System.out.println(string);
        }
    }

}
class node implements Comparable<node>,Iterable<node>{  //Comparable<node> 后边直接可用 这样写是为了接口后边好继承
    public String name;
    public node newroot;
    public node(String name){
        this.name = name ;
    }
    @Override
    public int compareTo(node arg){
        // TODO Auto-generated method stub  //逆字典序排列
        node n = (node) arg;
        return n.name.compareTo(this.name);
    }
    public Iterator<node> iterator() {
        //定义实现了Iterator的内部类
        class iter implements Iterator<node>
        {

            @Override
            public boolean hasNext() {
                // 判断当前指针是否小于实际大小
                if(name!=null){
                    return true;
                }
                return false;
            }

            @Override
            public node next() {
                // 返回当前元素，并把当前下标前移
                return newroot;
            }

            @Override
            public void remove() {
                // TODO Auto-generated method stub

            }
        }
        // 返回自定义的Iteraror子类
        return new iter();
    }
    public String toString(){
        return this.name;
    }
}
class ComparatorString implements Comparator<String>{
    String name ;
    public ComparatorString(){}
    public ComparatorString(String name){
        this.name = name;
    }
    public int compare(String s1,String s2){
        return s2.compareTo(s1);
    }

}
