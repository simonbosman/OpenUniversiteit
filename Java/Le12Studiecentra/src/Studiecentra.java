import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;

/**
 * Een gebruikersinterface waarmee een studiecentrum kan
 * worden geselecteerd. Een afbeelding van het geselecteerde
 * studiecentrum wordt getoond.
 *
 * @author Open Universiteit Nederland
 */
public class Studiecentra extends JFrame {

    private String[] plaatsnamen = {"amsterdam",
            "eindhoven",
            "heerlen",
            "rotterdam",
            "utrecht",
            "zwolle"};
    private JLabel fotoLabel = null;

    public Studiecentra() {
        super();
        initialize();
    }

    /**
     * Construeert een gebruikersinterface met links een knop voor
     * elke plaatsnaam en rechts een label waar een foto moet komen
     */
    private void initialize() {
        setSize(500, 300);
        setTitle("Studiecentra");

        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());

        // maak label voor afbeelding
        fotoLabel = new JLabel();
        fotoLabel.setBackground(Color.WHITE);
        fotoLabel.setOpaque(true);
        fotoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pane.add(fotoLabel, BorderLayout.CENTER);

        // maak knoppen voor keuze
        JPanel keuzePanel = new JPanel();
        keuzePanel.setLayout(new GridLayout(0, 1));
        pane.add(keuzePanel, BorderLayout.WEST);

        // luisteraar voor alle knoppen
        Luisteraar luisteraar = new Luisteraar();
        // maak alle knoppen
        for (String plaats : plaatsnamen) {
            JButton knop = new JButton(plaats);
            URL iconUrl = this.getClass().getResource("images/" + plaats + "_klein.jpg");
            Toolkit tk = this.getToolkit();
            Icon plaatsKlein = new ImageIcon(tk.getImage(iconUrl));
            knop.setIcon(plaatsKlein);
            keuzePanel.add(knop);
            knop.addActionListener(luisteraar);
        }
    }

    public static void main(String[] arg) {
        Studiecentra frame = new Studiecentra();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Luisteraarklasse voor de knoppen. Plaatst het juiste
     * plaatje op het label.
     *
     * @author Open Universiteit Nederland
     */
    public class Luisteraar implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //plaatsnaam ophalen.
            String plaatsNaam = ((JButton) e.getSource()).getText();
            //Icon maken met deze plaatsnaam.
            URL iconUrl = this.getClass().getResource("images/" + plaatsNaam + ".jpg");
            Toolkit tk = Studiecentra.this.getToolkit();
            Icon plaatsAfbeelding = new ImageIcon(tk.getImage(iconUrl));
            //afbeelding toevoegen aan fotoframe.
            fotoLabel.setIcon(plaatsAfbeelding);
        }
    }
}
