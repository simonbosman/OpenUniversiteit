package vormen;

/**
 * Representeert de vorm cilinder.
 */
public class Cilinder extends Vorm {
    private double straal;
    private double hoogte;

    /**
     * Default constructor, geeft de private fields een waarde.
     * @param straal
     * @param hoogte
     * @return
     */
    public Cilinder(double straal, double hoogte) {
        this.straal = straal;
        this.hoogte = hoogte;
    }

    /**
     * Bepaalt de inhoud van de cinlinder.
     * @return
     */
    public double inhoud() {
        return Math.PI * straal * straal * hoogte;
    }

    /**
     * Geeft een weergave van de cilinder
     */
    @Override
    public String toString() {
        return "Cilinder " + straal + " " + hoogte + " (" + inhoud() + ")";
    }
}
