import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecentlyUsedList<T> implements Iterable<T> {
    private List<T> myList;

    public RecentlyUsedList() {
        this.myList = new ArrayList<>();
    }

    public void addToList(T item) {
        myList.add(item);
    }

    public void accessItems() {
        if (myList.size() > 0) {
            printItems();
        } else {
            printMessage("There are no items in the list");
        }
    }

    public void printItems() {
        System.out.println(String.format("Recently used objects of class %s:", myList.get(0).getClass().getName()));
        int count = 0;
        for (T item : myList) {
            count++;
            System.out.println(String.format("%d. %s", count, item));
        }
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < myList.size() && myList.get(currentIndex) != null;
            }

            @Override
            public T next() {
                return myList.get(currentIndex++);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
