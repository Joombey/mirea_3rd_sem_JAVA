import java.lang.*;
import java.util.Scanner;

public class Practice12 {
    public static void main(String[] args) {
        Solution tester = new Solution();
        Scanner scn = new Scanner(System.in);
        try {
            tester.listen(scn.nextLine(), scn.nextInt());
        }
        catch(WrongParameter err){
            err.printStackTrace();
        }
    }
}

class Solution{
    private final int INN;
    private final String FIO;

    Solution(){
        System.out.println("Регистрация пользователя:\nВведите ФИО ");

        Scanner scn = new Scanner(System.in);
        FIO = scn.nextLine();

        System.out.println("Введите ИНН ");

        INN = scn.nextInt();
    }

    public boolean isCorrect(String FIO, int INN){
        return FIO == this.FIO && INN == this.INN;
    }

    public void listen(String FIO, int INN) throws WrongParameter {
        if(isCorrect(FIO, INN))
            System.out.print("All fine");
        if(!(FIO == this.FIO && INN == this.INN)){
            throw new WrongParameter("INN or FIO is wrong");
        }
    }
}

class WrongParameter extends Exception{
    public WrongParameter(String errorMessage){
        super(errorMessage);
    }
}
