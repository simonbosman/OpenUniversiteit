package paren;

/**
 * Generic klasse met twee type parameters.
 * @param <T>
 * @param <E>
 */
public class Paar<T, E> {

    private T firstElement;
    private E secondElement;

    /**
     * Default constructor verantwoordelijk voor definieren
     * de twee verschillende elementen.
     * @param firsElement
     * @param secondElement
     */
    public Paar(T firsElement, E secondElement) {
        this.firstElement = firsElement;
        this.secondElement = secondElement;
    }

    /**
     * Geeft eerste element terug.
     * @return
     */
    public T getFirstElement() {
        return firstElement;
    }

    /**
     * Geeft tweede element terug.
     * @return
     */
    public E getSecondElement() {
        return secondElement;
    }

    /**
     * Geert een string representatie van de elementen terug.
     * @return
     */
    public String toString() {
        return firstElement + ", " + secondElement;
    }

    /**
     * Simple test
     * @param args
     */
    public static void main(String[] args) {
        Paar<Integer, String> paar = new Paar<Integer, String>(10, "second element");
        System.out.println("element 1: " + paar.getFirstElement());
        System.out.println("element 2: " + paar.getSecondElement());
        System.out.println("paar: " + paar.toString());
    }
}
