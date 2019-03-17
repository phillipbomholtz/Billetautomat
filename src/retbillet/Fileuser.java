
package retbillet;
import java.io.FileWriter; 
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.StringTokenizer;

/**
 *
 * @author phill
 */
public class Fileuser  {
    private String filename;
    private String path;
    private boolean filecheck = true;
    private String searchstring;
   
   
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
       System.out.println("ERROR: file not to be accesed! behaves as if empty");
       return true;
       }
   }
   public int fileSearchUser(String USERNAME, String PASSWORD)throws IOException{
      BufferedReader search = new BufferedReader(new FileReader(path+filename));
      String tempUser;
      String tempPass;
      searchstring = search.readLine();
      while(searchstring != null){
          StringTokenizer tok = new StringTokenizer(searchstring,"(,)");
          tempUser = tok.nextToken();
          tempPass = tok.nextToken();
          if(tempUser.equals(USERNAME)){
           if(tempPass.equals(PASSWORD)){
               return 1;
           }
           return 0;
       }
         searchstring = search.readLine();
      }
       return -1;
   }
   
   public int userBalance(){
       StringTokenizer tok = new StringTokenizer(searchstring,"(,)");
       tok.nextToken(); tok.nextToken();
       
       return Integer.parseInt(tok.nextToken());
   }
   public void LogDate(String s)throws IOException{
       BufferedReader lag = new BufferedReader(new FileReader(path+filename));
       String temp = lag.readLine();
       while(temp != null){
           StringTokenizer tok = new StringTokenizer(temp,"(,)");
       }
       
   }
}
