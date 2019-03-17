
package retbillet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JOptionPane;

public class Retbillet {

    public static int pris;
    public static Vinduer menu = new Vinduer();
    public static LocalDate x = LocalDate.now();
    public static LocalTime y = LocalTime.now();
    
    public static void main(String[] args) throws IOException{
         Admin Montoer = new Admin();
         Users User = new Users();

        
         boolean close = false;

         
         String s = JOptionPane.showInputDialog("pris for alm. billet. \nPriser for oevre "
                 + "billeter er konstant stigning af standard (god + 2, super + 5, ultra + 10) ");
         pris = Integer.parseInt(s);
         while(!close){
         switch(menu.Startmenu()){
             case 0:
                 gaest();
                 break;
             case 1:
                 User.login();
                 if(User.loginstatus()){
                     bruger(User.name,User.getBalance());
                 }
                 User.logOut();
                 break;
             case 2:
                 User.NewUser();
                 break;
             case 3:
                 Montoer.login();
                 if(Montoer.loginstatus()){
                     admin(Montoer.name);
                 }
                 Montoer.logOut();
                 break;
             case 4:
                 close = true;
                 break;
         }
         }
    }
    public static void gaest()throws IOException{
        Billetautomat gaestAuto = new Billetautomat(pris);
        Fileuser log = new Fileuser();
        
        boolean EXIT = false;
        while(!EXIT){
        switch(menu.gaestmenu()){
            case 0:
               int i = menu.indsaetpenge(gaestAuto.getBalance());
               gaestAuto.indsaetPenge(i);
               log.filewrite(x.now()+","+y.getHour()+":"+y.getMinute()+":"+y.getSecond()+","+"1,"+i+",\n");
               break;
            case 1:
                int u = menu.koebbillet(pris,gaestAuto.getBalance());
                gaestAuto.udskrivBillet(u);
                log.filewrite(x.now()+","+y.getHour()+":"+y.getMinute()+":"+y.getSecond()+","+"2,"+u+",\n");
                break;
            case 2:
                EXIT = true;
                log.filewrite(x.now()+","+y.getHour()+":"+y.getMinute()+":"+y.getSecond()+","+"3,"+gaestAuto.getBalance()+",\n");
                break;
        }
        }
    }
     public static void bruger(String name,int balance)throws IOException{
           Billetautomat userAuto = new Billetautomat(pris,balance);
        Fileuser log = new Fileuser();
        
        boolean EXIT = false;
        while(!EXIT){
        switch(menu.usermenu(name)){
            case 0:
               int i = menu.indsaetpenge(userAuto.getBalance());
               userAuto.indsaetPenge(i);
               log.filewrite(x.now()+","+y.getHour()+":"+y.getMinute()+":"+y.getSecond()+","+"1,"+i+",\n");
               break;
            case 1:
                int u = menu.koebbillet(pris,userAuto.getBalance());
                userAuto.udskrivBillet(u);
                log.filewrite(x.now()+","+y.getHour()+":"+y.getMinute()+":"+y.getSecond()+","+"2,"+u+",\n");
                break;
            case 2:
                 int q = menu.indsaetpenge(userAuto.getBalance())*(-1);
                 userAuto.indsaetPenge(q);
                 log.filewrite(x.now()+","+y.getHour()+":"+y.getMinute()+":"+y.getSecond()+","+"3,"+q+",\n");
                break;
            case 3:
                EXIT = true;
                break;
        }
        }
    }
     public static void admin(String name)throws IOException{
         Billetautomat adminAuto = new Billetautomat(pris);
         Fileuser log = new Fileuser();
         boolean EXIT = false;
         while(!EXIT){
         switch(menu.Adminmenu(name)){
             case 0:
                     JOptionPane.showMessageDialog(null, log.readfilelog());
                     break;
             case 1:
                     String s = JOptionPane.showInputDialog("pris for alm. billet. \nPriser for oevre "
                     + "billeter er konstant stigning af standard (god + 2, super + 5, ultra + 10) ");
                     pris = Integer.parseInt(s);
                     break;
             case 2:
                      String v = JOptionPane.showInputDialog("For hvilken dato? Format: yyyy-mm-dd");
                      JOptionPane.showMessageDialog(null, log.LogDate(v));
                      break;
             case 3:
                 adminAuto.almbillet();
                 adminAuto.godbillet();
                 adminAuto.superbillet();
                 adminAuto.ultrabillet();
                 
             case 4:
                 EXIT = true;
                 break;
         }
         }
     }
 
}

