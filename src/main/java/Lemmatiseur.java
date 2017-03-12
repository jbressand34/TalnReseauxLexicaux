import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class Lemmatiseur {

	public static String lemmatiser(String formeFlechie){
		String nomFichier = "mots_"+formeFlechie.toLowerCase().charAt(0)+".txt";
		//System.out.println("Nom fichier : "+nomFichier);
		//System.out.println("Forme fléchie : "+formeFlechie);
		String lemme = null;
		
		try{
			BufferedReader bf = new BufferedReader(new FileReader(nomFichier));
			Boolean trouve = false;
			String line = null;
			while((line=bf.readLine()) != null && !trouve){
				String[] tokens = line.split("	");
				ArrayList<String> tokensPretraites = new ArrayList<String>();
				
				for(String str : tokens){
					String[] tokens2 = str.split(" ");
					for(String str2 : tokens2){
						if(!str2.equals(" ") && str2!=null && !str2.equals("")){
							tokensPretraites.add(str2);
						}
					}
				}
				
				if(tokensPretraites.get(0).equals(formeFlechie.toLowerCase())){
					trouve = true;
					//System.out.println("Trouve : "+tokensPretraites.toString());
					lemme = tokensPretraites.get(1);
				}
				//else{
					//System.out.println("Pas trouvé : "+tokensPretraites.toString());
					//System.out.println(tokensPretraites.get(0)+" est différent de "+formeFlechie);
				//}
			}
			bf.close();
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
		return lemme;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String formeFlechie = "purent";
		
		System.out.println(Lemmatiseur.lemmatiser(formeFlechie));
	}

}
