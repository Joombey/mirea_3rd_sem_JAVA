import java.util.Arrays;

public class UniversalArray<E> {
    private E[] Array;

    UniversalArray(E[] arr){
        E[] Array = (E[]) arr;
        System.out.println(Arrays.toString(Array));
    }

    public E at(int i){
        return Array[i];
    }

    public void asArray(E[] array) {
        Array = array;
    };

    public int len(){
        return Array.length;
    }
}
