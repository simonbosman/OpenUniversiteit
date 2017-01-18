package vormen;

/**
 * Representeert een cilinder.
 * @author Open Universiteit Nederland.
 */
public class Cilinder extends Vorm {
  private double straal = 0.0;
  private double hoogte = 0.0;
  
  /**
   * Maakt een cilinder.
   * @param straal straal van de cilinder
   * @param hoogte hoogte van de cilinder
   */
  public Cilinder(double straal, double hoogte) {
    this.straal = straal;
    this.hoogte = hoogte;
  }
  
  /**
   * Levert een String-representatie van de cilinder.
   * @return een String-representatie van de cilinder
   */
  public String toString() {
    return "Cilinder " + straal + " " + hoogte + "  (" + inhoud() + ")";
  }
  
  /**
   * Levert de inhoud van de cilinder.
   * @return de inhoud van de cilinder
   */
  public double inhoud() {
    return Math.PI * straal * straal * hoogte;
  }

}
