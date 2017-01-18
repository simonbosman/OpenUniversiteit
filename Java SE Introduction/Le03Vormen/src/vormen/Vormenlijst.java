package vormen;

import java.util.ArrayList;

/**
 * Representeert een lijst met vormen.
 */
public class Vormenlijst {

    private ArrayList<Vorm> vormen = new ArrayList<Vorm>();

    /**
     * Voegt een vorm toe aan de set van verzamelingen.
     *
     * @param vorm
     */
    public void voegToe(Vorm vorm) {
        vormen.add(vorm);
    }

    /**
     * Maakt een nieuwe instantie van blok
     * en voegt deze toe aan de lijst met vormen.
     *
     * @param zijde
     * @param hoogte
     */
    public void maakBlok(double zijde, double hoogte) {
        Blok blok = new Blok(zijde, hoogte);
        voegToe(blok);
    }

    /**
     * Maakt een nieuwe instantie van Bol
     * en voegt deze toe aan de lijst met vormen.
     *
     * @param straal
     */
    public void maakBol(double straal) {
        Bol bol = new Bol(straal);
        voegToe(bol);
    }

    /**
     * Maakt een nieuwe instantie van Cilinder
     * en voegt deze toe aan de lijst met vormen.
     * @param straal
     * @param hoogte
     */
    public void maakCilinder(double straal, double hoogte) {
        Cilinder cilinder = new Cilinder(straal, hoogte);
        voegToe(cilinder);
    }

    /**
     * Berekent de totale inhoud van alle vormen in  de lijst.
     *
     * @return totale inhoud
     */
    public double totaalInhoud() {
        double totInhoud = 0;
        for (Vorm vorm : vormen) {
            totInhoud += vorm.inhoud();
        }
        return totInhoud;
    }

    /**
     * Geeft een weergave van alle vormen in de lijst.
     *
     * @return weergave van alle vormen.
     */
    @Override
    public String toString() {
        String vormLijst = "";
        for (Vorm vorm : vormen) {
            vormLijst += vorm.toString() + "\n";
        }
        return vormLijst;
    }


}
