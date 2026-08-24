import persoBase.Transformador;
import persoBase.ResultadoPoder;
import Vilões.*;
import persoBase.Personagem;

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        System.out.println("==================================BEM VINDO AO RPG TEMÁTICO DE BEN 10==================================\nALIENS COM DNA NO OMNITRIX:\n(1)XlR8\n(2)Diamante\n(3)Enormossauro\n(4)Fogo Fátuo\n(5)Anfíbio\n(6)Ameaça Aquática\n(7)Feedback\n(8)Atômico\n(9)Quatro Braços\n(10)Bola De Canhão\nPara iniciar o jogo escolha um personagem:");
        int escolhaPersonagem = 0;
        String NomeUsuario="";
        while (escolhaPersonagem != 1 && escolhaPersonagem != 2 && escolhaPersonagem != 3 && escolhaPersonagem != 4 && escolhaPersonagem != 5 && escolhaPersonagem != 6 && escolhaPersonagem != 7 && escolhaPersonagem != 8 &&  escolhaPersonagem != 9 && escolhaPersonagem!=10) {
            escolhaPersonagem = leitor.nextInt();
            if (escolhaPersonagem>10 || escolhaPersonagem<1) {
                System.out.println("Personagem inválido");
                break;
            }
            System.out.println("Digite o nome de usuário: ");
            leitor.nextLine(); // limpar o buffer
            NomeUsuario = leitor.nextLine();

        }

        Personagem jogador = Transformador.transformar(NomeUsuario, escolhaPersonagem);
        int opcao=0;

        Personagem[] viloes={
            new Antonio("Antônio"),
            new Zombozo("Zomboso"),
            new DrAnimal("Dr.Animal"),
            new DrViktor("Dr.Viktor"),
            new KevinLevin("Kevin Levin"),
            new Soberanos("Soberanos"),
            new Khyber("Khyber"),
            new Albedo("Albedo"),
            new Aggregor("Aggregor"),
            new Vilgax("Vilgax")};
        int indiceVilao = 0;
        while (opcao != 4 && jogador.estaVivo()) {
            System.out.println("\n\n\n============================================ MENU =================================================\n1 - Lutar contra vilão\n2 - Ver status\n3 - Transformar em outro alien\n4 - Sair do jogo\nEscolha: ");
            opcao = leitor.nextInt();
            System.out.println("=============================================================================================\n");
            switch (opcao) {
                case 1:
                    Personagem vilaoAtual = viloes[indiceVilao];
                    System.out.printf("\nVocê enfrentará %s!\n",vilaoAtual.getNome());
                    System.out.println("\n==================================================================================================\n\n");
                    // loop da batalha
                    System.out.println("COMEÇAR BATALHA!\n");
                    while (jogador.estaVivo() && vilaoAtual.estaVivo()) {
                        System.out.println("\n**********************ROUND DO JOGADOR**********************\nSua vez! Escolha: 1-Atacar | 2-Usar magia | 3-Descansar | 4-Defender");
                        int acao = leitor.nextInt();
                        System.out.println();
                        boolean verifDefender=false;
                        switch (acao) {
                            case 1:
                               vilaoAtual.receberDano(jogador.atacar(),vilaoAtual);
                               break;
                            case 2:
                                ResultadoPoder resultado = jogador.usar_poder();
                                if (!jogador.staminaUsar(resultado.custoStamina))
                                    break;
                                vilaoAtual.receberDano( resultado.dano, vilaoAtual );
                                break;
                            case 3:
                                jogador.descansar();
                                break;
                            case 4:
                                verifDefender=true;
                                break;
                            default:
                                System.out.println("Ação inválida, perdeu a vez!");
                        }
                        System.out.println();
                        // turno do vilão (só age se ainda estiver vivo)
                        if (vilaoAtual.estaVivo() && jogador.getDesviou()==false) {
                            System.out.println("**********************ROUND DO VILÃO**********************");
                            Random chance = new Random();
                            int dado = chance.nextInt(1,4);
                            System.out.println("");
                            if (dado==1) {
                                if(verifDefender) {
                                    jogador.receberDano(jogador.defender(vilaoAtual.atacar()), jogador);
                                }else
                                    jogador.receberDano(vilaoAtual.atacar(),jogador);
                            }else if(dado==2) {
                                    if(verifDefender) {
                                        ResultadoPoder resultado = vilaoAtual.usar_poder();
                                        jogador.receberDano(jogador.defender(resultado.dano) /*-> Retorna o valor da defesa do jogador*/, jogador);/*-> Retorna o valor que o jogador ira receber de dano*/
                                    }
                                    else {
                                        ResultadoPoder resultado = vilaoAtual.usar_poder();
                                        jogador.receberDano(resultado.dano, jogador);
                                    }
                            }else if(dado==3) {
                                    vilaoAtual.descansar();
                            }else{
                                break;
                            }
                            System.out.printf("\n==================================STATUS JOGADOR==================================\nNome: %s\nVida: %d\nStamina: %d", jogador.getNome(),jogador.getVida(),jogador.getStamina());
                            System.out.printf("\n==================================STATUS VILÃO====================================\nNome: %s\nVida: %d\n", vilaoAtual.getNome(),vilaoAtual.getVida());
                        }

                        System.out.println("\n=============================================================================================\n\n");
                    }
                    if (jogador.estaVivo()) {
                        System.out.println("\n" + vilaoAtual.getNome() + " foi derrotado!");
                        jogador.ganhar_exp(50*(indiceVilao+1)); // recompensa
                        jogador.restaurarEnergia();
                        indiceVilao++;

                        if (indiceVilao >= viloes.length) { //  Verifica se todos os vilões foram derrotados
                        System.out.println("\n=====================================");
                        System.out.println("🌟 VITÓRIA SUPREMA! 🌟");
                        System.out.printf("%s derrotou todos os vilões do universo!\n", jogador.getNome());
                        System.out.println("O Omnitrix brilha intensamente — Você salvou o mundo mais uma vez!");
                        System.out.println("=====================================\n");
                        System.out.println("🏁 Fim de jogo. Parabéns, herói!");
                        break; // encerra o loop principal
                    }
                        System.out.printf("\nNova quantidade de xp para subir pro próximo nível: %d",jogador.expParaProximoNivel());
                        break;
                    } else {
                        System.out.println("\nVocê foi derrotado...");
                        break;
                    }

                case 2:
                    jogador.exibir_detalhes();
                    break;
                case 3:
                    System.out.println("Deseja se transformar em qual alien?");
                    int novaEscolha = leitor.nextInt();
                    jogador = Transformador.transformar(NomeUsuario, novaEscolha);
                    System.out.println("Transformado com sucesso!");
                    break;
                case 4:
                    System.out.println("Saindo do jogo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

            if (!jogador.estaVivo()) {
                System.out.println("Game Over! Seu personagem foi derrotado.");
            }
        }
    }
}
