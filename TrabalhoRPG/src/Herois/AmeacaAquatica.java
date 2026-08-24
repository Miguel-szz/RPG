package Herois;
import persoBase.Personagem;
import persoBase.ResultadoPoder;

import java.util.Random;
import java.util.Scanner;

//classe para representar o alien Ameaça Aquática presente no omnitrix. O personagem aparece no ben 10 Suprema"cia Alienígena
public class AmeacaAquatica extends Personagem {

    Random gerador = new Random();
    Scanner leitor = new Scanner(System.in);

    public AmeacaAquatica(String nome) {
        super(nome,"Ameaça Aquática");
    }

    //AmeacaAquatica deve levar menos dano para ataques de água, com chance de absorve-los
    @Override
    public ResultadoPoder usar_poder() {
        System.out.println("""
                        Escolha a habilidade:
                       (1) Blindagem de Água - Custo: 25 stamina
                       (2) Rajada H2O - Custo: 20 stamina
                       (3) Tsunâmi - Custo: 50 stamina
                       """);
        int hab = leitor.nextInt();
        int dano = 0;

        switch (hab) {// Se hab for igual a 1, executa esse ataque
            case 1:
                if (stamina>=25){// Custo de stamina do ataque é 40
                    System.out.println("%s usou \"Blindagem de água\"\n");
                    buffarAtaque();
                    return new ResultadoPoder(0, 25);
                }break;
            case 2:
                if (stamina>=20) {
                    saveDano = (int) (4 * danoAtaqueMagico + level * 3);
                    System.out.printf("%s usou a habilidade \"Rajada H2O\"! \n", nome);
                    return new ResultadoPoder(saveDano, 20);
                }break;
            case 3:
                if (stamina>=50) {
                    saveDano = (int) (5 * danoAtaqueMagico + level * 4);
                    System.out.printf("%s usou a habilidade \"Tsunâmi \"! \n", nome);
                    return new ResultadoPoder(0, 50);
                }break;
            default:
                System.out.println("Comando inválido! O turno foi desperdiçado.");
                break;
        }
        System.out.println(nome + " está sem stamina suficiente e não conseguiu usar a habilidade!");
        return new ResultadoPoder(0, 0);
    }
}