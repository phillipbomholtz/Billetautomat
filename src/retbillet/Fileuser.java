
package retbillet;
import java.io.FileWriter;        //needed for file coms (outgoing)
import java.io.IOException;       //exceptions for when something goes wrong
import java.io.BufferedWriter;    //for writing to file
import java.io.BufferedReader;    //for reading file
import java.io.FileReader;        //needed for file coms (ingoing)
import java.io.File;              //for creating file
import java.util.StringTokenizer; //for reading , seperated files

/**
 *
 * @author          Phillip Bomholtz
 * Created:         unknown
 * Last updated:    17-03-2019
 * function:        Reading and writing text files in billetautomat project 
 */
public class Fileuser  {
    private String filename;          //name of file (format #name#.txt)
    private String path;              //path to file (format #drive#/.../)
    private boolean filecheck = true; //logic for determining that a file is accesable (true if yes)
    private String searchstring;      //used when searching for users

   
    // basic constructer that assigns filename and path
  public Fileuser(){
      filename = "BilletLog.txt";  
      path = "c:/temp/";
      
      //makes sure file exist
      try{
      File temp = new File(path+filename); 
      if(temp.createNewFile()){
          System.out.println("Success in creating file: "+path+filename);
      }else{
          System.out.println("Found file: "+path+filename);
      }
      //if something goes wrong
      }catch(IOException e){
          System.out.println("ERROR: could not find nor create file");
          System.out.println(e);
          filecheck = false;  //file is not accesable
      }
  }
  
  //custom path and filename input (PATH , FILENAME)
  public Fileuser(String a,String b){
      filename = b;
      path = a;
      
      //makes sure file exist
      try{
      File temp = new File(path+filename); 
      if(temp.createNewFile()){
          System.out.println("Success in creating file: "+path+filename);
      }else{
          System.out.println("Found file: "+path+filename);
      }
      //if something goes wrong
      }catch(IOException e){
          System.out.println("ERROR: could not find nor create file");
          System.out.println(e);
          filecheck = false;
      }
  }

  //write to file
   public void filewrite(String s)throws IOException{
       //only if file is accesable
       if(filecheck){
       BufferedWriter log = new BufferedWriter(new FileWriter(path+filename,true)); //create a writer to the current file
       
       log.append(s+"\r\n"); //write to file 
       log.close();          //close file
       }else{
           System.out.println("ERROR: file cannot be accesed!");
       }
   }
   
   //simple funktion for reading a file and writing. is also used to check if file is empty
   public boolean readfile()throws IOException{
       //only if file is accessable
       if(filecheck){
        BufferedReader lag = new BufferedReader(new FileReader(path+filename));  //create a reader for file                
        
       boolean ifempty = true;         //if file is empty
       String line = lag.readLine();   //read line
       while(line != null){            //stop when no more is in the file
           System.out.println(line);   
           line = lag.readLine();      //read line
           ifempty = false;            //file is not empty
       }
       return ifempty;                 //return file state
       }else{
       System.out.println("ERROR: file not to be accesed! behaves as if empty");
       return true;                    //return file state
       }
   }
   
   //function for reading a log as a "," seperated file of format: #DATE#,#TIME#,#OPERATION#,#VALUE#,
   public String readfilelog()throws IOException{
        BufferedReader lag = new BufferedReader(new FileReader(path+filename)); //create reader for file
        StringBuilder b = new StringBuilder();                                  //builder for stringing together larger string
       String line = lag.readLine();                                            //read line

       while(line != null){                                                     //so long as file is not empty
           if(!line.equals("")){                                                //filter out empty but existing entrys
           StringTokenizer tok = new StringTokenizer(line,"(,)");               //tokenizer for reading "," seperated file
           b.append(tok.nextToken()+" "+tok.nextToken()+" ");                   //add date and time
           int d = Integer.parseInt(tok.nextToken());                           //read operation as int
               String temp = Hdecode(d);                                        //decode operation
               b.append(temp);                                                  //add operation
               if(d == 2){                                                      //if operation was a ticket buy
                   String temp4 = Bdecode(Integer.parseInt(tok.nextToken()));   //decode what ticket was bought
                   b.append(temp4);                                             //add ticket
               }else{
                   b.append(tok.nextToken());                                   //add value
               }
              b.append("\n");                                                   //add newline
           }
           line = lag.readLine();                                               //read line
       }
       return b.toString();                                                     //return log as one string
   }
   
