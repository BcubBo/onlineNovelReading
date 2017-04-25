package novelOnline.Server;
import java.io.*;

import java.util.*;
import java.net.*;
public class Server {
	public static void main(String[]args){
		try {
			
			System.out.println("服务器启动");
			
			Scanner Input =new Scanner(System.in);
			
			ServerSocket serverSocket = new ServerSocket(8900);
			
			Socket socket = serverSocket.accept();
			
			InputStream is = socket.getInputStream();
			
			BufferedReader bf = new BufferedReader(new InputStreamReader(is,"UTF-8"));
			
			String tempGetInfo = bf.readLine();
			System.out.println(tempGetInfo);
			
			
			
			OutputStream os = socket.getOutputStream();
			
			System.out.print("是否打开客户端？(y/n):");
			
			String tempCheckPoint = Input.next();
			
			
			
			
			
			if(tempCheckPoint.equals("y")){
				
				os.write(0);
				//返回码为0
				
			}else{
				
				os.close();
				
				os.close();
				
				serverSocket.close();
				
				
			}
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
