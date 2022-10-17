package BagsQueuesStacks;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizeDeque<Item> implements Iterable<Item> {
    private int numOfElements;

    public ResizeDeque() {
        numOfElements = 0;
    }

    private Item[] elements = (Item[]) new Object[1];

    public Boolean isEmpty() {
        return numOfElements == 0;
    }

    public int size() {
        return numOfElements;
    }

    private void resize(int newSize) {
        Item[] temp = (Item[]) new Object[newSize];
        if (numOfElements >= 0)
            System.arraycopy(elements, 0, temp, 0, numOfElements);
        elements = temp;
    }

    public void pushLeft(Item item) {
        if (elements.length - numOfElements < 1 && elements.length > 0) resize(2 * elements.length);
        for (int i = numOfElements; i > 0; i--)
            elements[i] = elements[i - 1];
        numOfElements++;
        elements[0] = item;
    }

    public void pushRight(Item item) {
        if (elements.length - numOfElements < 1 && elements.length > 0) resize(2 * elements.length);
        elements[numOfElements++] = item;
    }

    public Item popLeft() {
        Item item = elements[0];
        for (int i = 0; i < numOfElements-1; i++)
            elements[i] = elements[i+1];
        elements[--numOfElements] = null;
        if (numOfElements < elements.length / 4) resize(elements.length / 2);
        return item;
    }

    public Item popRight() {
        Item item = elements[numOfElements - 1];
        elements[numOfElements - 1] = null;
        numOfElements--;
        if (numOfElements < elements.length / 4) resize(elements.length / 2);
        return item;
    }

    public Iterator<Item> iterator() {
        return new ResizeDequeIterator();
    }

    private class ResizeDequeIterator implements Iterator<Item> {
        private int i = numOfElements;

        public boolean hasNext() {
            return numOfElements > 0;
        }


        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return elements[--i];
        }

    }
}
