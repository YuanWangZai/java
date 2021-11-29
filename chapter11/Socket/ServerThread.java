package chapter11.Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerThread extends Thread{
    private Socket s;
    private DataInputStream in;
    private DataOutputStream out;

    public ServerThread(Socket so) throws IOException{
        super();
        s = so;
        in = new DataInputStream(s.getInputStream());
        out = new DataOutputStream(s.getOutputStream());
        start();
    }
    public void run() {
        try{
            String str;
            double result,zhi;
            boolean NotEnd = true;
            while(NotEnd){
                str = in.readUTF();
                if(!str.equals("bye")){
                    zhi = Double.parseDouble(str);
                    System.out.println("接收到的值："+zhi);
                    result = zhi*zhi;
                    str = Double.toString(result);
                    out.writeUTF(str);
                    out.flush();
                    System.out.println("平方值"+str+"已发送");
                }else{
                    NotEnd = false;
                    out.writeUTF("bye-bye");
                    out.flush();
                }
            }
            in.close();
            out.close();
            s.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
