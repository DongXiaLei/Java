package JavaBasic;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.*;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/17 20:49
 */
public class ReflectDemo {
    public static void main(String [] args){
        Object obj =new BigInteger("12345");
        Class clas = obj.getClass();
        Field [] fields = clas.getFields();
        Constructor[] constructors = clas.getConstructors();
        Method[] methods = clas.getDeclaredMethods();
        Runnable run = new Runnable() {
            @Override
            public void run() {
                for(Field m :fields){
                    System.out.println(m);
                }
            }
        };
        run.run();
        Runnable run2 = ()->{
            for(Method m :methods){
                System.out.println(m);
            }
        };
        run2.run();

        int x =0 ;
        assert x>0;  //默认情况下关闭
        System.out.println(x);
    }
}
