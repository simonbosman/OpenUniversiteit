package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import verzamelingfout2.Verzameling;
/**
 * Klasse waarmee voegtoe, vereniging en doornede van klasse Verzameling getest worden
 * @author Open Universiteit Nederland
 */
public class VerzamelingTest {
  private Verzameling v1 = null;
  private Verzameling v2 = null; 
  private Verzameling v3 = null; 
  private Verzameling v4 = null; 
  private Verzameling v5 = null; 
  private Verzameling vleeg = null; 

  @Before
  public void setUp() {
    // v1 = {-2,-1,0}
    v1 = new Verzameling();
    v1.voegToe(-2);v1.voegToe(-1);v1.voegToe(0);
    // v2 = {1,2,3,4}
    //  v1 en v2 hebben geen elementen gemeen 
    v2 = new Verzameling();
    v2.voegToe(1);v2.voegToe(2);v2.voegToe(3);v2.voegToe(4);

    // v3 = {2,3,5,7,11} 
    v3 = new Verzameling();
    v3.voegToe(2);v3.voegToe(3);v3.voegToe(5);v3.voegToe(7);v3.voegToe(11);
    // v4 = {1,3,5,7,9}
    //  v3 en v4 hebben een paar elementen gemeen 
    v4 = new Verzameling();
    v4.voegToe(1);v4.voegToe(3);v4.voegToe(5);v4.voegToe(7);v4.voegToe(9);
    // v5 = {-2, -1}, deelverzameling van v1
    v5 = new Verzameling();  
    v5.voegToe(-2);v5.voegToe(-1);
    vleeg = new Verzameling();  
  }
  
  @After
  public void tearDown() throws Exception {
    v1 = null; v2 = null; v3 = null; v4 = null; v5 = null; vleeg = null;
  }

  @Test
  public void testVoegToe() {  
    // voeg een element toe dat al in de verzameling zit,
    // de afmeting wijzigt niet 
    v1.voegToe(-1);
    assertEquals("afmeting na toevoegen -1 aan {-2,-1,0}", 3, v1.afmeting());   
    // voeg een nieuw element toe, de afmeting neemt toe 
    v1.voegToe(1);
    assertEquals("afmeting na toevoegen 1 aan {-2,-1,0}", 4, v1.afmeting());
  }

  @Test
  public void testVereniging() {      
    // v1 en v2 hebben geen gemeenschappelijke elementen
    Verzameling actual = v1.vereniging(v2);
    Verzameling expected = new Verzameling();
    expected.voegToe(-2); expected.voegToe(-1); expected.voegToe(0);
    expected.voegToe(1); expected.voegToe(2); expected.voegToe(3); expected.voegToe(4);    
    assertEquals("verzamelingen zonder gemeenschappelijke elementen", expected, actual);
    
    // v3 en v4 hebben een paar gemeenschappelijke elementen
    actual = v3.vereniging(v4);
    expected = new Verzameling();
    expected.voegToe(1);expected.voegToe(2);expected.voegToe(3);
    expected.voegToe(5);expected.voegToe(7);expected.voegToe(9);expected.voegToe(11);    
    assertEquals("verzamelingen met gemeenschappelijke elementen",expected, actual);
    
    // v5 is deelverzameling van v1
    actual = v5.vereniging(v1);
    assertEquals("ene verzameling is deelverzameling van de ander",v1, actual);
    
    actual = v3.vereniging(vleeg);
    assertEquals("vereniging verzameling met lege verzameling ",v3, actual);
    
    actual = vleeg.vereniging(v3);
    assertEquals("vereniging lege verzameling met verzameling", v3, actual);
    
    actual = vleeg.vereniging(vleeg);
    assertEquals("vereniging lege verzameling met lege verzameling ", vleeg, actual);   
  }

  @Test
  public void testDoorsnede() {
    //  v1 en v2 hebben geen gemeenschappelijke elementen
    Verzameling actual = v1.doorsnede(v2);       
    assertEquals("verzamelingen zonder gemeenschapplijke elementen",vleeg, actual);
    
    // v3 en v4 hebben een paar gemeenschappelijke elementen
    actual = v3.doorsnede(v4);
    Verzameling expected = new Verzameling();
    expected.voegToe(3); expected.voegToe(5);expected.voegToe(7);    
    assertEquals("verzamelingen met gemeenschapplijke elementen", expected, actual);
    
    //  v5 is deelverzameling van v1
    actual = v5.doorsnede(v1);
    assertEquals("ene verzameling is deelverzameling van de ander",v5, actual);
    
    actual = v3.doorsnede(vleeg);
    assertEquals("niet lege verzameling doorsneden met lege verzameling ", vleeg, actual);
    
    actual = vleeg.doorsnede(v3);
    assertEquals("lege verzameling doorsneden met niet lege verzameling",vleeg, actual);
    
    actual = vleeg.doorsnede(vleeg);
    assertEquals("lege verzameling doorsneden met lege verzameling",vleeg, actual);     
  }
}
