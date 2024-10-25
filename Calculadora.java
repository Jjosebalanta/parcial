public class Calculadora {
   
         private int valor1;
         private int valor2 ;
        
        
         public Calculadora(int valor1,int valor2){
            this.valor1=valor1;
            this.valor2=valor2;
            
         }
         public  int suma(){
            int suma= this.valor1+this.valor2;
            return suma;
         }
         public int resta(){
                int resta= this.valor1-this.valor2;
                return resta;
         }
         public int multiplicacion(){
                int multiplicacion=this.valor1*this.valor2;
                return multiplicacion;
         }
         public double division(){
                double division=this.valor1/this.valor2;
                return division;
         }



    

}
