/**
 * Klasse die bepaalt of blokhaken goed staan in een expressie.
 */
public class Expressie {

    private String expressie;

    /**
     * Default constructor definieert de expressie.
     * @param expressie
     */
    public Expressie(String expressie) {
        this.expressie = expressie;
    }

    /**
     * Controleer of de haakjes goed staan.
     * @return true als de haaktjes goed staan.
     */
    public boolean haakjesGoed() {

        Stack<Character> stack = new Stack<Character>();

        for (char c : expressie.toCharArray()) {
            if (c == '(' || c == '[') {
                stack.push(c);
            }
            else if (c == ')') {
                return (!stack.isEmpty() && stack.pop() == ')');
            }
            else if (c == ']') {
                return (!stack.isEmpty() && stack.pop() == '[');
            }
        }

        return stack.isEmpty();
    }
}


