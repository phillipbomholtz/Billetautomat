
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
    private Fileuser adminusers = new Fileuser("c:/temp/","Admins.txt");
    private boolean x = false;
    
    public Admin()throws IOException{   
        if(!adminusers.readfile()){
            System.out.println("Ingen kendte admins! Der skal laves en admin nu:");
            NewAdmin();
        }
    }
    public void NewAdmin()throws IOException{
        Scanner tas = new Scanner(System.in);
        System.out.println("Indsaet brugernavn:");
        name = tas.next();
        System.out.println("Tak! Indsæt password for denne admin acount");
        code = tas.next();
        adminusers.filewrite(name+","+code);
    }
    public void login()throws IOException{
        Scanner tas = new Scanner(System.in);
        System.out.println("Brugernavn:");
        String a = tas.next();
         System.out.println("Password:");
        String b = tas.next();
        
        switch(adminusers.fileSearchUser(a,b)){
            case 1:
               System.out.println("Velkommen " + name);
               x = true;  
               break;
            case 0:
               System.out.println("Bruger fundet, men forkert password");
               x = false;
                break;
            case -1:
               System.out.println("Ukendt bruger");
                x = false;
                break;
        }
        
    }
    public boolean loginstatus(){
        return x;
    }
}
