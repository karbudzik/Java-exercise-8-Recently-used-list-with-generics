import java.util.ArrayList;
import java.util.List;

public class RecentlyUsedClassList {
    private List<ObjectContainer<?>> classlist;

    public RecentlyUsedClassList() {
        this.classlist = new ArrayList<>();
    }

    public void addClass(Object object) {
        ObjectContainer<?> objectContainer = new ObjectContainer<>(object);
        classlist.add(objectContainer);
    }

    public void addClasses(Object ...object) {
        for (Object i : object) {
            addClass(i);
        }
    }
}
