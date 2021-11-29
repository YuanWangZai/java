package chapter11.Socket;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class chatClient {
    public static void main(String [] args) throws Exception{
        Socket s1;
        InputStream in;
        DataInputStream din;
        s1 = new Socket("localhost",5600);
        in = s1.getInputStream();
        din = new DataInputStream(in);
        String st = new String(din.readUTF());
        System.out.println(st);
        in.close();
        s1.close();
    }
}
