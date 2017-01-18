package klokgui;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

import klok.Klok;


/**
 * Deze klasse toont een lopende klok  met wijzers die
 * tijd aangeeft in een door de gebruiker gekozen stad.
 */
public class WijzerKlokFrame extends JFrame {

    private Klok klok = new Klok(this); // de klok
    private KlokPanel klokPanel = null;
    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private JComboBox stadKeuze = null;

    /**
     * This is the default constructor
     */
    public WijzerKlokFrame() {
        super();
        initialize();
        mijnInit();
    }

    /**
     * Update de grafische representatie van de klok.
     */
    public void update() {
        klokPanel.repaint();
    }

    /**
     * Maakt de klok, voegt deze toe aan de interface.
     * Voegt de namen van de steden uit het domein toe
     * aan de keuzelijst
     */
    private void mijnInit() {
        for (String naam : klok.getStadsnamen()) {
            stadKeuze.addItem(naam);
        }
        klok.startKlok();
    }

    /**
     * Geeft een wijziging in de keuze van de stad door aan
     * de klok.
     */
    private void stadKeuzeAction() {
        int index = stadKeuze.getSelectedIndex();
        klok.wijzigStad(index);
    }

    /**
     * Bij het sluiten van het frame wordt eerst de klok gestopt.
     */
    private void closeWindow() {
        klok.stopKlok();
        System.exit(0);
    }

    /**
     * This method initializes this
     *
     * @return void
     */
    private void initialize() {
        this.setSize(640, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(getJContentPane());
        this.setTitle("Internationale klok");
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                closeWindow();
            }
        });
    }

    /**
     * This method initializes jContentPane
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jContentPane = new JPanel();
            jContentPane.setLayout(null);
            jContentPane.add(getStadKeuze(), null);
            jContentPane.add(getKlok());
        }
        return jContentPane;
    }

    /**
     * This method initializes de Klok.
     * @return javax.swing.JPanel
     */
    private KlokPanel getKlok() {
        klokPanel = new KlokPanel(this.klok);
        klokPanel.setLocation(10, 10);
        return klokPanel;
    }

    /**
     * This method initializes stadKeuze
     *
     * @return javax.swing.JComboBox
     */
    private JComboBox getStadKeuze() {
        if (stadKeuze == null) {
            stadKeuze = new JComboBox();
            stadKeuze.setBounds(new Rectangle(250, 620, 120, 25));
            stadKeuze.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    stadKeuzeAction();
                }
            });
        }
        return stadKeuze;
    }

    public static void main(String[] args) {
        WijzerKlokFrame klokFrame = new WijzerKlokFrame();
        klokFrame.setVisible(true);
    }


}  //  @jve:decl-index=0:visual-constraint="10,10"
