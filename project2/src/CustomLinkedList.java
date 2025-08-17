public class CustomLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        final T data;
        Node<T> next;
        Node<T> prev;

        Node(final T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public CustomLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(final T element) {
        final Node<T> newNode = new Node<>(element);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public T get(final int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        return getNode(index).data;
    }

    public T remove(final int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        final Node<T> nodeToRemove = getNode(index);
        final T removedData = nodeToRemove.data;

        if (size == 1) {
            head = null;
            tail = null;
        } else if (index == 0) {
            head = head.next;
            head.prev = null;
        } else if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
        } else {
            final Node<T> previous = nodeToRemove.prev;
            final Node<T> next = nodeToRemove.next;
            previous.next = next;
            next.prev = previous;
        }

        size--;
        return removedData;
    }

    public boolean remove(final T element) {
        Node<T> current = head;
        int index = 0;

        while (current != null) {
            if ((element == null && current.data == null) ||
                    (element != null && element.equals(current.data))) {
                remove(index);
                return true;
            }
            current = current.next;
            index++;
        }
        return false;
    }

    public void addAll(final T[] array) {
        if (array == null) {
            return;
        }
        for (final T element : array) {
            add(element);
        }
    }

    private Node<T> getNode(final int index) {
        Node<T> current;

        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }

        return current;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        final StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;

        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }

        sb.append("]");
        return sb.toString();
    }
}
