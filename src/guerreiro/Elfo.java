package guerreiro;
import arma.ArmaIF;
import principal.Conector;

public class Elfo extends Guerreiro {
		public Elfo(Conector central,String nome, int forca, int agil, int intel){
			super(central,nome, forca, agil,intel);
	                
	                this.danoBase = (int)(0.3*agil + 0.1*intel + 0.1*forca);
	                this.armaPref = "Leve";
		} 
        
        @Override
        public String getClasse(){
            return "Elfo";
        }
}