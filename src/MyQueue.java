public class MyQueue<T> {
    private MyLinkedList<T> queue;

    public MyQueue() {
        queue = new MyLinkedList<>();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    public T peek() {
        return queue.getFirst();
    }

    public void enqueue(T item) {
        queue.addLast(item);
    }


}
