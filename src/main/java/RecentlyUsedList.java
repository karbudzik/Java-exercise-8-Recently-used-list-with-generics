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
        for (T comparedItem : this) {
            if (item.equals(comparedItem)) {
                myList.remove(comparedItem);
            }
        }
    }

    public void deleteElementsAboveAllowedNumber() {
        myList.removeIf(u -> myList.indexOf(u) > (NUMBER_OF_ITEMS-1));
    }

    public List<T> getMyList() {
        return myList;
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
