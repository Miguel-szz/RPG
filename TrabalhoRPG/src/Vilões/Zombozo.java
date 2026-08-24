package Vilões;

import persoBase.ResultadoPoder;
import persoBase.Personagem;

import java.util.Random;

public class Zombozo extends Personagem {

    public Zombozo(String nome){
        super(nome,"Zombozo");
    }

    @Override
    public ResultadoPoder usar_poder() {

        Random chance = new Random();
        int dado = chance.nextInt(1,3);

        if ( dado==1) {
            saveDano=3*danoAtaqueMagico;
            System.out.printf("%s usou \"Aperto de mão elétrico\"! \n (%d de dano)\n", nome, saveDano);
            return new ResultadoPoder(saveDano, 0);

        } else if(dado==2){
            saveDano=4*danoAtaqueMagico;
            System.out.printf("%s usou a habilidade \"gás do riso\"! (%d de dano)\n", nome, saveDano);
            return new ResultadoPoder(saveDano, 0);

        }else{
            descansar();
            return new ResultadoPoder(0, 0);
        }
    }
}