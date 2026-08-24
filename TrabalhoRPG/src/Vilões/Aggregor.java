package Vilões;

import persoBase.ResultadoPoder;
import persoBase.Personagem;
import java.util.Random;

public class Aggregor extends Personagem {

    public Aggregor (String nome){
        super(nome,"Agregor");

    }

    @Override
    public ResultadoPoder usar_poder() {
        Random chance = new Random();
        int dado = chance.nextInt(1,3);
        if ( dado == 2 ) { // Se o numero sorteado for maior ou igual a 0.5 ele executara este ataque
            System.out.printf("%s usou \"Lança de energia\"! \n Causando %d de dano\n", this.nome, saveDano);
            saveDano=4*danoAtaqueMagico;
            return new ResultadoPoder(saveDano, 0);
        } else if (dado ==1) {
            System.out.printf("%s usou a habilidade \"Absorção de poderes\"! Causando %d de dano\n", this.nome, saveDano);
            saveDano=3*danoAtaqueMagico;
            return new ResultadoPoder(saveDano, 0);
        }
        else{
            descansar();
            return new ResultadoPoder(0, 0);
        }
    }
}


