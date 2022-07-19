package org.ispirer.systems.list;

public class ListUsr<T> {
    private Node<T> head;
    private Node<T> tail;

    private final Changed changed;

    public ListUsr(Changed changed) {
        this.changed = changed;
    }

    public ListUsr(T firstElement, Changed changed) {
        head = new Node<>(firstElement, null, null);
        tail = head;
        this.changed = changed;
    }

    public void add(T element) {
        if (head == null && tail == null) {
            head = new Node<>(element, null, null);
            tail = head;
        } else {
            Node<T> lastElement = tail;
            Node<T> newElement = new Node<>(element, null, lastElement);
            lastElement.setNext(newElement);
            tail = newElement;
        }
        changed.changed();
    }

    public T get(int index) {
        Node<T> current = findNodeByIndex(index);
        return current.getElement();
    }

    public void remove(int index) {
        Node<T> current = findNodeByIndex(index);
        if (current.getNext() == null && current.getPrev() == null) {
            head = null;
            tail = null;
        } else if (current.getNext() == null) {
            Node<T> prevElement = current.getPrev();
            prevElement.setNext(null);
            tail = prevElement;
        } else if (current.getPrev() == null) {
            Node<T> nextElement = current.getNext();
            nextElement.setPrev(null);
            head = nextElement;
        } else {
            Node<T> prevElement = current.getPrev();
            Node<T> nextElement = current.getNext();
            prevElement.setNext(nextElement);
            nextElement.setPrev(prevElement);
        }
        changed.changed();
    }

    private Node<T> findNodeByIndex(int index) {
        if (index < 0 || head == null) {
            throw new IndexOutOfBoundsException("Should be positive number");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            if (current.getNext() == null) {
                throw new IndexOutOfBoundsException();
            }
            current = current.getNext();
        }
        return current;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[  ");
        if (head == null) {
            builder.append(" ]");
            return builder.toString();
        }
        Node<T> current = head;
        builder.append(current.getElement()).append(" ");
        while (current.getNext() != null) {
            current = current.getNext();
            builder.append(current.getElement()).append(" ");
        }
        builder.append(" ]");
        return builder.toString();
    }
}
