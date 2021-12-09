import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConversionClass<E> {

    private List<E> list = new ArrayList<>();

    public ConversionClass(E[] array) {
        list.addAll(Arrays.asList(array));
        System.out.println(Arrays.toString(list.toArray()));
    };

    public void append(E element) {
        list.add(element);
    }

    public List get() {
        return list;
    }
}

