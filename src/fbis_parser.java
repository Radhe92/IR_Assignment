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

public class fbis_parser {

	public static void main (String args[]) throws IOException
	{
	
		List<String> folder_Names = new ArrayList<>();
	    try {
	      DirectoryStream<Path> directoryStreams = Files.newDirectoryStream(Paths.get("/Users/radheshyamyadav/Desktop/IR_Assignment_2/Assignment_Two/fbis"));
	      for (Path paths : directoryStreams) {
	    	  folder_Names.add(paths.toString());
		        
		        System.out.println("File name:"+paths.toString());
	      
		    
	 File file = new File(paths.toString());
	
	Document doc = Jsoup.parse(file, "UTF-8", "");
	   
	doc.select("docid").remove();
    //doc.select("tablerow").remove();
    //doc.select("table").remove();
    //doc.select("tablecell").remove();
    //doc.select("rowrule").remove();
    //doc.select("cellrule").remove();
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
    		String Headline = e.getElementsByTag("Header").text();
    		String Date = e.getElementsByTag("Date").text();
    		

    			System.out.println(DocNo + ":   ");
			System.out.println("Headline" + ":   " + Headline);
			System.out.println("Date" + ":   " + Date);
			System.out.println("TextContent" + ":   " + TextContent);
			
			 
			
			File result = new File("/Users/radheshyamyadav/eclipse-workspace/IR_2/FBIS_DOC/"+DocNo);
            PrintWriter writer = new PrintWriter(result, "UTF-8");
			writer.println(DocNo + '\n'+ Headline +'\n'+ Date + '\n'+ TextContent+'\n');
             writer.close();
         
    }
	      }
		    } catch (IOException ex) {
		    }
		    System.out.println("File Count:"+folder_Names.size());             

	      }
    	 	      }


