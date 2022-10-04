package test.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: cg1
 * @date: 2021-07-07 17:12
 **/
public class TCPServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            //阻塞等待客户端
            Socket socket = serverSocket.accept();
            System.out.println("接收到新的连接" + socket);

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            String str = null;
            if ((str = dataInputStream.readUTF()) != null) {
                System.out.println(str);
            }
            dataOutputStream.writeUTF("123");

            dataOutputStream.flush();
//            dataInputStream.close();
//            dataOutputStream.close();
//            serverSocket.close();
        }

    }
}
