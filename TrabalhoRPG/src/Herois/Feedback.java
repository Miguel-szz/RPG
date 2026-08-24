package Herois;
import persoBase.Personagem;
import persoBase.ResultadoPoder;

import java.util.Random;
import java.util.Scanner;

//classe para representar o alien Feedback presente no omnitrix. O personagem aparece no ben 10 clássico e no omniverse
public class Feedback extends Personagem {

    Random gerador = new Random();
    Scanner leitor = new Scanner(System.in);

    public Feedback(String nome) {
        super(nome,"Feedback");
    }

    //feedback deve levar menos dano para ataques eletricos, com chance de absorve-los
    @Override
    public ResultadoPoder usar_poder() {
        System.out.println("""
Escolha a habilidade:
(1) Potencializador Elétrico - Custo: 10 stamina
(2) Discos de Energia - Custo: 25 stamina
(3) Ondas de Choque - Custo: 50 stamina
""");
        int hab = leitor.nextInt();
        int dano = 0;
        switch (hab) {// Se hab for igual a 1, executa esse ataque
            case 1:
                if (stamina>=10){// Custo de stamina do ataque é 40
                    System.out.println("%s usou \"Potencializador Elétrico\"!\n");
                    buffarAtaque();
                    return new ResultadoPoder(0, 10);
                }break;
            case 2:
                if (stamina>=25) {
                    saveDano = (int) (4.5 * danoAtaqueMagico + level * 4);
                    System.out.printf("%s usou a habilidade \"Discos de Energia\"!\n", nome);
                    return new ResultadoPoder(saveDano, 25);
                }break;
            case 3:
                if (stamina>=50) {
                    saveDano = (int) (6 * danoAtaqueMagico + level * 5);
                    System.out.printf("%s usou a habilidade \"Ondas de Choque\"!\n", nome);
                    return new ResultadoPoder(saveDano, 50);
                }break;
            default:
                System.out.println("Comando inválido! O turno foi desperdiçado.");
                break;
        }

        System.out.println(nome + " está sem stamina suficiente e não conseguiu usar a habilidade!");
        return new ResultadoPoder(0, 0);
    }



}
