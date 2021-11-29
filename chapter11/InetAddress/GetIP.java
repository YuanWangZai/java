package chapter11.InetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetIP {
    public static void main(String [] args){
        System.out.println(args[0]);
        try{
            //getByName()返回对象，直接输出是主机名和ip，getHostAddress只返回主机名
            System.out.println(args[0]+"IP是"+(InetAddress.getByName(args[0])).getHostAddress());
        }catch(UnknownHostException e){
            e.printStackTrace();
        }
    }
}
