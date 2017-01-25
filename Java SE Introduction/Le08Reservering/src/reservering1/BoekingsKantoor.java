package reservering1;

import java.util.ArrayList;
import java.util.Random;


/**
 * Klasse boekingskantoor reserveert in een
 * aparte draad plaatsen op een gegeven vlucht.
 */
public class BoekingsKantoor extends Thread {

    private int kantoorNummer = 0;
    private Vlucht vlucht = null;
    private ArrayList<Integer> plaatsnummers = new ArrayList<Integer>();

    public BoekingsKantoor(int kantoorNummer, Vlucht vlucht) {
        this.kantoorNummer = kantoorNummer;
        this.vlucht = vlucht;
    }

    /**
     * Maakt, zolang de vlucht niet vol is, reserveringen en voegt
     * de verkregen plaatsnummers toe aan de array plaatsnummers
     */
    public void run() {
        while (!vlucht.isVol()) {
            int plaats = vlucht.maakReservering(kantoorNummer);
            if (plaats != -1) {
                plaatsnummers.add(plaats);
            }
        }
    }
}
