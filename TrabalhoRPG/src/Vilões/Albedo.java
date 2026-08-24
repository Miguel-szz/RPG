
package Vilões;
import persoBase.ResultadoPoder;
import persoBase.Personagem;
import java.util.Random;

public class Albedo extends Personagem {
    
    Random chance = new Random();
    
    public Albedo(String nome){
        super(nome,"Albedo");

    }
    @Override //Metodo herdado e polimorfado
    public ResultadoPoder usar_poder() {

        Random chance = new Random();
        int dado = chance.nextInt(1,3);

        if ( dado == 2) {
            saveDano=4*danoAtaqueMagico;
            System.out.printf("%s usou \"Disparos de Energia\"! \n C(%d de dano)\n", nome, saveDano);
            return new ResultadoPoder(saveDano, 0);
        } else if(dado ==1) {
            saveDano=3*danoAtaqueMagico;
            System.out.printf("%s usou a habilidade \"Ondas de Pulso de Energia\"! C(%d de dano)\n", nome, saveDano);
            return new ResultadoPoder(saveDano, 0);
        }else{
            descansar();
            return new ResultadoPoder(0, 0);
        }
    }
}

