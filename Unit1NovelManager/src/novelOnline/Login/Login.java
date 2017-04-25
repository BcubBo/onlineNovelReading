package novelOnline.Login;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import novelOnline.DownLoadNovel.DownLoadNovel;
import novelOnline.NovelParse.NovelParse;
import novelOnline.ReadNovelOnline.ReadNovelOnline;//在线小说阅读导入
import novelOnline.Register.Register;//注册器导入
import novelOnline.UploadNovel.UploadNovel;
//此类需要三个类的支持，耦合性可能加大
public class Login {
	ArrayList<Register> tempList = new Register().userlist;//return the userlist 
	
	public void firstInit(){
		Register tempRegisterObject = new Register();
		
		tempRegisterObject.arraylistSerializable(tempList);
		//在当前位置要进行ArrayList的反序列化进行值的传入
		
		
		//可以放在外边
	}
	

	
	public void checkAccount() throws FileNotFoundException{
		Scanner Input = new Scanner(System.in);
		
		tempList = new Register().objectDeSerializable();
		System.out.print("请输入你的账户名:");
		//需要有一个是否存在该对象的判断
		
		
		//从Register中获取链接了Register
		//templist 中存储的是ArrayList<Register>
		
		String  accountName = Input.next();
		
		//File file = new File("D:\\FileDemo\\SaveAccount\\"+accountName+".bin");
		//如果没有的话会进行创建文件保证不了是否存在
		
		
		//判断是否存在此账户
		String password=null;
		
		int index = -1 ;
		for (Register registerUser:tempList){
			//从templist中取出ArrayList对象并进行判断
			
			if(registerUser!=null&&registerUser.getName().equals(accountName)){
				System.out.println(registerUser.getName());
				index = tempList.indexOf(registerUser);
				//进行判断
			}else{
				
			}
				
				//此位置判断的应是是否存在此用户名并且放到一个大循环中
		}
		
		if (index!=-1){
			
			System.out.print("请输入你的密码:");
			
			//暂时存储Register对象
			Register temp = (Register)tempList.get(index);
			
			password= Input.next();

				
			//可能还要判断是否存在该目录
			//并创建相应的目录或者文件
				
			//从文件中读取的对象进行判断
					
			if (temp.getPwd().equals(password)){
						
				System.out.println("登陆成功!");
				//登陆成功后进行相应的对象操作
						
				//进行小说的阅读相关操作
						
				this.ReadOrNot();
				//登陆成功后的操作
				//进行相应的操作
				//功能有待完善
				

			}else{
				System.out.println("密码不匹配登陆失败");
				return;
			}

						
		}else{
			
			
			this.RegisterIfNotHaveAccount();
		}			
							
				
					
		
			

		
		
		
		
		
		
	
	}
	public void firstRegisterIfNotHaveAccount(){
		Scanner Input = new Scanner(System.in);
		
		System.out.println("----------------------------------------------------------------");
		System.out.print("你想创建新的账户吗？(y/n):");
		if (Input.next().equals("y")){
			Register user = new Register();
			//user 类
			int userNameCheck = -1;
			int userPasswordCheck = -1;
			System.out.println("你正在注册在线小说阅读账户！");
			System.out.println("----------------------------------------------------------------");
			System.out.print("设置你的账户名:");
			
			String tempUser = Input.next();
			int index = -1 ;
			//此索引位置判断在数组列表中是否存在该用户信息
			for (Register registerUser:tempList){
				//从templist中取出ArrayList对象并进行判断
				
				if(registerUser!=null&&registerUser.getName().equals(tempUser)){
					index = tempList.indexOf(registerUser);
					//进行判断
					//只在这进行了简单的账户判断
				}
					
					//此位置判断的应是是否存在此用户名并且放到一个大循环中
			}
			if(index != -1){
				//
				//太多的if判断
				
				System.out.println("账户已存在");
				/*
				 * 在此位置可能存在一个二级返回菜单的操作
				 * 
				 * 
				 * 
				 * **/
				
				
				
			}else{
				//先进行是否存在账户的判断
				//如果存在向下进行
				
				//临时用户名
				System.out.println("----------------------------------------------------------------");
				System.out.print("再次输入你的账户名:");
				String recheckUserName = Input.next();
				//二次检查用户名
				String tempPassword = null;
				String recheckPassword = null;
				if(!tempUser.equals(recheckUserName)||recheckUserName.contains(" ")||(recheckUserName.length()<6)||recheckUserName.contains(",")){
					System.out.println("----------------------------------------------------------------");
					System.out.println("账户名不匹配,用户名不能包括空格逗号且长度不能少于6位请重新设置用户名");
					try{
						new Login().checkAccount();
						//进行再次检查
					}catch(FileNotFoundException fnfe){
						fnfe.printStackTrace();
					}
					return;
					/*
					 * 不确定是否会出现死循环
					 * 
					 * 
					 * 
					 * **/
				}else{
					
					/*
					 * 在此进行彻底的判断，首先是名称的匹配再次是进行名称包含非法字符的一些操作，不能包括空格，长度不可小于6切不包括逗号在内
					 * 
					 * **/
					userNameCheck = 0;
					user.setName(recheckUserName);
					System.out.println("----------------------------------------------------------------");
					System.out.print("输入你的用户名密码:");
					
					tempPassword = Input.next();
					System.out.println("----------------------------------------------------------------");
					System.out.print("再次输入你的密码:");
					recheckPassword = Input.next();
					System.out.println("----------------------------------------------------------------");
					System.out.println("账户名称设置完成");
					if (index == -1){
						//进行密码和用户名的双向验证
						
						
						
						
						int passwordCheck = user.setPwd(recheckPassword);
						if(passwordCheck == -1){
							System.out.println("密码设置失败");
							tempUser=null;
							recheckUserName=null;
							tempPassword=null;
							recheckPassword=null;
							System.out.println("已清空相关信息数据");
							
						}else{
							//进行成功后操作
							System.out.println("----------------------------------------------------------------");
							System.out.println("密码设置完成");
							
							user.setRegisterDate();
							//设置注册时间
							System.out.println("----------------------------------------------------------------");
							System.out.println("你的账号设置完成");
							
							Register registerObject = new Register();
							
							tempList.add(user);
							
							registerObject.arraylistSerializable(tempList);
							//将ArrayList<Register>进行存储
							
							//创建对象
							
							registerObject.saveTheAccountInfo(user);
							//在此位置可能会存在异常，可能忘记进行用户名的设置
						}
						
						
						
						
						
						//暂时含有一个对象数组列表
						//需要时可进行遍历然后进行相应的属性或者方法的调用
						
						//user.saveTheAccountInfo(user);
						
							try {
								this.checkAccount();
							} catch (FileNotFoundException e) {
								
								e.printStackTrace();
							}
							
							//也可以进行菜单选项的设置
						 
						//对象信息持久化
						
						
						
					}else if(userNameCheck==-1||userPasswordCheck==-1){
						//System.out.println("用户名或密码不匹配");
						tempUser=null;
						recheckUserName=null;
						tempPassword=null;
						recheckPassword=null;
						
						//可能在此块中进行一个二级菜单返回操作
						
						
						
						
					}else{
						//清空
						
						tempUser=null;
						recheckUserName=null;
						tempPassword=null;
						recheckPassword=null;
						//进行清空操作
						
						//进行询问时候进行重新创建
						System.out.println("----------------------------------------------------------------");
						System.out.println("对不起账户已存在");
						
						System.out.println("----------------------------------------------------------------");
						System.out.print("对不起你没有正确设置你的账户如若重新注册请输入(y/n):");
						
						if (Input.next().equals("y")){
							
							firstRegisterIfNotHaveAccount();
						}else{
							System.out.println("----------------------------------------------------------------");
							System.out.println("再见");
							
							
						}
						
						
					}
				}
					user.setName(recheckUserName);
					recheckPassword = Input.next();
					if(tempPassword.equals(recheckPassword)){
						userPasswordCheck = 0;
					}else{
						System.out.println("密码不匹配");
					}

				}
			}
			
			
			


			
		
	
	}
	//进行首次注册时使用
	
