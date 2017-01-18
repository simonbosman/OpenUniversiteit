package bibliotheek;

/**
 * Deze klasse beheert de gegevens (titel en auteur)
 * van een boek.
 * @author Open Universiteit Nederland
 */ 
public class Boek {
  private String titel = null;
  private String auteur = null;
  
  /**
   * Creert een nieuw boek.
   * @param titel  de titel van het boek
   * @param auteur  de auteur van het boek
   */ 
  public Boek(String titel, String auteur){
    this.titel = titel;
    this.auteur = auteur;
  }

  /**
   * Geeft de naam van de auteur van het boek.
   * @return de naam van de auteur
   */
  public String getAuteur() {
    return auteur;
  }

  /**
   * Geeft de titel van het boek.
   * @return de titel van het boek
   */
  public String getTitel() {
    return titel;
  }
  
  /**
   * Maakt een string-representatie van het boek.
   * @return de stringrepresentatie
   */
  public String toString() {
    return titel + " - " + auteur;
  }
}
