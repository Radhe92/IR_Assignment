import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ft_parser {

	public static void main (String args[]) throws IOException
	{
	
		List<String> folder_Names = new ArrayList<>();
	    try {
	      DirectoryStream<Path> directoryStreams = Files.newDirectoryStream(Paths.get("/Users/radheshyamyadav/Desktop/IR_Assignment_2/Assignment_Two/ft"));
	      for (Path paths : directoryStreams) {
	    	  folder_Names.add(paths.toString());
		        
		        System.out.println("File name:"+paths.toString());
	      
		
		
		
		List<String> fileNames = new ArrayList<>();
	    try {
	      DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(paths.toString()));
	      for (Path path : directoryStream) {
	        fileNames.add(path.toString());
	        
	        System.out.println("File name:"+path.toString());
	        
	   
	    
	 File file = new File(path.toString());
	//File file = new File("/Users/radheshyamyadav/Desktop/IR_Assignment_2/Assignment_Two/latimes/la010189");
    //System.out.println("The file can be read: " + file.canRead());
	Document doc = Jsoup.parse(file, "UTF-8", "");
	   
	doc.select("docid").remove();
    doc.select("tablerow").remove();
    doc.select("table").remove();
    doc.select("tablecell").remove();
    doc.select("rowrule").remove();
    doc.select("cellrule").remove();
    doc.select("section").remove();
    doc.select("length").remove();
    doc.select("graphic").remove();
    doc.select("docid").remove();
    doc.select("dateline").remove();
    doc.select("date").remove();
    doc.select("correction-date").remove();

  
    Elements docs = doc.select("doc");
    System.out.println(docs.size());

    for (Element e: docs) {
     	String DocNo = e.getElementsByTag("Docno").text();
    		String TextContent = e.getElementsByTag("Text").text();
    		String ByLine = e.getElementsByTag("Byline").text();
    		String Profile = e.getElementsByTag("Profile").text();
    		String Headline = e.getElementsByTag("Headline").text();
    		

    		System.out.println(DocNo + ":   ");
			System.out.println("Headline" + ":   " + Headline);
			System.out.println("TextContent" + ":   " + TextContent);
			System.out.println("ByLine" + ":   " + ByLine);
			System.out.println("Profile" + ":   " + Profile);
			 
			
			File result = new File("/Users/radheshyamyadav/eclipse-workspace/IR_2/FT_DOC/"+DocNo);
            PrintWriter writer = new PrintWriter(result, "UTF-8");
			writer.println(DocNo + '\n'+ Headline + '\n'+ TextContent+'\n'+ ByLine + '\n'+ Profile + '\n');
             writer.close();
         
    }
	      }
		    } catch (IOException ex) {
		    }
		    System.out.println("File Count:"+fileNames.size());             

	      }
    	  
	      }
	    catch (IOException ex) {
	    }
	      
	      }
}

	