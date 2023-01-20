
/*
Antes 1.8
- nao tinha implementacao --> metodo abstrato ?
- nao permitia atributos --> final ?

Depois 1.8:
- implementar metodos em interfaces: default

polimorfismo:
- sobrescrita / override = herança + manter assinatura do método
- sobrecarga / overload = métodos com parâmetros diferentes (métodos com mesmo nome e assinatura diferente)
 */
/*
Metodo abstrato --> Classe abstrata
Classe abstrat NAO --> metodo abstrato
 */
abstract class JogoMaluco {

    abstract void runAgain();


    public void run() {
        System.out.println("JogoMaluco rodando");
    }

}

interface Game {

    void run();

    default void imprime() {
        System.out.println("Ola");
    }
}

//interface --> implements
//heranca --> extends
class Sonic implements Game {

    @Override
    public void run() {
        System.out.println("Sonic is running");
    }
}

class MarioBros implements Game {
    @Override
    public void run() {
        System.out.println("MarioBros is running");
    }

    public void run(int life) {
        System.out.println("MarioBros has " + life + " lives.");
    }
}

public class VideoGame {

    public static void runGame(Game game) {
        game.run();
    }

    public static void main(String[] args) {
        var gameMario = new MarioBros();
        var gameSonic = new Sonic();

        runGame(gameMario);
        runGame(gameSonic);
    }
}
