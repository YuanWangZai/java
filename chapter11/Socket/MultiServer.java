package chapter11.Socket;

import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {
    @SuppressWarnings("all")
    public static void main(String [] args){
        try {
            System.out.println("等待连接...");
            ServerSocket server = new ServerSocket(5500);
            Socket s = null;
            while(true){
                //等待客户端配对
                s = server.accept();
                //启动一个线程处理
                new ServerThread(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
