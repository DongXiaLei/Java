import java.lang.reflect.Method;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Logger;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/16 21:13
 */
/**
 *
 *
 * */
public class test {
    public static void main(String[] args){
        if(args.length>0)
        Logger.getGlobal();
        ArrayBlockingQueue abq = new ArrayBlockingQueue(14);
        int [] arrays = {1,2,3,4,4};
        //arrays.notify();
        List<Integer> ls = new ArrayList<>();
        List<Integer> synls = Collections.synchronizedList(new ArrayList<>());  //线程安全
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.valueOf(1);
        BigInteger c = a.add(b);
        String s = Arrays.toString(arrays);
        String ss= new String();
        System.out.println(s);
        System.out.println(new Date().toString());
        System.out.println(LocalDate.now());
        double f = Math.random(); //0-1之间的浮点数
        Random  random = new Random();
        int ran = random.nextInt(100);//0-99之前的数
        Integer n = Integer.valueOf("12");
        int nn = Integer.parseInt("12");
        System.out.println();
        Object obj =new Object();
        Class clas = obj.getClass();
        Method[] methods = clas.getMethods();
        Runnable run = ()->{
            for(Method m :methods){
                System.out.println(m);
            }
        };
        run.run();

        int x =0 ;
        assert x>0;
        System.out.println(x);
        List list = new LinkedList();
        ListIterator listterator= list.listIterator();
        Class cla = listterator.getClass();
        Method[] methods1 = cla.getMethods();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for(Method method:methods1){
                    System.out.println(method);
                }
            }
        };
        r.run();

        /*
        * 两种方法
        * 第一：新类实现Comparable接口里面的 compareTo（）
        * 第二：定义比较器 实现Comparator接口的compare方法 匿名内部类的方法
        *       如下 相当于lambad式相当于compare函数
        * */
        Comparator<String> comparator = (o1,o2)-> { return o2.compareTo(o1); };
        Comparator<node> comparator1 = new Comparator<node>() {
            @Override          //字典序排列
            public int compare(node o1, node o2) {
                return o1.name.compareTo(o2.name);
            }
        };
        Comparator<node> comparator2 = (o1,o2)->{return o1.name.compareTo(o2.name);};

        Set<node> set = new TreeSet<node>();
        set.add(new node("Bob"));
        set.add(new node("Alice"));
        set.add(new node("Dave"));
        set.add(new node("Candy"));
        set.add(new node("Candy"));
        Iterator iterator = set.iterator();
        set.forEach(ele->System.out.println(ele.toString()));
        iterator.forEachRemaining(ele->System.out.println(ele.toString()));


        String [] strings = {"111","222","444","222","666"};
        Arrays.sort(strings,new ComparatorString());
        for (String string:strings) {
            System.out.println(string);
        }
    }
}
class node implements Comparable{  //Comparable<node> 后边直接可用 这样写是为了接口后边好继承
    public String name;
    public node(String name){
        this.name = name ;
    }
    @Override
    public int compareTo(Object arg){
        // TODO Auto-generated method stub  //逆字典序排列
        node n = (node) arg;
        return n.name.compareTo(this.name);
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
