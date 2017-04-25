package novelOnline.NovelParse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
//此模块的一些功能已经完善
public class NovelParse {
	private ArrayList<String[]> bookBasicInfoAll = new ArrayList<String[]>();
	/*
	 * 有此数组列表就已经足够进行相关信息的获取和展示
	 * 使用字典有些冗余
	 * 
	 * 
	 * **/
	
	private Document document; 
	private String basicInfoArray[] = new String[3];
	public void initDoc(){
		
			
			DocumentBuilderFactory documentBuilder = DocumentBuilderFactory.newInstance();





			
			try{
				
				DocumentBuilder builder = documentBuilder.newDocumentBuilder();
				
				document = builder.parse("Novel.xml");
				
				NodeList nodelist = document.getElementsByTagName("Book");
				
				
				for(int i = 0 ;i < nodelist.getLength(); i++){
					String tempStringArray[] = new String[3];
					//每次要创建新的数组并进行初始化一边进行相应的
					//重新赋值操作
					Node bookNode = nodelist.item(i);
					
					Element books = (Element)bookNode;
					
					//System.out.println((i+1)+":"+books.getAttribute("Type"));
					//通过字典进行了存储值得操作，废弃此信息展示
					
					String type = books.getAttribute("Type");
					//父节点中的Type属性节点信息
					//从xml中取出的书的类型名称
					//
					tempStringArray[0] = type;
					//每次循环都会将主书籍类型加入到数组列表中
					//
					NodeList booksSub = books.getElementsByTagName("book");
					
					for (int j = 0; j< booksSub.getLength();j++){
						
						Node booksSubNode = booksSub.item(j);
						
						Element booksEle = (Element)booksSubNode;
						String author = booksEle.getAttribute("author");
						String name = booksEle.getAttribute("name");
						//将所有的信息加载到数组列表中以便使用
						String booksAllInfo = "类型:"+type+"\t名称:"+name+
								"\t"+"作者:"+author+":"+
								"\t"+"描述:"+booksEle.getAttribute("description");
						
						tempStringArray[1] = author;
						
						tempStringArray[2] = name;
						
						//System.out.println(booksAllInfo);
						//将要把当前类型书籍下的书名及相关信息放入到数组列表中以便后续使用
						

						//添加的是保存了些信息但是是否是冗余的呢?
						
						
						this.setBasicInfoArray(tempStringArray);
						//System.out.println(booksInfoAll);
						//通过数组进行信息展示废弃次方法的展示
							
						
					}
					bookBasicInfoAll.add(this.getBasicInfoArray());
					//两次的添加确实是加入进去了可是为什么两次都是一样的结果呢?
					//而且放入的都是最后读取的数据
				}
				

			}catch(ParserConfigurationException pars){
				
				pars.printStackTrace();
				
			}catch(SAXException sax){
				
				sax.printStackTrace();
				
			}catch(IOException ioe){
				
				ioe.printStackTrace();
			}
			
			//返回整个书籍列表的字典
			//返回值在这
		}

	public String[] getBasicInfoArray() {
		return basicInfoArray;
	}

	public void setBasicInfoArray(String[] basicInfoArray) {
		this.basicInfoArray = basicInfoArray;
	}

