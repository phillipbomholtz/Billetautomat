
package retbillet;
import javax.swing.JOptionPane; //user interface class
/**
 *
 * @author       Phillip Bomholtz
 * created:      17-03-2019
 * Last opdate:  -||-
 * just a colection of user interface windows
 */
public class Vinduer {
    public Vinduer(){
        
    }
    
    //menu on layer 1
    public int Startmenu(){
        String[] options = {"Gaest","Login som bruger","Lav en bruger","Admin","close"};
        int x = JOptionPane.showOptionDialog(null, "Velkommen til billetautomaten!",
                "vaelg en handling:",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        return x;
    }
    //menu on layer 2
    public int gaestmenu(){
        String[] options = {"indsaet penge","koeb billet","tilbage"};
        int x = JOptionPane.showOptionDialog(null, "Du er altid en velkommen gaest",
                "vaelg en handling:",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        return x;
    }
    //menu on layer 3
    public int indsaetpenge(int balance){
        String s = JOptionPane.showInputDialog("Hvor mange penge vil du saette ind? Nuvaerende balance: "+balance);
        return Integer.parseInt(s);
    }
    //menu on layer 3
    public int koebbillet(int pris,int balance){
         String[] options = {"alm. billet: "+pris+" kr","god billet "+(pris+2)+" kr","super billet "+(pris+5)+" kr","ultra billet "+(pris+10)+" kr","tilbage"};
        int x = JOptionPane.showOptionDialog(null, "hvad billet kunne du taenke dig? balance: "+balance,
                "vaelg en handling:",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        return x;
    }
    //menu on layer 2
    public int usermenu(String navn){
       String[] options = {"indsaet penge","koeb billet","Udebetal penge","Log ud"};
        int x = JOptionPane.showOptionDialog(null, "Hej "+navn,
                "vaelg en handling:",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        return x; 
    }
    //menu on layer 2
    public int Adminmenu(String navn){
         String[] options = {"Print log","indstil pris","Log efter Dato","Log ud"};
        int x = JOptionPane.showOptionDialog(null, "Hej "+navn,
                "vaelg en handling:",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        return x; 
    }
    //menu on layer 3
    public String Admindato(){
        String s = JOptionPane.showInputDialog("For hvad dato? (format: yyyy-mm-dd");
        return s; 
    }
    //menu on layer 4
    public int AdminHandl(){
         String[] options = {"Indsaet","BilletPrint","Retur","tilbage"};
        int x = JOptionPane.showOptionDialog(null, "hvad handling ledes der efter? (virker ikke)",
                "vaelg en handling:",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        return x+1; 
    }
}
