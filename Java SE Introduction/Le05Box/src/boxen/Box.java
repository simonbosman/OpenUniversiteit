package boxen;

/**
 * Generieke klasse voor het bewaren van
 * een element van type E.
 * @author Open Universiteit Nederland
 *
 * @param <E> het type van het element in de box
 */
public class Box<E>{
  private E elem = null; // het element in de box
  
  /**
   * Creeert een box voor het bewaren van
   * het gegeven element.
   * @param elem het element
   */
  public Box(E elem){
    this.elem = elem;
  }
  
  /**
   * Vergelijkt het element in deze box met
   * het element in de gegeven box. 
   * @param box de geegven box
   * @return true als de eleemnten gelijk zijn
   *         false anders
   */
  public boolean isGelijk(Box<E> box){
    return elem.equals(box.elem);
  }
  
  /**
   * Maakt een nieuwe box voor het element.
   * Het element wordt niet gekopieerd.
   * @return
   */
  public Box<E> kopieer(){
    return new Box<E>(elem);
  }
  
  public void setElem(E elem){
    this.elem = elem;
  }
  
  public E getElem(){
    return elem;
  }  
}

