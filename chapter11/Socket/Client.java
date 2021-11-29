package chapter11.Socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String [] args){
        try {
            Socket s = new Socket("localhost",5500);
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            System.out.println("输入待求平方值，输入bye结束");
            String outstr,instr;
            boolean NotEnd = true;
            BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
            while(NotEnd){
                outstr = buf.readLine();
                out.writeUTF(outstr);
                out.flush();
                instr = in.readUTF();
                if(!instr.equals("bye"))
                    System.out.println("返回结果："+instr);
                else
                    NotEnd = false;
            }
            in.close();
            out.close();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
