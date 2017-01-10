package verzameling;

import java.util.*;

/**
 * De klasse Bag biedt een eenvoudige implementatie van een
 * bag, waarvan alle elementen gehele getallen zijn.
 */
public class Bag {
    private ArrayList<Integer> elementen = new ArrayList<Integer>();

    /**
     * Voegt een element toe aan de bag.
     *
     * @param elem het toe te voegen element
     * @return true als het element is toegevoegd, anders false
     */
    public boolean voegToe(int elem) {
        return elementen.add(elem);
    }

    /**
     * Verwijdert een element uit de bag.
     *
     * @param elem de waarde van het te verwijderen element
     * @return true als element gevonden is en de bag gewijzigd is, anders false
     */
    public boolean verwijder(int elem) {
        return elementen.remove(new Integer(elem));
    }

    /**
     * Geeft het aantal elementen in de bag.
     *
     * @return het aantal elementen
     */
    public int afmeting() {
        return elementen.size();
    }

    /**
     * Gaat na of de bag het gegeven element bevat.
     *
     * @param elem het gezochte element
     * @return true als bag het element bevat, anders null
     */
    public boolean bevat(int elem) {
        return elementen.contains(elem);
    }

    /**
     * Gaat na of de bag leeg is.
     *
     * @return true als de bag geen elementen bevat, anders false
     */
    public boolean isLeeg() {
        return elementen.isEmpty();
    }

    /**
     * Verwijdert alle elementen uit de bag.
     */
    public void maakLeeg() {
        elementen.clear();
    }

    /**
     * Geeft een array met de elementen in de bag.
     *
     * @return array met elementen in de bag
     */
    public int[] elementen() {
        int[] elems = new int[elementen.size()];
        for (int i = 0; i < elementen.size(); i++) {
            elems[i] = elementen.get(i);
        }
        return elems;
    }

    /**
     * Geeft een string-representatie van de bag:
     * vijf elementen per regel, gescheiden door komma's.
     *
     * @return de stringrepresentatie
     */
    public String toString() {
        if (elementen.isEmpty()) {
            return "LEEG";
        }
        String s = "";
        int teller = 0;
        for (int elem : elementen) {
            teller++;
            s = s + elem;
            if (teller != elementen.size()) {
                s = s + ",";
                if (teller % 5 == 0) {
                    s = s + "\n";
                }
            }
        }
        return s;
    }

    /**
     * Vergelijkt deze bag met de actuele parameter bag.
     * Deze zijn gelijk aan elkaar, als ze dezelfde elementen bevatten.
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Bag)) {
            return false;
        }
        if (this.afmeting() != ((Bag) obj).afmeting()) {
            return false;
        }

        int[] elementen1 = this.elementen();
        int[] elementen2 = ((Bag)obj).elementen();

        QuickSort qs = new QuickSort();
        qs.sort(elementen1);
        qs.sort(elementen2);

        for (int i = 0; i < elementen1.length; i++) {
            if (elementen1[i] != elementen2[i]){
                return false;
            }
        }
        return true;
    }
}
