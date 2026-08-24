package Herois;

import persoBase.Personagem;
import persoBase.ResultadoPoder;

import java.util.Scanner;
        public class Xlr8 extends Personagem {
            Scanner leitor = new Scanner(System.in);

            public Xlr8(String nome) {
                super(nome,"XLR8");
            }


            @Override //Metodo herdado e polimorfado
            public ResultadoPoder usar_poder() {
                System.out.println("""
Escolha a habilidade:
(1) Esquivar e Contra Atacar - Custo: 40 stamina
(2) Soco Veloz - Custo: 15 stamina
(3) Investida Super Rápida - Custo: 25 stamina
""");
                int hab = leitor.nextInt();//Leitor de habilidade
                int dano = 0;

                switch (hab) {// Se hab for igual a 1, executa esse ataque
                    case 1:
                        if (stamina>=40){// Custo de stamina do ataque é 40
                            return new ResultadoPoder(esquivaEContraAtaca(), 40);}
                        break;
                    case 2:
                        if (stamina>=15) {
                            saveDano = (int) (4 * danoAtaqueMagico + level * 3);
                            System.out.printf("%s usou a habilidade \"Soco rápido\"! \n", nome);
                            return new ResultadoPoder(saveDano, 15);
                        }break;
                    case 3:
                        if (stamina>=25) {
                            saveDano = (int) (5 * danoAtaqueMagico + level * 4);
                            System.out.printf("%s usou a habilidade \"Investida super rápida\"! \n", nome);
                            return new ResultadoPoder(saveDano, 25);
                        }break;
                    default:
                        System.out.println("Comando inválido! O turno foi desperdiçado.");
                        break;
                }

                System.out.println(nome + " está sem stamina suficiente e não conseguiu usar a habilidade!");
                return new ResultadoPoder(0, 0);
            }
        }