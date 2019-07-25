package JavaBasic;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/18 20:16
 */
public class URLDemo {
    public static void main(String[] args){
        String localhost = "http://210.42.121.132/";
        try{
            URL url = new URL(localhost);
            URLConnection connection = url.openConnection();

            connection.connect();
            Map<String, List<String>> header = connection.getHeaderFields();
            header.forEach((K,V)->System.out.println(K+" "+V));




        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
