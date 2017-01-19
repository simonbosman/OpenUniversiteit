/**
 * Created by simon on 19-1-2017.
 */
public class StackTest {

    public static void main(String[] args) {

        Stack<String> stack1 = new Stack<>();

        stack1.push("Aap");
        stack1.push("Noot");
        stack1.push("Mies");

        System.out.println(stack1);

        while(!stack1.isEmpty()) {
            System.out.println(stack1.pop());
        }
    }
}
