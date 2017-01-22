package kloon;

/**
 * Deze klasse beheert de gegevens van een auto (kenteken en apkdatum).
 *
 * @author Open Universiteit Nederland
 */
public class Auto implements Cloneable {

    // kenteken van de auto
    private String kenteken = null;
    // apkdatum van de auto
    private String apkDatum = null;

    /**
     * Creeert een nieuwe auto
     *
     * @param kenteken het kenteken
     * @param apk      de apkdatum
     */
    public Auto(String kenteken, String apk) {
        this.kenteken = kenteken;
        this.apkDatum = apk;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * Geeft een stringrepresentatie van de auto.
     *
     * @return de stringrepresentatie
     */
    public String toString() {
        return "Auto: " + kenteken + " keuring: " + apkDatum;
    }

    /**
     * Geeft de apkdatum van de auto.
     *
     * @return de apkdatum van de auto
     */
    public String getApk() {
        return apkDatum;
    }

    /**
     * Wijzigt de apkdatum van de auto.
     *
     * @param apk de nieuwe apkdatum
     */
    public void setApk(String apk) {
        this.apkDatum = apk;
    }

}
