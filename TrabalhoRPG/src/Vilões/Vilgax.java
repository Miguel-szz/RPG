package Vilões;
import persoBase.ResultadoPoder;
import persoBase.Personagem;

import java.util.Random;

public class Vilgax extends Personagem{

    public Vilgax(String nome){
        super(nome, "Vilgax");

    }

    @Override
    public ResultadoPoder usar_poder(){
        Random chance = new Random();
        int dado = chance.nextInt(1,4);

        if ( dado==1) {
            saveDano=7*danoAtaqueMagico;
            System.out.printf("\n%s usou \"Raios laser vermelhos\"!(%d de dano)\n", nome, saveDano);
            return new ResultadoPoder(saveDano, 0);
        } else if(dado==2){
            saveDano=6*danoAtaqueMagico;
            System.out.printf("\n%s usou a habilidade \"Sopro Ciclone\"!(%d de dano)\n", nome, saveDano);
            return new ResultadoPoder(saveDano, 0);
        } else if(dado==3) {
            saveDano=5*danoAtaqueMagico;
            System.out.printf("\n%s usou a habilidade \"Espada de Energia\"!(%d de dano)\n", nome, saveDano);
            return new ResultadoPoder(saveDano, 0);
        }else{
            descansar();
            return new ResultadoPoder(0, 0);
        }
    }

}
