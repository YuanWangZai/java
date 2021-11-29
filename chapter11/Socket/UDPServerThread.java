package chapter11.Socket;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.*;

public class UDPServerThread extends Thread{
    protected DatagramSocket socket = null;
    protected BufferedReader in = null;
    protected boolean more = true;

    public UDPServerThread() throws IOException{
        this("UDPServerThread");
    }
    public UDPServerThread(String name) throws IOException{
        super(name);
        socket = new DatagramSocket(4445);
        try {
            in = new BufferedReader(new FileReader("one.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void run(){
        while(more){
            try {
                byte [] buf = new byte[256];
                DatagramPacket packet = new DatagramPacket(buf, buf.length);

                socket.receive(packet);
                String dString = null;
                if(in==null)
                    dString = new Date().toString();
                else
                    dString = getNext();
                buf = dString.getBytes();

                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                packet = new DatagramPacket(buf, buf.length, address, port);

                socket.send(packet);
            } catch (Exception e) {
                e.printStackTrace();
                more = false;
            }
        }
        socket.close();
    }

    protected String getNext(){
        String returnValue = null;
        try{
            if((returnValue = in.readLine())==null){
                in.close();
                more = false;
                returnValue = "bye-bye";
            }
        }catch(IOException e){
            returnValue = "IOException!";
        }
        return returnValue;
    }
}
