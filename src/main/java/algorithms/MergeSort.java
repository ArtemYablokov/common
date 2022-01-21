package main.java.algorithms;

import java.util.Arrays;

public class MergeSort {


    static int[] divideArray(int[] array){
        int length = array.length;
        if (length <2)
            return array;
        int center = length/2;

        int[] leftArray = Arrays.copyOfRange(array, 0, center);
        int[] rightArray = Arrays.copyOfRange(array, center, length);

        return mergeAndSortArrays(divideArray(leftArray), divideArray(rightArray));
    }

    static int[] mergeAndSortArrays(int[] leftArray, int[] rightArray){
        int leftL = leftArray.length;
        int rightL = rightArray.length;
        int total = leftL + rightL;
        int[] result = new int[leftL + rightL];

        int l = 0;
        int r = 0;
        int i = 0;


//        for (int j = 0; j < total; j++) {

        // пока массивы каждый НЕ ПУСТ !
        while (r < rightL && l < leftL){

            if (leftArray[l] < rightArray[r]) {
                result[i] = leftArray[l];
                l++;
            } else {
                result[i] = rightArray[r];
                r++;
            }
            i++;
        }
        if ( rightL != r )
            while (r < rightL) {
                result[i] = rightArray[r];
                r++; i++;
            }
        else
            while (l < leftL) {
                result[i] = leftArray[l];
                l++; i++;
            }

        return result;
    }


    public static void main(String[] args) {
        int[] arrayTest = new int[] {2,4,2,1,3,4,5,5,6,78,8,9,0,6,4,3,3,22,3,3,45,6,6,7,-88,6,4,-33};
//        int[] arrayTest = new int[] {22,3,3,3,3};
        System.out.printf("size before = %d\n", arrayTest.length);
        System.out.println(Arrays.toString(divideArray(arrayTest)));
        System.out.printf("size after = %d\n", arrayTest.length);

    }

}
