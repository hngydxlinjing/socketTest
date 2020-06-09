package serverSocket;

import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.InputStreamReader;  
import java.io.OutputStream;  
import java.net.ServerSocket;  
import java.net.Socket;  
public class serverSocket {  
  
    //先启动服务器端程序  
    public static void main(String[] args) throws IOException {  
        ServerSocket serverSocket=new ServerSocket(8001);  
        Socket socket=serverSocket.accept();//阻塞等待消息  
        InputStream inputStream=socket.getInputStream();  
        OutputStream outputStream=socket.getOutputStream();  
      outputStream.write("欢迎光临！".getBytes(), 0,"欢迎光临！".getBytes().length );  
        outputStream.write("welcome!".getBytes() );  
    /*  byte[] buf=new byte[1024]; 
        int len=inputStream.read(buf); 
//      System.out.println(new String(buf, 0, len)); 
        inputStream.close();*/  
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));  
        System.out.println(bufferedReader.readLine());  
        bufferedReader.close();  
        outputStream.close();  
        socket.close();  
        serverSocket.close();  
    }  
}  