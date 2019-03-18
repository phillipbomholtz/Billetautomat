
package retbillet;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author       Phillip Bomholtz
 * created:      unknown
 * last updated: 17-03-2019
 * for users functions
 */
public class Admin {
    protected String name;                                                      //admin name
    private String code;                                                        //admin code
    private Fileuser adminusers = new Fileuser("c:/temp/","Admins.txt");        //admin fileuser
    private boolean x = false;                                                  //loginstatus
    
    public Admin()throws IOException{   
        //check if there are no admins. if there aren't, create one.
        if(adminusers.readfile()){
            JOptionPane.showMessageDialog(null,"Der er ingen kendte admins... opretter");
            NewAdmin();
        }
    }
    //create new admin
    public void NewAdmin()throws IOException{
        name = JOptionPane.showInputDialog("Indtast brugernavn");               //GUI username input
        code = JOptionPane.showInputDialog("Indtast password");                 //GUI password input
        adminusers.filewrite(name+","+code+",");                                //write to file
    }
    //log admin in from file database
    public void login()throws IOException{
        String a = JOptionPane.showInputDialog("Indtast brugernavn");
        String b = JOptionPane.showInputDialog("Indtast password");
        
        //login state check
        switch(adminusers.fileSearchUser(a,b)){
            case 1:
               JOptionPane.showMessageDialog(null,"Velkommen " + a);
               x = true;  
               name = a;
               code = b;
               break;
            case 0:
               JOptionPane.showMessageDialog(null,"Bruger fundet, men forkert password");
               x = false;
                break;
            case -1:
               JOptionPane.showMessageDialog(null,"Ukendt bruger");
                x = false;
                break;
        }
        
    }
    //logout of admin account
    public void logOut(){
        x = false;
    }
    //check loginstatus
    public boolean loginstatus(){
        return x;
    }
}
