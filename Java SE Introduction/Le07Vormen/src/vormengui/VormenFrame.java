package vormengui;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import vormen.*;

/**
 * Gebruikersinterface voor de vormenapplicatie.
 * @author Open Universiteit Nederland
 */
public class VormenFrame extends JFrame {
  // Enumeratietype voor verschillende vormen
  public enum Vormkeuze {BLOK, BOL, CILINDER};  
  
  // Constante voor formatteren double-waarden.
  // De formatter krijgt een tweede parameter mee, die er voor zorgt
  // dat de decimale punt wordt gebruikt ipv de decimal komma
  // Dat voorkomt dat de invoer van double-waarden een punt eist,
  // terwijl de uitvoer een komma toont.
  private static final DecimalFormat formatter = 
    new DecimalFormat("0.000000", new DecimalFormatSymbols(Locale.US));  
  
  // attribuut voor vormenlijst
  private Vormenlijst vormen = new Vormenlijst();

  private static final long serialVersionUID = 1L;  
  private JPanel jContentPane = null;
  private JComboBox vormenKeuze = null;
  private JLabel vormLabel = null;
  private JButton voegtoeKnop = null;
  private JLabel afmeting1Label = null;
  private JLabel afmeting2Label = null;
  private JTextField afmeting1Veld = null;
  private JTextField afmeting2Veld = null;
  private JLabel totaalLabel = null;
  private JTextField totaalVeld = null;
  private JButton totaalKnop = null;
  private JTextArea uitvoerGebied = null;

  /**
   * This method initializes 
   * 
   */
  public VormenFrame() {
  	super();
  	initialize();
  	mijnInit();
  }

  /**
   * Vult  vormenkeuze met mogelijke vormen
   */
  private void mijnInit() {
    for (Vormkeuze keuze : Vormkeuze.values()) {
      vormenKeuze.addItem(keuze);
    }
    vormenKeuze.setSelectedIndex(-1);
  }
  
  /**
   * Toont de velden en labels die nodig zijn bij 
   * de geselecteerde vorm 
   */
  private void selecteerVormAction() {
    Vormkeuze keuze = (Vormkeuze)vormenKeuze.getSelectedItem();
    if (keuze == null) {
      afmeting1Label.setVisible(false);
      afmeting1Veld.setVisible(false);
      afmeting2Label.setVisible(false);
      afmeting2Veld.setVisible(false);
      return;
    }
    switch (keuze) {
      case BLOK:
        afmeting1Label.setText("Zijde");
        afmeting1Label.setVisible(true);
        afmeting1Veld.setVisible(true);
        afmeting2Label.setText("Hoogte");
        afmeting2Label.setVisible(true);
        afmeting2Veld.setVisible(true);
        break;
      case BOL:
        afmeting1Label.setText("Straal");
        afmeting1Label.setVisible(true);
        afmeting1Veld.setVisible(true);
        afmeting2Label.setVisible(false);
        afmeting2Veld.setVisible(false);
        break;
      case CILINDER:
        afmeting1Label.setText("Straal");
        afmeting1Label.setVisible(true);
        afmeting1Veld.setVisible(true);
        afmeting2Label.setText("Hoogte");
        afmeting2Label.setVisible(true);
        afmeting2Veld.setVisible(true);
        break;
      default:
        afmeting1Label.setVisible(false);
        afmeting1Veld.setVisible(false);
        afmeting2Label.setVisible(false);
        afmeting2Veld.setVisible(false);
    }
    afmeting1Veld.setText("");
    afmeting2Veld.setText("");
  }
  
  /**
   * Eventhandler voor het toevoegen van een vorm.
   * Leest de gegevens van een vorm (type + waarden),
   * maakt een vorm en voegt deze toe aan de vormenlijst.
   */
  private void voegtoeAction() {
    Vormkeuze keuze = (Vormkeuze)vormenKeuze.getSelectedItem();
    if (keuze == null) {
      return;
    }
    try {
      switch (keuze) {
        case BLOK:
          double zijde = Double.parseDouble(afmeting1Veld.getText());
          double hoogte = Double.parseDouble(afmeting2Veld.getText());
          vormen.maakBlok(zijde, hoogte);
          break;
        case BOL:
          double straal = Double.parseDouble(afmeting1Veld.getText());
          vormen.maakBol(straal);
          break;
        case CILINDER:
          straal = Double.parseDouble(afmeting1Veld.getText());
          hoogte = Double.parseDouble(afmeting2Veld.getText());
          vormen.maakCilinder(straal, hoogte);
          break;
      }
    }
    catch (NumberFormatException e) {
      toonExceptionMelding("Voor een getal in.");
    }
    afmeting1Veld.setText("");
    afmeting2Veld.setText("");
    uitvoerGebied.setText(vormen.toString());
  }

  /**
   * Toont een dialog window met de exception.
   * @param melding De te tonen exception.
   */
  private void toonExceptionMelding(String melding) {
    JOptionPane.showMessageDialog(this, melding, getClass().getName(), JOptionPane.ERROR_MESSAGE);
  }

