import java.lang.*;
import java.util.*;

public class Practice11 {
    public static void main(String[] args) {
        Solution HorseRace = new Solution();
        HorseRace.StartRace(6);
    }
}

class Horse extends Thread{
    private int number;
    Horse(int number){
        this.number = number;
        this.start();
    }
    @Override
    public void run() {
        synchronized (this) {
            System.out.println("Финишировал конь №" + number);
        }
    };
}

class Solution{
    public void StartRace(int n){
        Horse hr;
        for(int i = 0; i < n; i++) {
            hr = new Horse(i);
        }
    }
}