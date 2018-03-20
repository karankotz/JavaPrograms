import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    
	//function to sort the stack containing integers
    public static Stack<Integer> sort(Stack<Integer> stack)
    {
        Stack<Integer> helper = new Stack<Integer>();

        while(!stack.isEmpty())
        {
            int temp = stack.pop();

            //The element stored in the temp should be greater than the top of the helper stack else we need to pop
            //the elements of the helper stack until we find the correct position to push the temp element
            while(!helper.isEmpty() && helper.peek() > temp)
            {
                stack.push(helper.pop());
            }
            //Now push the temp element into the helper stack
            helper.push(temp);
        }
        return helper;

    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        //Read the integer to push into theb stack
        System.out.println("Enter the size of the stack");
        Scanner sc = new Scanner(System.in);
        //Size of the Stack
        int z = sc.nextInt();
        System.out.println("Enter the elements");
        while(z!=0)
        {
            stack.push(sc.nextInt());
            z--;
        }
        //Call the function sort in order to sort the stack
        Stack<Integer> SortedStack = sort(stack);
        //Print the sorted stack
        System.out.println(Arrays.toString(SortedStack.toArray()));
    }
}
