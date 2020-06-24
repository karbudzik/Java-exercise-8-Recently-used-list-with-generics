public class Main {
    public static void main(String[] args){
        String obj1 = "Blablabla";
        String obj2 = "Mandarynka";
        String obj3 = "Klaustrofobia";
        String obj4 = "Klaustrofobia";
        String obj5 = "Blablabla";

        RecentlyUsedList<String> list = new RecentlyUsedList<>(3);
        list.addItemsToList(obj1, obj2, obj3, obj4, obj5);
        list.printItems();
    }
}
