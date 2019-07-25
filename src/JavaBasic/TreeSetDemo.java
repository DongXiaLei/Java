package JavaBasic;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/13 18:38
 */

class TreeSetDemo1 {
    public static void main(String[] args) {

        /*
         * TreeSet类，底层用二叉树的数据结构
         * 集合中以有序的方式插入和抽取元素。
         * 添加到TreeSet中的元素必须是可以排序的
         *             保证数据的唯一性：
         *             第一种：让添加的类自身具有可比较性，
         *                     实现Comparable接口中的CompareTo()方法
         *              第二种：当元素自身不具备可比较性时，
         *                     或者具备的比较是不需要的，
         *                     此时，可以自定义一个比较器（类）
         *                     此类实现Comparator中的CompareTo()方法
         *                     最后在实例化TreeSet时传参数比较器类
         */
        TreeSet ts = new TreeSet();
        ts.add(new Wimen("xiaobai", 10));
        ts.add(new Wimen("xiaobai1", 14));
        ts.add(new Wimen("xiaobai2", 5));
        ts.add(new Wimen("xiaobai2", 5));
        ts.add(new Wimen("xiaobai3", 34));

        Iterator<Wimen> it = ts.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

}
/*
 *   添加类中实现Comparable方法中CompareTo()方法
 *   按对象的年龄进行排序存储，并把相同的属性的对象剔除
 */

class  Wimen implements Comparable{
    private String name;
    private int age;

    public Wimen(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Wimen [age=" + age + ", name=" + name + "]";
    }
    @Override
    public int compareTo(Object o) {
        if (!(o  instanceof  Wimen)) {
            throw new ClassCastException("对象不匹配！！1");
        }
        Wimen  wimen = (Wimen) o;
        if (this.age > wimen.age) {
            return 1;
        }
        if (this.age==wimen.age ) {
            return this.name.compareTo(wimen.name);
        }
        return -1;  // 1： 正序  0： 只存放第一个元素   -1： 倒序
    }



}

class TreeSetDemo {
    public static void main(String[] args) {


        TreeSet ts = new TreeSet(comparator); //自定义比较器
        ts.add(new Wimen2("xiaobai", 10));
        ts.add(new Wimen2("xiaobai1", 14));
        ts.add(new Wimen2("xiaobai1", 14));//除去重复的，按年龄大小存储
        ts.add(new Wimen2("xiaobai2", 5));
        ts.add(new Wimen2("xiaobai3", 34));

        Iterator<Wimen> it = ts.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
    public static Comparator<Wimen2> comparator = new Comparator<Wimen2>() {  //定义比较器
        @Override
        public int compare(Wimen2 o1, Wimen2 o2) {
            Wimen2 w1 = (Wimen2)o1;
            Wimen2 w2 = (Wimen2)o2;
            if (w1.getAge()>w2.getAge()) {
                return 1;
            }
            if (w1.getAge()==w2.getAge()) {
                return w1.getName().compareTo(w2.getName());
            }
            return -1;
        }
    };
}

class  Wimen2{
    private String name;
    private int age;

    public Wimen2(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Wimen2 [age=" + age + ", name=" + name + "]";
    }

}