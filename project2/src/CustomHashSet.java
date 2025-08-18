public class CustomHashSet<E> {
    private static final int DEFAULT_CAPACITY = 16;
    private final Node<E>[] buckets;
    private int size;

    private static final class Node<E> {
        final E key;
        final Node<E> next;

        Node(final E key, final Node<E> next) {
            this.key = key;
            this.next = next;
        }
    }

    @SuppressWarnings("unchecked")
    public CustomHashSet() {
        this.buckets = (Node<E>[]) new Node[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public boolean add(final E key) {
        if (key == null) {
            throw new NullPointerException("Key cannot be null");
        }

        final int index = getIndex(key);
        Node<E> current = buckets[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return false;
            }
            current = current.next;
        }

        buckets[index] = new Node<>(key, buckets[index]);
        size++;
        return true;
    }

    public boolean remove(final E key) {
        if (key == null) {
            throw new NullPointerException("Key cannot be null");
        }

        final int index = getIndex(key);
        Node<E> current = buckets[index];
        Node<E> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = current.next;
                } else {
                    prev = new Node<>(prev.key, current.next);
                }
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    private int getIndex(final E key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("[");
        boolean first = true;

        for (final Node<E> node : buckets) {
            Node<E> current = node;
            while (current != null) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append(current.key);
                first = false;
                current = current.next;
            }
        }

        sb.append("]");
        return sb.toString();
    }
}