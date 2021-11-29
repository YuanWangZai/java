package chapter11.URL;

import java.net.URL;

public class PraseURl{
    public static void main(String [] args) throws Exception {
        URL cqu = new URL("https://blog.csdn.net/l477918269/article/details/96748110");
        System.out.println(cqu.getProtocol());//协议
        System.out.println(cqu.getHost());//主机
        System.out.println(cqu.getFile());//文件名
        System.out.println(cqu.getDefaultPort());//端口 http是80 https端口号是443
        System.out.println(cqu.getRef());//文件内部的一个引用

    }
}