/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Clases.Operaciones;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

public class Calculadora {
    private ArrayList<Double> memory = new ArrayList<Double>(10);
    private double operandoAcumulado = 0;
    private int operador = 0;
    private boolean acumuladoNull = true;

    public Calculadora() {
        for (int i = 0; i < 10; i++)
            this.memory.add(null);
        this.write("");
    }

    public void setOperandoAcumulado(double operando) {
        this.operandoAcumulado = operando;
        this.acumuladoNull = false;
    }

    public boolean getAcumuladoNull() {
        return acumuladoNull;
    }

    public void resetAcumuladoNull() {
        this.acumuladoNull = true;
    }

    public void setOperador(int operadorCode) {
        this.operador = operadorCode;
    }

    public int getOperador() { 
        return operador;
    }

    public double getOperandoAcumulado() {
        return operandoAcumulado;
    }
    
    public String getMemory(){
        String result = "";
        for (int i = 0; i < 10; i++)
            if (memory.get(i) != null)
                result += Double.toString(memory.get(i)) + " ";
        return result;
    }
    
    public double operacionBasica(double operando) {
        double num1 = this.operandoAcumulado;
        double num2 = operando;
        int code = this.operador;
        switch (code) {
            case 1:
                return Operaciones.suma(num1, num2);
            case 2:
                return Operaciones.resta(num1, num2);
            case 3:
                return Operaciones.multiplicacion(num1, num2);
            case 4:
                return Operaciones.division(num1, num2);                          
            default:
                return 0;
        }
    }
    
    public void saveInMemory(double operando){
        if (this.memory.get(9) != null){
            for (int i = 0; i < 9; i++)
                memory.set(i, memory.get(i+1));
            memory.set(9, null);
        }
        for (int i = 0; i < 10; i++){
            if (memory.get(i) == null){
                memory.set(i, operando);
                break;
            }
        }
    }

    public double operacionPromedio(){
        return Operaciones.promedio(this.memory);
    }

    public double operacionBinario(){
        return Operaciones.binario(this.operandoAcumulado);
    }

    public boolean esPrimo(){
        return Operaciones.primo(this.operandoAcumulado);
    }
        
    public void write(String operation) {
        try {
            File archivo = new File("Bitacora.txt");
            FileOutputStream is = new FileOutputStream(archivo, true);
            OutputStreamWriter osw = new OutputStreamWriter(is);  
            Writer w = new BufferedWriter(osw);
            archivo.deleteOnExit();
            w.write(operation);
            w.close();
        }   
        catch (IOException e) {
            System.err.println("ERROR in writing file");
        }
    }
    
    public String readFile () throws FileNotFoundException, IOException {
        String path = "Bitacora.txt";
        String everything;
        try(BufferedReader br = new BufferedReader(new FileReader(path))) 
        {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
        everything = sb.toString();
        }
        return everything;
    }

}
