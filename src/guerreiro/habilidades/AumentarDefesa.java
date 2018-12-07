package guerreiro.habilidades;

import guerreiro.Guerreiro;

public class AumentarDefesa implements HabilidadeEspIF {
	Guerreiro guerreiroAgir;
	double perctAumentar = 0.3;
	
	public AumentarDefesa(Guerreiro guerreiro){
		this.guerreiroAgir = guerreiro;
	}
	
        @Override
	public String getMessagem(){
		String msg = "Aumentou sua defesa em  " + perctAumentar*100 + "%.";
		return msg;
	}
	
	@Override
	public void usar() {
		double defesaAnterior = this.guerreiroAgir.getDefesa();
		double quantidadeDeAumento = (int)(defesaAnterior*this.perctAumentar);
		
		int novaDefesa = (int)(defesaAnterior + quantidadeDeAumento);
		
		this.guerreiroAgir.setDefesa(novaDefesa);
	}

}
