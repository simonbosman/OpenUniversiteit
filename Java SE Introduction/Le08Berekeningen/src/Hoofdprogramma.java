/**
 * Demo voor draden.
 * Dit programma start een hulpdraad die van 1 tot 
 * Berekening.MAXTELLER telt, en telt dan zelf van
 * Berekening.MAXTELLER terug naar 0.
 */
public class Hoofdprogramma {

  public static void main(String[] args){
    // creëer en start een nieuwe draad met een 
    // Berekening-instantie als target
    for (int i = 0; i < 10; i++) {
      Berekening berekening = new Berekening(i + 1);
      Thread hulpdraad = new Thread(berekening);
      hulpdraad.start();
    }

    // Tel van Berekening.MAXTELLER terug naar 0
    // en print onderweg zo af en toe iets af.
    long teller = Berekening.MAXTELLER;
    while (teller > 0) {
      teller--;
      if (teller % Berekening.INTERVAL == 0) {
        System.out.println("main is bij " + teller);
      }    
    }
  }
}
