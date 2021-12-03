import java.util.*;
import java.lang.*;

public class DrunkGame {
    public static void main(String[] args) {
        ex1();
        ex2();
        ex3();
    }
    public static void ex3(){
        Scanner scn = new Scanner(System.in);
        Deque<Integer> player1 = new LinkedList<>();
        Deque<Integer> player2 = new LinkedList<>();

        for(int i = 0; i < 5; i++){
            player1.add(scn.nextInt());
        };
        for(int i = 0; i < 5; i++){
            player2.add(scn.nextInt());
        };

        for(int i = 0; i < 106; i++){

        }
        int turn1;
        int turn2;
        for(int i = 1; i <= 106; i++){
            turn1 = player1.poll();
            turn2 = player2.poll();
            if (turn2 > turn1 || turn2 == 6){
                player1.remove(player1.poll());
                player2.remove(player2.poll());
                player2.add(turn1);
                player2.add(turn2);

                if(player1.isEmpty()){
                    System.out.println("second " + i);
                    return;
                }
                continue;
            }
            if (turn1 > turn2 || turn1 == 6){
                player2.remove(player2.poll());
                player1.remove(player1.poll());
                player1.add(turn1);
                player1.add(turn2);

                if(player2.isEmpty()){
                    System.out.println("first " + i);
                    return;
                }
                continue;
            }
        }
        System.out.println("botva");
        return;
    }

    public static void ex2(){
        Scanner scn = new Scanner(System.in);
        Queue<Integer> player1 = new LinkedList<>();
        Queue<Integer> player2 = new LinkedList<>();

        for(int i = 0; i < 5; i++){
            player1.add(scn.nextInt());
        };
        for(int i = 0; i < 5; i++){
            player2.add(scn.nextInt());
        };

        for(int i = 0; i < 106; i++){

        }
        int turn1;
        int turn2;
        for(int i = 1; i <= 106; i++){
            turn1 = player1.poll();
            turn2 = player2.poll();
            if (turn2 > turn1 || turn2 == 6){
                player1.remove(player1.poll());
                player2.remove(player2.poll());
                player2.add(turn1);
                player2.add(turn2);

                if(player1.isEmpty()){
                    System.out.println("second " + i);
                    return;
                }
                continue;
            }
            if (turn1 > turn2 || turn1 == 6){
                player2.remove(player2.poll());
                player1.remove(player1.poll());
                player1.add(turn1);
                player1.add(turn2);

                if(player2.isEmpty()){
                    System.out.println("first " + i);
                    return;
                }
                continue;
            }
        }
        System.out.println("botva");
        return;
    }

    public static void ex1(){
        Scanner scn = new Scanner(System.in);
        Stack<Integer> player1 = new Stack<>();
        Stack<Integer> player2 = new Stack<>();

        for(int i = 0; i < 5; i++){
            player1.push(scn.nextInt());
        };
        for(int i = 0; i < 5; i++){
            player2.push(scn.nextInt());
        };

        for(int i = 0; i < 106; i++){

        }
        int turn1;
        int turn2;
        for(int i = 1; i <= 106; i++){
            turn1 = player1.firstElement();
            turn2 = player2.firstElement();
            if (turn2 > turn1 || turn2 == 6 || turn1 == 9 && turn2 == 0){
                player1.remove(player1.firstElement());
                player2.remove(player2.firstElement());
                player2.push(turn1);
                player2.push(turn2);

                if(player1.isEmpty()){
                    System.out.println("second " + i);
                    return;
                }
                continue;
            }
            if (turn1 > turn2 || turn1 == 6 || turn1 == 0 && turn2 == 9){
                player2.remove(player2.firstElement());
                player1.remove(player1.firstElement());
                player1.push(turn1);
                player1.push(turn2);

                if(player2.isEmpty()){
                    System.out.println("first " + i);
                    return;
                }
                continue;
            }
        }
        System.out.println("botva");
        return;
    }
}
