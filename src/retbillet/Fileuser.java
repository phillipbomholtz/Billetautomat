
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
    private int buffersize = 100;
    private String[] filewritebuffer = new String[buffersize];
    private int buffercounter = 0;
   
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
  public void addToFile(String s)throws IOException{
      boolean action = false;
      while(action){
      if(buffercounter < buffersize){
          filewritebuffer[buffercounter] = s;
          buffercounter++;
          action = true;
      }else{
          filewrite();
      }
      }
  }
  //write to file
   public void filewrite()throws IOException{
       BufferedWriter log = new BufferedWriter(new FileWriter(path+filename,true));
       for(int i = 0; i <= buffercounter; i++){
       log.append(filewritebuffer[i]+"\n");
       }
       buffercounter = 0;
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
