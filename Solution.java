import java.lang.*;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        /*Student std = new Student(new Scanner(System.in).nextInt());
        System.out.println(std);
        std.insertionSort();
        System.out.println(std);*/

        int[] arr1 = new int[new Scanner(System.in).nextInt()];
        for(int i = 0; i < arr1.length; i++) {arr1[i] = new Scanner(System.in).nextInt();}
        int[] arr2 = new int[new Scanner(System.in).nextInt()];
        for(int i = 0; i < arr2.length; i++) {arr2[i] = new Scanner(System.in).nextInt();}

        System.out.println(Arrays.toString(mergeSort(arr1, arr2, 0, arr1.length + arr2.length - 1)));

        //SortingStudentsByGPA tmp = new SortingStudentsByGPA(5);
        //System.out.println(tmp);

    }

    static int[] mergeSort(int[] arr1, int[] arr2, int left, int right){
        int[] tmp = new int[arr1.length + arr2.length];
        for(int i = 0; i < tmp.length; i++){
            if(i - arr1.length <= -1){
                tmp[i] = arr1[i];
            }
            else{tmp[i] = arr2[tmp.length - i - 1];}
        }
        // Выберем разделитель, т.е. разделим пополам входной массив
        int delimiter = left + ((right - left) / 2) + 1;
        // Выполним рекурсивно данную функцию для двух половинок (если сможем разбить(
        if (delimiter > 0 && right > (left + 1)) {
            mergeSort(tmp, new int[0],left, delimiter - 1);
            mergeSort(tmp, new int[0],delimiter, right);
        }
        // Создаём временный массив с нужным размером
        int[] buffer = new int[right - left + 1];
        // Начиная от указанной левой границы идём по каждому элементу
        int cursor = left;
        for (int i = 0; i < buffer.length; i++) {
            // Мы используем delimeter чтобы указывать на элемент из правой части
            // Если delimeter > right, значит в правой части не осталось недобавленных элементов
            if (delimiter > right || tmp[cursor] > tmp[delimiter]) {
                buffer[i] = tmp[cursor];
                cursor++;
            } else {
                buffer[i] = tmp[delimiter];
                delimiter++;
            }
        }
        System.arraycopy(buffer, 0, tmp, left, buffer.length);
        return tmp;
    }
}

class Student{
    private int[] iDnumber;
    Scanner scan;

    Student(int num){
        iDnumber = new int[num];
        scan = new Scanner(System.in);
        for(int i = 0; i < num; i++)
        {
            iDnumber[i] = scan.nextInt();
        }
    };


    public void insertionSort(){
        for (int left = 0; left < iDnumber.length; left++) {
            // Вытаскиваем значение элемента
            int value = iDnumber[left];
            // Перемещаемся по элементам, которые перед вытащенным элементом
            int i = left - 1;
            for (; i >= 0; i--) {
                // Если вытащили значение меньшее — передвигаем больший элемент дальше
                if (value <= iDnumber[i]) {
                    iDnumber[i + 1] = iDnumber[i];
                } else {
                    // Если вытащенный элемент больше — останавливаемся
                    break;
                }
            }
            // В освободившееся место вставляем вытащенное значение
            iDnumber[i + 1] = value;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "iDnumber=" + Arrays.toString(iDnumber) +
                '}';
    }
};

interface Comparator{
    public void reverseQuickSort(int leftBorder, int rightBorder);
}

class SortingStudentsByGPA implements Comparator{
    private float[] array;
    private Scanner scan;

    SortingStudentsByGPA(int num){
        array = new float[num];
        scan = new Scanner(System.in);
        for(int i = 0; i < num; i++)
        {
            array[i] = scan.nextFloat();
        }
        reverseQuickSort(0, num - 1);
    };
    @Override
    public void reverseQuickSort(int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        float pivot = array[(leftMarker + rightMarker) / 2];
        do {
            // Двигаем левый маркер слева направо пока элемент меньше, чем pivot
            while (array[leftMarker] > pivot) {
                leftMarker++;
            }
            // Двигаем правый маркер, пока элемент больше, чем pivot
            while (array[rightMarker] < pivot) {
                rightMarker--;
            }
            // Проверим, не нужно ли обменять местами элементы, на которые указывают маркеры
            if (leftMarker >= rightMarker) {
                // Левый маркер будет меньше правого только если мы должны выполнить swap
                if (leftMarker > rightMarker) {
                    float tmp = array[leftMarker];
                    array[leftMarker] = array[rightMarker];
                    array[rightMarker] = tmp;
                }
                // Сдвигаем маркеры, чтобы получить новые границы
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        // Выполняем рекурсивно для частей
        if (leftMarker < rightBorder) {
            reverseQuickSort(leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            reverseQuickSort(leftBorder, rightMarker);
        }
    }

    @Override
    public String toString() {
        return "SortingStudentsByGPA{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}