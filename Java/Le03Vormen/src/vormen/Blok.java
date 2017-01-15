package vormen;

/**
 * Reprsenteerd een blok.
 */
public class Blok extends Vorm {
    private double zijde;
    private double hoogte;

    /**
     * Default contstuctor, geeft de private fields een waarde.
     * @param zijde
     * @param hoogte
     */
    public Blok(double zijde, double hoogte) {
        this.zijde = zijde;
        this.hoogte = hoogte;
    }

    /**
     * Berekent de inhoud van een blok.
     * @return inhoud
     */
    public double inhoud() {
        return this.zijde * this.zijde * this.hoogte;
    }

    /**
     * Weergave van een blok
     * @return eigenschappen blok
     */
    @Override
    public String toString() {
        return "Blok " + zijde + " " + hoogte + " (" + inhoud() + ")";
    }
}
