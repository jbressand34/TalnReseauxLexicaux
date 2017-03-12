import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class Deriveur {

	public static ArrayList<String> deriver(String formeFlechie){
		ArrayList<String> formesDerives = new ArrayList<String>();
		
		String lemme = Lemmatiseur.lemmatiser(formeFlechie);
		String tag = TagPosing.tagger(formeFlechie);
		
		if(lemme==null || tag==null){
			return null;
		}
		
		String nomFichier = tag+".txt";
		
		try{
			BufferedReader bf = new BufferedReader(new FileReader(nomFichier));
			String line = null;
			
			while((line=bf.readLine())!= null){
				String suff = line.split(" ")[0];
				String suffDeriv = line.split(" ")[1];
				
				if(lemme.endsWith(suff)){
					String motDerive = lemme.substring(0, lemme.length()-suff.length())+suffDeriv;
					formesDerives.add(motDerive);
				}
			}
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
		
		return formesDerives;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String formeFlechie = "faisons";
        
        System.out.println(Deriveur.deriver(formeFlechie));
	}

}