  /**
   * Eventhandler voor het tonen van de totale inhoud
   * van alle vormen.
   */
  private void totaalInhoudAction() {
    double inhoud = vormen.totaalInhoud();
    totaalVeld.setText(formatter.format(inhoud));
  }
  
  /**
   * This method initializes this
   * 
   */
  private void initialize() {
    this.setSize(new Dimension(438, 251));
    this.setContentPane(getJContentPane());
    this.setTitle("Vormen");
  }

  /**
   * This method initializes jContentPane	
   * 	
   * @return javax.swing.JPanel	
   */
  private JPanel getJContentPane() {
    if (jContentPane == null) {
      totaalLabel = new JLabel();
      totaalLabel.setBounds(new Rectangle(9, 146, 107, 19));
      totaalLabel.setText("Totale inhoud");
      afmeting2Label = new JLabel();
      afmeting2Label.setBounds(new Rectangle(209, 10, 63, 19));
      afmeting2Label.setText("Hoogte");
      afmeting2Label.setVisible(false);
      afmeting1Label = new JLabel();
      afmeting1Label.setBounds(new Rectangle(110, 10, 63, 19));
      afmeting1Label.setText("Zijde");
      afmeting1Label.setVisible(false);
      vormLabel = new JLabel();
      vormLabel.setBounds(new Rectangle(9, 10, 63, 19));
      vormLabel.setText("Vorm");
      jContentPane = new JPanel();
      jContentPane.setLayout(null);
      jContentPane.add(getVormenComboBox(), null);
      jContentPane.add(vormLabel, null);
      jContentPane.add(getVoegtoeButton(), null);
      jContentPane.add(afmeting1Label, null);
      jContentPane.add(afmeting2Label, null);
      jContentPane.add(getAfmeting1TextField(), null);
      jContentPane.add(getAfmeting2TextField(), null);
      jContentPane.add(totaalLabel, null);
      jContentPane.add(getTotaalTextField(), null);
      jContentPane.add(getTotaalButton(), null);
      jContentPane.add(getUitvoerTextArea(), null);
    }
    return jContentPane;
  }

  /**
   * This method initializes vormenComboBox	
   * 	
   * @return javax.swing.JComboBox	
   */
  private JComboBox getVormenComboBox() {
    if (vormenKeuze == null) {
      vormenKeuze = new JComboBox();
      vormenKeuze.setBounds(new Rectangle(9, 39, 94, 19));
      vormenKeuze.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          selecteerVormAction();
        }
      });
    }
    return vormenKeuze;
  }

  /**
   * This method initializes voegtoeButton	
   * 	
   * @return javax.swing.JButton	
   */
  private JButton getVoegtoeButton() {
    if (voegtoeKnop == null) {
      voegtoeKnop = new JButton();
      voegtoeKnop.setBounds(new Rectangle(9, 83, 93, 19));
      voegtoeKnop.setText("Voeg toe");
      voegtoeKnop.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          voegtoeAction();
        }
      });
    }
    return voegtoeKnop;
  }

  /**
   * This method initializes afmeting1TextField	
   * 	
   * @return javax.swing.JTextField	
   */
  private JTextField getAfmeting1TextField() {
    if (afmeting1Veld == null) {
      afmeting1Veld = new JTextField();
      afmeting1Veld.setBounds(new Rectangle(110, 39, 94, 19));
      afmeting1Veld.setVisible(false);
    }
    return afmeting1Veld;
  }

  /**
   * This method initializes afmeting2TextField	
   * 	
   * @return javax.swing.JTextField	
   */
  private JTextField getAfmeting2TextField() {
    if (afmeting2Veld == null) {
      afmeting2Veld = new JTextField();
      afmeting2Veld.setBounds(new Rectangle(209, 39, 94, 19));
      afmeting2Veld.setVisible(false);
    }
    return afmeting2Veld;
  }

  /**
   * This method initializes totaalTextField	
   * 	
   * @return javax.swing.JTextField	
   */
  private JTextField getTotaalTextField() {
    if (totaalVeld == null) {
      totaalVeld = new JTextField();
      totaalVeld.setBounds(new Rectangle(9, 182, 108, 19));
      totaalVeld.setHorizontalAlignment(JTextField.LEFT);
      totaalVeld.setEditable(false);
    }
    return totaalVeld;
  }

  /**
   * This method initializes totaalButton	
   * 	
   * @return javax.swing.JButton	
   */
  private JButton getTotaalButton() {
    if (totaalKnop == null) {
      totaalKnop = new JButton();
      totaalKnop.setBounds(new Rectangle(110, 83, 114, 19));
      totaalKnop.setText("Totale inhoud");
      totaalKnop.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          totaalInhoudAction();
        }
      });
    }
    return totaalKnop;
  }

  /**
   * This method initializes uitvoerTextArea	
   * 	
   * @return javax.swing.JTextArea	
   */
  private JTextArea getUitvoerTextArea() {
    if (uitvoerGebied == null) {
      uitvoerGebied = new JTextArea();
      uitvoerGebied.setBounds(new Rectangle(240, 85, 160, 124));
      uitvoerGebied.setEditable(false);
    }
    return uitvoerGebied;
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    VormenFrame frame = new VormenFrame();
    frame.setVisible(true);
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

}
