package vormen;

/**
 * Vorm die een bol representeert.
 */
public class Bol extends Vorm{
    private double straal;

    /**
     * Default constructor, zet de waarde voor private field straal
     * @param straal
     */
    public Bol(double straal) {
        this.straal = straal;
    }

    /**
     * Berekent de inhoud van de bol.
     * @return inhoud
     */
    public double inhoud() {
        return (4 * Math.PI * straal * straal * straal) / 3;
    }

    /**
     * Geeft een weergave van de bol.
     * @return
     */
    @Override
    public String toString() {
        return "Bol " + straal + " (" + inhoud() + ")";
    }
}
