package klok;
/**
 * Klasse Stad representeert een Stad met een gegeven naam
 * en tijdsverschil. Het tijdverschil geeft het verschil 
 * in minuten aan ten opzichte van Amsterdam (GMT +1)
 */

public class Stad {
  private String naam = null;
  private int tijdverschil = 0;
 
  public Stad(String naam, int tijdverschil) {
    this.naam = naam;
    this.tijdverschil = tijdverschil;
  }
  
  public int getTijdverschil() {
    return tijdverschil;
  }
  
  public String getNaam() {
    return naam;
  }
}
