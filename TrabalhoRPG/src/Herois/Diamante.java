package Herois;

import persoBase.Personagem;
import persoBase.ResultadoPoder;

import java.util.Scanner;


public class Diamante extends Personagem {

    Scanner leitor = new Scanner(System.in);

    public Diamante(String nome) {
        super(nome,"Diamante");
    }


    @Override //Metodo herdado e polimorfado
    public ResultadoPoder usar_poder() {
        System.out.println("""
Escolha a habilidade:
(1) Lâmina de Cristal - Custo: 30 stamina
(2) Armadura Diamantina - Custo: 20 stamina
(3) Corte de Diamante - Custo: 50 stamina
""");
        int hab = leitor.nextInt(); //Leitor de habilidade
        int dano = 0;

        switch (hab) {// Se hab for igual a 1, executa esse ataque
            case 1:
                if (stamina>=30){// Custo de stamina do ataque é 40
                    System.out.println("%s usou \"Lâmina de cristal\"\n");
                    buffarAtaque();
                    return new ResultadoPoder(0, 30);
                }break;
            case 2:
                if (stamina>=20) {
                    System.out.printf("%s usou a habilidade \"Armadura Diamantina\"!\n", nome);
                    buffarDefesa();
                    return new ResultadoPoder(0, 20);
                }break;
            case 3:
                if (stamina>=50) {
                    saveDano = (int) (6 * danoAtaqueMagico + level * 5);
                    System.out.printf("%s usou a habilidade \"Corte de Diamante\"!\n", nome);
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