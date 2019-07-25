package JavaBasic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/20 16:25
 */
public class PatternDemo {
    public static void main(String[] args){
        String s1 = new String("qwer");
        String s2 = new String("qwer");
        if(s1==s2)System.out.println("s1==s2");
        if(s1.equals(s2))System.out.println("s1.equal(s2)");
        judgeIsHaveChinese("董nihao 夏磊");

    }
    public static void judgeIsHaveChinese(String string){
        String regEx = "[\u4e00-\u9fa5 ]";  //判断是否有中文字符
        if(string.length() == string.getBytes().length){
            System.out.println("没有汉字");
        }else {
            Pattern pattern = Pattern.compile(regEx);
            Matcher matcher = pattern.matcher(string);
            while (matcher.find()){
                System.out.print(matcher.group(0)+" ");
            }
        }
    }
}
