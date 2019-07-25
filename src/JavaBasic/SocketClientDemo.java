package JavaBasic;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/18 18:46
 */
public class SocketClientDemo {
    public static void main(String[] args) throws IOException
    {
        if(args.length>0){
            String host = args[0];
            InetAddress address = InetAddress.getByName(host);
        }
        try(
                Socket socket = new Socket("time-a.nist.gov",13);
                Scanner in = new Scanner(socket.getInputStream(),"UTF-8");
                ){
           while (in.hasNextLine()){
               String line = in.nextLine();
               System.out.println(line);
           }

        }
        Socket socket = new Socket();
        socket.setSoTimeout(10000);

        InetAddress address = InetAddress.getByName("time-a.nist.gov");
        InetAddress[] addresses = InetAddress.getAllByName("google.com");
        InetAddress localaddress = InetAddress.getLocalHost();
        String host  = localaddress.getHostName();  //name 域名   address IP地址
        byte[] bytes = address.getAddress();

        socket.connect(new InetSocketAddress(localaddress,8189),10000);
        if(socket.isConnected()){
            System.out.println("Connected!");
            try(Scanner in = new Scanner(System.in)){
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                PrintWriter out = new PrintWriter(outputStream,true);
                while(in.hasNextLine()){
                    String line = in.nextLine();
                    out.println(line);
                }
                Scanner scan = new Scanner(inputStream);
                while (scan.hasNextLine()){
                    System.out.println(scan.nextLine());
                }

            }

        }

    }
}
