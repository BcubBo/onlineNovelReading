package novelOnline.RunProj;
import java.io.FileNotFoundException;
import java.util.Scanner;

import novelOnline.Client.Client;
import novelOnline.DownLoadNovel.DownLoadNovel;
import novelOnline.Login.Login;
import novelOnline.NovelParse.NovelParse;
import novelOnline.UploadNovel.UploadNovel;
public class RunProj {
	public static void main(String[]args){
		
		RunProj run =new RunProj();
		run.loopRun();
		
		
	}


	public void loopRun(){
		Scanner Input = new Scanner(System.in);
		boolean checkPoint = true;
		Client client = new Client();
		int runCode = client.socketCommunicate();
		if(runCode == 0){
			do{
				System.out.println("1，登陆\n2，注册\n3，退出");
				System.out.print("请输入数字:");
				int check = 0 ;
				switch(Input.nextInt()){
				case 1:
					Login login = new Login();
					
					try {
						login.checkAccount();
					} catch (FileNotFoundException e) {
						
						e.printStackTrace();
					}
					
					break;
				case 2:
					new Login().firstRegisterIfNotHaveAccount();
					break;
				case 3:
					checkPoint = false ;
					System.out.println("已经退出谢谢使用");
					break;
					
				}
				
				
				
				
				
				
				
				
				
				
			}while(checkPoint);
		}else{
			System.out.println("服务器拒绝进行连接");
		}
		
		
	}


























}


