import java.util.Stack;

class MyQueue<T>{

    Stack<T> StackNewestOnTop, StackOldestOnTop;

    MyQueue()
    {
        StackNewestOnTop = new Stack<T>();
        StackOldestOnTop = new Stack<T>();
    }

    public int size()
    {
        return StackNewestOnTop.size() + StackOldestOnTop.size();
    }

    public void add(T item)
    {
        StackNewestOnTop.push(item);
    }

    //Shifting the elements from the new stack to the old stack occurs only if the old stack is empty
    public void shiftstack()
    {
        if(StackOldestOnTop.isEmpty())
        {
            while(!StackNewestOnTop.isEmpty())
            {
                StackOldestOnTop.push(StackNewestOnTop.pop());
            }
        }
    }
    public T remove()
    {
        //Shift the elements of the new stack to the old stack if the old stack is empty while we do a pop operation
        shiftstack();
        T item = StackOldestOnTop.pop();
        return item;
    }

    public T peek()
    {
        //Shift the elements of the new stack to the old stack if the old stack is empty while we do a pop operation
        shiftstack();
        T item = StackOldestOnTop.peek();
        return item;
    }

}



public class Main {

    public static void main(String[] args) {
        MyQueue<Integer> t = new MyQueue<Integer>();
        t.add(3);
        t.add(4);
        t.add(5);
        t.add(6);
        System.out.println(t.remove());
        System.out.println(t.peek());
        System.out.println(t.size());
        System.out.println(t.remove());
        System.out.println(t.peek());
    }
}
