package JavaBasic;

public class TestFinal {
        public static void main(String[] args) {
            /*
             * final 修饰的基本数据类型 不能改变值
             * 修饰的引用数据类型 不能修改引用地址
             * */
            //局部变量是基本数据类型
            int x = 10;
            x = 100;
            System.out.println(x);
            final int y = 10;
            //无法为最终变量y分配值
            //y = 100;
            System.out.println(y);
            System.out.println("--------------");

            //局部变量是引用数据类型
            Student s = new Student();
            System.out.println(s.age);
            s.age = 100;
            System.out.println(s.age);
            System.out.println("--------------");

            final Student ss = new Student();
            System.out.println(ss.age);
            ss.age = 100;
            System.out.println(ss.age);

            //重新分配内存空间
            //无法为最终变量ss分配值
            //ss = new Student();
        }

}
class Student {
    int age = 10;
}
