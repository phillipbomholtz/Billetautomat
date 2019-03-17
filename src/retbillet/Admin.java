
package retbillet;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author phill
 */
public class Admin {
    protected String name;
    private String code;
    private Fileuser adminusers = new Fileuser("c:/temp/","Admins.txt");
    private boolean x = false;
    
    public Admin()throws IOException{   
        if(adminusers.readfile()){
            JOptionPane.showMessageDialog(null,"Der er ingen kendte admins... opretter");
            NewAdmin();
        }
    }
    public void NewAdmin()throws IOException{
        name = JOptionPane.showInputDialog("Indtast brugernavn");
        code = JOptionPane.showInputDialog("Indtast password");
        adminusers.filewrite(name+","+code+",");
    }
    public void login()throws IOException{
        String a = JOptionPane.showInputDialog("Indtast brugernavn");
        String b = JOptionPane.showInputDialog("Indtast password");
        
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
    public void logOut(){
        x = false;
    }
    public boolean loginstatus(){
        return x;
    }
}
