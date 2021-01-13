package ru.anfy.javaAlg;

public class Main {
    //Возведение в степень
    //это простой алгоритм, его сложность - O(n-1)
    static double simpleExponentiation(double v, double exp){
        double result = v;
        for (int i = 1; i < exp; i++) {
            result *= v;
        }
        System.out.printf("%f^%f=%f\n",v,exp,result);
        return result;
    }

    //это более интересное возведение в степень
    //O(logN) (примерно)
    static double quickExponentiation(double v, double exp){
        return quickExponentiation(v, exp, true);
    }

    static double quickExponentiation(double v, double exp, boolean echo){
        if(exp == 1) return v;
        boolean isParity = exp % 2 == 0; //Определим четная или нечетная степень
        double result = v;

        if(!isParity) exp--;

        if(exp > 1){
            result = quickExponentiation(v*v, exp/2, false);
        }

        if(!isParity) result *= v;

        if(echo) System.out.printf("%f^%f=%f\n",v,exp,result);
        return result;
    }

    //1.2. Поиск минимального элемента в массиве O(n-1)
    double min(double arr[]){
        double m = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(m > arr[i]) m = arr[i];
        }
        return m;
    }

    //1.3. Нахождение среднего арифметического массива O(n)
    double avr(double arr[]){
        if(arr.length == 0) return 0;
        double s = 0;
        for (int i = 0; i < arr.length; i++) {
            s+= arr[i];
        }
        return s / arr.length;
    }

    public static void main(String[] args) {
        simpleExponentiation(4,7);
        quickExponentiation(4,7);
    }
}
