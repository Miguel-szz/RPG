package persoBase;

import java.util.Random;
import java.util.Scanner;

public abstract class Personagem {
    Scanner leitor = new Scanner(System.in);
    Random gerador = new Random();

    protected String nome;
    protected int level;
    protected int vida;
    protected int saveVida;
    protected int stamina;
    protected int saveStamina;
    protected int danoAtaqueBasico;
    protected int danoAtaqueMagico;
    protected int defesa;
    protected int exp;
    protected boolean proximoAtaqueBuffado;
    protected boolean proximaDefesaBuffado;
    protected boolean desviou;
    protected int saveDano;
    protected String classe;

    public Personagem(String nome, String classe) {
        this.nome = nome;
        this.classe = classe;
        level = 0;
        exp = 0;
        proximoAtaqueBuffado = false;
        proximaDefesaBuffado = false;
        desviou = false;

        // Definição de atributos fixos por classe
        switch (classe.toLowerCase()) {
            case "enormossauro":
            case "quatro braços":
            case "diamante":
                vida = 140;
                stamina = 90;
                defesa = 14;
                danoAtaqueBasico = 8;
                danoAtaqueMagico = 8;
                break;

            case "fogo fátuo":
            case "bola de canhão":
            case "atômico":
                vida = 100;
                stamina = 100;
                defesa = 7;
                danoAtaqueBasico = 10;
                danoAtaqueMagico = 12;
                break;

            case "xlr8":
            case "anfíbio":
            case "feedback":
            case "ameaça aquática":
                vida = 85;
                stamina = 120;
                defesa = 6;
                danoAtaqueBasico = 7;
                danoAtaqueMagico = 10;
                break;

            // VILÕES — garantir também stamina e defesa para eles
            case "antonio":
                vida = 120;
                defesa = 8;
                danoAtaqueBasico = 8;
                danoAtaqueMagico = 9;
                break;

            case "zombozo":
                vida = 160;
                defesa = 9;
                danoAtaqueBasico = 9;
                danoAtaqueMagico = 11;
                break;

            case "dr.animal":
                vida = 200;
                defesa = 10;
                danoAtaqueBasico = 12;
                danoAtaqueMagico = 9;
                break;

            case "dr.viktor":
                vida = 230;
                defesa = 11;
                danoAtaqueBasico = 11;
                danoAtaqueMagico = 12;
                break;

            case "kevin levin":
                vida = 260;
                defesa = 12;
                danoAtaqueBasico = 13;
                danoAtaqueMagico = 10;
                break;

            case "soberanos":
                vida = 300;
                defesa = 13;
                danoAtaqueBasico = 10;
                danoAtaqueMagico = 14;
                break;

            case "khyber":
                vida = 340;
                defesa = 12;
                danoAtaqueBasico = 12;
                danoAtaqueMagico = 13;
                break;

            case "albedo":
                vida = 400;
                defesa = 14;
                danoAtaqueBasico = 14;
                danoAtaqueMagico = 14;
                break;

            case "aggregor":
                vida = 480;
                defesa = 15;
                danoAtaqueBasico = 13;
                danoAtaqueMagico = 16;
                break;

            case "vilgax":
                vida = 600;
                defesa = 16;
                danoAtaqueBasico = 16;
                danoAtaqueMagico = 18;
                break;

            default:
                vida = 100;
                stamina = 100;
                defesa = 8;
                danoAtaqueBasico = 10;
                danoAtaqueMagico = 10;
        }

        saveVida = vida;
        saveStamina = stamina;
    }

    // atacar sem modificar atributo base
    public int atacar() {
        int dano = danoAtaqueBasico;
        if (proximoAtaqueBuffado) {
            dano = (int) Math.round(dano * 1.25);
            proximoAtaqueBuffado = false;
            System.out.println("Ataque buffado! +25% de dano.");
        }
        System.out.printf("%s golpeou o inimigo (%d de dano)\n", nome, dano);
        return dano;
    }

    // defender: retorna o valor final que será aplicado ao dano recebido (pode aplicar redução por defesa)
    public int defender(int danoTomado) {
        System.out.printf("\nO personagem escolheu defender o ataque de %d de dano (Defesa: %d)\n", danoTomado, defesa);
        return danoTomado-defesa;
    }

    public void receberDano(int danoTomado, Personagem personagemAtacado) {
        // aplicar buff de defesa se ativo
        if (proximaDefesaBuffado) {
            danoTomado = (int) Math.round(danoTomado * 0.8);
            proximaDefesaBuffado = false;
            System.out.println("Escudo mágico reduziu o dano em 20%!");
        }
        int danoFinal = danoTomado;
        if (danoFinal < 0) danoFinal = 0;
        personagemAtacado.vida -= danoFinal;
        System.out.printf("%s sofreu um ataque recebendo %d de dano\n", nome, danoFinal);
        // garantir que vida não fique abaixo de zero
        if (personagemAtacado.vida < 0) personagemAtacado.vida = 0;
    }

