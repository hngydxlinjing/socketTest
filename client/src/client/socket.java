package client;

import java.io.BufferedReader;  
import java.io.DataOutputStream;  
import java.io.InputStream;  
import java.io.InputStreamReader;  
import java.io.OutputStream;  
import java.net.InetAddress;  
import java.net.Socket;  
//�������ͻ��˳���  
public class socket {  
    //����mainʱ����������������ip�Ͷ˿ں�  
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
        //����Socket  
       // Socket s=new Socket(InetAddress.getByName(args[0]),Integer.parseInt(args[1]));  
        InputStream ips=s.getInputStream();  
        OutputStream ops=s.getOutputStream();  
          
        BufferedReader brKey = new BufferedReader(new InputStreamReader(System.in));//��������  
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
/*���ͺͽ��ܶ�����SocketΪ��Ϣ����*/  