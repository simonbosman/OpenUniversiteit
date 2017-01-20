package verzamelingfout2;

import verzameling.Bag;

/**
 * De klasse Verzameling representeert een verzameling.
 * In een verzameling komt ieder element slechts één maal voor. 
 * Deze klasse bevat (bewust)een fout
 * @author Open Universiteit Nederland
 */
public class Verzameling extends Bag {
  
  /**
   * Voegt een nieuw element toe aan de verzameling.
   * @param elem het toe te voegen element
   * @return true als een nieuw element is toegevoegd,
   * anders false
   */
  public boolean voegToe(int elem) {
    if (!bevat(elem)) {
      return super.voegToe(elem);
    }
    return false;
  }
  
  /**
   * Berekent de vereniging van de verzameling met een
   * andere verzameling.
   * @param v de andere verzameling
   * @return de vereniging, een nieuwe verzameling
   */
  public Verzameling vereniging(Verzameling v) {
    // maak een nieuw verzamelinginstantie
    Verzameling vereniging = new Verzameling();    
    // voeg elementen van "eigen" verzameling toe
    for (int elem : this.elementen()) {
      vereniging.voegToe(elem);
    }
    // voeg elementen van "andere" verzameling toe
    for (int elem : elementen()) {
      vereniging.voegToe(elem);
    }
    return vereniging;
  }
  
  /**
   * Berekent de doorsnede van de verzameling met een
   * andere verzameling.
   * @param v de andere verzameling
   * @return de doorsnede, een nieuwe verzameling
   */
  public Verzameling doorsnede(Verzameling v) {
    // maak een nieuw verzamelinginstantie
    Verzameling doorsnede = new Verzameling();
    // voor alle elementen in "eigen" verzameling
    // kijk of deze ook in "andere" zitten
    // zo ja, voeg element toe aan nieuwe verzameling
    for (int elem : this.elementen()) {
      if (v.bevat(elem)) {
        doorsnede.voegToe(elem);
      }
    }
    return doorsnede;
  }
  
}
