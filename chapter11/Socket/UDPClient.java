package chapter11.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String [] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s = r.readLine();

        DatagramSocket socket = new DatagramSocket();

        byte[] buf = new byte[256];
        InetAddress address = InetAddress.getByName(s);
        DatagramPacket packet = new DatagramPacket(buf, buf.length,address,4445);//发送包

        socket.send(packet);

        packet = new DatagramPacket(buf, buf.length);//接受包
        socket.receive(packet);

        String received = new String(packet.getData());
        System.out.println(received);
        socket.close();
    }
}
