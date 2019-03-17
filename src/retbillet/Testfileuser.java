/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retbillet;
import java.io.IOException;
/**
 *
 * @author phill
 */
public class Testfileuser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException {
        int errors=0;
        //test file existing
        System.out.println("expectet output: (Found file: c:/temp/test.txt) or (Success in creating file)");
        Fileuser m = new Fileuser("c:/temp/","test.txt");
        
        //test write read
        System.out.println("\nenter a line (Hello world) in test.txt");
        String e = "Hello World";
        m.filewrite(e);
        System.out.println("done now to read it and detect error");
        m.readfile();
        
        //test search with no balance data
        Fileuser usertest = new Fileuser("c:/temp/","usertest.txt");
        usertest.filewrite("Dorte,1234,");
        if(usertest.fileSearchUser("Dorte", "1234") != 1) errors++; //search with valid ID and password
        if(usertest.fileSearchUser("Hans", "1234") != -1) errors++; //search with invalid ID but valid password
        if(usertest.fileSearchUser("Dorte", "2233") != 0) errors++; //search with valid ID but invalid password
        
        //test search with balance data
        Fileuser usertest2 = new Fileuser("c:/temp/","usertest2.txt");
        usertest2.filewrite("Dorte,1234,100");
        if(usertest2.fileSearchUser("Dorte", "1234") != 1) {
            if(usertest2.userBalance() != 100) errors++;
        }
         Fileuser g = new Fileuser();
         String b = g.LogDate("10-10-10");
         System.out.println("correct output: 10-10-10 20:12:10 beloeb indsat(kr): 200");
         System.out.println(b);
         
         String c = g.LogDate("10-10-11");
         System.out.println("correct output: Ingen Log for dato");
         System.out.println(c);
         
        /* String k = g.LogHandL(1);
         System.out.println("correct output: 10-10-10 20:12:10 beloeb indsat(kr): 200");
         System.out.println(k);
         
          String p = g.LogHandL(2);
         System.out.println("correct output: 10-10-10 20:12:10 der blev købt en alm. billet");
         System.out.println(p);*/
        System.out.println("there where "+errors+" errors");
        

    }
    
}
