package JavaBasic;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/18 11:49
 */
public class RandomDemo {
    public static void main(String[] args){
        System.out.println(new Date().toString());
        System.out.println(LocalDate.now());
        double f = Math.random(); //0-1之间的浮点数
        Random random = new Random();
        int ran = random.nextInt(100);//0-99之前的数
        Integer n = Integer.valueOf("12");
        int nn = Integer.parseInt("12");
        System.out.println();
    }
}
