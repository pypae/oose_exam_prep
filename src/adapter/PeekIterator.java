package adapter;

import java.util.ListIterator;
import java.util.NoSuchElementException;

// Adapter
public class PeekIterator<T> implements Peekerator<T>{

    // iterator.add() is only possible with a ListIterator.
    // idk how to implement with a basic Iterator, because it is unordered and does not support previous()
    private ListIterator<? extends T> iterator;

    public PeekIterator(ListIterator<? extends T> iterator){
        this.iterator = iterator;
    }

    @Override
    public T peek() throws NoSuchElementException {
        T item = iterator.next();
        iterator.previous();
        return item;
    }
}
