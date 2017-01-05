package bibliotheekdata;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import bibliotheek.Boek;

/**
 * De klasse BibliotheekBestand is verantwoordelijk voor het
 * lezen en schrijven van boeken naar een bestand.
 *
 * @author Open Universiteit Nederland
 */
public class BibliotheekBestand {
    private File file = null;

    /**
     * Creëert een instantie van BibliotheekBestand
     *
     * @param file de padnaam van het achterliggende bestand
     */
    public BibliotheekBestand(File file) {
        this.file = file;
    }

    /**
     * Leest alle boeken in uit het gegeven bestand.
     *
     * @return een ArrayList met alle Boek-objecten
     * @throws BibliotheekException als er een fout optreedt
     */
    public ArrayList<Boek> leesAlleBoeken()
            throws BibliotheekException {
        ArrayList<Boek> boekenlijst = new ArrayList<Boek>();
        BufferedReader lezer = null;
        try {
            lezer = new BufferedReader(
                    new FileReader(file));
            String titel = lezer.readLine();
            while (titel != null) {
                String auteur = lezer.readLine();
                boekenlijst.add(new Boek(titel, auteur));
                titel = lezer.readLine();
            }
        } catch (FileNotFoundException e) {
            // Er was nog geen bestand
        } catch (IOException e) {
            // Nu is er echt iets mis gegaan
            throw new BibliotheekException("Fout bij lezen");
        } finally {
            if (lezer != null) {
                try {
                    lezer.close();
                } catch (IOException ioe) {
                }
            }
        }
        return boekenlijst;
    }

    /**
     * Schrijft alle boeken uit de lijst weg naar het bestand
     *
     * @param boekenlijst het toe te voegen boek
     * @throws BibliotheekException als er een fout optreedt
     */

    public void schrijfAlleBoeken(ArrayList<Boek> boekenlijst)
            throws BibliotheekException {
        PrintWriter schrijver = null;
        try {
            schrijver =
                    new PrintWriter(
                            new BufferedWriter(
                                    new FileWriter(file, false)));
            for (Boek boek : boekenlijst) {
                schrijver.println(boek.getTitel());
                schrijver.println(boek.getAuteur());
            }
        } catch (IOException e) {
            throw new BibliotheekException("Fout bij schrijven");
        } finally {
            if (schrijver != null) {
                schrijver.close();
            }
        }
    }

}
