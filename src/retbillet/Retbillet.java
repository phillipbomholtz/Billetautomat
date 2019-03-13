
package retbillet;

import java.io.IOException;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Retbillet {

    public boolean admin = false;
   
    public static void main(String[] args) throws IOException{
                
		Billetautomat automat = new Billetautomat(24);  //make new billetaoutomat with ticket price of 24 kr
                Fileuser log = new Fileuser();                      //make a new logger with default pathing
                Admin bob = new Admin("bob","Gumpen221");       //make an admin
		Scanner t = new Scanner(System.in);             //just a scanner for keyboard input
                Calendar calender = Calendar.getInstance();     //object for tracking time
                SimpleDateFormat date = new SimpleDateFormat("HH:mm:ss");  //time format
                int ch = 0;                                                //user interface case variable                       
                
                System.out.println("velkommen til billetaoutomaten. hvad er det du vil?");
                while(ch != 4){
                    
                //user interface
                System.out.println();
                System.out.println("indtast tal for den handlig du ønsker at fortage dig");
                System.out.println("1: købe en billet");
                System.out.println("2: logge ind som admin");
                System.out.println("3: udskrive log over køb");
                System.out.println("4: exit");
                
                //user input
                ch = t.nextInt();
                switch(ch){
                    case 1:
                        System.out.println("prisen for en billet er "+automat.getBilletpris()+".- indsæt penge:");
                        //user enters money
                        int a = t.nextInt();
                        automat.indsætPenge(a);
                        System.out.println("Din balance er på: "+automat.getBalance()+" kr");
                        System.out.println("hvor mange billetter ønskes der?");
                        //user chooses how many tickets to buy
                        int num = t.nextInt();
                        log.filewrite(date.format(calender.getTime())+"bruger indsatte "+a+" kr"); //log action
                        
                        int count = 0; //count how many tickets have been printed
                        //print tickets utill wanted amount has been reached or user run out of money in balance
                        while(automat.getBilletpris() <= automat.getBalance() && num >= count){
                            automat.udskrivBillet();
                            count++;
                        }
                        
                        log.filewrite("der blev udskrevet " +count+ " billete(r)"); //log action
                        break;
                    case 2:
                        //admin login interface
                        System.out.println("enter brugernavn: ");
                        String s1 = t.next();
                        System.out.println("enter kode: ");
                        String s2 = t.next();
                        bob.login(s1, s2);  //checks if name and password is correct
                        break;
                    case 3:
                        if(bob.loginstatus()){
                            log.readfile();    //print whole file
                        }else{
                            System.out.println("erh. u no admin!");  //like for real... u no admin
                        }
                        break;
                    case 4:
                        System.out.println("hav en god rejse, MEN KUN HVIS DU KOEBTE NOGET! ;:(");
                        break;
                    default:
                        System.out.println("ja...erh... det er en god ide at indtaste en rigtig mulighed");
                }
                } 
    }
    
}
