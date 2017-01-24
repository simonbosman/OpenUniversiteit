/**
 * Deze klasse telt in een aparte draad van van 0 
 * tot MAXTELLER; onderweg wordt tien keer een
 * voortgangsbericht afgedrukt.
 */
public class Berekening implements Runnable {
  // Constanten MAXTELLER en INTERVAL 
  public static final long MAXTELLER = 100000L;
  public static final long INTERVAL = MAXTELLER /10;
  private int nummer;

  /**
   * Default contstructor
   * Zet de waarde van attribuut nummer.
   * @param nummer
   */
  public Berekening(int nummer) {
    this.nummer = nummer;
  }
  
  /**
   * Telt van 0 tot MAXTELLER
   */
  public void run() { 
    long teller = 0;
    while (teller < MAXTELLER) {
      teller++;
      if (teller % INTERVAL == 0) {
        System.out.println("run nummer " + nummer + " is bij " + teller);
      }    
    }
  }
}

