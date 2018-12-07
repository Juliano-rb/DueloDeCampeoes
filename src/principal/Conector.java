/*
 * Esta classe funciona como um tipo de intermediario entre os objetos do jogo e 
 * a interface. Também pode ser usada para criar logs
 */
package principal;
import principal.GUI.*;
import arma.ArmaIF;
import guerreiro.Guerreiro;
import javax.swing.JOptionPane;
/**
 *
 * @author Juliano
 */
public class Conector {
    boolean showLogs;
    boolean modoTexto;
    
    
    MainWindow outScreen;
    Batalha batalha;
    
    public Conector(boolean textMode, boolean showLogs){
        this.showLogs = showLogs;
        this.modoTexto = textMode;
    }
    
     public void setShowLogs(boolean show){
        this.showLogs = show;
    }
     
    public void logMsg(String text){
        if(showLogs)
            if(this.modoTexto == true){
                System.out.println("LOG: " + text);
            }
            else{
                System.out.println("LOG: " + text);
            }
    }
    
    public void battleMsg(String text){
        if(this.modoTexto == true){
            System.out.println("BATALHA: " + text);
        }
        else{
            this.outScreen.addText(text);
        }
    }
    public void errorMsg(String erro){
        if(this.modoTexto == true){
            System.out.println("ERRO: " + erro);
        }
        else{
            //TO DO:
        }
    }
    
    
    //Setar a janela de saida das mensagens(GUI)
    public void setOutGUI(MainWindow outTela){
       this.outScreen = outTela;
    }
    
    public void ihcOut(String text){
        if(this.modoTexto = true){
            System.out.println("MENSAGEM: " + text);
        }
        else{
                
        }
    }
    
    /*Cria uma nova batalha
    * Depois serao adicionados os guerreiros e os equipamentos serao dados
    */
    public void creatBattle(){
        this.batalha = new Batalha(this);
    }
    
    public void iniciarBatalha(){
        this.batalha.iniciarBatalha();
    }
    public void fimBatalha(Guerreiro vencedor){
        this.battleMsg("Fim da batalha! O vencedor foi " + vencedor.getNome() + ".");
        JOptionPane.showMessageDialog(null, "Fim da batalha! O vencedor foi " + vencedor.getNome() + ".");
        this.batalha = null;
        this.outScreen.restart();
    }
    public void reportarVida(int player, int vida){
        this.outScreen.sendReport(player, vida);
    }
    public Guerreiro getGuerreiro(int player){
        return this.batalha.getGuerreiro(player);
    }
    //
    public int addGuerreiro(Guerreiro guerreiro){
        int qtdGuerreiros = this.batalha.adicionarGuerreiro(guerreiro);
        return qtdGuerreiros;
    }
    
    public void darArma(int player, ArmaIF arma){
        batalha.entregarArma(player, arma);
    }
    
    public void ataque(){
        this.batalha.atacar();
        
    }
    
    public void resetar(){
        this.batalha = null;
    }
    
    public void sendUseHability(){
        this.batalha.usarHabilidadeEspecial();
    }
    
}
