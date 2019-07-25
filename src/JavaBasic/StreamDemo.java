package JavaBasic;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/18 15:05
 */
public class StreamDemo {
    public static void main(String[] args) throws IOException 
    {
        String string = new String(Files.readAllBytes( Paths.get("C:\\Users\\LEE\\Desktop\\OfferDays\\stream.txt")) , StandardCharsets.UTF_8 );
        List<String> list = Arrays.asList(string.split("\\PL+"));
        String[] content ={"dong","xia","lei","is","ha"};
        List<String> l = Arrays.asList(content);

        Stream s = Arrays.stream(content);  // 1
        Stream<String > stream = list.stream().filter(ele->ele.length()>3); // 2
        long count = stream.count();
        System.out.println(count);

        Stream<String> stream1 = list.parallelStream().filter(ele->ele.length()>3);  // 3
        long count1 =stream1 .count();
        System.out.println(count1);

        Stream<String > stream2 = Stream.of(content); // 4

        Stream <String> echo = Stream.generate(()->"Echo");  //5   无穷常量流
        Stream <Double> randoms = Stream.generate(Math::random);
        System.out.println(echo.count());


    }
}
