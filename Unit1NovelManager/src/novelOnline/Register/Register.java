package novelOnline.Register;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public final class Register implements Serializable{
	/**
	 * 已经进行实现序列化实现
	 * 并且不可继承
	 */
	private static final long serialVersionUID = 1000010L;
	/*
	 * 单独的注册类，进行相关用户的注册，并和服务器进行通讯，并且与此同时可以进行序列化和反序列化
	 * 并进行相应的数据存储，并将数据存储在不同的文件夹下
	 * 
	 * 
	 * */
	private String name;
	private String pwd;
	private String novel;
	private String registerDate;//系统生成的注册时间
	private int returnDate;//返还日期
	private String describe;//简单描述
	private int borrowMonth;
	private int borrowDay;
	private String borrowWeek;
	private int borrowWeekOfMonthek;//借出日期
	public ArrayList<Register> userlist = new ArrayList<Register>();
	
	public void setRegisterDate() {
		String registerDateSys=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		this.registerDate = registerDateSys;
		//创建用户时自动设置注册日期
		//注册时间
	}
	public String getRegisterDate() {
		return registerDate;
	}

	public Register(){
		setRegisterDate();
	}
	public Register(String name,String pwd,String describe){
		//给定一个构造方法
		//只给了三个，考虑到小说的给定可能需要进行方法的调用和直接从DataBase传入故此构造方法只传入三个参数
		setName(name);
		setPwd(pwd);
		setDescribe(describe);
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		
		this.name = name;
			
			//done 
		}
	
		//增加了判断逻辑

	public String getPwd() {
		return pwd;
	}
	public int setPwd(String pwd) {
		//进行相关的判断包括字母数字下划线
		//返回值如果为0不进行方法的二次调用，
		//返回值为-1进行方法的二次调用
		int check=0;
		System.out.println("为你的账户设置密码 ");
		if(pwd.contains(" ")||pwd.length()<6||pwd.contains(",")||pwd == null){
			System.out.println("密码不能包括空格逗号且长度不能少于6位同时不可为空请重新设置密码");
			//是否可行的递归？
			check=-1;
			//进行的验证操作
		}//进行优化
		else{
			this.pwd=pwd;
			
			//done 
		}
		return check;
	}
	public String getNovel() {
		return novel;
	}
	public void setNovel(String novel) {
		//要进行是否有此小说的内容进行判定
		this.novel = novel;
	}
	public int[] getBorrowDate(){
		//返回整数型的数据以便判断
		int date[]=new int[2];
		date[0]=this.borrowMonth;
		date[1]=this.borrowDay;
		return date;
		//此方法可能被废弃
	}
	
	
	public int getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(int returnDate) {
		//进行相关的判断
		//还是自行传入
		this.returnDate = returnDate;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		//基本备注
		this.describe = describe;
	}
	/*
	 * 进行服务器的通信
	 * 
	 * 
	 * 
	 * */
	public int getBorrowWeekOfMonth() {
		return borrowWeekOfMonthek;
	}
	public void setBorrowWeekOfMonth(int borrowMonthOfWeek) {
		this.borrowWeekOfMonthek = borrowMonthOfWeek;
	}
	public String getBorrowWeek() {
		return borrowWeek;
	}
	public void setBorrowWeek(String borrowWeek) {
		this.borrowWeek = borrowWeek;
	}
	
	public int getBorrowMonth() {
		return borrowMonth;
	}
	public void setBorrowMonth(int borrowMonth) {
		this.borrowMonth = borrowMonth;
	}
	public int getBorrowDay() {
		return borrowDay;
	}
	public void setBorrowDay(int borrowDay) {
		this.borrowDay = borrowDay;
	}
	
	public ArrayList<Register> showInfoBasic(){
		
		return userlist;
		//可能废弃的方法
	}
	public void saveTheAccountInfo(Register user){
		
		
		
		//没有进行对象的输入操作
	
		
		
		
		//将对象写入文件并保存
		ObjectOutputStream  oos = null;
		
		try{
			userlist.add(user);
			//将用户名用作文件的名称
			File file = new File("D:\\FileDemo\\SaveAccount\\");
			
			if(file.exists()){
				
				System.out.println("文件存在验证TRUE");
			}else{
				file.mkdirs();
				new File("D:\\FileDemo\\SaveAccount\\"+user.getName()+".bin").createNewFile();
				System.out.println("文件创建成功(FROM REGISTER)");
			}
			oos = new ObjectOutputStream(new FileOutputStream("D:\\FileDemo\\SaveAccount\\"+user.getName()+".bin"));
			
			//可能报错
			
			oos.writeObject(user);
			//oos.writeObject(userlist);冗余
			//写入二进制文件
			//写入后持久化
			
			//must be closed in case the side effects
			oos.close();
			
			
			
			

		}catch(FileNotFoundException fnfe){
			
			fnfe.printStackTrace();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		
	}
//登陆和注册基本完成	
	public void arraylistSerializable(ArrayList<Register> userlist){
		
		

		//进行数组列表的对象序列化
		
		
		
		//将对象写入文件并保存
		ObjectOutputStream  oos = null;
		
		try{
			
		
			oos = new ObjectOutputStream(new FileOutputStream("D:\\FileDemo\\SaveArrayList\\userlist.arr"));
			//可能报错
			//进行了文件存在的校验
			

			oos.writeObject(userlist);
			//写入二进制文件
			//写入后持久化
			
//must be closed in case the side effects
			oos.close();
			
			
			
			

		}catch(FileNotFoundException fnfe){
			
			fnfe.printStackTrace();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Register> objectDeSerializable(){
		//进行反序列化
		//将对象进行输入
		//进行的是对象从文件中取出
		
		ObjectInputStream ois = null;
		
		ArrayList<Register> temp = null;
		
		try{
			
			ois = new  ObjectInputStream(new FileInputStream("D:\\FileDemo\\SaveArrayList\\userlist.arr"));
			
			
			
			temp = (ArrayList<Register>) ois.readObject();
			
			
			
			
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		return temp;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 
}	