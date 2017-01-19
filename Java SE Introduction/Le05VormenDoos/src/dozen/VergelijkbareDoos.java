package dozen;

/**
 * Generieke klasse voor het bewaren van
 * een object van type T. Type Comparable is gedefineerd
 * als upper bound.
 *
 * @param <T> het type van het object in de doos
 * @author Open Universiteit Nederland
 */
public class VergelijkbareDoos<T extends Comparable<T>> {
    private T object = null; // het object in de doos

    /**
     * Plaatst een object in de doos.
     *
     * @param object het te bewaren object
     */
    public void bewaar(T object) {
        this.object = object;
    }

    /**
     * Geeft een object terug uit de doos.
      * @return object
     */
    public T getObject() {
        return object;
    }


    /**
     * Geeft een string presentatie van de doos.
     * @return String
     */
    public String toString() {
        return "Doos: " + object;
    }

    /**
     * Vergelijkt twee dozen met elkaar.
     * Dozen hebben, als formeel type parameter, type Comparable
     * als upperbound.
     * @param andereDoos
     * @return
     */
    public int vergelijkMet(VergelijkbareDoos<T> andereDoos) {
        return object.compareTo(andereDoos.getObject());
    }

}

