import java.util.Comparator;
public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap;

    public MyMinHeap() {
        heap = new MyArrayList<>();
    }

    public boolean empty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

    public T getMin() {
        return heap.get(0);
    }

    public T extractMin() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        T min = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.removeLast();
        heapify(0);
        return min;
    }

    public void insert(T item) {
        heap.add(item);
        traverseUp(heap.size() - 1);
    }

    private void heapify(int index) {
        int leftChildIndex = leftChildOf(index);
        int rightChildIndex = rightChildOf(index);
        int smallest = index;

        if (leftChildIndex < heap.size() && heap.get(leftChildIndex).compareTo(heap.get(smallest)) < 0) {
            smallest = leftChildIndex;
        }
        if (rightChildIndex < heap.size() && heap.get(rightChildIndex).compareTo(heap.get(smallest)) < 0) {
            smallest = rightChildIndex;
        }
        if (smallest != index) {
            swap(index, smallest);
            heapify(smallest);
        }
    }

    private void traverseUp(int index) {
        while (index > 0) {
            int parentIndex = parentOf(index);
            if (heap.get(index).compareTo(heap.get(parentIndex)) < 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private int leftChildOf(int index) {
        return 2 * index + 1;
    }

    private int rightChildOf(int index) {
        return 2 * index + 2;
    }

    private int parentOf(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        T temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }
}