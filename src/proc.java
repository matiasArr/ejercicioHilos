public class proc extends Thread{
    double numero;
    double fa = 0.0;
    //contructor
    public proc(double num){
        numero = num;
    }
    public void run(){
        for (int i = 1; i <= numero; i++) {
            fa = fa + i*(i+1);
        }
        setNum(fa);
        
    }
    public double getNum(){
        return numero;
    }
    public void setNum(double fa){
        numero = 0;
        getNum();
        //numero = fa;
    }
   
}
