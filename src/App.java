import java.util.Scanner;
import javax.sound.sampled.SourceDataLine;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        double resultado;
        /*proc hiloUno = new proc();
        procDos hiloDos = new procDos();
        hiloDos.start();
        //hiloUno.start();

        //hiloUno.interrupt();
        hiloDos.interrupt();
        
        */
        
        System.out.println("dame un numero");
        double  n =  sc.nextDouble();

        resultado=coordinador(n);

        System.out.println("El resultado es: "+ resultado);
    }
    public static double coordinador(double num){

        double res = iterativa((int)num);
        double resu = recursiva((int )num);
        return resu;

        /*double n = num/2;
        double resu;
        proc hiloUno = new proc(n);
        hiloUno.start();
        resu = hiloUno.getNum();
        hiloUno.interrupt();
        return resu;*/
    }
    public static double iterativa(int nu){
        double fa;
        if(nu <= 2){
            return nu;
        }else{
            fa = nu;
            for (int i = nu; i >= 2; i--) {
                fa = fa*(i-1);
            }
            return fa;
        }
    }
    public static double recursiva(int num){
        if(num == 0){
            return 1;
        }else{
            System.out.println(num);
            return num * recursiva(num-1);
        }

    }
}
