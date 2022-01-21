package main.java.algorithms;

import java.util.Arrays;

public class InsertionSort {

    private static void insertionSort(int[] ints){


        for (int i = 1; i < ints.length; i++) {
            int key = ints[i]; // сохраним значение ключа ( его вставляем в отсортированный массив слева)
            // массив из одного элемента - заведомо отсортирован - это ИНВАРИАНТ цикла
            int limit = i-1; // начальный предел в начале меньше индекса ключа на единицу


            while (limit > -1 && ints[limit] > key){ // пока граница не меньше нуля И ее значение БОЛЬШЕ нашего ключа
                // пересохраняем элемент из границы в соседнюю правую ячейку
                ints[limit+1] = ints[limit];
                // перемещаем границу влево
                limit--;
            }
            // после выхода из цикла ключ нужно положить на позицию граница+1

            ints[limit+1] = key;
        }


    }

    public static void main(String[] args) {
        int[] ints = new int[]{3,5,1,6,8,2,0,4, -2, -11};
        insertionSort(ints);
        System.out.println(Arrays.toString(ints));

    }
}
