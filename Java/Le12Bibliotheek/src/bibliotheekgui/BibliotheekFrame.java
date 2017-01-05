package bibliotheekgui;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;


import bibliotheek.*;
import bibliotheekdata.BibliotheekException;


/**
 * Bouwsteen voor gebruikersinterface voor de bibliotheek
 *
 * @author Open Universiteit Nederland
 */
public class BibliotheekFrame extends JFrame {

    private Bibliotheek bibliotheek;
    private JList<Boek> boekenLijst;
    private JFileChooser bestandKiezer = new JFileChooser(".");

    private BibliotheekFrame() {
        super();
        initialize();
    }

    /**
     * Methode initialize geeft het frame een titel en geeft
     * de contentPane een BorderLayout.
     */
    private void initialize() {
        setSize(450, 350);
        setTitle("Bibliotheek");
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());
        bibliotheek = new Bibliotheek();
        //Make model for JList.
        DefaultListModel<Boek> modelBoeken = new DefaultListModel<Boek>();
        //Maak lijst met boeken en schuifbalken.
        boekenLijst = new JList<Boek>();
        boekenLijst.setModel(modelBoeken);
        JScrollPane scroller = new JScrollPane(boekenLijst);
        pane.add(scroller, BorderLayout.CENTER);
        makeMenu();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                leegMaken();
                System.exit(0);
            }
        });
    }

    /**
     * Maakt het menu.
     */
    private void makeMenu() {
        //Menu creëren.
        //Menubalk
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        //Menu Bestand
        JMenu menuBestand = new JMenu("Bestand");
        menuBar.add(menuBestand);
        //Menu Bewerken
        JMenu menuBewerken = new JMenu("Bewerken");
        menuBar.add(menuBewerken);
        //Menuopties toevoegen aan Bestand.
        JMenuItem openBestand = new JMenuItem("Openen...");
        openBestand.addActionListener(new OpenLuisteraar());
        menuBestand.add(openBestand);
        JMenuItem leegMaken = new JMenuItem("Leeg maken");
        leegMaken.addActionListener(new LeegMakenLuisteraar());
        menuBestand.add(leegMaken);
        menuBestand.addSeparator();
        JMenuItem opslaanBestand = new JMenuItem("Opslaan als..");
        //opslaanBestand.addActionListener(new OpslaanLuisteraar());
        opslaanBestand.addActionListener(e -> leegMaken());
        menuBestand.add(opslaanBestand);
        menuBestand.addSeparator();
        JMenuItem afsluiten = new JMenuItem("Afsluiten");
        afsluiten.addActionListener(new AfsluitenLuisteraar());
        menuBestand.add(afsluiten);
        //Menuopties toevoegen aan Bewerken
        JMenuItem toevoegen = new JMenuItem("Toevoegen");
        toevoegen.addActionListener(new ToevoegenLuisteraar());
        menuBewerken.add(toevoegen);
        JMenuItem verwijderen = new JMenuItem("Verwijderen");
        verwijderen.addActionListener(new VerwijderLuisteraar());
        menuBewerken.add(verwijderen);
    }

    /**
     * Open bibliotheek, haalt alle boeken op en laat deze zien.
     */
    public class OpenLuisteraar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            openBibliotheek();
            toonBoeken();
        }
    }

    /**
     * Laat een dialoog zien waarmee een boek toegevoegd kan worden.
     */
    public class ToevoegenLuisteraar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            voegBoekToe();
            toonBoeken();
        }
    }

    /**
     * Verwijder de geselecteerde boeken uit de bibliotheek.
     */
    public class VerwijderLuisteraar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            verwijderBoek();
            toonBoeken();
        }
    }

    /**
     * Slaat alle boeken op in de bibliotheek
     */
    private class OpslaanLuisteraar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            slaOpBibliotheek();
        }
    }

    /**
     * Maakt de lijst met boeken leeg.
     * Vraag of huidige lijst met boeken opgeslagen moet worden.
     */
    public class LeegMakenLuisteraar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            leegMaken();
            toonBoeken();
        }
    }

    /**
     * Sluit programma af, vraagt om opslaan i.g.v. gewijzigde boekenlijst.
     */
    public class AfsluitenLuisteraar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            leegMaken();
            System.exit(0);
        }
    }

    /**
     * Open bibliotheek met boeken in opgegeven bestand.
     */
    private void openBibliotheek() {
        int gekozen = bestandKiezer.showOpenDialog(BibliotheekFrame.this);
        if (gekozen == JFileChooser.APPROVE_OPTION) {
            System.out.println(bestandKiezer.getSelectedFile());
            try {
                bibliotheek.open(bestandKiezer.getSelectedFile());
            } catch (BibliotheekException e) {
                JOptionPane.showMessageDialog(this, "Boeken uit dit " +
                                "bestand kunnen niet gelezen worden.", "BibliotheekException",
                        JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    /**
     * Sla de bibliotheek met boeken op in het gegeven bestand.
     */
    private void slaOpBibliotheek() {
        int gekozenFile = bestandKiezer.showSaveDialog(this);
        if (gekozenFile == JFileChooser.APPROVE_OPTION) {
            try {
                bibliotheek.slaOp(bestandKiezer.getSelectedFile());
            } catch (BibliotheekException e) {
                JOptionPane.showMessageDialog(this, "Boeken kunnen niet worden " +
                        "opgeslagen in dit bestand." + e, "BibliotheekException", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Voegt een boek toe aan de bibliotheek.
     */
    private void voegBoekToe() {
        System.out.println("Toevoegen...clicked.");
        String titel = JOptionPane.showInputDialog("Geef de titel van het boek:");
        if (titel != null && !titel.isEmpty()) {
            String auteur = JOptionPane.showInputDialog("Geef de auteur van het boek:");
            if (auteur != null && !auteur.isEmpty()) {
                bibliotheek.voegBoekToe(titel, auteur);
            }
        }
    }

    /**
     * Verwijdert de geselecteerde boeken.
     */
    private void verwijderBoek() {
        int[] boekIds = boekenLijst.getSelectedIndices();
        DefaultListModel model = (DefaultListModel) boekenLijst.getModel();
        for (int index : boekIds) {
            Boek boek = (Boek) model.getElementAt(index);
            bibliotheek.verwijderBoek(boek);
        }
    }

    /**
     * Laat alle boeken uit de bibliotheek zien.
     */
    private void toonBoeken() {
        DefaultListModel<Boek> model = (DefaultListModel<Boek>) boekenLijst.getModel();
        model.removeAllElements();
        for (Boek boek : bibliotheek.getBoekenlijst()) {
            model.addElement(boek);
        }
    }

    /**
     * Maakt de lijst met boeken leeg en vraagt om huidige lijst op te slaan.
     */
    private void leegMaken() {
        if (bibliotheek.isGewijzigd()) {
            int keuze = JOptionPane.showConfirmDialog(this, "Wilt u de " +
                    "bibliotheek opslaan?", "", JOptionPane.YES_NO_OPTION);
            if (keuze == JOptionPane.YES_OPTION) {
                slaOpBibliotheek();
            }
        }
        bibliotheek.maakLeeg();
    }
    /**
     * Maakt gui in look en feel van gebruikt OS.
     *
     * @param args input parameters
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        BibliotheekFrame frame = new BibliotheekFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        SwingUtilities.updateComponentTreeUI(frame);
    }

}
