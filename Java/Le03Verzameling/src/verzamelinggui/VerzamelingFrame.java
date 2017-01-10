package verzamelinggui;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

import verzameling.Verzameling;

import javax.swing.JTextArea;

/**
 * Klasse Verzamelingframe biedt een gebruikersinterface
 * waarmee operaties op twee verzamelingen kunnen worden
 * uitgevoerd.
 * Er zijn twee verzamelingen. Aan een geselecteerde
 * verzameling kan een element worden toegevoegd, er
 * kan een element uit worden verwijderd of alle elementen
 * kunnen eruit worden verwijderd. Ook kan de vereniging en
 * de doorsnede van de twee verzamelingen bepaald worden
 *
 * @author Open Universiteit Nederland
 */
public class VerzamelingFrame extends JFrame {

    // maak twee verzamelingen
    private Verzameling[] verzamelingen =
            {new Verzameling(), new Verzameling()};

    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private JLabel verzamelingLabel = null;
    private JLabel elementLabel = null;
    private JComboBox verzamelingComboBox = null;
    private JTextField elementTextField = null;
    private JButton voegtoeButton = null;
    private JButton verwijderButton = null;
    private JButton verenigingButton = null;
    private JButton doorsnedeButton = null;
    private JTextArea uitvoerTextArea = null;
    private JButton maakleegButton = null;
    private JButton gelijkButton = null;

    /**
     * This is the default constructor
     */
    public VerzamelingFrame() {
        super();
        initialize();
        mijnInit();
    }

    /**
     * Eigen initializaties.
     */
    private void mijnInit() {
        verzamelingComboBox.addItem("verzameling 1");
        verzamelingComboBox.addItem("verzameling 2");
    }

    /**
     * Event handler voor het wisselen van verzameling.
     */
    private void wisselVerzamelingAction() {
        int keuze = verzamelingComboBox.getSelectedIndex();
        uitvoerTextArea.setText(verzamelingen[keuze].toString());
        elementTextField.setText("");
        elementTextField.requestFocus();
    }

    /**
     * Event handler voor het toevoegen van een element aan
     * de verzameling.
     */
    private void voegtoeAction() {
        int keuze = verzamelingComboBox.getSelectedIndex();
        try {
            int elem = Integer.parseInt(elementTextField.getText());
            verzamelingen[keuze].voegToe(elem);
            uitvoerTextArea.setText(verzamelingen[keuze].toString());
        } catch (Exception e) {
        }
        elementTextField.setText("");
        elementTextField.requestFocus();
    }

    /**
     * Event handler voor het verwijderen van een element uit
     * de verzameling.
     */
    private void verwijderAction() {
        int keuze = verzamelingComboBox.getSelectedIndex();
        try {
            int elem = Integer.parseInt(elementTextField.getText());
            verzamelingen[keuze].verwijder(elem);
            uitvoerTextArea.setText(verzamelingen[keuze].toString());
        } catch (Exception e) {
        }
        elementTextField.setText("");
        elementTextField.requestFocus();
    }

    /**
     * Event handler voor het leegmaken van de verzameling.
     */
    private void maakleegAction() {
        int keuze = verzamelingComboBox.getSelectedIndex();
        verzamelingen[keuze].maakLeeg();
        uitvoerTextArea.setText(verzamelingen[keuze].toString());
        elementTextField.setText("");
        elementTextField.requestFocus();
    }

    /**
     * Event handler voor het bepalen van de vereniging van de
     * twee verzamelingen.
     */
    private void verenigingAction() {
        uitvoerTextArea.setText(verzamelingen[0].toString());
        uitvoerTextArea.append("\nvereniging met\n");
        uitvoerTextArea.append(verzamelingen[1].toString());
        uitvoerTextArea.append("\nis\n");
        uitvoerTextArea.append(verzamelingen[0].vereniging(verzamelingen[1]).toString());
    }

    /**
     * Event handler voor het bepalen van de doorsnede van de
     * twee verzamelingen.
     */
    private void doorsnedeAction() {
        uitvoerTextArea.setText(verzamelingen[0].toString());
        uitvoerTextArea.append("\ndoorsnede met\n");
        uitvoerTextArea.append(verzamelingen[1].toString());
        uitvoerTextArea.append("\nis\n");
        uitvoerTextArea.append(verzamelingen[0].doorsnede(verzamelingen[1]).toString());
    }

    /**
     * Event handler voor het bepalen of twee verzamelingen
     * gelijk zijn.
     */
    private void gelijkAction() {
        uitvoerTextArea.setText(verzamelingen[0].toString());
        uitvoerTextArea.append("\nen\n");
        uitvoerTextArea.append(verzamelingen[1].toString());
        if (verzamelingen[0].equals(verzamelingen[1])) {
            uitvoerTextArea.append("\nzijn gelijk\n");
        } else {
            uitvoerTextArea.append("\nzijn ongelijk\n");
        }
    }

    /**
     * This method initializes this
     *
     * @return void
     */
    private void initialize() {
        this.setSize(371, 273);
        this.setContentPane(getJContentPane());
        this.setTitle("Verzamelingen");
    }

