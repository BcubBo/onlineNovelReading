package novelOnline.UploadNovel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class UploadNovel {
	
	public void saveFile(String path,String[] novelInfo)throws FileNotFoundException {
		/*
		 *path可能是一个已经传入的拼接的字符串或者是字符串数组
		 *
		 *上传文件的路径了之后呢？
		 *上传的文件的路径进行解析
		 *String tempFileName = path.substring(path.lastIndexOf("\\"),path.length());
		 *通过substring获取文件名path.lastIndexOf("\\")获取最后一个\的位置确定文件名
		 *并进行相应的操作
		 *暂时存在的位置
		 *String tempDirectoryPath = path.substring(0,path.lastIndexOf("\\"));
		 *获取文件夹路径并进行相应的操作
		 *暂时存在的位置
		 */
		BufferedWriter bwFile = null;
		BufferedReader brReader = null;
		//File file = new File(path);
		File inputFileInfo = new File("D:\\FileDemo\\Novel"+"\\"+novelInfo[0]+"\\"+novelInfo[1]+"\\");
		try{
		if(inputFileInfo.exists()){
			System.out.println("*********************************************");
			System.out.println("正在存储");
			brReader = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));
			bwFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\FileDemo\\Novel"+"\\"+novelInfo[0]+"\\"+novelInfo[1]+"\\"+novelInfo[2]+".txt"),"UTF-8"));
			//可以从添加的小说的部分进行直接的字符串拼接并上传												//书的类型  作者名称  书的名称
			//传入的字符串数组进行相应的拼接
			System.out.println("*********************************************");
			System.out.println("存储成功");
		}else{
			
			try {
				System.out.println("*********************************************");
				System.out.println("正在创建");
				inputFileInfo.mkdirs();
				
				new File("D:\\FileDemo\\Novel"+"\\"+novelInfo[0]+"\\"+novelInfo[1]+"\\"+novelInfo[2]+".txt").createNewFile();
				brReader = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));
				bwFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\FileDemo\\Novel"+"\\"+novelInfo[0]+"\\"+novelInfo[1]+"\\"+novelInfo[2]+".txt"),"UTF-8"));
				
				String tempBuffer = null;
				while((tempBuffer = brReader.readLine())!=null){
					
					bwFile.write(tempBuffer);
					bwFile.newLine();
				}
				bwFile.flush();
				
				brReader.close();
				bwFile.close();
				System.out.println("*********************************************");
				System.out.println("上传创建成功");
				
				
			} catch(FileNotFoundException fnfe ){
				System.err.println("文件不存在");
				
			}
			catch (IOException e) {
				
				e.printStackTrace();
			}

		
		 
		

		

				}
			}catch(Exception e){
			e.printStackTrace();
		}
		
		//上传信息完成

}
	







}
