package persoBase;

import Herois.*;

public class Transformador {
    public static Personagem transformar(String nome, int escolha) {
        return switch (escolha) {
            case 1 -> new Xlr8(nome);
            case 2 -> new Diamante(nome);
            case 3 -> new Enormossauro(nome);
            case 4 -> new FogoFatuo(nome);
            case 5 -> new Anfibio(nome);
            case 6 -> new AmeacaAquatica(nome);
            case 7 -> new Feedback(nome);
            case 8 -> new Atomico(nome);
            case 9 -> new QuatroBracos(nome);
            case 10 -> new BolaDeCanhao(nome);
            default -> throw new IllegalArgumentException("Alien inválido!");
        };
    }
}