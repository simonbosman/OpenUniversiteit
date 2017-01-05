package dobbelsteengui;

import dobbelsteen.Dobbelsteen;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.Observable;
import java.util.Observer;
import java.awt.RenderingHints;

import javax.swing.JPanel;

/**
 * Een subklasse van JPanel waarop de bovenkant van een dobbelsteen
 * getekend wordt, overeenkomend met het aantal ogen.
 */
public class DobbelPanel extends JPanel implements Observer {
    private static final int AFMETING = 90;
    private static final int VAK = AFMETING / 3;
    private static final int OOGAFMETING = VAK - 10;

    private int ogen = 0;

    /**
     * Geeft de panel de juiste kleur (geel) en afmeting.
     */
    public DobbelPanel() {
        this.setBackground(Color.YELLOW);
        this.setSize(AFMETING + 1, AFMETING + 1);
    }

    /**
     * Haalt het aantal ogen van de dobbelsteen op.
     * Geeft deze weer als stippen.
     */
    @Override
    public void update(Observable o, Object arg) {
        Dobbelsteen dobbelSteen = (Dobbelsteen) o;
        ogen = dobbelSteen.getOgen();
        repaint();
    }

    /**
     * Tekent de bovenkant van een dobbelsteen met
     * het juiste aantal ogen.
     * Er zijn zeven mogelijke posities voor een oog; ze worden
     * een voor een getekend waarbij eerst gekeken wordt of
     * het oog er voor deze waarde van ogen moet staan.
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        Shape oog = new Ellipse2D.Double(0, 0, OOGAFMETING, OOGAFMETING);

        // oog linksboven
        g2d.translate(5, 5);
        if (ogen >= 2 && ogen <= 6) {
            g2d.fill(oog);
        }

        // oog linksmidden
        g2d.translate(0, VAK);
        if (ogen == 6) {
            g2d.fill(oog);
        }

        // oog linksonder
        g2d.translate(0, VAK);
        if (ogen >= 4 && ogen <= 6) {
            g2d.fill(oog);
        }

        // oog midden
        g2d.translate(VAK, -VAK);
        if (ogen == 1 || ogen == 3 || ogen == 5) {
            g2d.fill(oog);
        }

        // oog rechtsboven
        g2d.translate(VAK, -VAK);
        if (ogen >= 4 && ogen <= 6) {
            g2d.fill(oog);
        }

        // oog rechtsmidden
        g2d.translate(0, VAK);
        if (ogen == 6) {
            g2d.fill(oog);
        }

        // oog rechtsonder
        g2d.translate(0, VAK);
        if (ogen >= 2 && ogen <= 6) {
            g2d.fill(oog);
        }
    }
}