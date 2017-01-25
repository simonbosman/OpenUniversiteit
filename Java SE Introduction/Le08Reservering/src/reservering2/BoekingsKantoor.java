package reservering2;

import java.util.Vector;
import java.util.Random;

/**
 * Klasse boekingskantoor reserveert in een
 * aparte draad plaatsen op een gegeven vlucht.
 */
public class BoekingsKantoor extends Thread {

    private int kantoorNummer = 0;
    private Vlucht vlucht = null;
    private Vector<Integer> plaatsnummers = new Vector<Integer>();
    private Random random = new Random();

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
            //try {Thread.sleep(random.nextInt(10)); } catch (InterruptedException e){}
        }
        System.out.println(plaatsnummers);
        controleerBoekingen();
    }

    /**
     * Controleert of de plaatsnummers die het kantoor heeft ontvangen
     * ook allemaal echt voor dit kantoor gereserveerd zijn en of
     * er plaatsen voor dit kantoor gereserveerd zijn die niet in
     * plaatsnummers staan.
     */
    private void controleerBoekingen() {
        Vector<Integer> reserveringen = vlucht.getReserveringen();
        //System.out.println("Aantal reserveringen volgens kantoor " +
        //       kantoorNummer + ":  "+ reserveringen.size());
        // zijn alle plaatsen in plaatsnummers ook echt gereserveerd?
        for (int nummer : plaatsnummers) {
            if (reserveringen.get(nummer) != kantoorNummer) {
                System.out.println("Kantoor " + kantoorNummer +
                        ": plaats " + nummer + " niet toegewezen");
            }
        }
        // zijn er plaatsen gereserveerd die niet in plaatsnummers voorkomen?
        for (int i = 0; i < reserveringen.size(); i++) {
            if (reserveringen.get(i) == kantoorNummer) {
                if (!plaatsnummers.contains(i)) {
                    System.out.println("Kantoor " + kantoorNummer +
                            ": plaats " + i + " ten onrechte toegewezen");
                }
            }
        }
    }
}
