
package retbillet;

import java.io.IOException;


public class Retbillet {

   
    public static void main(String[] args) throws IOException{
		Billetautomat automat = new Billetautomat(24);
		System.out.println("Installatøren har installeret en ny billetautomat");
		System.out.println();
		System.out.println("En kunde vil købe en billet");
		int pris = automat.getBilletpris();
		System.out.println("Billetprisen er: " + pris + " kroner");
		System.out.println("Kunden putter 24 kroner i automaten");
		automat.indsætPenge(30);
		System.out.println("Balancen er nu på " + automat.getBalance() + " kroner");
		automat.udskrivBillet();
		System.out.println("Balancen er nu på " + automat.getBalance() + " kroner");
                Logger log = new Logger();
    }
    
}
