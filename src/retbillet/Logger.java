
package retbillet;
import java.io.FileWriter; 
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

/**
 *
 * @author phill
 */
public class Logger  {
    private String filename;
    private String path;
   
    // basic constructer that assigns filename and path
  public Logger() throws IOException{
      filename = "BilletLog.txt";
      path = "c:/temp/";
      File temp = new File(path+filename);
      
  }
  
  //custom path and filename
  public Logger(String a,String b)throws IOException{
      filename = a;
      path = b;
      File temp = new File(path+filename);
  }
 
  //write to file
   public void filewrite(String a)throws IOException{
       BufferedWriter log = new BufferedWriter(new FileWriter(path+filename,true));
       log.append(a+"\n");
       log.close();
   }
   public void readfile()throws IOException{
       BufferedReader lag = new BufferedReader(new FileReader(path+filename));
       String line = lag.readLine();
       while(line != null){
           System.out.println(line);
           line = lag.readLine();
       }
   }
}
