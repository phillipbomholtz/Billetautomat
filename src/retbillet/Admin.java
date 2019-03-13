
package retbillet;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author phill
 */
public class Admin {
    private String name;
    private String code;
    private Fileuser adminusers = new Fileuser("c:/temp/", "Admins.txt");
    private boolean x = false;
    
    public Admin()throws IOException{   
        if(!adminusers.readfile()){
            NewAdmin();
        }
    }
    public void NewAdmin()throws IOException{
        Scanner tas = new Scanner(System.in);
        System.out.println("this looks like the first time im being installed!");
        System.out.println("you are going to be the first admin of this machine. please enter username below:");
        name = tas.next();
        System.out.println("thank you! now please enter a password for this account");
        code = tas.next();
        adminusers.filewrite(name+","+code);
    }
    public void login(String a, String b){
        if(a.equals(name) && b.equals(code)){
            System.out.println("welcome " + name);
            x = true;
        }else{
            System.out.println("YOU ARE NOT AN ADMIN! ;:( ");
            x = false;
        }
    }
    public boolean loginstatus(){
        return x;
    }
}
