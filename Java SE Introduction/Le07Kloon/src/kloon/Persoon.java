package kloon;

/**
 * Deze klasse beheert de gegevens van een persoon (naam, tel en auto)
 *
 * @author Open Universiteit Nederland
 */
public class Persoon implements Cloneable {

    private String naam = null;
    private String tel = null;
    private Auto auto = null;
    private int leeftijd;

    /**
     * Creëert een nieuwe persoon
     *
     * @param naam de naam
     * @param tel  het telefoonnummer
     * @param auto de auto
     */
    public Persoon(String naam, String tel, Auto auto, int leeftijd) {
        this.naam = naam;
        this.tel = tel;
        this.auto = auto;
        this.leeftijd = leeftijd;
    }

    /**
     * Geeft een ondiepe kopie van het object.
     *
     * @return de kopie
     */
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * Geeft een stringrepresentatie van de persoon.
     *
     * @return de stringrepresentatie
     */
    public String toString() {
        return naam + ", "  + leeftijd + ", "+ tel + " " + auto;
    }

    /**
     * Wijzigt het telefoon van de persoon.
     *
     * @param tel nieuwe telefoonnummer
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * Wijzigt de keuringsdatum van de auto.
     *
     * @param apk nieuwe keuringsdatum van de auto
     */
    public void wijzigApk(String apk) {
        auto.setApk(apk);
    }

    /** Wijzigt de leeftijd van de persoon.
     *
     * @param leeftijd
     */
    public void setLeeftijd(int leeftijd) {
        this.leeftijd = leeftijd;
    }
}
