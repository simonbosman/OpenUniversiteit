package lijstdemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static lijstdemo.ZoekActie.BINSEARCH;

public class LijstDemo {

    public static final int N = 40000; //aantal elementen

    /**
     * Het type van attribuut lijst is List, een interface
     */
    private List<Integer> lijst = null;

    /**
     * Vult de lijst l met N elementen en toont hoelang
     * dat duurt.
     *
     * @param l een lege lijst
     */
    public LijstDemo(List<Integer> l) {
        this.lijst = l;
        //  vul lijst met N random getallen
        Random rn = new Random();
        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            lijst.add(0, rn.nextInt());
        }
        long stop = System.currentTimeMillis();
        System.out.println("Creatie: " + (stop - start));
    }

    /**
     * Zoekt alle getallen in de lijst een keer op en
     * toont hoe lang dat duurt.
     * De gebruikte methode is de klassenmethode binarySearch
     * van de klasse Collections. Deze methode geeft de index
     * van het gevonden getal terug; in dit geval doen we daar niets
     * meer (want die weten we al; die is i). Ter vergelijking
     * worden ook de stream methodiek uit Java 8 getest.
     *
     * @param zoekActie de te gebruiken zoekmethode.
     */

    public void zoek(ZoekActie zoekActie) {
        Collections.sort(lijst);
        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            int getal = lijst.get(i);
            switch (zoekActie) {
                case BINSEARCH:
                    Collections.binarySearch(lijst, getal);
                    break;
                case STREAM:
                    lijst.stream().filter(x -> x == getal).findFirst().get();
                    break;
                case PARALLELSTREAM:
                    lijst.parallelStream().filter(x -> x == getal).findFirst().get();
                    break;
            }
        }
        long stop = System.currentTimeMillis();
        System.out.println("Zoeken: " + (stop - start));
    }


    /**
     * Maakt instanties van LijstDemo met achtereenvolgens
     * een ArrayList en een LinkedList en roept op beide
     * LijstDemo-instanties de methode zoek aan.
     *
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("Prestatietest van een linked list en een array backed list met " +
                N + " elementen.");

        System.out.println("ArrayList");
        ArrayList<Integer> al = new ArrayList<Integer>();
        LijstDemo ld = new LijstDemo(al);
        ld.zoek(ZoekActie.BINSEARCH);

        System.out.println();
        System.out.println("LinkedList");
        LinkedList<Integer> ll = new LinkedList<Integer>();
        LijstDemo ld2 = new LijstDemo(ll);
        ld2.zoek(ZoekActie.BINSEARCH);

        System.out.println("\nNog een keer zoeken m.b.v. Java 8 streams.\n");
        ld.zoek(ZoekActie.STREAM);
        ld2.zoek(ZoekActie.STREAM);

        System.out.println("\n Nog een keer zoeken m.b.v. Java 8 parallel streams");
        ld.zoek(ZoekActie.PARALLELSTREAM);
        ld2.zoek(ZoekActie.PARALLELSTREAM);
    }

}
