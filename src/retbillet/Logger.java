/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retbillet;
import java.io.FileWriter; // JAVA says this is conflicting...why?
import java.io.IOException;
import java.io.BufferedWriter;

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
  }
  
  //custom path and filename
  public Logger(String a,String b)throws IOException{
      filename = a;
      path = b;
  }
 
  //write to file
   public void filewrite(String a)throws IOException{
       BufferedWriter log = new BufferedWriter(new FileWriter(path+filename));
       log.write(a);
       log.close();
   }
}
