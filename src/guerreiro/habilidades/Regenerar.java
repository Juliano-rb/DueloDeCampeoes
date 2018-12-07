package guerreiro.habilidades;

import guerreiro.Guerreiro;

public class Regenerar implements HabilidadeEspIF {
	Guerreiro guerreiroAgir;
	int regenerarQtd = 30;
	
	public Regenerar(Guerreiro guerreiro){
		this.guerreiroAgir = guerreiro;
	}
	
	public String getMessagem(){
		String msg = "Regenerou " + regenerarQtd + " pontos de vida.";
		return msg;
	}
	
	@Override
	public void usar() {
		int vidaAnterior = this.guerreiroAgir.getVida();
		
		this.guerreiroAgir.setVida(vidaAnterior+this.regenerarQtd);
	}
	
}