	public void ReadOrNot(){
		String BookInfoContainer[] = new String[3];
		//可能废弃的容器
		ArrayList<String[]> booksAllInfoContainer = new ArrayList<String[]>();
		Scanner Input = new Scanner(System.in);
		NovelParse novelParse = new NovelParse();
		novelParse.initDoc();
		boolean checkPoint = true;
		do{
			System.out.println("1，阅读小说\n2，上传小说\n3，下载小说\n0，返回上一级");
			System.out.print("请输入你的选项:");
			int option = Input.nextInt();
			switch(option){
				case 0:
					System.out.println("返回上级菜单");
					checkPoint = false;
					break;
				case 1:
					System.out.println("--------------------------------");
					System.out.print("你想现在就阅读小说吗?(y/n):");
					//System.out.println("以下是显示的信息");
					if (Input.next().equals("y")){
						
						ReadNovelOnline readOnline = new ReadNovelOnline();
						
						readOnline.listNovel();
						//进行在线阅读
						
					}
					break;
					
					
					
					
				case 2:
					System.out.println("--------------------------------");
					System.out.print("要上传小说吗？(y/n):");
					if(Input.next().equals("y")){
						UploadNovel uploadNovel = new UploadNovel();
						System.out.println("--------------------------------");
						System.out.print("请输入要上传的文件路径:");
						String uploadPath = Input.next();
						//直接在这个位置用上容器一次性接收信息
						
						int checkFileCode = 0 ;
						try{
							
							uploadNovel.saveFile(uploadPath,novelParse.addEle() );
						}catch(FileNotFoundException fnfe){
							System.err.println("文件未找到");
							 checkFileCode = - 1;
							
						}
						if(checkFileCode == 0){
							
						
							novelParse.saveXML();
						}else{
							System.out.println("未存储XML信息");
						}
						//更新XML文件
					}else{
						
						System.out.println("好的不进行上传");
						
					}
					break;
					
					
					
					
					
					
					
				case 3:
					System.out.print("要下载小说吗?(y/n):");
					if(Input.next().equals("y")){
						
						DownLoadNovel download = new DownLoadNovel();
						System.out.println("此为小说列表");
						System.out.println("*********************************************");
						novelParse.showInfo();
						booksAllInfoContainer = novelParse.getBookBasicInfoAll();
						download.downLoadFile(booksAllInfoContainer);
					}else{
						System.out.println("*********************************************");
						System.out.println("Okay不下载听你的");
					}
					
					break;
					
				}
			
		}while(checkPoint);
		
	}
		
	
		
	//checkAccount()模块暂时确定。网络通信的过程中需要进行判断
	//并进行传值的操作
	public void  RegisterIfNotHaveAccount(){
		System.out.println("----------------------------------------------------------------");
		System.out.println("对不起该账户不存在，你可以重新检查账户或者进行创建账户");
		
		this.firstRegisterIfNotHaveAccount();

	}
	
}
//登陆和注册暂时基本完成
/*
 * 
 * 
 * 
 * @author:BoBcub
 * 此模块有待优化
 * 
 * 
 * 
 * 
 * 
 * 
 * **/