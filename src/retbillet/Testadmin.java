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
public class Testadmin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException {
        int errors = 0;
        Admin g = new Admin();
        
        if(g.loginstatus()) errors++;
        g.login();                    //incorrect login
        if(g.loginstatus()) errors++;
        g.login();                    //correct login
        if(!g.loginstatus()) errors++;
        g.logOut();
        if(g.loginstatus()) errors++;
        System.out.println("there where this many errors: "+errors);
    }
    
}
