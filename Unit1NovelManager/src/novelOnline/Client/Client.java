package novelOnline.Client;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import novelOnline.Login.Login;
import novelOnline.NovelParse.NovelParse;
public final class Client {

	
	public NovelParse showInfo(){
		//此方法的多余使用
		NovelParse novelParse = new NovelParse();
		
		return novelParse;
	}
	

	public int socketCommunicate(){
		Scanner Input = new Scanner(System.in);
		Socket socket = null;
		int runCode = -1;
		try {
			
			socket = new Socket("localhost",8900);
			
			OutputStream os = socket.getOutputStream();
			
			
			
			os.write("客户端已连接".getBytes());
			

			socket.shutdownOutput();
			
			InputStream is = socket.getInputStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
			
			int reply = br.read();
			
			if(reply==0){
				System.out.println("服务器已连接");
				Login login = new Login();
				//登陆选项
				File file = new File("D:\\FileDemo\\SaveArrayList\\");
				if(file.exists()){
					
					System.out.println("链接数据中");
				}else{
					System.out.println("创建文件中创建"+(file.mkdir()?"成功":"失败"));
					new File("D:\\FileDemo\\SaveArrayList\\userlist.arr").createNewFile();
					System.out.println("初始化数据中");
					login.firstInit();
					System.out.println("初始化完成");
				}
				
				runCode = 0 ;
				login.checkAccount();
				
				//通过此方法进行账户的验证和进行相应的操作
				
			}else{
				System.out.println("服务器拒绝进行通信");
				
				br.close();
				
				is.close();
				
				socket.close();
			}
			
			
			
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return runCode;
	}
		
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

