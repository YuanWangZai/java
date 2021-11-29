package chapter11.Socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class chatServer {
    @SuppressWarnings("all")
    public static void main(String [] args){
        ServerSocket s = null;
        Socket s1;
        Scanner input=new Scanner(System.in);
        String send = input.next();
        OutputStream out;
        DataOutputStream dout;
        try {
            s = new ServerSocket(5600);//本地端口5600
        } catch (Exception e) {
            e.printStackTrace();
        }
        while(true){
            try {
                s1 = s.accept();//成功连接则返回一个Socket对象
                out = s1.getOutputStream();
                dout = new DataOutputStream(out);
                dout.writeUTF(send);
                //先关闭输出流，再关闭socket
                out.close();
                s1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }
    }
}
