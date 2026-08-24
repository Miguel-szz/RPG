package Herois;
import java.util.Scanner;
import persoBase.Personagem;
import persoBase.ResultadoPoder;

public class Atomico extends Personagem {
    Scanner leitor = new Scanner(System.in);

    public Atomico(String nome) {
        super(nome, "Atômico");
    }

    @Override
    public ResultadoPoder usar_poder() {
        System.out.println("""
    Escolha a habilidade:
    (1) Escudo de Energia - Custo: 10 stamina
    (2) Vitória Nuclear - Custo: 25 stamina
    (3) Culinária de Fusão - Custo: 50 stamina
    """);
        int hab = leitor.nextInt();
        int dano = 0;

        switch (hab) {// Se hab for igual a 1, executa esse ataque
            case 1:
                if (stamina>=10){// Custo de stamina do ataque é 40
                    System.out.println("%s usou \"Escudo de Energia\"\n");
                    buffarDefesa();
                    return new ResultadoPoder(0, 10);
                }break;
            case 2:
                if (stamina>=25) {
                    saveDano = (int) (4 * danoAtaqueMagico + level * 3);
                    System.out.printf("%s usou a habilidade \"Vitória Nuclear\"! \n", nome);
                    return new ResultadoPoder(saveDano, 25);
                }break;
            case 3:
                if (stamina>=50) {
                    saveDano = (int) (5 * danoAtaqueMagico + level * 4);
                    System.out.printf("%s usou a habilidade \"Culinária de Fusão\"! \n", nome);
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
