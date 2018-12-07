package guerreiro;
import arma.ArmaIF;
import principal.Conector;

public class Mago extends Guerreiro{
	public Mago(Conector conector,String nome, int forca, int agil, int intel){
		super(conector, nome, forca,agil,intel);
                
                this.danoBase = (int)(0.3*intel + 0.1*agil + 0.1*forca);
                this.armaPref = "Magica";
		}
        
        @Override
        public String getClasse(){
            return "Mago";
        }

}