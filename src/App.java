import java.util.Scanner;
import javax.sound.sampled.SourceDataLine;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.*;

public class App {
    /*
    Preguntas:
     1-¿Si calculamos el factorial de 1.000.000 iterativamente es más eficiente
     que hacerlo con 2 hilos?
     2-¿Si calculamos el factorial de 1.000.000 recursivamente es más
     eficiente que hacerlo con 2 hilos?
    */

    public static void main(String[] args) throws Exception {
        File f = new File("respuestas.txt");
        FileOutputStream fos = new FileOutputStream(f);
        PrintWriter w = new PrintWriter(fos);
        
        long val = 100000L;
        w.println("Factorial("+val+")");
        System.out.println("Estadísticas");

        double start = System.currentTimeMillis();
        BigInteger respuesta = iterativa(val);
        double end = System.currentTimeMillis();
        double tiempoIte = end-start;
        System.out.println("los milisegundos son con el metodo iterativo es: "+ tiempoIte);
        w.println("los milisegundos con el metodo iterativo es: "+ tiempoIte);
        w.flush();

        start = System.currentTimeMillis();
        BigInteger respuesta2 = recursiva(val);
        end = System.currentTimeMillis();
        double tiempoRec = end-start;
        w.println("los milisegundos con el metodo recursivo es: "+ tiempoRec);
        System.out.println("los milisegundos son con el metodo recursivo es: "+ tiempoRec);
        w.flush();

        start = System.currentTimeMillis();
        BigInteger respuesta3 = factorialHilos(val);
        end = System.currentTimeMillis();
        double tiempoCon = end-start;
        System.out.println("los milisegundos son con el metodo concurrente es: "+ tiempoCon);
        w.println("los milisegundos con el metodo concurrente es: "+ tiempoCon);
        w.println("Factorial( "+val +" ) es:\n"+respuesta3.toString());
        w.flush();

        //comparación método iterativo con el concurrente (siempre será mejor el concurrente a menos que se modifiquen los valores)
        if(tiempoIte>tiempoCon){
            System.out.println("Pregunta 1: Entre el método iterativo y el concurrente, el más rápido es el concurrente");
        }else{
            System.out.println("Pregunta 1: Entre el método iterativo y el concurrente, el más rápido es el iterativo");
        }

        //comparación método recursivo con el concurrente (siempre será mejor el concurrente a menos que se modifiquen los valores)
        if(tiempoRec>tiempoCon){
            System.out.println("Pregunta 2: Entre el método recursivo y el concurrente, el más rápido es el concurrente");
        }else{
            System.out.println("Pregunta 2: Entre el método recursivo y el concurrente, el más rápido es el recursivo");
        }

        w.close();
    }
    
    public static BigInteger iterativa(long nu){
        BigInteger res = BigInteger.valueOf(1L);
        for (long i = 1L; i <= nu ; i++) {
            res = res.multiply(BigInteger.valueOf(i));  // res = res * i
        }
        return res;
    }

    public static BigInteger recursiva(long num){
        
        if (num == 1L) {
            return BigInteger.valueOf(num);
        } else {
            return BigInteger.valueOf(num).multiply(recursiva(num - 1L));
        }
    }

    //METODO CON HILOS
    public static BigInteger factorialHilos(long num){
        long mitad = num/2;

        proc hiloUno = new proc(mitad);
        procDos hiloDos = new procDos(mitad + 1L,num);

        return hiloUno.get().multiply(hiloDos.get());
    }
}

