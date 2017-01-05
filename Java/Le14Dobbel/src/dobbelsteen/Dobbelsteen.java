package dobbelsteen;

import java.util.Observable;
import java.util.Random;

/**
 * Observable klasse die verantwoordelijk is voor het
 * genereren en toegankelijk maken van een willekeurig
 * getal tussen 1 en 6
 */
public class Dobbelsteen extends Observable {
    private int ogen = 0;

    /**
     * Maakt een nieuwe Dobbelsteen-instantie en kent
     * meteen een waarde tussen 1 en 6 toe aan ogen.
     */
    public Dobbelsteen() {
        super();
        this.werp();
    }

    public int getOgen() {
        return ogen;
    }

    /**
     * Genereert en bewaart een waarde tussen 1 en 6.
     * Brengt observers op de hoogte van de verandering.
     */
    public void werp() {
        Random r = new Random();
        ogen = r.nextInt(6) + 1;
        setChanged();
        notifyObservers();
    }

}