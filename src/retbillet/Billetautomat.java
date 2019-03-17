package retbillet;
/**
 * Model af en simpel billetautomat til enkeltbilletter med en fast pris.
 */
public class Billetautomat {
	private int almpris;    // Price of a normal ticket
        private int godpris;    // Price of a good ticket
        private int superpris;    // Price of a super ticket
        private int ultrapris;    // Price of an ultra ticket
	private int balance; // Hvor mange penge kunden p.t. har puttet i automaten
	private int antalBilletterSolgt; // Antal billetter automaten i alt har solgt

	/**
	 * Opret en billetautomat, der sælger billetter til en given billetpris.
	 * @param billetpris skal være større end nul (p.t. bliver det ikke tjekket)
	 */
	public Billetautomat(int billetpris) {
		almpris = billetpris;
                godpris = billetpris +2;
                superpris = billetpris + 5;
                ultrapris= billetpris + 10;
	}

	/**
	 * Opret en billetautomat, der sælger billetter til en given billetpris
	 * @param billetpris skal være større end nul (p.t. bliver det ikke tjekket)
	 * @param startbalance mængden af penge automaten allerede indeholder
	 */
	public Billetautomat(int billetpris, int startbalance) {
	        almpris = billetpris;
                godpris = billetpris +2;
                superpris = billetpris + 5;
                ultrapris= billetpris + 10;
		balance = startbalance;
	}

	/**
	 * Giver prisen for en billet.
	 */
	public int getBilletpris() {
		return almpris;
	}

	/**
	 * Modtag nogle penge (i kroner) fra en kunde.
	 */
	public void indsætPenge(int beløb) {
		balance = balance + beløb;
	}

	/**
	 * Giver balancen (beløbet maskinen har modtaget til den næste billet).
	 */
	public int getBalance() {
		return balance;
	}

	/** Udskriv en billet. */
	public void udskrivBillet(int g) {
            switch(g){
                case 0:
                    almbillet();
                    balance = balance - almpris;             // trækker fra balance
                    antalBilletterSolgt = antalBilletterSolgt + 1;
                    break;
                case 1:
                    godbillet();
                    balance = balance - godpris;             // trækker fra balance
                    antalBilletterSolgt = antalBilletterSolgt + 1;
                    break;
                case 2:
                    superbillet();
                    balance = balance - superpris;             // trækker fra balance
                    antalBilletterSolgt = antalBilletterSolgt + 1;
                    break;
                case 3:
                    ultrabillet();
                    balance = balance - ultrapris;             // trækker fra balance
                    antalBilletterSolgt = antalBilletterSolgt + 1;
                    break;
            }
		

		
	}
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
        
	/*public void setBilletpris(String montørkode, int nyPris) {
		if (montørkode.equals("1234")) pris = nyPris;
		else System.err.println("Kunne ikke sætte pris - forkert kode");
	}

	public int getSamletSalgsbeløb(String montørkode) {
		if (montørkode.equals("1234")); return pris * antalBilletterSolgt;
	}*/
}