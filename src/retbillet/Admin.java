
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
    public void login(String a, String b){
        if(a.equals(name) && b.equals(code)){
            System.out.println("welcome " + name);
            x = true;
        }else{
            System.out.println("YOU ARE NOT AN ADMIN! ;:( ");
            x = false;
        }
    }
    public boolean loginstatus(){
        return x;
    }
}
