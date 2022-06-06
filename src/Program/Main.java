package Program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Scanner scn = new Scanner(System.in);
        Arrays.sort(array);

        System.out.print("Введите искомую сумму: s = ");
        int sum = scn.nextInt(); // искомая сумма

        // создаём список пар(дуетов)
        List<Duet> duets = new ArrayList<>();
        for (int i = 0; i < array.length - 1; i++) {
            // число, для которого ищем пару
            int firstNumberForDuet = array[i];
            // обрезаем начальный массив по элементам от следующего после текущего до последнего
            int[] cutArray = Arrays.copyOfRange(array, i + 1, array.length);
            // ищем с помощью бинарного поиска
            binarySearch(duets, cutArray, sum, array[i]);
        }
    }

    // бинарный поиск
    public static void binarySearch(List<Duet> duets, int[] array, int item, int firstNumberForDuet) {
        int position;

        int first = 0;
        int last = array.length - 1;

        // для начала найдем индекс среднего элемента массива
        position = (first + last) / 2;

        while ((array[position]  + firstNumberForDuet != item) && (first <= last)) {
            if (array[position]  + firstNumberForDuet > item) {  // если число заданного для поиска
                last = position - 1; // уменьшаем позицию на 1.
            } else {
                first = position + 1;    // иначе увеличиваем на 1
            }
            position = (first + last) / 2;
        }
        if (first <= last) {
            duets.add(new Duet(firstNumberForDuet, array[position]));
            System.out.println(duets.get(duets.size() - 1));
        }
    }


    public static void printResult(int s, List<Duet> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }
}
