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
public class Admin {
    private String name;
    private String code;
    private boolean x = false;
    
    public Admin(){
        name = "Dorte";
        code = "1234";
    }
    public Admin(String a, String b){
        name = a;
        code = b;
    }
    public boolean login(String a, String b){
        if(a.equals(name) && b.equals(code)){
            System.out.println("welcome " + name);
            x = true;
        }else{
            System.out.println("YOU ARE NOT AN ADMIN! ;:( ");
            x = false;
        }
        return x;
    }
}
