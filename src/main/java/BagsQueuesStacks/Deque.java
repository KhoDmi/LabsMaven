package BagsQueuesStacks;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private class Node {
        Item elements;
        Node next;
        Node prev;
    }

    private Node first;
    private Node last;
    private int numOfElements;

    public Boolean isEmpty() {
        return first == null || last == null;
    }

    public int size() {
        return numOfElements;
    }

    public Deque() {
        numOfElements = 0;
    }

    public void pushLeft(Item item) {
        Node old = first;
        first = new Node();
        first.elements = item;
        first.next = old;
        if (isEmpty()) last = first;
        else old.prev = first;
        numOfElements++;
    }

    public void pushRight(Item item) {
        Node old = last;
        last = new Node();
        last.elements = item;
        last.prev = old;
        if (isEmpty()) first = old;
        else old.next = last;
        numOfElements++;
    }

    public Item popLeft() {
        Item item = first.elements;
        if (numOfElements==1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            first.prev = null;
        }
        numOfElements--;
        return item;
    }

    public Item popRight() {
        Item item = last.elements;
        if (numOfElements==1) {
            first = null;
            last = null;
        } else {
            last = last.prev;
            last.next = null;
        }
        numOfElements--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        private Node i = first;

        public boolean hasNext() {
            return numOfElements > 0;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            i = i.next;
            return i.elements;
        }

    }

}
