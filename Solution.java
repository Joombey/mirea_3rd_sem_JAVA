import java.lang.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        //№1
        Student std = new Student(new Scanner(System.in).nextInt());

        //№2
        SortingStudentsByGPA temp = new SortingStudentsByGPA(new Scanner(System.in).nextInt());
        System.out.println(temp);

        //№3
        Task3 tmp = new Task3();
    }
}


class Task3{
    Task3(){
        int[] arr1 = {3, 2, 1, 12,3, 12,31, 3,12, 3,123,123,123, 123,123,1, 23,12312,3,123, 12,3};
        int[] arr2 = {7, 6, 56, 6, 12,3,1, 2,1, 23,123, 12,31, 23,3,3, 5};
        int[] arr = new int[arr1.length + arr2.length];

        System.arraycopy(arr1, 0, arr, 0, arr1.length);
        System.arraycopy(arr2, 0, arr, arr1.length, arr2.length);

        arr = mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static int[] mergeSort(int[] array) {
        int[] tmp;
        int[] currentSrc = array;
        int[] currentDest = new int[array.length];

        int size = 1;
        while (size < array.length) {
            for (int i = 0; i < array.length; i += 2 * size) {
                merge(currentSrc, i, currentSrc, i + size, currentDest, i, size);
            }

            tmp = currentSrc;
            currentSrc = currentDest;
            currentDest = tmp;

            size = size * 2;

            System.out.println(Arrays.toString(currentSrc));
        }
        return currentSrc;
    }

    private static void merge(int[] src1, int src1Start, int[] src2, int src2Start, int[] dest,
                              int destStart, int size) {
        int index1 = src1Start;
        int index2 = src2Start;

        int src1End = Math.min(src1Start + size, src1.length);
        int src2End = Math.min(src2Start + size, src2.length);

        if (src1Start + size > src1.length) {
            for (int i = src1Start; i < src1End; i++) {
                dest[i] = src1[i];
            }
            return;
        }

        int iterationCount = src1End - src1Start + src2End - src2Start;

        for (int i = destStart; i < destStart + iterationCount; i++) {
            if (index1 < src1End && (index2 >= src2End || src1[index1] < src2[index2])) {
                dest[i] = src1[index1];
                index1++;
            } else {
                dest[i] = src2[index2];
                index2++;
            }
        }
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
        insertionSort();
        System.out.println(Arrays.toString(iDnumber));
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
    public void quickSort(float[] source, int leftBorder, int rightBorder);
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
        quickSort(this.array, 0, array.length - 1);
    };

    @Override
    public String toString() {
        return "SortingStudentsByGPA{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    @Override
    public void quickSort(float[] source, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        float pivot = source[(leftMarker + rightMarker) / 2];
        do {
            // Двигаем левый маркер слева направо пока элемент меньше, чем pivot
            while (source[leftMarker] > pivot) {
                leftMarker++;
            }
            // Двигаем правый маркер, пока элемент больше, чем pivot
            while (source[rightMarker] < pivot) {
                rightMarker--;
            }
            // Проверим, не нужно обменять местами элементы, на которые указывают маркеры
            if (leftMarker <= rightMarker) {
                // Левый маркер будет меньше правого только если мы должны выполнить swap
                if (leftMarker < rightMarker) {
                    float tmp = source[leftMarker];
                    source[leftMarker] = source[rightMarker];
                    source[rightMarker] = tmp;
                }
                // Сдвигаем маркеры, чтобы получить новые границы
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        // Выполняем рекурсивно для частей
        if (leftMarker < rightBorder) {
            quickSort(source, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quickSort(source, leftBorder, rightMarker);
        }
    }
}
