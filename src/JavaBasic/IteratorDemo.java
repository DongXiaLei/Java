package JavaBasic;



import java.util.*;
import java.util.Iterator;
public class IteratorDemo {
    public static void main(String[] args){
        String [] strings = {"dong","xia","lei","love","ziji"};
        String [] sre = strings.clone();
        List<Integer> ls = new LinkedList<>();
        ls.add(1);ls.add(2);ls.add(3);
        ls.add(1);ls.add(2);ls.add(3);
        //ls.removeIf(ele->ele>2); //删除大于2的元素
        Iterator iterable = ls.listIterator();
        ListIterator iterable2 = ls.listIterator(); // LinkedList ls.listIterator(i)返回迭代器 链表遍历和查找用迭代器尽量不用get(i)
        //iterable.next(); //再删除之前必须跳过        ArrayList 一般用get 和 set
        //iterable.remove();
        iterable2.next();
        iterable2.set(3);
        ls.iterator().forEachRemaining(ele->System.out.println(ele));
        if(sre instanceof String[])
            return;
        if(ls instanceof RandomAccess){
            //检验ls是否支持高效的随机访问
        }
        Collection<Integer> collection = new ArrayList<>();
        Iterator in = collection.iterator();
        //Iterable是一个接口 String 和int double等基本类型实现
            //主要用于for(T ele : eles)循环
        //Iterator 接口是每个集合类都实现的接口
        //     所以 都有 List queue 等 都有方法 next hasnext remove forEachRemaining四个方法

        MyIterator test = new MyIterator();
        Iterator<String> it = test.iterator();

        while(it.hasNext()) {
            System.out.println(it.next());
        }
        //增强for，必须实现Iteralbe接口
        //不考虑下标
        for(String temp:test) {
            System.out.println(temp);
        }
    }
}
class MyIterator implements Iterable<String> {

    private String[] element = {"a","b","c","d","e"};

    private int size = element.length;

    //匿名内部类
    public Iterator<String> iterator(){
        return new Iterator<String>(){
            //游标指针
            private int cursor = -1;

            /**
             * 判断是否存在下一个元素
             * @return
             */
            public boolean hasNext() {
                return cursor+1 < size;
            }

            /**
             * 获取下一个元素
             * @param
             */
            public String next() {
                cursor++;
                return element[cursor];
            }

            /**
             * 删除元素
             * @param
             */
            public void remove() {

            }
        };
    }
}

