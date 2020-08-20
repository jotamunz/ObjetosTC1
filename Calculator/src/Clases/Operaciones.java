/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;


public class Operaciones {
    
    public static double suma(double num1, double num2){
        return num1 + num2;
    }
    
    public static double resta(double num1, double num2){
        return num1 - num2;
    }
    
    public static double multiplicacion(double num1, double num2){
        return num1 * num2;
    }
    
    public static double division(double num1, double num2){
        if (num2 != 0)
            return num1 / num2;
        return 0;
    }
    
    public static double promedio(ArrayList<Double> arrayDoubles){
        double suma = 0;
        int count = 0;
        for (int i = 0; i < 10; i++){
            if (arrayDoubles.get(i) != null){
                suma += arrayDoubles.get(i);
                count++;
            }
        }
        if (count == 0)
            return 0;
        return suma / count;
    }
    
    public static double binario(double num){     
        boolean neg = false;
        if (num < 0){
            num *= -1;
            neg = true;
        }
        long wholeNum = (long) num;
        String binStr = Long.toBinaryString(wholeNum);
        double result = Double.parseDouble(binStr);
        if (neg)
            result *= -1;
        return result;
    }
    
    public static boolean primo(double num){
        if (num%1 != 0 || num <= 1)
            return false;
        for (int i = 2; i <= num/2; ++i){
            if(num % i == 0)
                return false;
        }
        return true;
    }
}
