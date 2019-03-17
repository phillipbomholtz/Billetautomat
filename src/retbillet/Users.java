/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retbillet;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author phill
 */
public class Users {
    private String name;
    private String code;
    private int balance;
    private Fileuser User = new Fileuser("c:/temp/","Users.txt");
    private boolean x = false;
    
    public Users()throws IOException{

}
    public void NewUser()throws IOException{
        name = JOptionPane.showInputDialog("Indtast brugernavn");
        code = JOptionPane.showInputDialog("Indtast password");
        User.filewrite(name+","+code+","+"0,");
        x = true;
    }
    public void login()throws IOException{
        String a = JOptionPane.showInputDialog("Indtast brugernavn");
        String b = JOptionPane.showInputDialog("Indtast password");
        
        switch(User.fileSearchUser(a,b)){
            case 1:
               JOptionPane.showMessageDialog(null,"Velkommen " + a);
               x = true;  
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
        if(x){
            balance = User.userBalance();
        }
        
    }
    public void logOut(){
        x = false;
    }
    public boolean loginstatus(){
        return x;
    }
    public int getBalance(){
    return balance;
}
    public void addBalance(int t){
        balance = balance+t;
    }
}
