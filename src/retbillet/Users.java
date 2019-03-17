
package retbillet;
import java.io.IOException;    
import javax.swing.JOptionPane; //user interface

/**
 *
 * @author       Phillip Bomholtz
 * created:      unknown
 * last updated: 17-03-2019
 * for users functions
 */
public class Users {
    protected String name;                                                      //name of user
    private String code;                                                        //code of user
    private int balance;                                                        //balance of user
    private Fileuser User = new Fileuser("c:/temp/","Users.txt");               //fileuser for user
    private boolean x = false;                                                  //loginstatus true if yes
    
    public Users()throws IOException{

}
    
    //create new user
    public void NewUser()throws IOException{
        name = JOptionPane.showInputDialog("Indtast brugernavn");
        code = JOptionPane.showInputDialog("Indtast password");
        User.filewrite(name+","+code+","+"0,");                                 //send to filewriter with 0 balace
    }
    public void login()throws IOException{
        String a = JOptionPane.showInputDialog("Indtast brugernavn");
        String b = JOptionPane.showInputDialog("Indtast password");
        
        //check how login went
        switch(User.fileSearchUser(a,b)){
            case 1:                                                             //login succes
               JOptionPane.showMessageDialog(null,"Velkommen " + a);
               x = true;  
               name = a;
               code = b;
               break;
            case 0:                                                             //login small falure
               JOptionPane.showMessageDialog(null,"Bruger fundet, men forkert password");
               x = false;
                break;
            case -1:                                                            //login critical falure
               JOptionPane.showMessageDialog(null,"Ukendt bruger");
                x = false;
                break;
        }
        if(x){
            balance = User.userBalance();                                       //check balance of logged in user
        }
        
    }
    //log user out
    public void logOut(){
        x = false;
    }
    //check if logged in
    public boolean loginstatus(){
        return x;
    }
    //check balance
    public int getBalance(){
    return balance;
}
    //add balance
    public void addBalance(int t){
        balance = balance+t;
    }
}
