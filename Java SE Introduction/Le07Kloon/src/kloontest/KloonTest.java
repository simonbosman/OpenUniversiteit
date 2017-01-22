 package kloontest;

import kloon.Auto;
import kloon.Persoon;

/**
 * Klasse voor het testen van methode clone en voor het testen van diepe- en
 * ondiepe kopie.
 * 
 * @author Open Universiteit Nederland
 */
public class KloonTest {

  /**
   * Illustreert het gebruik van een ondiepe kopie.
   * Een wijziging in een persoon kan doorwerken in de kloon 
   * @param args nvt
   */
  public static void main(String[] args) throws CloneNotSupportedException {
    Persoon persoon = new Persoon("Jan", "12345", new Auto("1-ABC-10",
        "1-2-2008"), 36);
    Persoon kloon = (Persoon) persoon.clone();
    toon(persoon, kloon);
    persoon.setTel("54321");
    persoon.wijzigApk("30-1-2009");
    persoon.setLeeftijd(45);
    System.out.println("Persoon gewijzigd!");
    toon(persoon, kloon);
  }
  
  /**
   * Schrijft stringrepresentatie van twee gegeven personen naar de standaarduitvoor.  
   * @param persoon eerste persoon
   * @param kloon tweede persoon
   */
  private static void toon(Persoon persoon, Persoon kloon) {
    System.out.println("Persoon:: " + persoon);
    System.out.println("Kloon:: " + kloon);
    System.out.println();
  }
}
