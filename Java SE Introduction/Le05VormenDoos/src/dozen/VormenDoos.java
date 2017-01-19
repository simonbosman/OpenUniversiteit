package dozen;

import vormen.Vorm;

/**
 * Generieke klasse voor het bewaren
 * van een object van het type T met als
 * upperbound type Vorm.
 * @param <T>
 */
public class VormenDoos<T extends Vorm> {
    private T object;

    /**
     * Bewaart object van type T in VormenDoos.
     * Upperbound van type T is Vorm.
     * @param object
     */
    public void bewaar(T object) {
        this.object = object;
    }

    /**
     * Geeft object van type T terug uit VormenDoos.
     * @return
     */
    public T getObject() {
        return object;
    }

    /**
     * Geeft de inhoud het object met als
     * type upperbound Vorm.
     * @return
     */
    public double InhoudObject() {
        return object.inhoud();
    }
}
