package verzameling;

/**
 * Testklasse voor methode equals van klasse Bag
 * @author Medewerker OUNL
 *
 */
public class TestBag {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // Maak twee (lege) bags
        Bag bag1 = new Bag();
        Bag bag2 = new Bag();

        // Zijn de lege bags gelijk?
        System.out.println(bag1.equals(bag2)); // true

        // Voeg 1, 2, 2, 5 toe aan bag1
        // Deze is niet gelijk aan bag2?
        bag1.voegToe(1);
        bag1.voegToe(2);
        bag1.voegToe(2);
        bag1.voegToe(5);
        System.out.println(bag1.equals(bag2)); // false

        // Voeg 2, 2, 5, 1 toe aan bag2 (zelfde
        // elementen als bag1, in andere volgorde
        // toegevoegd). De bags zijn weer gelijk.
        bag2.voegToe(2);
        bag2.voegToe(2);
        bag2.voegToe(5);
        bag2.voegToe(1);
        System.out.println(bag1.equals(bag2)); // true

        // Verwijder 2 uit de eerste bag (dubbel element).
        // De bags zijn niet meer gelijk
        bag1.verwijder(2);
        System.out.println(bag1.equals(bag2)); // false

        // Verwijder ook 2 uit de tweede bag.
        // De bags zijn weer gelijk.
        bag2.verwijder(2);
        System.out.println(bag1.equals(bag2)); // true

        // Maak de eerste bag leeg.
        // De bags zijn niet gelijk
        bag1.maakLeeg();
        System.out.println(bag1.equals(bag2)); // false

        // Verwijder 1, 2, 5 en ook 6, 7 en 9
        // uit bag2 (die laatste drie zitten er niet in).
        // Dan is bag2 ook leeg en de bags zijn weer gelijk.
        bag2.verwijder(1);
        bag2.verwijder(2);
        bag2.verwijder(5);
        bag2.verwijder(6);
        bag2.verwijder(7);
        bag2.verwijder(9);
        System.out.println(bag1.equals(bag2)); // true
    }

}
