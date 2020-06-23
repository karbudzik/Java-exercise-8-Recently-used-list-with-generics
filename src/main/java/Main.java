import classexamples.*;

public class Main {
    public static void main(String[] args){
        Animal obj1 = new Animal();
        Home obj2 = new Home();
        String obj3 = "String content";
        Integer obj4 = 6;
        Item obj5 = new Item();
        Vehicle obj6 = new Vehicle();
        Vehicle obj7 = new Car();


        RecentlyUsedClassList classList = new RecentlyUsedClassList();
        classList.addClasses(obj1, obj2, obj3, obj4, obj5, obj6, obj7);
    }
}
