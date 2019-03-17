
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
   public String LogDate(String s)throws IOException{
       BufferedReader lag = new BufferedReader(new FileReader(path+filename));
       StringBuilder b = new StringBuilder();
       String temp = lag.readLine();
       while(temp != null){
           StringTokenizer g = new StringTokenizer(temp,"(,)");
           String temp2 = g.nextToken();
           if(temp2.equals(s)){
               b.append(temp2+" "+g.nextToken()+" ");
               int d = Integer.parseInt(g.nextToken());
               String temp3 = Hdecode(d);
               b.append(temp3);
               if(d == 2){
                   String temp4 = Bdecode(Integer.parseInt(g.nextToken()));
                   b.append(temp4);
               }else{
                   b.append(g.nextToken());
               }
              b.append("\n");
           }
           temp = lag.readLine();
       }
       if(!b.toString().equals("")){
           return b.toString();
       }else{
           return "Ingen log for denne dato";
       }
   }
   public String LogHandL(int i)throws IOException{
        BufferedReader lag = new BufferedReader(new FileReader(path+filename));
        StringBuilder b = new StringBuilder();
        String temp = lag.readLine();
        while(temp != null){
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
        if(!b.toString().equals("")){
           return b.toString();
       }else{
           return "Ingen log for denne handling";
       }
        
   }
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
   public String Bdecode(int i){
       switch(i){
           case 1:
               return "alm billet";
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
