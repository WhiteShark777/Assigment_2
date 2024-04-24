import java.util.Comparator;
public class MyStack<T> {
    private MyArrayList<T> stack;

    public MyStack() {
        stack = new MyArrayList<>();
    }

    public boolean empty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public T peek() {
        return stack.get(stack.size() - 1);
    }

    public void push(T item) {
        stack.add(item);
    }


}