
public final class CustomHashSet<T> {
    private static final int DEFAULT_CAPACITY = 16;
    private final Node<T>[] buckets;
    private int size;

    private static final class Node<T> {
        final T key;
        final Node<T> next;

        Node(final T key, final Node<T> next) {
            this.key = key;
            this.next = next;
        }
    }

    @SuppressWarnings("unchecked")
    public CustomHashSet() {
        this.buckets = (Node<T>[]) new Node[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public boolean add(final T key) {
        if (key == null) {
            throw new NullPointerException("Key cannot be null");
        }

        final int index = getIndex(key);
        Node<T> current = buckets[index];

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

    public boolean remove(final T key) {
        if (key == null) {
            throw new NullPointerException("Key cannot be null");
        }

        final int index = getIndex(key);
        Node<T> current = buckets[index];
        Node<T> prev = null;

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

    private int getIndex(final T key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("[");
        boolean first = true;

        for (final Node<T> node : buckets) {
            Node<T> current = node;
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