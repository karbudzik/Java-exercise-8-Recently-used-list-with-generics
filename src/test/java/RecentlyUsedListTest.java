import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RecentlyUsedListTest {

    private final RecentlyUsedList<String> stringList = new RecentlyUsedList<>(4);
    private final RecentlyUsedList<Integer> integerList = new RecentlyUsedList<>(4);
    private final RecentlyUsedList<User> userList = new RecentlyUsedList<>(4);

    @Test
    public void shouldPlaceElementsInTheRightOrder() {
        //given
        String obj1 = "Example";
        String obj2 = "AnotherExample";

        //when
        stringList.addItemToList(obj1);
        stringList.addItemToList(obj2);

        //then
        assertEquals(obj1, stringList.getMyList().get(1));
        assertEquals(obj2, stringList.getMyList().get(0));
    }

    @Test
    public void shouldHoldObjectsOfManyClasses() {
        //given
        String objString = "Example";
        Integer objInteger = 5;
        User objUser = new User();

        //when
        stringList.addItemToList(objString);
        integerList.addItemToList(objInteger);
        userList.addItemToList(objUser);

        //then
        assertEquals(1, stringList.getMyList().size());
        assertEquals(1, integerList.getMyList().size());
        assertEquals(1, userList.getMyList().size());
    }

    @Test
    public void shouldntContainDuplicates() {
        //given
        User user1 = new User();
        User user2 = new User();

        //when
        stringList.addItemsToList("Example", "String", "Example", "Dummy");
        integerList.addItemsToList(1, 1, 1, 29);
        userList.addItemsToList(user1, user2, user1, user2);

        //then
        assertEquals(3, stringList.getMyList().size());
        assertEquals(2, integerList.getMyList().size());
        assertEquals(2, userList.getMyList().size());
    }
}