	public void showInfo(){
		
		DocumentBuilderFactory documentBuilder = DocumentBuilderFactory.newInstance();




		//不知道是否此数组列表可否有存在的价值
		//可以进行HashMap的设置
		//此字典进行类别和所在类别的书名的映射
		
		try{
			
			DocumentBuilder builder = documentBuilder.newDocumentBuilder();
			
			document = builder.parse("Novel.xml");
			
			NodeList nodelist = document.getElementsByTagName("Book");
			
			for(int i = 0 ;i < nodelist.getLength(); i++){
				
				Node bookNode = nodelist.item(i);
				
				Element books = (Element)bookNode;
				
				//System.out.println((i+1)+":"+books.getAttribute("Type"));
				//通过字典进行了存储值得操作，废弃此信息展示
				
				String type = books.getAttribute("Type");
				//从xml中取出的书的类型名称
				//

				//每次循环都会将主书籍类型加入到数组列表中
				//
				
				NodeList booksSub = books.getElementsByTagName("book");
				
				for (int j = 0; j< booksSub.getLength();j++){
					
					Node booksSubNode = booksSub.item(j);
					
					Element booksEle = (Element)booksSubNode;

					
					
					
					//将所有的信息加载到数组列表中以便使用
					String booksAllInfo = "类型:"+type+"\t名称:"+booksEle.getAttribute("name")+
							"\t"+"作者:"+booksEle.getAttribute("author")+":"+
							"\t"+"描述:"+booksEle.getAttribute("description");
					
					System.out.println(booksAllInfo);
					//将要把当前类型书籍下的书名及相关信息放入到数组列表中以便后续使用
					

					//添加的是保存了些信息但是是否是冗余的呢?
					
					
					
					//System.out.println(booksInfoAll);
					//通过数组进行信息展示废弃次方法的展示
						
					
				}
				
			}

		}catch(ParserConfigurationException pars){
			
			pars.printStackTrace();
			
		}catch(SAXException sax){
			
			sax.printStackTrace();
			
		}catch(IOException ioe){
			
			ioe.printStackTrace();
		}
		
		//返回整个书籍列表的字典
		//返回值在这
	}
	public void justShowInfo(){
		DocumentBuilderFactory documentBuilder = DocumentBuilderFactory.newInstance();
		


	
		
		try{
			
			DocumentBuilder builder = documentBuilder.newDocumentBuilder();
			
			document = builder.parse("Novel.xml");
			
			NodeList nodelist = document.getElementsByTagName("Book");
			
			for(int i = 0 ;i < nodelist.getLength(); i++){
				
				Node bookNode = nodelist.item(i);
				
				Element books = (Element)bookNode;
				
				//System.out.println((i+1)+":"+books.getAttribute("Type"));
				//通过字典进行了存储值得操作，废弃此信息展示
				
				String type = books.getAttribute("Type");
				//从xml中取出的书的类型名称
				//

				//每次循环都会将主书籍类型加入到数组列表中
				//
				NodeList booksSub = books.getElementsByTagName("book");
				
				for (int j = 0; j< booksSub.getLength();j++){
					
					Node booksSubNode = booksSub.item(j);
					
					Element booksEle = (Element)booksSubNode;
					
					String booksAllInfo = "类型:"+type+"\t名称:"+booksEle.getAttribute("name")+
							"\t"+"作者:"+booksEle.getAttribute("author")+
							"\t"+"描述:"+booksEle.getAttribute("description");
					//将要把当前类型书籍下的书名及相关信息放入到数组列表中以便后续使用
					
					
					System.out.println(booksAllInfo);
					
					//System.out.println(booksInfoAll);
					//通过数组进行信息展示废弃次方法的展示
						
					
				}
			}
			
			
		}catch(ParserConfigurationException pars){
			
			pars.printStackTrace();
			
		}catch(SAXException sax){
			
			sax.printStackTrace();
			
		}catch(IOException ioe){
			
			ioe.printStackTrace();
		}
		
		//返回整个书籍列表的字典
		//返回值在这
	}
	
	
	public ArrayList<String[]> getBookBasicInfoAll() {
		return bookBasicInfoAll;
	}

	public void setBookBasicInfoAll(ArrayList<String[]> bookBasicInfoAll) {
		this.bookBasicInfoAll = bookBasicInfoAll;
		//这里得传入数组列表
	}

	public String[] addEle(){
		//这的数组不可动
		//返回的数组保存的是文件的信息
		String basicAddInfo[] = new String[3];
		
		Scanner Input = new Scanner(System.in);
		System.out.println("---------------------------------------");
		System.out.println("正在进行相应的书籍的添加");
		//可能会进行相应的模式匹配操作
		System.out.print("请输入书的类型:");
		String tempType = Input.next(); 
		basicAddInfo[0] = tempType;
		//书的类型
		Element Book = document.createElement("Book");
		System.out.println("---------------------------------------");
		System.out.print("请输入作者:");
		
		String tempBookAuthor = Input.next();
		basicAddInfo[1] = tempBookAuthor;
		//作者信息
		Element books = document.createElement("book");
		
		books.setAttribute("author", tempBookAuthor);
		
		Book.setAttribute("Type",tempType);
		
		System.out.println("---------------------------------------");
		System.out.print("请输入书的名称:");
		
		String tempBookName = Input.next();
		basicAddInfo[2] = tempBookName;
		//书的名称
		
		books.setAttribute("name", tempBookName);
		
		System.out.println("---------------------------------------");
		System.out.print("请输入描述:");
		
		String tempBookDescription = Input.next();
		
		books.setAttribute("description", tempBookDescription);
		
		Book.appendChild(books);
		
		document.getElementsByTagName("Novel").item(0).appendChild(Book);
		//进行分支的添加
		
		System.out.println("---------------------------------------");
		
		return basicAddInfo;
		//进行文件夹的创建
		//返回数组进相应的判断并且进行字符串重组
		//也可能不进行字符串数组重组
	}
	
	public void updateEle(){
		
		NodeList books = document.getElementsByTagName("Book");
		
		for (int i = 0 ;i < books.getLength();i++){
			
			Node BooksEle = books.item(i);
			
			Element bookEle = (Element)BooksEle;
			
			bookEle.setAttribute("ID",i+"");
			
			saveXML();
		}
	}
	
	public void saveXML(){
	
		//直接从Document中进行读取操作进行存储
		TransformerFactory transformerFac = TransformerFactory.newInstance();
		
		transformerFac.setAttribute("indent-number",4);
		
		
		
		try {
			
			Transformer transformer = transformerFac.newTransformer();
			
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			
			DOMSource source = new DOMSource(document);
			
			
			File file = new File("Novel.xml");
		
			StreamResult result = null;
			
				System.out.println("正在存储XML文件");
				result = new StreamResult(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
				
				System.out.println("存储成功");
		

					
					

			 
			
			//以防万一，缩进失效
			
			transformer.transform(source, result);
			
		} catch (TransformerConfigurationException e) {
			
			e.printStackTrace();
		}catch(FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}catch(UnsupportedEncodingException usee){
			usee.printStackTrace();
		}catch(TransformerException tfe){
			tfe.printStackTrace();
		}
		
		
	}

	//保存XML文件模块

	
	
	
	
	
	
	
	
	
	
}
