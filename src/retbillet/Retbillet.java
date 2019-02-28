
package retbillet;

import java.io.IOException;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Retbillet {

    public boolean admin = false;
   
    public static void main(String[] args) throws IOException{
                
		Billetautomat automat = new Billetautomat(24);
                Logger log = new Logger();
                Admin bob = new Admin("bob","Gumpen221");
		Scanner t = new Scanner(System.in);
                Calendar calender = Calendar.getInstance();
                SimpleDateFormat date = new SimpleDateFormat("HH:mm:ss");
                int ch = 0;
                System.out.println("velkommen til billetaoutomaten. hvad er det du vil?");
                while(ch != 4){
                
                System.out.println();
                System.out.println("indtast tal for den handlig du ønsker at fortage dig");
                System.out.println("1: købe en billet");
                System.out.println("2: logge ind som admin");
                System.out.println("3: udskrive log over køb");
                System.out.println("4: exit");
                
                
                ch = t.nextInt();
                switch(ch){
                    case 1:
                        System.out.println("prisen for en billet er "+automat.getBilletpris()+".- indsæt penge:");
                        int a = t.nextInt();
                        automat.indsætPenge(a);
                        System.out.println("Din balance er på: "+automat.getBalance()+" kr");
                        System.out.println("hvor mange billetter ønskes der?");
                        int num = t.nextInt();
                        log.filewrite(date.format(calender.getTime())+"bruger indsatte "+a+" kr");
                        int count = 0;
                        while(automat.getBilletpris() <= automat.getBalance() && num >= count){
                            automat.udskrivBillet();
                            count++;
                        }
                        log.filewrite("der blev udskrevet " +count+ " billete(r)");
                        break;
                    case 2:
                        System.out.println("enter brugernavn: ");
                        String s1 = t.next();
                        System.out.println("enter kode: ");
                        String s2 = t.next();
                        bob.login(s1, s2);
                        break;
                    case 3:
                        if(bob.loginstatus()){
                            log.readfile();
                        }else{
                            System.out.println("erh. u no admin!");
                        }
                    case 4:
                        System.out.println("hav en god rejse, MEN KUN HVIS DU KOEBTE NOGET! ;:(");
                    default:
                        System.out.println("ja...erh... det er en god ide at indtaste en rigtig mulighed");
                }
                } 
    }
    
}
