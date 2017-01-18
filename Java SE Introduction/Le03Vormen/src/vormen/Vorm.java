package vormen;


/**
 * Basis vorm waarvan de overige vormen erven.
 */
public class Vorm {
    /**
     * Basis methode die de inhoud van de vorm retourneert.
     * Methode wordt door subklasse hergedefinieerd.
     * @return bij gegrek aan beter, standaard waarde -1
     */
    public double inhoud() {
        return -1;
    }
}
