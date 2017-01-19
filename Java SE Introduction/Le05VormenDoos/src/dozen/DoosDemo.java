package dozen;

import vormen.Bol;
import vormen.Cilinder;
import vormen.Vorm;

import java.util.ArrayList;

/**
 * Klasse voor het testen van verschillende generieke concepten.
 */
public class DoosDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {

        //Maak een doos met als actuele type parameter Integer.
        //Voor doos is geen upperbound gedefinieerd, dus geldt
        //automatisch Object als upperbound.
        Doos<Integer> integerDoos = new Doos<Integer>();
        integerDoos.bewaar(10);
        Integer i = integerDoos.getObject();
        System.out.println("Doos heeft waarde: " + i);

        //Maak een verzameling van dozen met als actuele type parameter String.
        ArrayList<Doos<String>> listDozen = new ArrayList<Doos<String>>();
        for (int idx = 0; idx < 10; idx++) {
            Doos<String> doos = new Doos<String>();
            doos.bewaar("Artikel " + idx);
            listDozen.add(doos);
        }
        System.out.println("Volgende dozen zitten in de verzameling dozen van het actuele type String: ");
        listDozen.forEach((d) -> {
            System.out.println(d.toString());
        });

        //Maak een doos met als actuele parameter een type
        //dat erft van Vorm. De upperbound van het formele type
        //is Vorm.
        VormenDoos<Bol> bolDoos = new VormenDoos<Bol>();
        VormenDoos<Vorm> vormDoos = new VormenDoos<Vorm>();

        Cilinder cilinder = new Cilinder(80, 80);
        Bol bol = new Bol(10);
        Object obj = new Object();

        //Het bewaren van een cilinder in een VormenDoos
        //van het type Bol, resulteert in een compile error.
        //bolDoos.bewaar(cilinder);
        bolDoos.bewaar(bol);
        System.out.println(bolDoos.getObject());

        //Het bewaren van een object in een VormenDoos
        //resulteert in een compile error; de upperbound is
        //namelijk type Vorm.
        //vormDoos.bewaar(obj);
        //Een cilinder echter wel, deze erft van Vorm.
        vormDoos.bewaar(cilinder);
        System.out.println(vormDoos.getObject());
    }
}

