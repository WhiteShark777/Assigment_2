import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    private static final int DEFAULT_CAPACITY = 10;

    private Object[] arr;
    private int length;

    public MyArrayList() {
        arr = new Object[DEFAULT_CAPACITY];
        length = 0;
    }

    @Override
    public void add(T item) {
        if (length == arr.length) {
            increaseCapacity();
        }
        arr[length++] = item;
    }

    @Override
    public void set(int index, T item) {
        if (index >= 0 && index < length) {
            arr[index] = item;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException();
        }

        if (length == arr.length) {
            increaseCapacity();
        }

        for (int i = length; i > index; i--) {
            arr[i] = arr[i - 1];
        }

        arr[index] = item;
        length++;
    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        add(length, item);
    }

    @Override
    public T get(int index) {
        if (index >= 0 && index < length) {
            return (T) arr[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public T getFirst() {
        return get(0);
    }

    @Override
    public T getLast() {
        return get(length - 1);
    }

    @Override
    public void remove(int index) {
        if (index >= 0 && index < length) {
            for (int i = index; i < length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[length - 1] = null;
            length--;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(length - 1);
    }

    @Override
    public void sort() {
        // Implement sorting logic
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < length; i++) {
            if (arr[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for (int i = length - 1; i >= 0; i--) {
            if (arr[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[length];
        System.arraycopy(arr, 0, array, 0, length);
        return array;
    }

    @Override
    public void clear() {
        for (int i = 0; i < length; i++) {
            arr[i] = null;
        }
        length = 0;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < length;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new IndexOutOfBoundsException();
                }
                return (T) arr[currentIndex++];
            }
        };
    }

    private void increaseCapacity() {
        int newCapacity = arr.length * 2;
        Object[] newElements = new Object[newCapacity];
        System.arraycopy(arr, 0, newElements, 0, length);
        arr = newElements;
    }

}