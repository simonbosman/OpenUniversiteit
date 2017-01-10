package verzameling;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * De klasse representeert een verzameling met gehele getallen.
 * In een verzameling komt ieder element slechts één maal voor.
 */
public class Verzameling extends Bag {

    /**
     * Voegt een element toe aan de verzameling
     * als dit element nog niet voorkomt in de verzameling.
     *
     * @param element
     * @return
     */

    @Override
    public boolean voegToe(int element) {
        if (!bevat(element)) {
            return super.voegToe(element);
        }
        return false;
    }

    /**
     * Berekent de vereniging van een verzameling
     * met een andere verzameling.
     *
     * @param verzameling de andere verzemeling.
     * @return een nieuwe verzameling met de verenigde elementen.
     */
    public Verzameling vereniging(Verzameling verzameling) {

        Verzameling vereniging = new Verzameling();

        for (int element : this.elementen()) {
            vereniging.voegToe(element);
        }
        for (int element : verzameling.elementen()) {
            vereniging.voegToe(element);
        }
        return vereniging;
    }

    /**
     * Berekent de doorsnede van een verzameling
     * met een andere verzameling.
     *
     * @param verzameling de andere verzameling
     * @return de nieuwe verzameling een doorsnede van de
     * twee verzamelingen.
     */
    public Verzameling doorsnede(Verzameling verzameling) {

        Verzameling doorsnede = new Verzameling();

        for(int element : verzameling.elementen()) {
            if (this.bevat(element)) {
                doorsnede.voegToe(element);
            }
        }
        return doorsnede;
    }
}