package vormen;

import java.util.ArrayList;

/**
 * Representeert een lijst met vormen.
 * @author Open Universiteit Nederland
 */
public class Vormenlijst {
  private ArrayList<Vorm> vormen = new ArrayList<Vorm>();
  
  /**
   * Voegt een vorm toe aan de vormenlijst.
   * @param vorm nieuwe vorm
   */
  public void voegToe(Vorm vorm) {
    vormen.add(vorm);
  }
  
  /**
   * Geeft een stringrepresentatie van de vormenlijst.
   * De stringrepresentatie van de vormenlijst bestaat
   * uit een opsomming van de gegevens van alle vormen
   * in de lijst, iedere vorm op een eigen regel.
   * @return de stringrepresentatie
   */
  public String toString() {
    String stringlijst = "";
    for (Vorm vorm : vormen) {
      stringlijst = stringlijst + vorm.toString() + "\n";
    }
    return stringlijst;
  }
  
  /**
   * Levert de som van de inhouden van alle vormen in de 
   * lijst.
   * @return de som van de inhouden van alle vormen in de
   *         lijst
   */
  public double totaalInhoud() {
    double inhoud = 0;
    for (Vorm vorm : vormen) {
      inhoud = inhoud + vorm.inhoud();
    }
    return inhoud;
  }

}
