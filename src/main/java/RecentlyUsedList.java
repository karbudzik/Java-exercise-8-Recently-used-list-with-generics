import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecentlyUsedList<T> implements Iterable<T> {
    private List<T> myList;
    private final int NUMBER_OF_ITEMS;

    public RecentlyUsedList(int numberOfItems) {
        this.myList = new ArrayList<>();
        this.NUMBER_OF_ITEMS = numberOfItems;
    }

    public void addItemToList(T item) {
        deletePossibleDuplicate(item);
        myList.add(0, item);
        deleteElementsAboveAllowedNumber();
    }

    public void addItemsToList(T ...items) {
        for (T item : items) {
            addItemToList(item);
        }
    }

    public void deletePossibleDuplicate(T item) {
        Iterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            T comparedItem = iterator.next();
            if (item.equals(comparedItem)) {
                myList.remove(comparedItem);
            }
        }
    }

    public void deleteElementsAboveAllowedNumber() {
        myList.removeIf(u -> myList.indexOf(u) > (NUMBER_OF_ITEMS-1));
    }

    public void printItems() {
        if (myList.size() > 0) {
            printList();
        } else {
            printMessage("There are no items in the list");
        }
    }

    public void printList() {
        System.out.println(String.format("Recently used objects of class %s:", myList.get(0).getClass().getName()));
        int count = 0;
        for (T item : myList) {
            count++;
            System.out.println(String.format("%d. %s", count, item.toString()));
        }
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
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
