package JavaBasic;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/18 19:14
 */
public class SocketServerDemo {
    public static void main(String[] args) throws IOException
    {
        try(ServerSocket s = new ServerSocket(8189)){
            try(Socket incoming = s.accept()){
                InputStream inputStream = incoming.getInputStream();
                OutputStream outputStream = incoming.getOutputStream();
                try(Scanner in = new Scanner(inputStream)){
                    PrintWriter out = new PrintWriter(outputStream,true);
                    Scanner scan = new Scanner(System.in);
                    while (scan.hasNextLine()){
                        out.println(scan.nextLine());
                    }

                    while (in.hasNextLine()){
                        String line = in.nextLine();
                        out.println(line);
                        System.out.println(line);
                    }
                }

            }
        }
    }
}
