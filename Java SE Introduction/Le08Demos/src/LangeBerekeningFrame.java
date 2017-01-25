import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.JLabel;

/**
 * Klasse bedoeld om te demonstreren dat een actie die
 * wordt uitgevoerd in een event handler, niet door een
 * andere event handler kan worden onderbroken.
 */
public class LangeBerekeningFrame extends JFrame implements Runnable {

    private static final long MAXTELLER = 50000000000L;

    private AtomicBoolean stoppen = new AtomicBoolean(true);

    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private JButton stopKnop = null;
    private JButton rekenKnop = null;
    private JLabel waardeLabel = null;
    private JLabel tijdLabel = null;

    /**
     * This is the default constructor
     */
    public LangeBerekeningFrame() {
        super();
        initialize();
    }
    /**
     * Deze methode telt tot MAXTELLER en toont dan in tijdLabel
     * hoe lang dat duurt. Als de boolean-variabele stoppen de
     * waarde true krijgt, wordt gestopt met tellen.
     */
    public void run() {
        stoppen.set(false);
        waardeLabel.setText("");
        tijdLabel.setText("");

        long startTijd = System.currentTimeMillis();
        long teller = 0;
        while (teller < MAXTELLER && !stoppen.get()) {
            teller++;
        }
        long eindTijd = System.currentTimeMillis();
        waardeLabel.setText("teller = " + teller);
        tijdLabel.setText("tijd: " + (eindTijd - startTijd) / 1000 + " sec.");
    }

    /**
     * Maakt een nieuwe thread waarin de code van
     * methode run wordt uitgevoerd.
     */
    private void rekenKnopAction() {
        Thread thread = new Thread(this);
        thread.start();
    }

    /**
     * Poging om de lange berekening te onderbreken door
     * stoppen true te maken.
     */
    private void stopKnopAction() {
        stoppen.set(true);
        System.out.println("StopKnopAction");
    }

    /**
     * This method initializes this
     *
     * @return void
     */
    private void initialize() {
        this.setSize(192, 215);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(getJContentPane());
        this.setTitle("Demo");
    }

    /**
     * This method initializes jContentPane
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJContentPane() {
        if (jContentPane == null) {
            tijdLabel = new JLabel();
            tijdLabel.setBounds(new Rectangle(18, 93, 150, 22));
            tijdLabel.setText("");
            waardeLabel = new JLabel();
            waardeLabel.setBounds(new Rectangle(18, 61, 150, 22));
            waardeLabel.setText("");
            jContentPane = new JPanel();
            jContentPane.setLayout(null);
            jContentPane.add(getRekenKnop(), null);
            jContentPane.add(waardeLabel, null);
            jContentPane.add(getStopKnop(), null);
            jContentPane.add(tijdLabel, null);
        }
        return jContentPane;
    }

    /**
     * This method initializes stopKnop
     *
     * @return javax.swing.JButton
     */
    private JButton getStopKnop() {
        if (stopKnop == null) {
            stopKnop = new JButton();
            stopKnop.setBounds(new Rectangle(18, 125, 149, 41));
            stopKnop.setText("Stop!");
            stopKnop.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    stopKnopAction();
                }
            });
        }
        return stopKnop;
    }

    /**
     * This method initializes rekenKnop
     *
     * @return javax.swing.JButton
     */
    private JButton getRekenKnop() {
        if (rekenKnop == null) {
            rekenKnop = new JButton();
            rekenKnop.setBounds(new Rectangle(18, 10, 150, 41));
            rekenKnop.setText("Lange berekening");
            rekenKnop.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    rekenKnopAction();
                }
            });
        }
        return rekenKnop;
    }

    public static void main(String[] args) {
        LangeBerekeningFrame gui = new LangeBerekeningFrame();
        gui.setVisible(true);
    }

}  //  @jve:decl-index=0:visual-constraint="10,10"
