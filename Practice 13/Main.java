import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //Task 1;
        Integer[] list = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        ConversionClass<Integer> convertedlist = new ConversionClass<>(list);

        UniversalArray<Integer> integerUniversalArray = new UniversalArray<Integer>(list);
        //Task 2 - 3;
        String[] stringList = {"pk", "gb", "ac"};
        UniversalArray<String> stringUniversalArray = new UniversalArray<String>(stringList);

        //Task 4;

        FileTask cake = new FileTask("E:\\");
        cake.write("E:\\newtext.txt");
        cake.ReadFile("E:\\newtext.txt");

    }
}
