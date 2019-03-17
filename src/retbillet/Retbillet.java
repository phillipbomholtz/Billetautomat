
package retbillet;

import java.io.IOException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JOptionPane;

public class Retbillet {

    public static int pris;
    public static Vinduer menu = new Vinduer();
   
    public static void main(String[] args) throws IOException{
         Admin Montoer = new Admin();
         Users User = new Users();
         Fileuser log = new Fileuser();
	 LocalDate x = LocalDate.now();
         LocalTime y = LocalTime.now();


         
         String s = JOptionPane.showInputDialog("pris for alm. billet. \nPriser for oevre "
                 + "billeter er konstant stigning af standard (god + 2, super + 5, ultra + 10) ");
         pris = Integer.parseInt(s);

         switch(menu.Startmenu()){
             case 0:
                 gaest();
                 
         }
    }
    public static void gaest(){
        Billetautomat gaestAuto = new Billetautomat(pris);
        boolean EXIT = false;
        while(!EXIT){
        switch(menu.gaestmenu()){
            case 0:
               gaestAuto.indsaetPenge(menu.indsaetpenge());
               break;
            case 1:
                gaestAuto.udskrivBillet(menu.koebbillet(pris));
        }
        }
    }
}
