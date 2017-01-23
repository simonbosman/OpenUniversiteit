package vormen;

/**
 * Representeert een blok.
 * @author Open Universiteit Nederland
 */
public class Blok implements Vorm {
  private double zijde = 0.0;
  private double hoogte = 0.0;
  
  /**
   * Maakt een blok.
   * @param zijde lengte en breedte van blok
   * @param hoogte hoogte van blok
   */
  public Blok(double zijde, double hoogte) {
    this.zijde = zijde;
    this.hoogte = hoogte;
  }
  
  /**
   * Levert een String-representatie van het blok.
   * @return een String-representatie van het blok
   */
  public String toString() {
    return "Blok " + zijde + " " + hoogte + "  (" + inhoud() + ")";
  }
  
  /**
   * Levert de inhoud van het blok.
   * @return de inhoud van het blok
   */
  public double inhoud() {
    return zijde * zijde * hoogte;
  }

}
