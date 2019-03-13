
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
public class Fileuser  {
    private String filename;
    private String path;
   
   
    // basic constructer that assigns filename and path
  public Fileuser() throws IOException{
      filename = "BilletLog.txt";
      path = "c:/temp/";
      File temp = new File(path+filename); //makes sure file exist
      
  }
  
  //custom path and filename
  public Fileuser(String a,String b)throws IOException{
      filename = a;
      path = b;
      File temp = new File(path+filename); // makes sure file exist
  }

  //write to file
   public void filewrite(String s)throws IOException{
       BufferedWriter log = new BufferedWriter(new FileWriter(path+filename,true));
       log.append(s+"\n");
       log.close();
   }
   public boolean readfile()throws IOException{
       BufferedReader lag = new BufferedReader(new FileReader(path+filename));
       boolean ifempty = true;
       String line = lag.readLine();
       while(line != null){
           System.out.println(line);
           line = lag.readLine();
           ifempty = false;
       }
       return ifempty;
   }
}
