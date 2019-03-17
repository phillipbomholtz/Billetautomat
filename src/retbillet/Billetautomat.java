package retbillet;
/**
 * auther:       Jacop Nordfalk
 * Modified by:  Phillip Bomholtz
 * created:      unknown
 * Last updated: 17-03-2019
 */
public class Billetautomat {
	private int almpris;    // Price of a normal ticket
        private int godpris;    // Price of a good ticket
        private int superpris;    // Price of a super ticket
        private int ultrapris;    // Price of an ultra ticket
	private int balance; // user curent balance
	private int abs; // amount sold

	/**
	 * construct the machine with price
	 */
	public Billetautomat(int billetpris) {
            //set prices
            if(billetpris > 0){
		almpris = billetpris;
                godpris = billetpris +2;
                superpris = billetpris + 5;
                ultrapris= billetpris + 10;
            }else{
                System.out.println("pris kan ikke vaere lavere end 0 kr");
                int i = 10;
                almpris = i;
                godpris = i +2;
                superpris = i + 5;
                ultrapris= i + 10;
            }
	}


	 //construckt machine with start balance
	public Billetautomat(int billetpris, int startbalance) {
	       //set prices
            if(billetpris > 0){
		almpris = billetpris;
                godpris = billetpris +2;
                superpris = billetpris + 5;
                ultrapris= billetpris + 10;
            }else{
                System.out.println("pris kan ikke vaere lavere end 0 kr");
                int i = 10;
                almpris = i;
                godpris = i +2;
                superpris = i + 5;
                ultrapris= i + 10;
            }
		balance = startbalance;
	}

	//unused
	public int getBilletpris() {
		return almpris;
	}

	//add to balance
	public void indsaetPenge(int beløb) {
		balance = balance + beløb;
	}

       //current balance
	public int getBalance() {
		return balance;
	}

	//write ticket if sufficient funds. recives wanted ticket type
	public void udskrivBillet(int g) {
            switch(g){
                case 0:
                    if(balance > almpris){
                    almbillet();
                    balance = balance - almpris;             // subtract from balance
                    abs = abs + 1;
                    }else System.out.println("ikke nok penge");
                    break;
                case 1:
                    if(balance > godpris){
                    godbillet();
                    balance = balance - godpris;             // subtract from balance
                    abs = abs + 1;
                    }else System.out.println("ikke nok penge");
                    break;
                case 2:
                    if(balance > superpris){
                    superbillet();
                    balance = balance - superpris;             // subtract from balance
                    abs = abs + 1;
                    }else System.out.println("ikke nok penge");
                    break;
                case 3:
                    if(balance > ultrapris){
                    ultrabillet();
                    balance = balance - ultrapris;             // subtract from balance
                    abs = abs + 1;
                    }else System.out.println("ikke nok penge");
                    break;
            }
	
	}
        
        //all tickets
        public void almbillet(){
                System.out.println("##########B##T##########");
		System.out.println("# Borgen Trafikselskab #");
		System.out.println("#                      #");
		System.out.println("#      alm. Billet     #");
		System.out.println("#        " + almpris + " kr.        #");
		System.out.println("#                      #");
		System.out.println("##########B##T##########");
		System.out.println();
        }
        public void godbillet(){
                System.out.println("##########B##T##########");
		System.out.println("# Borgen Trafikselskab #");
		System.out.println("#                      #");
		System.out.println("#      god Billet      #");
		System.out.println("#        " + godpris + " kr.        #");
		System.out.println("#                      #");
		System.out.println("##########B##T##########");
		System.out.println();
        }
        public void superbillet(){
                System.out.println("##########B##T##########");
		System.out.println("# Borgen Trafikselskab #");
		System.out.println("#                      #");
		System.out.println("#      super Billet    #");
		System.out.println("#        " + superpris + " kr.        #");
		System.out.println("#                      #");
		System.out.println("##########B##T##########");
		System.out.println();
        }
        public void ultrabillet(){
                System.out.println("##########B##T##########");
		System.out.println("# Borgen Trafikselskab #");
		System.out.println("#                      #");
		System.out.println("#      ultra Billet    #");
		System.out.println("#        " + ultrapris + " kr.        #");
		System.out.println("#                      #");
		System.out.println("##########B##T##########");
		System.out.println();
        }
        
}