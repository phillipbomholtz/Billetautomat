
package retbillet;
//imprts
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JOptionPane;

public class Retbillet {

    public static int pris;                                                     //ticket price
    public static Vinduer menu = new Vinduer();                                 //new vinduer object
    //time and date variables
    public static LocalDate x = LocalDate.now();
    public static LocalTime y = LocalTime.now();
    
    public static void main(String[] args) throws IOException{
         Admin Montoer = new Admin();                                           //new admin object
         Users User = new Users();                                              //new user object
         boolean close = false;                                                 //close state

         //set ticet price on open
         String s = JOptionPane.showInputDialog("pris for alm. billet. \nPriser for oevre "
                 + "billeter er konstant stigning af standard (god + 2, super + 5, ultra + 10) ");
         pris = Integer.parseInt(s);
         
         //loop start menu
         while(!close){
         switch(menu.Startmenu()){
             case 0:
                 gaest(); 
                 break;
             case 1:
                 User.login();                                                  //user funtion call
                 if(User.loginstatus()){                                        //if logged in
                     bruger(User.name,User.getBalance());                       //pass to next menu with user info
                 }
                 User.logOut();                                                 //log user out
                 break;
             case 2:
                 User.NewUser();                                                //create new user
                 break;
             case 3:
                 Montoer.login();                                               //admin log in
                 if(Montoer.loginstatus()){                                     //if logged in
                     admin(Montoer.name);                                       //pass to next menu with admin info
                 }
                 Montoer.logOut();                                              //log admin out
                 break;
             case 4:
                 close = true;                                                  //close program
                 break; 
         }
         }
    }
    public static void gaest()throws IOException{
        Billetautomat gaestAuto = new Billetautomat(pris);                      //new Billetautomat
        Fileuser log = new Fileuser();                                          //logger
        
        boolean EXIT = false;                                                   //exitstatus
        while(!EXIT){
        switch(menu.gaestmenu()){
            case 0:
               int i = menu.indsaetpenge(gaestAuto.getBalance());               //load input
               gaestAuto.indsaetPenge(i);                                       //add to balance of Billetautomat
               //log action
               log.filewrite(x.now()+","+y.getHour()+":"+y.getMinute()+":"+y.getSecond()+","+"1,"+i+",\n");
               break;
            case 1:
                int u = menu.koebbillet(pris,gaestAuto.getBalance());           //load input
                gaestAuto.udskrivBillet(u);                                     //print ticket
                //log action
                log.filewrite(x.now()+","+y.getHour()+":"+y.getMinute()+":"+y.getSecond()+","+"2,"+(u+1)+",\n");
                break;
            case 2:
                EXIT = true;                                                    //exit
                //log action
                log.filewrite(x.now()+","+y.getHour()+":"+y.getMinute()+":"+y.getSecond()+","+"3,"+gaestAuto.getBalance()+",\n");
                break;
        }
        }
    }
     public static void bruger(String name,int balance)throws IOException{
        Billetautomat userAuto = new Billetautomat(pris,balance);               //new Billetautomat with start balance
        Fileuser log = new Fileuser();                                          //logger
        
        boolean EXIT = false;                                                   //exitstatus
        while(!EXIT){
        switch(menu.usermenu(name)){
            case 0:
               int i = menu.indsaetpenge(userAuto.getBalance());                //load input
               userAuto.indsaetPenge(i);                                        //add to balance of Billetautomat
               //log action
               log.filewrite(x.now()+","+y.getHour()+":"+y.getMinute()+":"+y.getSecond()+","+"1,"+i+",\n");
               break;
            case 1:
                int u = menu.koebbillet(pris,userAuto.getBalance());            //load input
                userAuto.udskrivBillet(u);                                      //print ticket
                //log action
                log.filewrite(x.now()+","+y.getHour()+":"+y.getMinute()+":"+y.getSecond()+","+"2,"+u+",\n");
                break;
            case 2:
                 int q = menu.indsaetpenge(userAuto.getBalance())*(-1);         //load input
                 userAuto.indsaetPenge(q);                                      //subtract from balance of Billetautomat
                 //log action
                 log.filewrite(x.now()+","+y.getHour()+":"+y.getMinute()+":"+y.getSecond()+","+"3,"+q+",\n");
                break;
            case 3:
                EXIT = true;                                                    //exit
                break;
        }
        }
    }
     public static void admin(String name)throws IOException{
         Billetautomat adminAuto = new Billetautomat(pris);                     //new Billetautomat
         Fileuser log = new Fileuser();                                         //logger
         boolean EXIT = false;                                                  //exitstatus
         while(!EXIT){
         switch(menu.Adminmenu(name)){
             case 0:
                     JOptionPane.showMessageDialog(null, log.readfilelog());    //print log
                     break;
             case 1:
                     String s = JOptionPane.showInputDialog("pris for alm. billet. \nPriser for oevre "
                     + "billeter er konstant stigning af standard (god + 2, super + 5, ultra + 10) ");
                     pris = Integer.parseInt(s);                                //set price
                     break;
             case 2:
                      String v = JOptionPane.showInputDialog("For hvilken dato? Format: yyyy-mm-dd");
                      JOptionPane.showMessageDialog(null, log.LogDate(v));      //print log of date
                      break;
             case 3:
                 //print tickets
                 adminAuto.almbillet();
                 adminAuto.godbillet();
                 adminAuto.superbillet();
                 adminAuto.ultrabillet();
                 
             case 4:
                 EXIT = true;                                                   //exit
                 break;
         }
         }
     }
 
}

