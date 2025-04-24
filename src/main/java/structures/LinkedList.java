package structures;
import model.Route;
import structures.Node;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LinkedList<T> {
    private Node<T> head;

    public void add(T data) {
        if (head == null) {
            head = new Node<>(data);
        } else {
            Node<T> actual = head;
            while (actual.next != null) {
                actual = actual.next;
            }
            actual.next = new Node<>(data);
        }
    }


    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T data = current.getData();
                current = current.getNext();
                return data;
            }
        };
    }

    public T min(Comparator<T> comparator) {
        if (head == null) {
            return null;
        }

        Node<T> current = head;
        T minElement = current.data;

        while (current != null) {
            if (comparator.compare(current.data, minElement) < 0) {
                minElement = current.data;
            }
            current = current.next;
        }

        return minElement;
    }


    public Node<T> getHead() {
        return head;
    }

    public T search(Predicate<T> condition) {
        Node<T> current = head;
        while (current != null) {
            if (condition.test(current.getData())) {
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void forEach(Consumer<T> action) {
        Node<T> current = head;
        while (current != null) {
            action.accept(current.getData());
            current = current.getNext();
        }
    }

    public void clear() {
        head = null;
    }

    public void sort(Comparator<T> comparator) {
        if (head == null || head.next == null) {
            return;
        }
        head = mergeSort(head, comparator);
    }

    private Node<T> mergeSort(Node<T> head, Comparator<T> comparator) {
        if (head == null || head.next == null) {
            return head;
        }

        Node<T> middle = getMiddle(head);
        Node<T> nextToMiddle = middle.next;
        middle.next = null;

        Node<T> left = mergeSort(head, comparator);
        Node<T> right = mergeSort(nextToMiddle, comparator);

        return merge(left, right, comparator);
    }

    private Node<T> getMiddle(Node<T> head) {
        if (head == null) return head;

        Node<T> slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node<T> merge(Node<T> left, Node<T> right, Comparator<T> comparator) {
        if (left == null) return right;
        if (right == null) return left;

        Node<T> result;
        if (comparator.compare(left.data, right.data) <= 0) {
            result = left;
            result.next = merge(left.next, right, comparator);
        } else {
            result = right;
            result.next = merge(left, right.next, comparator);
        }
        return result;
    }
}
