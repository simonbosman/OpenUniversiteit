import java.util.ArrayList;

/**
 * Created by simon on 19-1-2017.
 */
public class Stack<E> {

    private ArrayList<E> stack;

    public Stack() {
        this.stack = new ArrayList<E>();
    }

    /**
     * Plaatst een element boven
     * op de stack
     *
     * @param elem
     */
    public void push(E elem) {
        stack.add(elem);
    }

    /**
     * Haalt een element van de top van de stack.
     *
     * @return Het element bovenop de stack of
     * null i.g.v. een lage stack.
     */
    public E pop() {
        if (!isEmpty()) {
            return stack.remove(stack.size() - 1);
        } else {
            return null;
        }
    }

    /**
     * Test of de stack leeg is.
     *
     * @return True als de stack leeg is.
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     * Levert een String-representatie van de stack.
     *
     * @return String-representatie van de stack.
     */
    public String toString() {
        String res = "";
        int i = 0;
        while (i < stack.size()) {
            res += stack.get(i);
            i++;
            if (i < stack.size()) {
                res += ", ";
            }
        }
        return res;
    }
}