package serverSocket;

import java.io.BufferedReader;  
import java.io.DataOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.InputStreamReader;  
import java.io.OutputStream;  
import java.net.ServerSocket;  
import java.net.Socket;  
  
public class Servicer implements Runnable {  
    Socket socket;  
  
    public Servicer(Socket socket) {  
        super();  
        this.socket = socket;  
    }  
  
    @Override  
    public void run() {  
    try {  
        InputStream inputStream=socket.getInputStream();  
        OutputStream outputStream=socket.getOutputStream();  
          
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));  
        DataOutputStream dataOutputStream=new DataOutputStream(outputStream);  
        while (true) {  
            String strWord=bufferedReader.readLine();  
//          System.out.println(strWord+":"+strWord.length());  
            if ("quit".equalsIgnoreCase(strWord)) {  
                break;  
            }  
            String strEcho=(new StringBuilder(strWord).reverse()).toString();  
            //dataOutputStream.writeBytes(strWord+"---->"+strEcho+"\r\n");  
            //System.getProperty("line.separator")为跨平台换行符。Window为\r\n,unix为\n  
            dataOutputStream.writeBytes(strWord+"---->"+strEcho+System.getProperty("line.separator"));  
        }  
        bufferedReader.close();  
        bufferedReader.close();  
        socket.close();  
    } catch (IOException e) {  
        // TODO Auto-generated catch block  
        e.printStackTrace();  
    }  
      
  
    }  
      
    public static void main(String [] args)  
    {  
        try  
        {  
            ServerSocket ss=new ServerSocket(8001);  
            while(true)  
            {  
                Socket s=ss.accept();  
                new Thread(new Servicer(s)).start();  
            }  
            //ss.close();  
        }catch(Exception e){e.printStackTrace();}  
    }  
  
}  