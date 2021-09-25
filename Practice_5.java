import java.lang.*;
import java.util.Scanner;
public class Practice_5{
    public static int t5(int num){
        if(num/10 == 0){
            return num;
        }
        else{
            return num % 10 + t5(num/10);
        }
    }

    public static String t6(int num, int div) {
        if(num <= 2){
            if(num == 2){
                return "YES";
            }
            else{
                return "NO";
            }
        }
        if(num % div == 0)
        {
            return "NO";
        }
        if(div * div > num){
            return "YES";
        }
        return t6(num, div + 1);
    }

    public static void t7(int num, int div)
    {
        if(div == 1)
        {
            System.out.println(num);
            return;
        }
        else if(num % div == 0){
            System.out.println(num / div);
        }
        t7(num, div - 1);
    }

    public static String t8(String word){
        if(word.length() <= 1){
            return "YES";
        }
        if(word.charAt(0) != word.charAt(word.length() - 1)){
            return "NO";
        }
        return t8(word.substring(1, word.length() - 1));
    }

    public static  int t9(int a, int b){
        if (a > b + 1){
            return 0;
        }
        if(a == 0 || b == 0){
            return 1;
        }
        return t9(a, b - 1) + t9(a - 1, b - 1);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num;
        String word;
        System.out.print("Задание 5 введите число\n");
        num = in.nextInt();
        System.out.println(t5(num));
        System.out.print("Задание 6 введите число\n");
        num = in.nextInt();
        System.out.println(t6(num, 2));
        System.out.print("Задание 7 введите число\n");
        num = in.nextInt();
        t7(num, num);
        System.out.print("Задание 8 введите слово\n");
        word = in.next();
        System.out.println(t8(word));
        System.out.print("Задание 9 введите число A\n");
        num = in.nextInt();
        System.out.print("Задание 9 введите число B\n");
        int B = in.nextInt();
        System.out.println(t9(num, B));
    }
}
