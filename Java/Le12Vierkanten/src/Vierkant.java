import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * Representeert een vierkante panel.
 *
 * @author Open Universiteit Nederland
 */
class Vierkant extends JPanel {
    private static final int AFMETING = 600;
    private static final int DELTA = 10; // verplaatsing in pixel
    private final Point anker = new Point();

    /**
     * Maakt een vierkante panel.
     */
    public Vierkant(Color kleur) {
        setSize(AFMETING + 200, AFMETING);
        setBackground(kleur);
        setFocusable(true);
        ImageIcon icon = new ImageIcon("images\\hondjes.jpg");
        add(new JLabel(icon));
        setOpaque(false);
        addKeyListener(new PijlLuisteraar());
        addKeyListener(new KleurLuisteraar());
        addMouseListener(new MuisLuisteraar());
        addMouseMotionListener(new MuisBewegingLuisteraar());
    }

    /**
     * Handelt klik events af.
     */
    public class MuisLuisteraar extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            requestFocusInWindow();
            anker.x = e.getX();
            anker.y = e.getY();
        }
    }

    /**
     * Handelt muisbewegingen af.
     */
    public class MuisBewegingLuisteraar extends MouseMotionAdapter {
        @Override
        public void mouseDragged(MouseEvent e) {
            int dx = e.getX() - anker.x;
            int dy = e.getY() - anker.y;
            Point pos = getLocation();
            setLocation(pos.x + dx, pos.y + dy);
        }
    }

    /**
     * Verandert de kleuren van het mainframe.
     *
     */
    public class KleurLuisteraar extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            Container parent = ((Container) e.getSource()).getParent();
            switch (e.getKeyCode()) {
                case KeyEvent.VK_B:
                    parent.setBackground(Color.BLACK);
                    break;
                case KeyEvent.VK_Y:
                    parent.setBackground(Color.YELLOW);
                    break;
                case KeyEvent.VK_R:
                    parent.setBackground(Color.RED);
                    break;
                case KeyEvent.VK_G:
                    parent.setBackground(Color.GREEN);
                    break;
                case KeyEvent.VK_L:
                    parent.setBackground(Color.DARK_GRAY);
                    break;
                default:
                    System.out.println(e.getKeyChar());
            }
        }
    }

    /**
     * Handelt de key events af.
     */
    public class PijlLuisteraar extends KeyAdapter {
        /**
         * Verplaatst het vierkant i.g.v. één van de pijltoetsen gekozen is.
         * Verplaatsing is de waarde van DELTA.
         *
         * @param e
         */
        @Override
        public void keyPressed(KeyEvent e) {

            Point locVierkant = getLocation();

            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    locVierkant.y = locVierkant.y - DELTA;
                    break;
                case KeyEvent.VK_DOWN:
                    locVierkant.y = locVierkant.y + DELTA;
                    break;
                case KeyEvent.VK_LEFT:
                    locVierkant.x = locVierkant.x - DELTA;
                    break;
                case KeyEvent.VK_RIGHT:
                    locVierkant.x = locVierkant.x + DELTA;
                    break;
            }

            setLocation(locVierkant);
        }
    }
}
