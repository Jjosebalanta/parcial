import java.util.Random;
import java.util.Scanner;

class Personaje {
   private String cuchillo;
    private String nombre;
    private int puntosDeVida;
    //en mayusculas porque es constate y el "private final" es porque no va a cambiar***
    private final int MAX_DANO = 30;
    private final int MIN_DANO = 10;

    public Personaje(String nombre) {
        this.nombre = nombre;
        this.puntosDeVida = 100;
    }
    //firma la firam de este metodo es publico no retora tipo de bariable personage
    public void atacar(Personaje oponente) {
        Random rand = new Random();
        //para de clarar un aleatorio rand
        int incremeto=20;
        int dano = rand.nextInt((MAX_DANO - MIN_DANO) + 1) +
                MIN_DANO;
        oponente.recibirDano(dano);
        System.out.print(this.nombre + " ataca a " +
                oponente.getNombre() + " causando " + dano + "puntos de dano .");
        oponente.recibirincrimetodevida(incremeto);  
            
    }

    public void recibirDano(int dano) {
        this.puntosDeVida -= dano;
        if (this.puntosDeVida < 0) {
            this.puntosDeVida = 0;
        }
    }
    public void recibirincrimetodevida(int incremeto) {
        this.puntosDeVida +=incremeto ;
        if (this.puntosDeVida < 15) {
            this.puntosDeVida +=20;
        }
    }

    public boolean estaVivo() {
        return this.puntosDeVida > 0;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getPuntosDeVida() {
        return this.puntosDeVida;
    }
    public String cuchillo(){
        return this.cuchillo;
    }
}

class JuegoLucha {
    private Personaje jugador1;
    private Personaje jugador2;
     // el publuc es el constructor
    public JuegoLucha(String nombre1, String nombre2) {
        //estos son los atrivutos de constructor
        this.jugador1 = new Personaje(nombre1);
        this.jugador2 = new Personaje(nombre2);
    }
    
    public void iniciarPelea() {
        System.out.print("La pelea comienza entre " +
                jugador1.getNombre() + " y " + jugador2.getNombre() + " ");
                
                
        System.out.print("se asigna el arma cuchillo a "+
        jugador1.getNombre()+".");
        System.out.print("se asigna el arma manopla a "+
        jugador2.getNombre()+".");


        while (jugador1.estaVivo() && jugador2.estaVivo()) {
            turno(jugador1, jugador2);
            if (jugador2.estaVivo()) {
                turno(jugador2, jugador1);

            }
        }
    
        if (jugador1.estaVivo()) {
            System.out.print(jugador1.getNombre() + " haganado la pelea .");
        } else {
            System.out.print(jugador2.getNombre() + " haganado la pelea .");
        }
    }
    
    private void turno(Personaje atacante, Personaje defensor) {
        System.out.print(" Turno de " + atacante.getNombre() + ". Puntos de vida de " + defensor.getNombre() + ": "
                + defensor.getPuntosDeVida());
        atacante.atacar(defensor);
        System.out.print(defensor.getNombre() + " ahoratiene " + defensor.getPuntosDeVida() + " puntosde vida .");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(" Introduce el nombre del jugador 1:");
        String nombre1 = scanner.nextLine();

        System.out.print(" Introduce el nombre del jugador 2:");
        String nombre2 = scanner.nextLine();

        JuegoLucha juego = new JuegoLucha(nombre1, nombre2);
        juego.iniciarPelea();
    }

}