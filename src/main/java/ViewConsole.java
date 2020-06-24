import java.util.List;

public class ViewConsole <T>{

    public void printItems(List<T> myList) {
        if (myList.size() > 0) {
            printList(myList);
        } else {
            printMessage("There are no items in the list");
        }
    }

    public void printList(List<T> myList) {
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
}
