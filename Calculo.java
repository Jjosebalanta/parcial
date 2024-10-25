public class Calculo {
 public static void main(String[] args) {
    Calculadora objp1 = new Calculadora (10,3);

    int suma = objp1.suma();
    System.out.println("la suma es: "+suma);

    int resta = objp1.resta();
    System.out.println("la resta es: "+resta);

    int multiplicacion = objp1.multiplicacion();
    System.out.println("la multiplicacion es: "+multiplicacion);

    double division = objp1.division();
    System.out.println("la division es: "+division);
    
 }
    



}