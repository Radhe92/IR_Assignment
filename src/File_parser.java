
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

public class File_parser {
	// FOR LATIMES 
	
	public static void main (String args[]) throws IOException
	{
	
		List<String> fileNames = new ArrayList<>();
	    try {
	      DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get("/Users/radheshyamyadav/Desktop/IR_Assignment_2/Assignment_Two/latimes"));
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
    		String Correction = e.getElementsByTag("Correction").text();
    		String Headline = e.getElementsByTag("Headline").text();
    		String Subject = e.getElementsByTag("Subject").text();
    		String Type = e.getElementsByTag("Type").text();

    		System.out.println(DocNo + ":   ");
			System.out.println("Headline" + ":   " + Headline);
			System.out.println("TextContent" + ":   " + TextContent);
			System.out.println("ByLine" + ":   " + ByLine);
			System.out.println("Subject" + ":   " + Subject);
			System.out.println("Correction" + ":   " + Correction);
			System.out.println("Type" + ":   " + Type); 
			
			File result = new File("/Users/radheshyamyadav/eclipse-workspace/IR_2/IA_DOC/"+DocNo);
            PrintWriter writer = new PrintWriter(result, "UTF-8");
			writer.println(DocNo + '\n'+ Headline + '\n'+ TextContent+'\n'+ ByLine + '\n'+ Subject + '\n'+ Correction + '\n' + Type);
             writer.close();
         
    }
	      }
		    } catch (IOException ex) {
		    }
		    System.out.println("File Count:"+fileNames.size());             
}
}

	


