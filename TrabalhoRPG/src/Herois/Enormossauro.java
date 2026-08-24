package Herois;
import java.util.Scanner;
import persoBase.Personagem;
import persoBase.ResultadoPoder;

public class Enormossauro extends Personagem {
    Scanner leitor = new Scanner(System.in);

    public Enormossauro(String nome) {
    super(nome, "Enormossauro");
    }

    @Override
    public ResultadoPoder usar_poder() {
        System.out.println("""
Escolha a habilidade:
(1) Superforça - Custo: 15 stamina
(2) Rugido Poderoso - Custo: 50 stamina
(3) Alongamento - Custo: 15 stamina
""");
        int hab = leitor.nextInt();
        int dano = 0;
        switch (hab) {// Se hab for igual a 1, executa esse ataque
            case 1:
                if (stamina>=15){// Custo de stamina do ataque é 40
                    System.out.println("%s usou \"Superforça\"\n");
                    buffarAtaque();
                    return new ResultadoPoder(0, 15);
                }break;
            case 2:
                if (stamina>=50) {
                    saveDano = (int) (4.5 * danoAtaqueMagico + level * 4);
                    System.out.printf("%s usou a habilidade \"Rugido Poderoso\"! \n", nome);
                    return new ResultadoPoder(saveDano, 50);
                }break;
            case 3:
                if (stamina>=15) {
                    System.out.printf("%s usou a habilidade \"Alongamento\"!\n", nome);
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
