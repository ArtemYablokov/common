package main.java.algorithms;

public class Exponential {
    private static int exp(int numb, int k){
        int result = 1; // это число в нулевой степени
        // инвариант - сколько вычли из k единиц - во столько степеней возвели число
        // одна сетепень - это домножение на само число
        // две - перемножение их между собой
        // ОСНОВНОЙ СМЫСЛ  - В РЕЗУЛЬТАТЕ АККУМУЛИРУЕМ ВСЕ УМНОЖЕНИЯ В РЕЗУЛЬТАТЕ

//        int k = n;

        while (k > 0){
            if (k%2 == 0){
                numb *= numb;
                k/=2;
            } else {
                result *= numb;
                k--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(exp(3,1));
    }
}
