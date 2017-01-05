import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Applicatie die een aantal vierkanten toont.
 *
 * @author Open Universiteit Nederland.
 */
class VierkantenFrame extends JFrame {

    private VierkantenFrame() {
        super();
        initialize();
    }

    /**
     * Tekent tien blauwe vierkanten op random locaties
     */
    private void initialize() {
        setTitle("Vierkanten");
        Dimension screenSize = getToolkit().getScreenSize();
        setSize(screenSize);

        Container pane = getContentPane();
        pane.setLayout(null);
        pane.setBackground(Color.DARK_GRAY);

        for (int i = 0; i < 5; i++) {
            Vierkant vierkant = new Vierkant(Color.WHITE);
            vierkant.setLocation((int) (400 * Math.random()),
                    (int) (400 * Math.random()));
            pane.add(vierkant);

        }
    }

    public static void main(String[] arg) {
        VierkantenFrame frame = new VierkantenFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
