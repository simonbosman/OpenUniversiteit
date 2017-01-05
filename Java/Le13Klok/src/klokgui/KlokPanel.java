package klokgui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.Calendar;

import klok.Klok;

/**
 * Representeerd een analoge klok.
 */
public class KlokPanel extends JPanel {

    private static final Dimension AFMETING = new Dimension(600, 600);
    private static final int STRAAL = 240;
    private static final int STREEP1 = 30;
    private static final int STREEP5 = 45;
    private static final double SECONDEWIJZER = 0.9;
    private static final double MINUUTWIJZER = 0.75;
    private static final double UURWIJZER = 0.6;
    private static final int CIJFERLOC = 70;
    private static final Font CIJFERFONT;

    static {
        CIJFERFONT = new Font("MONOSPACED", Font.BOLD + Font.ITALIC, 50);
    }

    private Klok klok = null;


    /**
     * sets the klok attribute.
     *
     * @param klok
     */
    public void setKlok(Klok klok) {

        this.klok = klok;
    }

    /**
     * Default constructor initializes KlokPanel properties.
     */
    public KlokPanel() {
        super();
        initialize();
    }

    /**
     * Overloaded contstuctor for setting the klok.
     */
    public KlokPanel(Klok klok) {
        this();
        this.klok = klok;
    }

    /**
     * Initializes and sets properties KlokPanel.
     */
    private void initialize() {
        setSize(AFMETING);
        setBackground(Color.BLUE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        //Transformatie naar centrum
        g2d.translate(AFMETING.getWidth() / 2, AFMETING.getHeight() / 2);
        AffineTransform centrum = g2d.getTransform();

        //Maak wijzerplaat
        Shape wijzerPlaat = new Ellipse2D.Double(-STRAAL, -STRAAL, 2 * STRAAL, 2 * STRAAL);
        g2d.setColor(Color.ORANGE);
        g2d.fill(wijzerPlaat);
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(8.0f));
        g2d.draw(wijzerPlaat);

        //Maak centrum wijzerplaat
        Shape centrumPunt = new Ellipse2D.Double(-10, -10, 20, 20);
        g2d.setColor(Color.BLACK);
        g2d.fill(centrumPunt);

        //Maak cijfers op de wijzerplaat
        g2d.setFont(CIJFERFONT);
        g2d.setColor(Color.BLUE);
        float fontSize = g2d.getFont().getSize2D();
        g2d.drawString(12 + "", -(fontSize * 2 / 3), -STRAAL + CIJFERLOC + (fontSize / 2));
        g2d.drawString(3 + "", STRAAL - CIJFERLOC - (fontSize / 2), +(fontSize / 4));
        g2d.drawString(6 + "", -(fontSize / 4), STRAAL - CIJFERLOC);
        g2d.drawString(9 + "", -STRAAL + CIJFERLOC, +(fontSize / 4));

        //Maak minutenaanduiding op rand.
        //Iedere 5 minuten wat groter.
        Shape streep1 = new Line2D.Double(0, -STRAAL, 0, -STRAAL + STREEP1);
        Shape streep5 = new Line2D.Double(0, -STRAAL, 0, -STRAAL + STREEP5);
        g2d.setStroke(new BasicStroke(2.0f));
        g2d.setColor(Color.BLACK);
        for (int i = 0; i < 60; i++) {
            if (i % 5 == 0) {
                g2d.draw(streep5);
            } else {
                g2d.draw(streep1);
            }
            g2d.rotate(Math.PI / 30);
        }
        //Wijzers halen hun informatie uit de klok.
        int seconden = klok.getTijd().get(Calendar.SECOND);
        int minuten = klok.getTijd().get(Calendar.MINUTE);
        int uren = klok.getTijd().get(Calendar.HOUR);
        Shape wijzer = new Line2D.Double(0, -12, 0, -STRAAL);

        //Uurwijzer
        g2d.setTransform(centrum);
        g2d.setStroke(new BasicStroke(5.0f));
        g2d.rotate((uren % 12 + minuten / 60.0) * Math.PI / 6);
        g2d.scale(1.0, UURWIJZER);
        g2d.draw(wijzer);

        //Minuutwijzer
        g2d.setStroke(new BasicStroke(3.0f));
        g2d.setColor(Color.BLACK);
        g2d.setTransform(centrum);
        g2d.rotate(minuten * Math.PI / 30);
        g2d.scale(1.0, MINUUTWIJZER);
        g2d.draw(wijzer);

        //Secondewijzer
        g2d.setTransform(centrum);
        g2d.setColor(Color.RED);
        g2d.rotate(seconden * Math.PI / 30);
        g2d.scale(1.0, SECONDEWIJZER);
        g2d.draw(wijzer);

    }
}
