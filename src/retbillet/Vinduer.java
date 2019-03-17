/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retbillet;
import javax.swing.JOptionPane;
/**
 *
 * @author phill
 */
public class Vinduer {
    public Vinduer(){
        
    }
    public int Startmenu(){
        String[] options = {"Gaest","Login som bruger","Lav en bruger","Admin"};
        int x = JOptionPane.showOptionDialog(null, "Velkommen til billetautomaten!",
                "vaelg en handling:",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        return x;
    }
    public int gaestmenu(){
        String[] options = {"indsaet penge","koeb billet","tilbage"};
        int x = JOptionPane.showOptionDialog(null, "Du er altid en velkommen gaest",
                "vaelg en handling:",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        return x;
    }
    public int indsaetpenge(){
        String s = JOptionPane.showInputDialog("Hvor mange penge vil du saette ind?");
        return Integer.parseInt(s);
    }
    public int koebbillet(int pris){
         String[] options = {"alm. billet: "+pris+" kr","god billet "+(pris+2)+" kr","super billet "+(pris+5)+" kr","ultra billet "+(pris+10)+" kr","tilbage"};
        int x = JOptionPane.showOptionDialog(null, "hvad billet kunne du taenke dig",
                "vaelg en handling:",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        return x;
    }
    public int usermenu(String navn){
       String[] options = {"indsaet penge","koeb billet","Udebetal penge","Log ud"};
        int x = JOptionPane.showOptionDialog(null, "Hej "+navn,
                "vaelg en handling:",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        return x; 
    }
    public int Adminmenu(String navn){
         String[] options = {"Print log","indstil pris","Log efter beloeb","Log efter tid","tilbage"};
        int x = JOptionPane.showOptionDialog(null, "Hej "+navn,
                "vaelg en handling:",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        return x; 
    }
}
