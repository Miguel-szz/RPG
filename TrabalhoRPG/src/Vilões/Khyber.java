/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vilões;

import persoBase.ResultadoPoder;
import persoBase.Personagem;

import java.util.Random;

public class Khyber extends Personagem {
    
    public Khyber (String nome){
        super(nome,"Khyber");

    }
    
    @Override //Metodo herdado e polimorfado
    public ResultadoPoder usar_poder() {

        Random chance = new Random();
        int dado = chance.nextInt(1,3);

        if ( dado ==2) {
            saveDano=4*danoAtaqueMagico;
            System.out.printf("%s Khyber \"Chamou seu cao \"! \n C(%d de dano)\n", nome, saveDano);
            return new ResultadoPoder(saveDano, 0);
        } else if(dado==1) {
            saveDano=3*danoAtaqueMagico;
            System.out.printf("%s usou sua \"Espada \"! C(%d de dano)\n", nome, saveDano);
            return new ResultadoPoder(saveDano, 0);
        }else{
            descansar();
            return new ResultadoPoder(0, 0);
        }
    }
}

