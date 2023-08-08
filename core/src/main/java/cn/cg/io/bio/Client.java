package cn.cg.io.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author: cg
 * @date: 2023-08-08 15:22
 **/
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8080);

        OutputStream outputStream = socket.getOutputStream();
        //把字节输出流包装成一个打印流
        PrintStream ps = new PrintStream(new PrintStream(outputStream));
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入需要发送的消息");
            String msg = sc.nextLine();
            ps.println(msg);
            ps.flush();
        }
    }
}
