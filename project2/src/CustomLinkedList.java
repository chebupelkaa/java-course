public class CustomLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    private static class Node<E> {
        final E data;
        Node<E> next;
        Node<E> prev;

        Node(final E data) {
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

    public void add(final E element) {
        final Node<E> newNode = new Node<>(element);

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

    public E get(final int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        return getNode(index).data;
    }

    public E remove(final int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        final Node<E> nodeToRemove = getNode(index);
        final E removedData = nodeToRemove.data;

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
            final Node<E> previous = nodeToRemove.prev;
            final Node<E> next = nodeToRemove.next;
            previous.next = next;
            next.prev = previous;
        }

        size--;
        return removedData;
    }

    public boolean remove(final E element) {
        Node<E> current = head;
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

    public void addAll(final E[] array) {
        if (array == null) {
            return;
        }
        for (final E element : array) {
            add(element);
        }
    }

    private Node<E> getNode(final int index) {
        Node<E> current;

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
        Node<E> current = head;

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