    /**
     * This method initializes jContentPane
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJContentPane() {
        if (jContentPane == null) {
            elementLabel = new JLabel();
            elementLabel.setBounds(new Rectangle(130, 14, 82, 18));
            elementLabel.setText("Element");
            verzamelingLabel = new JLabel();
            verzamelingLabel.setBounds(new Rectangle(12, 14, 85, 18));
            verzamelingLabel.setName("");
            verzamelingLabel.setText("Verzameling");
            jContentPane = new JPanel();
            jContentPane.setLayout(null);
            jContentPane.add(verzamelingLabel, null);
            jContentPane.add(elementLabel, null);
            jContentPane.add(getVerzamelingComboBox(), null);
            jContentPane.add(getElementTextField(), null);
            jContentPane.add(getVoegtoeButton(), null);
            jContentPane.add(getVerwijderButton(), null);
            jContentPane.add(getVerenigingButton(), null);
            jContentPane.add(getDoorsnedeButton(), null);
            jContentPane.add(getUitvoerTextArea(), null);
            jContentPane.add(getMaakleegButton(), null);
            jContentPane.add(getGelijkButton(), null);
        }
        return jContentPane;
    }


    /**
     * This method initializes verzamelingComboBox
     *
     * @return javax.swing.JComboBox
     */
    private JComboBox getVerzamelingComboBox() {
        if (verzamelingComboBox == null) {
            verzamelingComboBox = new JComboBox();
            verzamelingComboBox.setBounds(new Rectangle(12, 37, 107, 20));
            verzamelingComboBox.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    wisselVerzamelingAction();
                }
            });
        }
        return verzamelingComboBox;
    }

    /**
     * This method initializes elementTextField
     *
     * @return javax.swing.JTextField
     */
    private JTextField getElementTextField() {
        if (elementTextField == null) {
            elementTextField = new JTextField();
            elementTextField.setBounds(new Rectangle(130, 37, 82, 20));
        }
        return elementTextField;
    }

    /**
     * This method initializes voegtoeButton
     *
     * @return javax.swing.JButton
     */
    private JButton getVoegtoeButton() {
        if (voegtoeButton == null) {
            voegtoeButton = new JButton();
            voegtoeButton.setBounds(new Rectangle(249, 13, 97, 25));
            voegtoeButton.setText("Voeg toe");
            voegtoeButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    voegtoeAction();
                }
            });
        }
        return voegtoeButton;
    }

    /**
     * This method initializes verwijderButton
     *
     * @return javax.swing.JButton
     */
    private JButton getVerwijderButton() {
        if (verwijderButton == null) {
            verwijderButton = new JButton();
            verwijderButton.setBounds(new Rectangle(249, 51, 97, 25));
            verwijderButton.setText("Verwijder");
            verwijderButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    verwijderAction();
                }
            });
        }
        return verwijderButton;
    }

    /**
     * This method initializes verenigingButton
     *
     * @return javax.swing.JButton
     */
    private JButton getVerenigingButton() {
        if (verenigingButton == null) {
            verenigingButton = new JButton();
            verenigingButton.setBounds(new Rectangle(249, 89, 97, 25));
            verenigingButton.setText("Vereniging");
            verenigingButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    verenigingAction();
                }
            });
        }
        return verenigingButton;
    }

    /**
     * This method initializes doorsnedeButton
     *
     * @return javax.swing.JButton
     */
    private JButton getDoorsnedeButton() {
        if (doorsnedeButton == null) {
            doorsnedeButton = new JButton();
            doorsnedeButton.setBounds(new Rectangle(249, 127, 97, 25));
            doorsnedeButton.setText("Doorsnede");
            doorsnedeButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    doorsnedeAction();
                }
            });
        }
        return doorsnedeButton;
    }

    /**
     * This method initializes uitvoerTextArea
     *
     * @return javax.swing.JTextArea
     */
    private JTextArea getUitvoerTextArea() {
        if (uitvoerTextArea == null) {
            uitvoerTextArea = new JTextArea();
            uitvoerTextArea.setBounds(new Rectangle(12, 64, 200, 168));
        }
        return uitvoerTextArea;
    }

    /**
     * This method initializes maakleegButton
     *
     * @return javax.swing.JButton
     */
    private JButton getMaakleegButton() {
        if (maakleegButton == null) {
            maakleegButton = new JButton();
            maakleegButton.setBounds(new Rectangle(249, 203, 97, 25));
            maakleegButton.setText("Maak leeg");
            maakleegButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    maakleegAction();
                }
            });
        }
        return maakleegButton;
    }

    /**
     * This method initializes gelijkButton
     *
     * @return javax.swing.JButton
     */
    private JButton getGelijkButton() {
        if (gelijkButton == null) {
            gelijkButton = new JButton();
            gelijkButton.setBounds(new Rectangle(249, 165, 97, 25));
            gelijkButton.setText("Gelijk");
            gelijkButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    gelijkAction();
                }
            });
        }
        return gelijkButton;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        VerzamelingFrame frame = new VerzamelingFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}  //  @jve:decl-index=0:visual-constraint="10,10"