   //function for searching after a user.
   public int fileSearchUser(String USERNAME, String PASSWORD)throws IOException{
      BufferedReader search = new BufferedReader(new FileReader(path+filename));//create reader for file
      String tempUser;                                                          //temp. stored user
      String tempPass;                                                          //temp stored password
      
      searchstring = search.readLine();                                         //read to searchstring
      while(searchstring != null){                                              //so long file is not empty
          StringTokenizer tok = new StringTokenizer(searchstring,"(,)");        //tokenizer for reading "," seperated file
          tempUser = tok.nextToken();                                           //load in user
          tempPass = tok.nextToken();                                           //load in password
          if(tempUser.equals(USERNAME)){
           if(tempPass.equals(PASSWORD)){
               return 1;                                                        //return 1 if succesful login
           }
           return 0;                                                            //return 0 if known user
       }
         searchstring = search.readLine();                                      //read new line
      }
       return -1;                                                               //failed login
   }
   
   //reading balance of a user
   public int userBalance(){
       StringTokenizer tok = new StringTokenizer(searchstring,"(,)");           //tokenizer for reading "," seperated file
       tok.nextToken(); tok.nextToken();                                        //dismiss first two tokes
       
       return Integer.parseInt(tok.nextToken());                                //return balance
   }
   
   //read log for date
   public String LogDate(String s)throws IOException{
       BufferedReader lag = new BufferedReader(new FileReader(path+filename));  //create a reader for file
       StringBuilder b = new StringBuilder();                                   //builde for building string
       String temp = lag.readLine();                                            //read line
       
       while(temp != null){                                                     //so long as file is not empty
           
           if(!temp.equals("")){                                                //filter out empty but existing space
           StringTokenizer g = new StringTokenizer(temp,"(,)");                 //tokenizer for reading "," seperated file
           String temp2 = g.nextToken();                                        //temp store Date token
           if(temp2.equals(s)){                                                 //check if wanted token
               b.append(temp2+" "+g.nextToken()+" ");                           //add date and time
               int d = Integer.parseInt(g.nextToken());                         //check operation
               String temp3 = Hdecode(d);                                       //decode operation
               b.append(temp3);                                                 //add operation
               if(d == 2){                                                      //if operation was a ticket buy
                   String temp4 = Bdecode(Integer.parseInt(g.nextToken()));     //decode operation
                   b.append(temp4);                                             //add ticket type
               }else{
                   b.append(g.nextToken());                                     //add value
               }
              b.append("\n");                                                   //add newline
           }
           }
           temp = lag.readLine();                                               //read line
       }
       if(!b.toString().equals("")){                                            //check if empty
           return b.toString();                                                 //return string
       }else{
           return "Ingen log for denne dato";                                   //return string
       }
   }
   
   //BROKEN!!! DO NOT USE
   public String LogHandL(int i)throws IOException{
        BufferedReader lag = new BufferedReader(new FileReader(path+filename));
        StringBuilder b = new StringBuilder();
        String temp = lag.readLine();
        while(temp != null){
            if(!temp.equals("")){
            StringTokenizer g = new StringTokenizer(temp,"(,)");
            g.nextToken();g.nextToken();
            if(Integer.parseInt(g.nextToken())==i){
                 StringTokenizer o = new StringTokenizer(temp,"(,)");
                 b.append(o.nextToken()+" "+o.nextToken()+" ");
                 int d = Integer.parseInt(o.nextToken());
                 String temp2 = Hdecode(d);
                 b.append(temp2);
                if(d == 2){
                   String temp3 = Bdecode(Integer.parseInt(o.nextToken()));
                   b.append(temp3);
               }else{
                   b.append(o.nextToken());
               }
              b.append("\n");
            }
            }
        }
        if(!b.toString().equals("")){
           return b.toString();
       }else{
           return "Ingen log for denne handling";
       }
        
   }
   
   //for decoding an operation
   public String Hdecode(int i){
       switch(i){
           case 1:
               return "Beloeb indsat(kr): ";
           case 2:
               return "Der blev koebt en ";
           case 3:
               return "beloeb returneret(kr): ";
               
       }
       return "";
   }
   
   //decode ticket
   public String Bdecode(int i){
       switch(i){
           case 1:
               return "alm. billet";
           case 2:
               return "god billet";
           case 3:
               return "super billet";
           case 4:
               return "ultra billet";
               
       }
       return "";
   }
}
