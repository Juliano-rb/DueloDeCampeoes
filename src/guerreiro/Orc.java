package guerreiro;

import arma.ArmaIF;
import principal.Conector;

public class Orc extends Guerreiro {
	public Orc(Conector conector,String nome, int forca, int agil, int intel){
		super(conector, nome, forca,agil,intel);
                
                this.danoBase = (int)(0.3*forca + 0.1*agil + 0.1*intel);
                this.armaPref = "Pesada";
	}
        
        @Override
        public String getClasse(){
            return "Orc";
        }
}
