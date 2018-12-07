package guerreiro;

import java.util.Random;
import principal.Conector;
import arma.ArmaIF;
import guerreiro.habilidades.HabilidadeEspIF;

public abstract class Guerreiro {
  
    //Atributos:
    protected int vida=300;//Valor padrao
    protected String nome;
    private int forca;
    private int	agilidade;
    private int inteligencia;
    
    protected int danoBase;
    private int defesa;
    
    protected HabilidadeEspIF comportamentoHabilidade;
    protected int contadorUsoHabilidade = 0;
    
    private ArmaIF arma;
    protected String armaPref;
    
    Conector conector;
    
    public Guerreiro(Conector conector,String nome, int forc, int agil, int intel){
        this.nome = nome;
        this.forca = forc;
        this.agilidade = agil;
        this.inteligencia = intel;
        this.defesa = forca/4;
        this.conector = conector;
    }
    public void atacar(Guerreiro inimigo){
        int dano = this.danoBase;
        double chanceCritico = 0.3*(double)this.inteligencia;
        boolean danoCritico;//Determina se o personagem irar causar dano extra
        
        conector.logMsg("Chance de golpe critico de " + this.nome + ": " + chanceCritico);
        //Cria um objeto para conseguir dados aleat√≥rios
        Random randNum = new Random();
        
        int resultado = randNum.nextInt(100);
        
        if(resultado <= chanceCritico){
            danoCritico = true;
        }
        else{
            danoCritico = false;
        }
        
        conector.battleMsg(this.nome + " atacou " + inimigo.getNome());
        conector.logMsg("Numero sorteado: " + resultado);
        if(danoCritico) {
            dano = dano*2;
            conector.battleMsg(this.nome + " causou dano crÌtico em " + inimigo.getNome() + "!! (-" + dano + ")");
        }
        
        inimigo.receberAtaque(dano);
    }
    
    
    public void setarArma(ArmaIF arma){
    	this.arma = arma;
    	
        if(this.armaPref.equals(arma.getTipo())){
            this.danoBase += arma.getDano();
        }
        else if(arma.getTipo().equals("Neutro")){
            this.danoBase += arma.getDano();
        }
        else{
            this.danoBase += arma.getDano()-6;
        }
    	
    	conector.logMsg(this.nome + " recebeu a arma " + this.arma.getNome());
    	
    }
    
    public void receberAtaque(int danoAtk){
        boolean esquivou = this.tentarEsquivar();
        
        if(esquivou){
            conector.battleMsg("IncrÌvel! " + this.nome + " conseguiu se esquivar do ataque!!");
            conector.battleMsg("Vida restante de  " + this.nome + ": " + this.vida);
        }
        else{
            int dano;
            if(this.defesa > danoAtk)
                dano = 5;
            else
                dano = danoAtk - this.defesa;

            this.vida -= dano;
            
            if(this.vida <= 0){
                conector.battleMsg(this.nome + " Morreu ");
            }
            else{
                conector.battleMsg(this.nome + " recebeu " + dano + " de dano.");
                conector.battleMsg("Vida restante de  " + this.nome + ": " + this.vida);
            }
        }
    }
    
    public void setVida(int vida){
        this.vida = vida;
    }
    public void setDefesa(int defesa){
    	this.defesa = defesa;
    }
    public String getNome(){
        return this.nome;
    }
    public int getVida(){
        return this.vida;
    }
    public int getDano(){
        return this.danoBase;
    }
    public int getDefesa(){
        return this.defesa;
    }
    public int getInteligencia(){
        return this.inteligencia;
    }
    public int getForca(){
        return this.forca;
    }
    public int getAgilidade(){
        return this.agilidade;
    }
    public ArmaIF getArma(){
        return this.arma;
    }
    public void setAgilidade(int nAgilidade){
    	this.agilidade = nAgilidade;
    }
    
    private boolean tentarEsquivar(){
        Random randNum = new Random();
        
        double chanceEsquiva = 0.3*(double)this.agilidade;
        
        int tentativa = randNum.nextInt(100);
        
        if(tentativa <= chanceEsquiva)
            return true;
        else return false;
    }
    
    public void setarComportamentoHabilidadeEsp(HabilidadeEspIF habilidade){
    	this.comportamentoHabilidade = habilidade;
    }
    
    public abstract String getClasse();
    
    public void habilidadeEspec(){
    	if(this.contadorUsoHabilidade < 3){
    		this.comportamentoHabilidade.usar();
    		
    		conector.battleMsg(this.getNome() + " " + comportamentoHabilidade.getMessagem());
    		
    		this.contadorUsoHabilidade++;
    	}
    	else conector.battleMsg(this.getNome() + " n„o pode mais usar habilidade");
    }
}