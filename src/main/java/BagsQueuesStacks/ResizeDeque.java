package BagsQueuesStacks;

import java.util.Iterator;

public class ResizeDeque<Item> implements Iterable<Item> {
    private int numOfElements;

    public ResizeDeque() {
        numOfElements = 0;
    }

    private Item[] element = (Item[]) new Object[1];

    public Boolean isEmpty() {
        return numOfElements == 0;
    }

    public int size() {
        return numOfElements;
    }

    private void resize(int newSize) {
        Item[] temp = (Item[]) new Object[newSize];
        if (numOfElements >= 0)
            System.arraycopy(element, 0, temp, 0, numOfElements);
        element = temp;
    }

    public void pushLeft(Item item) {
        if (element.length - numOfElements < 1 && element.length > 0) resize(2 * element.length);
        for (int i = numOfElements; i > 0; i--)
            element[i] = element[i - 1];
        numOfElements++;
        element[0] = item;
    }

    public void pushRight(Item item) {
        if (element.length - numOfElements < 1 && element.length > 0) resize(2 * element.length);
        element[numOfElements++] = item;
    }

    public Item popLeft() {
        Item item = element[0];
        for (int i = 0; i < numOfElements-1; i++)
            element[i] = element[i+1];
        element[--numOfElements] = null;
        if (numOfElements < element.length / 4) resize(element.length / 2);
        return item;
    }

    public Item popRight() {
        Item item = element[numOfElements - 1];
        element[numOfElements - 1] = null;
        numOfElements--;
        if (numOfElements < element.length / 4) resize(element.length / 2);
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
            return element[--i];
        }

        public void remove() {
        }
    }
}
