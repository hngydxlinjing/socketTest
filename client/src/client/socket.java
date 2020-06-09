package client;

import java.io.BufferedReader;  
import java.io.DataOutputStream;  
import java.io.InputStream;  
import java.io.InputStreamReader;  
import java.io.OutputStream;  
import java.net.InetAddress;  
import java.net.Socket;  
//后启动客户端程序  
public class socket {  
    //启动main时传进来两个参数：ip和端口号  
    public static void main(String [] args)   
    {  
    try  
    {  
        Socket s=new Socket(InetAddress.getByName("127.0.0.1"),8001);  
        /*if(args.length < 2)  
        {  
            System.out.println("Usage:java TcpClient ServerIP ServerPort");  
            return;  
        }  */
        //建立Socket  
       // Socket s=new Socket(InetAddress.getByName(args[0]),Integer.parseInt(args[1]));  
        InputStream ips=s.getInputStream();  
        OutputStream ops=s.getOutputStream();  
          
        BufferedReader brKey = new BufferedReader(new InputStreamReader(System.in));//键盘输入  
        DataOutputStream dos = new DataOutputStream(ops);  
        BufferedReader brNet = new BufferedReader(new InputStreamReader(ips));  
  
        String strWord = brKey.readLine();  
        dos.writeBytes(strWord + System.getProperty("line.separator"));  
        System.out.println(brNet.readLine());  
        
        /*while(true)  
        {  
            String strWord = brKey.readLine();  
            dos.writeBytes(strWord + System.getProperty("line.separator"));  
            if(strWord.equalsIgnoreCase("quit"))  
                break;  
            else  

            	System.out.println(brNet.readLine());  
        }  */
        dos.close();  
        brNet.close();  
        brKey.close();  
        s.close();  
    }catch(Exception e){e.printStackTrace();}  
    }  
}  
/*发送和接受都是以Socket为信息载体*/  