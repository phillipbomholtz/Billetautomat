/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retbillet;

/**
 *
 * @author phill
 */
public class Testfileuser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("expectet output: (Found file: c:/temp/test.txt) or (Success in creating file)");
        Fileuser m = new Fileuser("c:/temp/","test.txt");
        
    }
    
}
