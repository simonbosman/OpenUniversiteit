/**
 * Created by simon on 19-1-2017.
 */
public class StackTest {

    public static void main(String[] args) {

        //Test stack met String elementen.
        Stack<String> stack1 = new Stack<>();

        stack1.push("Aap");
        stack1.push("Noot");
        stack1.push("Mies");

        System.out.println(stack1);

        while (!stack1.isEmpty()) {
            System.out.println(stack1.pop());
        }

        //Expressie test
        System.out.println(new Expressie("").haakjesGoed());//true
        System.out.println(new Expressie("x + y*2 -17").haakjesGoed());//true
        System.out.println(new Expressie("[x] + ((5*3) -y[x+2, 5])").haakjesGoed());//true
        System.out.println(new Expressie("(x + ((5*3) - Y[X+2, 5])").haakjesGoed());//false
        System.out.println(new Expressie("(x + ((5*3) - Y[X+2, 5]))))").haakjesGoed());//false
        System.out.println(new Expressie("[x + ((5*3) - Y[X+2, 5]])").haakjesGoed());//false
    }
}
