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
        String[] options = {"indsaet penge","koeb billet"};
        int x = JOptionPane.showOptionDialog(null, "Du er altid en velkommen gaest",
                "vaelg en handling:",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        return x;
    }
}
