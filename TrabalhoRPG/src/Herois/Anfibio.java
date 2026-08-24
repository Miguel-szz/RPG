package Herois;
import persoBase.Personagem;
import persoBase.ResultadoPoder;

import java.util.Random;
import java.util.Scanner;

//classe para representar o alien Anfíbio presente no omnitrix. O personagem aparece no ben 10 Supremacia Alienígena
public class Anfibio extends Personagem {

    Random gerador = new Random();
    Scanner leitor = new Scanner(System.in);

    public Anfibio(String nome) {
        super(nome,"Anfíbio");
    }

    //Anfíbio deve levar menos dano para ataques de eletrecidade , com chance de absorve-los
    @Override
    public ResultadoPoder usar_poder() {
        System.out.println("""
    Escolha a habilidade:
    (1) Intangibilidade - Custo: 15 stamina
    (2) Eletrocinese - Custo: 20 stamina
    (3) Telepatia - Custo: 45 stamina
    """);
        int hab = leitor.nextInt();
        int dano = 0;

        switch (hab) {// Se hab for igual a 1, executa esse ataque
            case 1:
                if (stamina>=15){// Custo de stamina do ataque é 40
                    System.out.println("%s usou \"Intangibilidade\"Tentando desviar e contra atacar\n");
                    return new ResultadoPoder(esquivaEContraAtaca(), 15);
                }break;
            case 2:
                if (stamina>=20) {
                    saveDano = (int) (4 * danoAtaqueMagico + level * 3);
                    System.out.printf("%s usou a habilidade \"Eletrocinese\"! (%d de dano)\n", nome , saveDano);
                    return new ResultadoPoder(saveDano, 20);
                }break;
            case 3:
                if (stamina>=45) {
                    saveDano = (int) (5 * danoAtaqueMagico + level * 4);
                    System.out.printf("%s usou a habilidade \"Telepatia\"! (%d de dano)\n", nome, saveDano);
                    return new ResultadoPoder(saveDano, 45);
                }break;
            default:
                System.out.println("Comando inválido! O turno foi desperdiçado.");
                break;
        }
        System.out.println(nome + " está sem stamina suficiente e não conseguiu usar a habilidade!");
        return new ResultadoPoder(0, 0);
    }
}