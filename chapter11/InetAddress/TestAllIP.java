package chapter11.InetAddress;
import java.net.InetAddress;

public class TestAllIP {
    public static void main(String [] args){
        String ip = "111.205.231.";
        //ip最后三个数是0~255
        for(int i='1';i<255;i++){
            String host = ip+i;//i会自动转化为字符串
            new ThreadIP(host).start();
        }
    }

    //
    static class ThreadIP extends Thread{
        String ip = null;
        public ThreadIP(String ip){
            super();
            this.ip = ip;
        }
        @Override
        public void run(){
            super.run();
            try{
                InetAddress ia = InetAddress.getByName(ip);
                boolean bool = ia.isReachable(1500);//等待响应1500ms
                if(bool){
                    System.out.println("主机："+ip+"可用");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
