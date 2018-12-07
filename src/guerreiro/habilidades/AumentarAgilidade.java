package guerreiro.habilidades;

import guerreiro.Guerreiro;

public class AumentarAgilidade implements HabilidadeEspIF{
	Guerreiro guerreiroAgir;
	double percentAumentar = 0.3;
	
	public AumentarAgilidade(Guerreiro inimigo) {
		this.guerreiroAgir = inimigo;
	}

	@Override
	public void usar() {
		double agilidadeAntiga = this.guerreiroAgir.getAgilidade();
		int qtdAumentar = (int) (agilidadeAntiga*percentAumentar);
		int novaAgilidade = (int) (agilidadeAntiga + qtdAumentar);
		
		this.guerreiroAgir.setAgilidade(novaAgilidade);
	}

	@Override
	public String getMessagem() {
		String msg = "Aumentou sua agilidade em  " + percentAumentar*100 + "%.";
		return msg;
	}

}
