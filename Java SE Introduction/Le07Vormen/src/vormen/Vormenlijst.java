package vormen;

import java.util.ArrayList;

/**
 * Representeert een lijst met vormen.
 * @author Open Universiteit Nederland
 */
public class Vormenlijst {
  private ArrayList<Vorm> vormen = new ArrayList<Vorm>();

  /**
   * Maakt een bol-instantie en voegt deze toe aan de vormenlijst.
   * @param straal straal van de bol
   */
  public void maakBol(double straal) {
    Bol bol = new Bol(straal);
    vormen.add(bol);
  }
  
  /**
   * Maakt een blok-instantie en voegt deze toe aan de vormenlijst.
   * @param zijde zijde van blok (lengte en breedte)
   * @param hoogte hoogte van blok
   */
  public void maakBlok(double zijde, double hoogte) {
    Blok blok = new Blok(zijde, hoogte);
    vormen.add(blok);
  }
  
  /**
   * Maakt een cilinder-instantie en voegt deze toe aan de vormenlijst.
   * @param straal straal van de cilinder
   * @param hoogte hoogte van de cilider
   */
  public void maakCilinder(double straal, double hoogte) {
    Cilinder cilinder = new Cilinder(straal, hoogte);
    vormen.add(cilinder);
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
