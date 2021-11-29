package chapter11.URL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLReader {
    public static void main(String [] args){
        try{
            URL obj = new URL("http://www.ucdrs.superlib.net/");
            String inputLine;
            //openStream()返回输入流对象
            //InputStreamReader类是从字节流到字符流的桥接器
            //BufferedReader字符缓冲流
            BufferedReader in = new BufferedReader(new InputStreamReader(obj.openStream()));
            while((inputLine = in.readLine())!=null)
                System.out.println(inputLine);
            in.close();

            //
            URLConnection conn = obj.openConnection();
            conn.connect();
            System.out.println(conn.getContentLength());
            System.out.println(conn.getContentType());

            //定义输入流读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            String result = null;
            while((line = in.readLine())!=null)
                result += line;
            System.out.println(result);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
