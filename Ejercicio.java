import java.util.Random;
import java.util.Scanner;

class Personaje {
    private String nombre;
    private int puntosDeVida;
    private final int MAX_DANO = 30;
    private final int MIN_DANO = 10;

    public Personaje(String nombre) {
        this.nombre = nombre;
        this.puntosDeVida = 100;
    }

    public void atacar(Personaje oponente) {
        Random rand = new Random();
        int dano = rand.nextInt((MAX_DANO - MIN_DANO) + 1) +
                MIN_DANO;
        oponente.recibirDano(dano);
        System.out.print(this.nombre + " ataca a " +
                oponente.getNombre() + " causando " + dano + "puntos de dano .");
    }

    public void recibirDano(int dano) {
        this.puntosDeVida -= dano;
        if (this.puntosDeVida < 0) {
            this.puntosDeVida = 0;
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
}

class JuegoLucha {
    private Personaje jugador1;
    private Personaje jugador2;

    public JuegoLucha(String nombre1, String nombre2) {

        this.jugador1 = new Personaje(nombre1);
        this.jugador2 = new Personaje(nombre2);
    }

    public void iniciarPelea() {
        System.out.print("La pelea comienza entre " +
                jugador1.getNombre() + " y " + jugador2.getNombre() + "...");

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