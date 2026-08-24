package Vilões;

import persoBase.ResultadoPoder;
import persoBase.Personagem;

import java.util.Random;

public class DrViktor extends Personagem {

    Random chance = new Random();

    public DrViktor(String nome) {
        super(nome,"Dr. Viktor");

    }


    @Override //Metodo herdado e polimorfado
    public ResultadoPoder usar_poder() {

        Random chance = new Random();
        int dado = chance.nextInt(1,3);
        if ( dado==2) {
            saveDano=3*danoAtaqueMagico;
            System.out.printf("%s usou \"Choque Vital\"! \n Causando %d de dano\n", nome, saveDano);
            return new ResultadoPoder(saveDano, 0);
        } else if(dado==1) {
            saveDano=5*danoAtaqueMagico;
            System.out.printf("%s usou a habilidade \"Descarga Supersônica\"! Causando %d de dano\n", nome, saveDano);
            return new ResultadoPoder(saveDano, 0);
        }else{
            descansar();
            return new ResultadoPoder(0, 0);
        }
    }
}