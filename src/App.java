import java.util.Scanner;
import javax.sound.sampled.SourceDataLine;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.*;

public class App {
    /*
      NOTAS PARA LA PROXIMA VUELTA

     - ESTA LA OPCION DE ELIMINAR LOS METODOS FACT QUE SE ENCUENTRAN EN LOS HILOS 
     - SE CREO EL METODO CON LOS HILOS(FALTA EL CASO: NUMERO NO ES PAR) 

    */

    public static void main(String[] args) throws Exception {
        File f = new File("respuestas.txt");
        FileOutputStream fos = new FileOutputStream(f);
        PrintWriter w = new PrintWriter(fos);
        
        long val = 1000000L;

        w.flush();
        double start = System.currentTimeMillis();
        BigInteger respuesta = iterativa(val);
        double end = System.currentTimeMillis();
        w.println("Factorial( "+val +" ) calculado de manera iterativa es:\n"+respuesta.toString());
        w.println("Y los milisegundos son: "+ (end-start));
        w.flush();

        start = System.currentTimeMillis();
        BigInteger respuesta2 = recursiva(val);
        end = System.currentTimeMillis();
        w.println("Factorial( "+val +" ) calculado de manera recursiva es:\n"+respuesta2.toString());
        w.println("Y los milisegundos son: "+ (end-start));
        w.flush();

        start = System.currentTimeMillis();
        BigInteger respuesta3 = factorialHilos(val);
        end = System.currentTimeMillis();
        w.println("Factorial( "+val +" ) calculado de manera concurrente es:\n"+respuesta3.toString());
        w.println("Y los milisegundos son: "+ (end-start));
        w.flush();


        w.flush();
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

