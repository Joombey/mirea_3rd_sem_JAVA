import java.lang.*;
import java.lang.instrument.UnmodifiableClassException;
import java.util.*;

public class Practice9 {
    public static void main(String[] args) {
        Solution sol = new Solution();
    }
}

class Solution{
    private List<String> SolarSys1 = new ArrayList<>(9);

    private ArrayList<String> SolarSys2 = new ArrayList<>(9);

    Solution(){
        SolarSys1 = Unmodifiable();//Делаем SolarSys1 немодифицируемой.
        for(int i = 0; i < 9; i++){
            add((new Scanner(System.in).next()));//Заполняем SolarSys2 применяя ф-ю добавления.
        }
        print();
        remove("Юпитер");
        print();
        change("Марс", "Mars");
        print();
        shuffle();
        print();
        randomPlanet();
        showIndex("Mars");
        inList("Mars");
        print();
        reverse();
        print();
        swap(0, SolarSys2.size() - 1);
        print();
    }

    public void print(){
        for(int i = 0; i < SolarSys2.size(); i++){
            System.out.print(SolarSys2.get(i) + " ");
        }
        System.out.print("\n");
    }

    public List Unmodifiable(){
        return Collections.unmodifiableList(this.SolarSys1);
    };

    public void add(String str){
        Collections.addAll(this.SolarSys2, str);
    }

    public void remove(String str){
        SolarSys2.remove(str);
    }

    public void change(String ostr, String nstr){
        Collections.replaceAll(this.SolarSys2, ostr, nstr);
    }
    public void shuffle(){
        Collections.shuffle(this.SolarSys2);
    }

    public void randomPlanet(){
        System.out.println(SolarSys2.get(new Random().nextInt(SolarSys2.size())));
    }

    public void showIndex(String str){
        System.out.println(SolarSys2.indexOf(str));
    }

    public void inList(String str){
        System.out.println(Arrays.asList(SolarSys2).contains(str));
    }

    public void reverse(){
        Collections.reverse(SolarSys2); // Переворачивает ArrayList
    };

    public void swap(int id1, int id2){
        Collections.swap(SolarSys2, id1, id2);
    };
}