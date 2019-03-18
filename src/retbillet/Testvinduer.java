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
public class Testvinduer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vinduer f = new Vinduer();
        f.Startmenu();
        f.Adminmenu("sven");
        f.gaestmenu();
       // f.indsaetpenge();
        f.usermenu("bob");
      //  f.koebbillet(20);
    }
    
}
