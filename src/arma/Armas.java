package arma;

public abstract class Armas implements ArmaIF {
	protected String nome;
	protected int danoArma;
	protected String tipoArma;
	
	//protected int danoBonus;

	public Armas(String nome, int dano, String tipo){
		this.nome = nome;
		this.danoArma = dano;
		//this.danoBonus = danoBonus;
		this.tipoArma = tipo;
	}
	
        @Override
	public String getNome(){
		return this.nome;
	}
        @Override
	public int getDano(){
		return this.danoArma;
	}
        @Override
        public String getTipo(){
            return this.tipoArma;
        }
}
