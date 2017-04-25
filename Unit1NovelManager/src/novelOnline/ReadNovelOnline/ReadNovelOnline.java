package novelOnline.ReadNovelOnline;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import novelOnline.NovelParse.NovelParse;
import novelOnline.Register.Register;

public class ReadNovelOnline {
	/*public static void main(String[]args){
		new ReadNovelOnline().listNovel();
	}*/
	
	
	
	//用ArrayList查找文档后发现可序列化进行XML解析，进行信息的展示
	
	public void listNovel(){
		//进行小说的展示
		//并进行相应的判断是否进行阅读
		Scanner Input = new Scanner(System.in);
		NovelParse tempNovelParseObj = new NovelParse();
		tempNovelParseObj.initDoc();
		tempNovelParseObj.showInfo();
		
		//进行信息初始化
		
		System.out.print("是否进行阅读？(y/n):");
		
		if(Input.next().equals("y")){
			//new NovelParse().justShowInfo();
			this.readNovel(tempNovelParseObj.getBookBasicInfoAll());
			//没有进行对象持久化操作,造成了数据丢失
		}
		
		
	}
	public void readNovel(ArrayList<String[]> bookBasicInfoAll){
		//可能要进行一次信息的初始化操作
		Scanner Input = new Scanner(System.in);
		
		System.out.print("请根据信息的展示输入你想阅读的书籍的名称:");
		String novelName = Input.next();
		
		int indexOfMap = -1;
		
		for(int i = 0;i<bookBasicInfoAll.size();i++){
			String tempCheck[] = bookBasicInfoAll.get(i);
			
			for(int j =  0; j<tempCheck.length;j++){
				//System.out.println(tempCheck[j]);
				//之保存了最后一条信息
				if(tempCheck[j].equals(novelName)){
					//此处会出现问题
					//在匹配字段的时候会出现问题
					//觉得有必要进行信息初始化
					//只要有一个匹配项就可以进行阅读
					indexOfMap = i;
					
				}
			}
		}
		
		if(indexOfMap==-1){
			System.out.println("没有存在的书籍请重新搜索");
			return ;
			
		}else{
			BufferedReader brReader = null;
			File file = new File("D:\\FileDemo\\Novel\\"+bookBasicInfoAll.get(indexOfMap)[0]+"\\"+bookBasicInfoAll.get(indexOfMap)[1]+"\\"+bookBasicInfoAll.get(indexOfMap)[2]+".txt");
					
					
					
					
					System.out.println("D:\\FileDemo\\Novel\\"+bookBasicInfoAll.get(indexOfMap)[0]+"\\"+bookBasicInfoAll.get(indexOfMap)[1]+"\\"+bookBasicInfoAll.get(indexOfMap)[2]+".txt");
					
					
					
					
					//此代码只用来进行信息测试
					try{
						if(file.exists()){
						System.out.println("正在获取");
						
						brReader=new BufferedReader(
								new InputStreamReader(
								new FileInputStream(file),"UTF-8"));
						
						String tempReadFile = null;
						while((tempReadFile = brReader.readLine())!= null){
							
							System.out.println(tempReadFile);
						}
						
						}else{
							System.out.println("你输入的书名不存在请检查基本信息");
							
							new NovelParse().justShowInfo();
							//简单的输出信息
						}
					}catch(Exception e){
						e.printStackTrace();
					}finally{
						try {
							
							brReader.close();
							System.out.println("小说加载完毕");
							
						} catch (IOException e) {
							
							e.printStackTrace();
						}
						
					}
		}
		
		
	}
	public void setBorrowDate(Register user){
		/*进行小说借阅的同时进行借阅时间的设定
		 * 进行系统的借阅时间设置
		 * 也可以在进行借阅的时候进行内容获取
		 * 
		 * 
		 * 
		 * */
		//传入用户
		//在内部进行设定
		if(user.getBorrowDate()[0]!=0||user.getBorrowDate()[1]!=0){
			//宽松条件
			System.out.println("此用户已经有一个账户请重新检查");
		}else{
			//会将原始的内容给覆盖
			//借阅时间
			//考虑外部调用的问题
			Calendar calendar=Calendar.getInstance();
			user.setBorrowMonth(calendar.get(Calendar.MONTH)+1);
			user.setBorrowDay(calendar.get(Calendar.DAY_OF_MONTH));
			user.setBorrowWeekOfMonth(calendar.get(Calendar.WEEK_OF_MONTH));
			user.setBorrowWeek("星期"+((calendar.get(Calendar.DAY_OF_WEEK)-1)==0?"日":""));
			
			System.out.println("借阅日期已设置");
			//可能用不到的功能
			//可能被废弃
			//根据具体情形进行添加和删除
			
			}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
