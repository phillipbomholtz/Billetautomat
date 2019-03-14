
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
    private boolean filecheck = true;
   
   
    // basic constructer that assigns filename and path
  public Fileuser(){
      filename = "BilletLog.txt";
      path = "c:/temp/";
      try{
      File temp = new File(path+filename); //makes sure file exist
      if(temp.createNewFile()){
          System.out.println("Success in creating file: "+path+filename);
      }else{
          System.out.println("Found file: "+path+filename);
      }
      }catch(IOException e){
          System.out.println("ERROR: could not find nor create file");
          System.out.println(e);
          filecheck = false;
      }
  }
  
  //custom path and filename
  public Fileuser(String a,String b){
      filename = b;
      path = a;
      try{
      File temp = new File(path+filename); //makes sure file exist
      if(temp.createNewFile()){
          System.out.println("Success in creating file: "+path+filename);
      }else{
          System.out.println("Found file: "+path+filename);
      }
      }catch(IOException e){
          System.out.println("ERROR: could not find nor create file");
          System.out.println(e);
          filecheck = false;
      }
  }

  //write to file
   public void filewrite(String s)throws IOException{
       if(filecheck){
       BufferedWriter log = new BufferedWriter(new FileWriter(path+filename,true));
       log.append(s+"\r\n");
       log.close();
       }else{
           System.out.println("ERROR: file cannot be accesed!");
       }
   }
   public boolean readfile()throws IOException{
       if(filecheck){
        BufferedReader lag = new BufferedReader(new FileReader(path+filename));
       boolean ifempty = true;
       String line = lag.readLine();
       while(line != null){
           System.out.println(line);
           line = lag.readLine();
           ifempty = false;
       }
       return ifempty;   
       }else{
       System.out.println("ERROR: file not to be accesed! behaves as if empty empty");
       return true;
       }
   }
   public String fileSearch(String s){
       
   }
}
