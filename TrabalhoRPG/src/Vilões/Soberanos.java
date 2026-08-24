package Vilões;

import persoBase.ResultadoPoder;
import persoBase.Personagem;

import java.util.Random;

public class Soberanos extends Personagem {

    Random chance = new Random();

    public Soberanos(String nome) {
        super(nome,"Soberanos");
    }

    @Override //Metodo herdado e polimorfado
    public ResultadoPoder usar_poder() {
        Random chance = new Random();
        int dado = chance.nextInt(1,3);
        if (dado==2) {
            System.out.printf("%s usou \"Choque Vital\"! \n Causando %d de dano\n", nome, saveDano);
            saveDano=4*danoAtaqueMagico;
            return new ResultadoPoder(saveDano, 0);
        } else if(dado==1) {
            System.out.printf("%s usou a habilidade \"Descarga Supersônica\"! Causando %d de dano\n", nome, saveDano);
            saveDano=3*danoAtaqueMagico;
            return new ResultadoPoder(saveDano, 0);
        }else{
            descansar();
            return new ResultadoPoder(0, 0);
        }
    }
}