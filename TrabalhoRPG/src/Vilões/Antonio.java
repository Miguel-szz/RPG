package Vilões;

import persoBase.ResultadoPoder;
import persoBase.Personagem;

import java.util.Random;

public class Antonio extends Personagem {

    public Antonio(String nome){
        super(nome,"Antônio");
    }

    @Override
    public ResultadoPoder usar_poder() {

        Random chance = new Random();
        int dado = chance.nextInt(1,3);

        if ( dado==1) {
            saveDano=4*danoAtaqueMagico;
            System.out.printf("\n%s usou \"Ataque de pedregulho\"!(%d de dano)\n", nome, saveDano);
            return new ResultadoPoder(saveDano, 0);
        } else if(dado==2){
            saveDano=3*danoAtaqueMagico;
            System.out.printf("\n%s usou a habilidade \"sessão de socos\"!(%d de dano)\n", nome, saveDano);
            return new ResultadoPoder(saveDano, 0);
        }
        else{
            descansar();
            return new ResultadoPoder(0, 0);
        }
    }
    
}