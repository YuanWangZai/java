package chapter11.Socket;

import java.io.IOException;

public class UDPServer {
    public static void main(String [] args) throws IOException{
        new UDPServerThread().start();
    }
}
