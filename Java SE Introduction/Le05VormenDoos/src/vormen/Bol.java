package vormen;

/**
 * Representeert een bol.
 * @author Open Universiteit Nederland
 */
public class Bol extends Vorm {
  private double straal = 0.0;
  
  /**
   * Maakt een bol
   * @param straal straal van de bol
   */
  public Bol(double straal) {
    this.straal = straal;
  }
  
  /**
   * Levert een String-representatie van de bol.
   * @return een String-representatie van de bol
   */
  @Override
  public String toString() {
    return "Bol " + straal + "  (" + inhoud() + ")";
  }
  
  /**
   * Levert de inhoud van de bol.
   * @return de inhoud van de bol
   */
  public double inhoud() {
    return (4 * Math.PI * straal * straal * straal) / 3;
  }

}
