package cn.cg.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: cg
 * @date: 2023-08-08 15:05
 **/
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            while (true) {
                //阻塞,一个线程->一个socket
                //jdk1.4使用accept()接收客户端,jdk1.7以后使用poll()等待/接收客户端
                Socket client = serverSocket.accept();
                System.out.println(String.format("接收到客户端连接------->address:%s,port:%s", client.getInetAddress().getHostAddress(), client.getPort()));
                Thread thread = new Thread(() -> {
                    try {
                        InputStream inputStream = client.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        while (true) {
                            //阻塞读,理论上一个线程占用8mb
                            String msg = bufferedReader.readLine();
                            if (msg != null || !"".equals(msg)) {
                                System.out.println(String.format("address:%s send msg:%s", client.getInetAddress().getHostAddress(), msg));
                            }
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                });
                thread.start();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
