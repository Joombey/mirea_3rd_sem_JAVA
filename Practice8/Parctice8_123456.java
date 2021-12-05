import java.lang.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Parctice8_123456 {

    public static void main(String[] args) {
        Pet obj = new Pet(0);
        obj.entry();
        obj.call();
    }
}

class Pet{
    public int index;
    public Map<String, Pet> hashmap = new HashMap<String, Pet>();
    Scanner snc = new Scanner(System.in);
    Pet(int index) {
        this.index = index;
    }
    int get(){
        return index;
    }
    void entry(){
        hashmap.put("Animal1", new Pet(1));
        hashmap.put("Animal2", new Pet(2));
        System.out.print("Добавление нового элемента в список.\nВведите ключ/значение: ");
        String name = snc.next();
        int num = snc.nextInt();
        hashmap.put(name, new Pet(num));
    }
    void call(){
        Dog dog = new Dog(hashmap);
        Owl owl = new Owl(hashmap);
        Cat cat = new Cat(hashmap);
        for(Map.Entry<String, Pet> item : hashmap.entrySet()){
            System.out.printf("KEY: %s  INDEX: %s \n", item.getKey(), item.getValue().get());
        }
    }
}

class Dog extends Pet{

    Dog(Map <String, Pet> hashmap) {
        super(0);
        hashmap.put("ObjectDog", new Pet(4));
    }

}
class Owl extends Pet{

    Owl(Map <String, Pet> hashmap) {
        super(0);
        hashmap.put("ObjectOwl", new Pet(5));
    }
}

class Cat extends Pet{
    Cat(Map <String, Pet> hashmap) {
        super(0);
        hashmap.put("ObjectCat", new Pet(3));
    }
}