    // forçar que subclasses implementem habilidades
    public abstract ResultadoPoder usar_poder();

    // retorna true se conseguiu gastar a stamina, false se sem stamina suficiente
    public boolean staminaUsar(int custo) {
        if (custo <= 0) return true; // custo zero ou negativo = liberado
        if (stamina >= custo) {
            stamina -= custo;
            return true;
        } else {
            System.out.printf("%s tentou usar uma habilidade que custa %d de stamina, mas tem apenas %d stamina!\n", nome, custo, stamina);
            return false;
        }
    }

    public void descansar() {
        double regenVidaPct = gerador.nextDouble(0.10, 0.21);   // 10% a 20% da vida máxima
        double regenStaminaPct = gerador.nextDouble(0.15, 0.31); // 15% a 30% da stamina máxima

        int vidaRecuperada = (int) (saveVida * regenVidaPct);
        int staminaRecuperada = (int) (saveStamina * regenStaminaPct);

        vida = Math.min(saveVida, vida + vidaRecuperada);
        stamina = Math.min(saveStamina, stamina + staminaRecuperada);

        System.out.printf("%s descansou e recuperou +%d de vida e +%d de stamina!\n", nome, vidaRecuperada, staminaRecuperada);
    }

    public int expParaProximoNivel() {
        return Math.max(1, level) * 75; // evita 0
    }

    public boolean ganhar_exp(int exp) {
        this.exp += exp;
        if (this.exp >= expParaProximoNivel()) {
            this.exp -= expParaProximoNivel();
            this.level += 1;
            System.out.printf("Subiu para o nível %d!\n", level);
            uparNivel();
            return true;
        } else return false;
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public int esquivaEContraAtaca() {
        double chance = Math.random();
        if (chance <= 0.5) {
            System.out.println(nome + " esquivou e contra-atacou!");
            saveDano = 5 * danoAtaqueMagico;
            this.desviou = true;
            return saveDano;
        } else {
            System.out.println(nome + " tentou esquivar, mas não conseguiu!");
            this.desviou = false;
            return 0;
        }
    }

    public void exibir_detalhes() {
        System.out.printf("Nome do Jogador: %s (Classe: %s)\nNível/Level: %d\nVida: %d/%d\nStamina: %d/%d\nExp: %d\n",
                nome, classe, level, vida, saveVida, stamina, saveStamina, exp);
    }

    public void buffarAtaque() {
        proximoAtaqueBuffado = true;
        System.out.printf("%s concentrando energia! Próximo ataque será mais forte.\n", nome);
    }

    public void buffarDefesa() {
        proximaDefesaBuffado = true;
        System.out.printf("%s ergueu uma postura defensiva! Próximo ataque recebido será reduzido.\n", nome);
    }
    public void restaurarEnergia() {
        this.stamina = saveStamina;
        System.out.printf("%s restaurou toda a stamina!\n", nome);
    }

    public void uparNivel() {
        // Escalamento básico — ajuste como quiser
        int ganhoVida = (int) (saveVida * 0.15);       // +10% de vida máxima
        int ganhoStamina = (int) (saveStamina * 0.15); // +10% de stamina máxima
        int ganhoDanoBasico = (int) (danoAtaqueBasico * 0.15);
        int ganhoDanoMagico = (int) (danoAtaqueMagico * 0.15);
        int ganhoDefesa = (int) (defesa * 0.05);       // +5% de defesa

        saveVida += ganhoVida;
        saveStamina += ganhoStamina;
        danoAtaqueBasico += ganhoDanoBasico;
        danoAtaqueMagico += ganhoDanoMagico;
        defesa += ganhoDefesa;

        // ao subir de nível, recupere vida e stamina
        vida = saveVida;
        stamina = saveStamina;

        System.out.printf("""
            \n🎉 %s subiu para o nível %d!
            +%d de Vida Máxima
            +%d de Stamina Máxima
            +%d de Dano Físico
            +%d de Dano Mágico
            +%d de Defesa
            Vida e Stamina totalmente restauradas!
            """, nome, level, ganhoVida, ganhoStamina, ganhoDanoBasico, ganhoDanoMagico, ganhoDefesa);
    }

    public String getNome() { return nome; }
    public int getVida() { return vida; }
    public int getStamina() { return stamina; }
    public String getClasse() { return classe; }
    public boolean getDesviou() {
        boolean tmp = desviou;
        desviou = false; // reset automático depois de lido para evitar travar turnos
        return tmp;
    }
}
