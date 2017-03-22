
import RequeterRezo.Annotation;
import RequeterRezo.Mot;
import RequeterRezo.RequeterRezo;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

/**
 *
 * @author Jimmy Benoits
 */
public class Example {

    public static void main(String[] args) throws IOException, MalformedURLException, InterruptedException {
        //Initialisation du système
        //Le premier paramètre donne le délais de péremption : le temps avant qu'un fichier du cache soit considéré comme obsolète
        //Le second est la taille du cache (en nombre d'entrées)
        RequeterRezo systeme = new RequeterRezo("36h", 3000);

        //La méthode "requete" permet d'interroger rezoJDM ou le cache si le terme est présent
        Mot mot = systeme.requete("chat");

        //Il est alors possible de manipuler le mot directement
        if(mot==null){
        	System.out.println("Mot null");
        }
        else {
        	System.out.println(mot.getDefinition());
        }
        /*Ou de l'enregistrer dans un fichier
        //File monFichier = new File("chat.txt");
        Mot.ecrire(mot, monFichier);
        //Un mot enregistrer peut alors être lu et chargé
        Mot chat = Mot.lire("chat.txt");

        //Attention cependant, si le terme demandé n'est pas présent dans le réseau, null est retourné
        if ((mot = systeme.requete("azetbzgdjshsmdf")) != null) {
            System.out.println(mot.getDefinition());
        } else {
            System.out.println("\"azetbzgdjshsmdf\" n'existe pas !");
        }

        //Il est possible de forcer la mise en cache d'un terme (true) ou de l'empêcher (false). 
        //Si rien n'est précisé, le système prend la décision de lui-même.
        Mot gencive = systeme.requete("gencive", true);

        //"gencive" est un terme qui possède plusieurs annotations.
        //Lors de la requête, ces informations sont stockées dans des objets Annotations.
        ArrayList<Annotation> annotations = gencive.getAnnotations();
        System.out.println("Une annotation ressemble à : " + annotations.get(0).toString());
        //Une annotation dans rezoJDM est aussi une entrée. On peut y avoir accès et la manipuler comme un mot à partir d'une requête sur son id
        Mot une_annotation_gencive = systeme.requete(annotations.get(0).getId_annotation());
        //Les opérations habituelles sont désormais possible. 
        System.out.println(une_annotation_gencive.toString());

        //Opération nécessaire une fois toutes les opérations réalisées. 
        systeme.sauvegarder();
        */
    }
}
