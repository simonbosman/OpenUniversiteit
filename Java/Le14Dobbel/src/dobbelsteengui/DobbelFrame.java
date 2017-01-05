package dobbelsteengui;

import javax.swing.JFrame;
import javax.swing.JButton;

import dobbelsteen.Dobbelsteen;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * GUI-klasse die op twee manieren het aantal ogen van
 * een dobbelsteen toont.
 */
public class DobbelFrame extends JFrame {
    // constanten voor afnmetingen van het frame
    private static final int FRAME_BREEDTE = 260;
    private static final int FRAME_HOOGTE = 220;

    private Dobbelsteen dobbelsteen = new Dobbelsteen();

    /**
     * Constructor roept initialize() aan
     */
    public DobbelFrame() {
        super();
        initialize();
    }

    /**
     * Plaatst een knop, DobbelLabel en DobbelPanel
     * en geeft de knop een event handler.
     */
    private void initialize() {
        setTitle("Dobbelsteen frame");
        setSize(FRAME_BREEDTE, FRAME_HOOGTE);
        getContentPane().setLayout(null);

        // Maak de knop, voeg die toe en geef hem een
        // luisteraar
        JButton gooiKnop = new JButton();
        gooiKnop.setBounds(19, 15, 81, 35);
        gooiKnop.setText("Gooi");
        getContentPane().add(gooiKnop);
        gooiKnop.addMouseListener(new KnopLuisteraar());

        // Maak de DobbelLabel en voeg die toe
        DobbelLabel dobbelLabel = new DobbelLabel();
        dobbelLabel.setBounds(122, 15, 94, 73);
        dobbelLabel.setFont(new Font("Dialog", Font.BOLD, 72));
        dobbelLabel.setOpaque(true);
        dobbelLabel.setBackground(Color.LIGHT_GRAY);
        getContentPane().add(dobbelLabel);
        dobbelsteen.addObserver(dobbelLabel);

        // Maak het DobbelPanel en voeg dat toe
        DobbelPanel dobbelPanel = new DobbelPanel();
        dobbelPanel.setBounds(15, 65, 90, 90);
        dobbelsteen.addObserver(dobbelPanel);
        getContentPane().add(dobbelPanel);
    }

    public static void main(String[] args) {
        DobbelFrame frame = new DobbelFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Bij klikken op de knop wordt de dobbelsteen
     * gegooid.
     */
    public class KnopLuisteraar extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            dobbelsteen.werp();
        }
    }


} 
