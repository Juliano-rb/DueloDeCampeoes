/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import guerreiro.Guerreiro;
import arma.ArmaIF;
/**
 *
 * @author Juliano
 */
public class Batalha {
    //Composicao, uma Batalha cont√©m guerreiros
    private Guerreiro guerreiro1;
    private Guerreiro guerreiro2;
    private int turno=0;
    int vezDeJogador=1;
    Conector conector;
    
    public Batalha(Conector conector){
        this.conector = conector;
        conector.logMsg("Nova batalha criada! adicione agora guerreiros para comecar");
    }
    
    public void iniciarBatalha(){
        if( (guerreiro1 == null) || guerreiro2 == null){
            conector.errorMsg("N„o existem guerreiros suficientes para iniciar a batalha.");
        }
        else{
            //TO DO
        }
    }
    public void atacar(){
        conector.battleMsg("Turno " + turno + "\n");
        if(this.vezDeJogador == 1){
            guerreiro1.atacar(guerreiro2);
            conector.reportarVida(2, guerreiro2.getVida());
            this.vezDeJogador = 2;
            if(guerreiro2.getVida()<=0){
                this.finalizarBatalha(guerreiro1);
            }
        }
        else if(this.vezDeJogador == 2){
            guerreiro2.atacar(guerreiro1);
            conector.reportarVida(1, guerreiro1.getVida());
            this.vezDeJogador = 1;
            if(guerreiro1.getVida()<=0){
                this.finalizarBatalha(guerreiro2);
            }
        }
        this.turno++;

    }
    public void finalizarBatalha(Guerreiro vencedor){
        conector.fimBatalha(vencedor);
    }
    
    //Adiciona um guerreiro √† batalha...
    public int adicionarGuerreiro(Guerreiro guerreiro){
        if(guerreiro1 == null){
            this.guerreiro1 = guerreiro;
            conector.logMsg(guerreiro.getNome() + " da classe " + guerreiro.getClasse() + " colocado no slot do jogador 1");
            return 1;//Retorna a quantidade de guerreiros na batalha;
        }
        else if( guerreiro2 == null ){
            this.guerreiro2 = guerreiro;
            conector.logMsg(guerreiro.getNome() + " da classe " + guerreiro.getClasse() + " colocado no slot do jogador 2");
            return 2;
        }
        else {
            conector.logMsg("Sem mais espaÁos livres nos slots de batalha para o "
                    + "guerreiro " + guerreiro.getNome());
            return 2;
        }
    }
    //Seta a arma de algum guerreiro
    public void entregarArma(int player, ArmaIF arma){
        if(player == 1){
            this.guerreiro1.setarArma(arma);
        }
        else if(player == 2){
            this.guerreiro2.setarArma(arma);
        }
        else{
            conector.errorMsg("Algo deu errado ao entregar arma, jogador " + player + " n„o existe.");
        }
    }
    public Guerreiro getGuerreiro(int player){
        if(player == 1){
            return this.guerreiro1;
        }
        else if(player == 2){
            return this.guerreiro2;
        }
        return null;
    }
    
    public void usarHabilidadeEspecial(){
        if(this.vezDeJogador == 1){
            this.guerreiro1.habilidadeEspec();
            conector.reportarVida(1, guerreiro1.getVida());
        }
        else if(this.vezDeJogador == 2){
            this.guerreiro2.habilidadeEspec();
            conector.reportarVida(2, guerreiro2.getVida());
        }
    }
}
