package JavaBasic;

import java.util.*;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/13 18:29
 */


public class priorityQueuecDemo {
    public static void main(String[] args) {
        //红黑树实现
        TreeSet<String> ts = new TreeSet<>();
        ts.add("bbbb");ts.add("cccc");ts.add("aaa");
        ts.add("ttt");ts.add("fff");ts.add("ggg");
        Iterator itre = ts.iterator();
        itre.forEachRemaining(ele -> System.out.println(ele));

        /**
         *
         * @author Xialei Dong
         * Priority Queue
         * 通过最小堆实现，具体说是通过完全二叉树（complete binary tree）实现的小顶堆
         * （任意一个非叶子节点的权值，都不大于其左右子节点的权值），
         * 也就意味着可以通过数组来作为 PriorityQueue 的底层实现。
         * @date 2019/7/13 19:10
         */
        /*
        * class COMparetor implement  Comparator<String>{
        *       public int compare(String o1, String o2){
        *   }
        * }
        * COMparetor comparatorString = new COMparetor();
        * */
        Comparator<String> comparatorString = new Comparator<String>()
        {                                       //匿名内部类
            //小根堆
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
                return o1.charAt(i)-o2.charAt(i);
            }
        };
        PriorityQueue<String> pq = new PriorityQueue<>(comparatorString);
        pq.add("bbbb");pq.add("ccccc");pq.add("aaa");
        pq.add("ttt");pq.add("fff");pq.add("ggg");
        Iterator itre2 = pq.iterator();
        itre2.forEachRemaining(ele -> System.out.println(ele));

        String string = "12334";
        System.out.println(string.compareTo("242"));

        Comparator<Integer> comparatorInteger = new Comparator<Integer>() { //大根堆
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        };
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(comparatorInteger);
        pq2.add(2);pq2.add(3);pq2.add(1);
        pq2.add(8);pq2.add(5);pq2.add(6);
        Iterator itre3 = pq2.iterator();
        itre3.forEachRemaining(ele -> System.out.println(ele));

        Queue<Integer> queue1 = new PriorityQueue<Integer>();
        queue1.add(2);
        queue1.add(3);
        queue1.add(1);
        queue1.add(8);
        queue1.add(5);
        queue1.add(6);

        while (!queue1.isEmpty()) {
            Integer i = queue1.poll();
            System.out.println(i);
        }

        Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (o1.id - o2.id);
            }
        };
        Queue<Student> queue2 = new PriorityQueue<Student>(comparator);
        queue2.add(new Student(2, "B"));
        queue2.add(new Student(1, "A"));
        queue2.add(new Student(3, "C"));

        while (!queue2.isEmpty()) {
            Student s = queue2.poll();
            System.out.println(s.toString());
        }

    }
    public static class Student {
        private int id;
        private String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }
        public String toString() {
            return id + "-" + name;
        }
    }
}
