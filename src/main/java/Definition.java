import RequeterRezo.Annotation;
import RequeterRezo.Mot;
import RequeterRezo.RequeterRezo;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class Definition {

	public RequeterRezo systeme;
	
	public Definition(){
		this.systeme = new RequeterRezo("36h",3000);
	}
	
	public String getDefinition(String mot) throws MalformedURLException, IOException, InterruptedException{
		Mot definition = this.systeme.requete(mot, true);
		if(definition == null){
			return null;
		}
		else{
			return definition.getDefinition();
		}
	}
	
	public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException{
		Definition def = new Definition();
		
		String mot = "construction";
		
		String strDef = def.getDefinition(mot);
		
		if(strDef == null){
			System.out.println("Le mot "+mot+" n'a pas de définition.");
		}
		else {
			System.out.println("Le mot "+mot+" a la définition suivante : "+strDef);
		}
	}
}
