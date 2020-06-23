public class Main {
    public static void main(String[] args){
        String obj1 = "Blablabla";
        String obj2 = "Mandarynka";
        String obj3 = "Klaustrofobia";
        String obj4 = "Klaustrofobia";

        RecentlyUsedList<String> list = new RecentlyUsedList<>();
        list.addToList(obj1);
        list.addToList(obj2);
        list.addToList(obj3);
        list.addToList(obj4);
        list.printItems();
    }
}
