package bibliotheek;

import java.util.*;
import java.io.*;

import bibliotheekdata.BibliotheekBestand;
import bibliotheekdata.BibliotheekException;

/**
 * Deze klasse beheert een bibliotheek van boeken.
 * Er kan een boek worden toegevoegd en de auteur van een
 * gegeven titel kan worden opgezocht.
 * @author Open Universiteit Nederland
 */ 
public class Bibliotheek {

  private BibliotheekBestand bestand = null;
  private ArrayList<Boek> boekenlijst = new ArrayList<Boek>();
  private boolean gewijzigd = false;
 
  /**
   * Levert een lijst van alle boeken.
   * @return  de lijst met boeken
   */
  public ArrayList<Boek> getBoekenlijst() {
    return boekenlijst;
  }
  
  /**
   * Kijkt of bibliotheek gewijzigd is, sinds de laatste keer
   * dat bibliotheek gelezen of gescheven is uit/naar bestand.
   * @return true als bibliotheek is gewijzigd, anders false.
   */
  public boolean isGewijzigd() {
    return gewijzigd;
  }
  
  /**
   * Voegt een boek toe aan de bibliotheek.
   * Voorwaarde: er is nog geen boek met deze titel van deze auteur
   * @param titel  de titel van het boek
   * @param auteur  de auteur van het boek
   */
  public void voegBoekToe(String titel, String auteur) {
    if (geefBoek(titel, auteur) == null) {
      Boek boek = new Boek(titel, auteur);
      boekenlijst.add(boek);
      gewijzigd = true;
    }
  }
  
  /**
   * Verwijdert boek uit bibliotheek.
   * @param boek het te verwijderen boek.
   */
  public void verwijderBoek(Boek boek) {
    boekenlijst.remove(boek);
    gewijzigd = true;
  }
 
  /**
   * Opent een nieuwe bibliotheek uit gegeven bestand.
   * @param file bestandsfile
   * @throws BibliotheekException bij fout tijdens inlezen van de boeken
   */
  public void open(File file) throws BibliotheekException {
    bestand = new BibliotheekBestand(file);
    boekenlijst = bestand.leesAlleBoeken();
    gewijzigd = false;
  }

  /**
   * Slaat bibliotheek op in gegeven bestand.
   * @param file bestandsfile
   * @throws BibliotheekException bij fout tijdens inlezen van de boeken
   */
  public void slaOp(File file)  throws BibliotheekException{
    bestand = new BibliotheekBestand(file);
    bestand.schrijfAlleBoeken(boekenlijst);
    gewijzigd = false;
  }
  
  /**
   * Maakt de bibliotheek leeg.
   */
  public void maakLeeg() {
    boekenlijst.clear();
    gewijzigd = false;
  }
  
  /**
   * Levert het boek met gegeven titel en auteur.
   * @param titel titel van boek
   * @param auteur auteur van boek
   * @return het boek indien aanwezig in bibliotheek, anders null
   */
  private Boek geefBoek(String titel, String auteur){
    for (Boek boek : boekenlijst) {
      if (boek.getTitel().equals(titel) &&
          boek.getAuteur().equals(auteur)){
        // gevraagd boek gevonden
        return boek;
      }     
    }
    return null;
  }
 
}
