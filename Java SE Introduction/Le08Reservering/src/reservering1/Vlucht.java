package reservering1;

import java.util.ArrayList;

/**
 * Klasse Vlucht is verantwoordelijk voor de toewijzing
 * van plaatsen op een vlucht aan verschillende boekingskantoren.
 */
public class Vlucht {
    /**
     * Plaatsen zijn genummerd van 0 tot AANTALPLAATSEN - 1
     */
    public static final int AANTALPLAATSEN = 500;

    /**
     * Reserveringen worden bewaard in een ArrayList
     */
    private ArrayList<Integer> reserveringen = new ArrayList<Integer>();

    /**
     * Het nummer van de eerste nog niet toegewezen plaats
     */
    private int eersteVrijePlaats = 0;

    /**
     * Is de vlucht al vol?
     */
    private boolean vol = false;

    /**
     * Maakt een reservering voor een gegeven kantoor
     *
     * @param kantoor het nummer van het kantoor dat een
     *                plaats wil boeken
     * @return het nummer van de toegewezen plaats als er nog
     * plaats is en anders -1
     */
    public int maakReservering(int kantoor) {
        if (eersteVrijePlaats < AANTALPLAATSEN) {
            reserveringen.add(kantoor);
            eersteVrijePlaats++;
            return eersteVrijePlaats - 1;
        } else {
            vol = true;
            return -1;
        }
    }


    public boolean isVol() {
        return vol;
    }

    /**
     * Creëer een vlucht en start een aantal kantoren, elk in een
     * eigen draad. Alle kantoren roepen dezelfde methode boek aab
     * op de vlucht.
     */
    public static void main(String[] args) {
        final int aantalKantoren = 50;

        Vlucht vlucht = new Vlucht();
        for (int i = 1; i < aantalKantoren; i++) {
            BoekingsKantoor k = new BoekingsKantoor(i, vlucht);
            k.start();
        }
    }
}
