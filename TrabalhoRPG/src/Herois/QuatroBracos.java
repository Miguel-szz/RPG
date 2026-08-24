package Herois;

import persoBase.Personagem;
import persoBase.ResultadoPoder;

import java.util.Scanner;



public class QuatroBracos extends Personagem {

    Scanner leitor = new Scanner(System.in);
    
    public QuatroBracos(String nome) {
        super(nome, "Quatro Braços");
    }
    
    @Override
    public ResultadoPoder usar_poder() {
        System.out.println("""
Escolha a habilidade:
(1) Ondas Supersônicas - Custo: 10 stamina
(2) Big Smack - Custo: 15 stamina
(3) Endurecimento - Custo: 15 stamina
""");
        int hab = leitor.nextInt();
        int dano = 0;
        switch (hab) {// Se hab for igual a 1, executa esse ataque
            case 1:
                if (stamina>=10){// Custo de stamina do ataque é 40
                    saveDano = (int) (2.5 * danoAtaqueMagico + level * 2);
                    System.out.printf("%s usou \"Ondas Supersônicas\"\n", nome);
                    return new ResultadoPoder(saveDano, 10);
                }break;
            case 2:
                if (stamina>=15) {
                    saveDano = (int) (3.5 * danoAtaqueMagico + level * 3);
                    System.out.printf("%s usou a habilidade \"Big Smack\"!\n", nome);
                    return new ResultadoPoder(saveDano, 15);
                }break;
            case 3:
                if (stamina>=15) {
                    System.out.printf("%s usou a habilidade \"Endurecimento\"!\n", nome);
                    buffarDefesa();
                    return new ResultadoPoder(0, 15);
                }break;
            default:
                System.out.println("Comando inválido! O turno foi desperdiçado.");
                break;
        }

        System.out.println(nome + " está sem stamina suficiente e não conseguiu usar a habilidade!");
        return new ResultadoPoder(0, 0);
    }
}