package Vilões;

import persoBase.ResultadoPoder;
import persoBase.Personagem;

import java.util.Random;

public class KevinLevin extends Personagem {

    public KevinLevin(String nome){
        super(nome,"Kevin Levin");

    }

    @Override
    public ResultadoPoder usar_poder() {


        Random chance = new Random();
        int dado = chance.nextInt(1,3);

        if ( dado == 2 ) { // Se o numero sorteado for maior ou igual a 0.5 ele executara este ataque
            saveDano=4*danoAtaqueMagico;
            System.out.printf("%s usou \"Manipulção de cristais\"! \n Causando %d de dano\n", this.nome, saveDano);
            return new ResultadoPoder(saveDano, 0);
        } else if (dado ==1) {
            saveDano=3*danoAtaqueMagico;
            System.out.printf("%s usou a habilidade \"Eletrocinese\"! Causando %d de dano\n", this.nome, saveDano);
            return new ResultadoPoder(saveDano, 0);
        }
        else{
            descansar();
            return new ResultadoPoder(0, 0);
        }

    }
}

