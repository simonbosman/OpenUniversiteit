package boxen;

import java.util.Objects;

/**
 * Klasse voor het testen van de klasse Box.
 * @author Open Universiteit Nederland
 *
 */
public class BoxTest {

  /**
   * @param args
   */
  public static void main(String[] args) {
    //Box<?> box1 = new Box<?>(10);
    Box<?> box2 = new Box<String>("abc");
    
    //box2.setElem("xyz");
    //box2.setElem(null);
    
    //String s = box2.getElem();
    Object o = box2.getElem();
    String s = (String) o;
    System.out.println(s);

    //boolean b1 = box2.isGelijk(new Box<String>("abc"));
    //boolean b2 = box2.isGelijk(box2);
    
    Box<?> box3 = box2.kopieer();
    //Box<String> box4 = box2.kopieer();
    Box<? extends String> box5 = new Box<String>("def");
    //Box<String> box6 = box5;
  }
}
