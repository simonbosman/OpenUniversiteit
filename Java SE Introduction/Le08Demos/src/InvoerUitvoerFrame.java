
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JTextField;
import java.awt.Font;
import java.util.Random;

import javax.swing.JButton;
import java.awt.Dimension;

/**
 *
 * Demo-applicatie die illustreert dat er in een Java-programma
 * met een gui verschillende processen tegelijk plaatsvinden:
 * Er is interactie met de GUI mogelijk terwijl main een
 * berekening uitvoert.
 * De GUI toont een ingevoerde tekst groter en in kleur
 * @author Open Universiteit Nederland
 *
 */
public class InvoerUitvoerFrame extends JFrame {
  
  /**
   * Door de waarde van deze variabele te wijzigen, kan
   * de tijd dat main bezig is, beïnvloed worden.
   */
  private static final long MAXTELLER = 5000000000000000L;
  
  private static final long serialVersionUID = 1L;
  private JPanel jContentPane = null;
  private JLabel uitvoerLabel = null;

  private JTextField invoerVeld = null;

  /**
   * This is the default constructor
   */
  public InvoerUitvoerFrame() {
    super();
    initialize();
  }
  
  /**
   * Kopieert de string van invoerVeld naar uitvoerLabel
   */
  private void invoerVeldAction() {
    String s = invoerVeld.getText();
    uitvoerLabel.setText(s);
  }

  /**
   * This method initializes this
   * @return void
   */
  private void initialize() {
    this.setSize(341, 158);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(getJContentPane());
    this.setTitle("Invoer en uitvoer");
  }

  /**
   * This method initializes jContentPane
   * 
   * @return javax.swing.JPanel
   */
  private JPanel getJContentPane() {
    if (jContentPane == null) {
      uitvoerLabel = new JLabel();
      uitvoerLabel.setBounds(new Rectangle(14, 58, 315, 59));
      uitvoerLabel.setFont(new Font("Dialog", Font.BOLD, 36));
      uitvoerLabel.setForeground(Color.red);
      uitvoerLabel.setText("");
      jContentPane = new JPanel();
      jContentPane.setLayout(null);
      jContentPane.add(uitvoerLabel, null);
      jContentPane.add(getInvoerVeld(), null);
    }
    return jContentPane;
  }

  /**
   * This method initializes invoerVeld	
   * 	
   * @return javax.swing.JTextField	
   */
  private JTextField getInvoerVeld() {
    if (invoerVeld == null) {
      invoerVeld = new JTextField();
      invoerVeld.setBounds(new Rectangle(16, 14, 137, 30));
      invoerVeld.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          invoerVeldAction();
        }
      });
    }
    return invoerVeld;
  }

  /**
   * main toont de gui en begint dan aan een lange berekening.
   * Acties in de gui en de berekening lopen parallel
   */
  public static void main(String[] args) {
    long starttijd = System.currentTimeMillis();
    InvoerUitvoerFrame gui = new InvoerUitvoerFrame();
    gui.setVisible(true);
    
    // Hier begint een lange berekening
    long teller = 0;
    while (teller < MAXTELLER) {
      teller++;
    }
    long eindtijd = System.currentTimeMillis();
    System.out.println("Main is klaar na " + (eindtijd - starttijd) / 1000 + " seconden");
  }

}  //  @jve:decl-index=0:visual-constraint="10,10"
