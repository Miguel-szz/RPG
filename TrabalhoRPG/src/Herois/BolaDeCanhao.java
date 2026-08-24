package Herois;

import persoBase.Personagem;
import persoBase.ResultadoPoder;

import java.util.Scanner;

public class BolaDeCanhao extends Personagem {
    
    Scanner leitor = new Scanner(System.in);
    
    public BolaDeCanhao(String nome) {
    super(nome, "Bola de Canhão");
    }
    
    @Override
    public ResultadoPoder usar_poder(){
        System.out.println("""
Escolha a habilidade:
(1) Forma de Esfera - Custo: 15 stamina
(2) Espinhos - Custo: 10 stamina
(3) Forma de Esfera (Defensiva) - Custo: 12 stamina
""");
        int hab = leitor.nextInt();
        int dano = 0;
        switch (hab) {
            case 1:
                if(stamina>=15){
                    saveDano = (int) (2.5 * danoAtaqueMagico + level * 2);
                    System.out.printf("%s usou \"Forma de Esfera\" \n", nome);
                    return new ResultadoPoder(saveDano, 15);
                }break;
            case 2:
                if(stamina>=10) {
                    saveDano = (int) (2 * danoAtaqueMagico + level * 1.5);
                    System.out.printf("%s usou a habilidade \"Espinhos\"\n", nome);
                    return new ResultadoPoder(0, 10);
                }break;
            case 3:
                if(stamina>=12) {
                    System.out.printf("%s usou a habilidade \"Forma de Esfera\"!\n", nome);
                    buffarDefesa();
                    return new ResultadoPoder(0, 12);                
                }break;
            default:
                System.out.println("Seu personagem está sem stamina ou o comando foi inválido");
                break;
        }
        System.out.println(nome + " está sem stamina suficiente e não conseguiu usar a habilidade!");
        return new ResultadoPoder(0, 0);

    }
}