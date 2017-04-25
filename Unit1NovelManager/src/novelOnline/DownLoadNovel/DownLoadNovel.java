package novelOnline.DownLoadNovel;

import java.io.*;
import java.util.*;

import novelOnline.NovelParse.NovelParse;
public class DownLoadNovel {
	//和流相关并且可复制
	
	public void downLoadFile(ArrayList<String[]> bookBasicInfoAll){
		//下载的话需要进行字典的相应的操作才行
		//进行判断
		
		Scanner Input = new Scanner(System.in);
		System.out.print("请输入你选中的小说名称:");
		String novelName = Input.next();
		
		int indexOfMap = 0;
		
		/**
		 * 
		 * 			basicInfoArray[0]=booksEle.getAttribute("Type");
					basicInfoArray[1]=booksEle.getAttribute("author");
					basicInfoArray[2]=booksEle.getAttribute("name");
		 * 
		 * 
		 * 
		 * **/
		for(int i = 0;i<bookBasicInfoAll.size();i++){
			String tempCheck[] = bookBasicInfoAll.get(i);
			
			for(int j =  0; j<tempCheck.length;j++){
				
				if(tempCheck[j].equals(novelName)){
					indexOfMap = i;
					
				}
			}
		}
		
		//获取文件夹路径并进行相应的操作
		BufferedReader brReader = null;
		BufferedWriter bwFile = null;
		File file = new File("D:\\FileDemo\\Novel\\"+bookBasicInfoAll.get(indexOfMap)[0]+"\\"+bookBasicInfoAll.get(indexOfMap)[1]+"\\"+bookBasicInfoAll.get(indexOfMap)[2]+".txt");
		System.out.println("D:\\FileDemo\\Novel\\"+
		bookBasicInfoAll.get(indexOfMap)[0]+
		"\\"+bookBasicInfoAll.get(indexOfMap)[1]+
		"\\"+bookBasicInfoAll.get(indexOfMap)[2]+
		".txt");
		try{
			if(file.exists()){
			System.out.println("正在下载");
			System.out.print("请输入下载文件夹:");
			String filePath = Input.next();
			File targetFile = new File(filePath+"\\");
			if(!targetFile.exists()){
				targetFile.mkdirs();
				new File(filePath+"\\"+bookBasicInfoAll.get(indexOfMap)[2]+".txt").createNewFile();
			brReader=new BufferedReader(
					new InputStreamReader(
					new FileInputStream(file),"UTF-8"));
			bwFile = new BufferedWriter(
					new OutputStreamWriter(
					new FileOutputStream(new File(filePath+"\\"+bookBasicInfoAll.get(indexOfMap)[2]+".txt")),"UTF-8"));
			}else{
				brReader=new BufferedReader(
						new InputStreamReader(
						new FileInputStream(file),"UTF-8"));
				bwFile = new BufferedWriter(
						new OutputStreamWriter(
						new FileOutputStream(new File(filePath+"\\"+bookBasicInfoAll.get(indexOfMap)[2]+".txt")),"UTF-8"));
			}
			String tempReadFile = null;
			while((tempReadFile = brReader.readLine())!=null){
				
				bwFile.write(tempReadFile);
				
				bwFile.newLine();
			}
			bwFile.flush();
			
			System.out.println("下载成功");
			}else{
				System.out.println("你输入的书名不存在请检查基本信息");
				
				new NovelParse().justShowInfo();
				//简单的输出信息
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				
				bwFile.close();
				brReader.close();
				
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	
	
	
	
	
	
	
}
