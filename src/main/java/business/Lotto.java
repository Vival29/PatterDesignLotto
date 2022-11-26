package business;

import javax.json.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
//classe dans laquelle on crée notre liste d'objet Carte depuis un import json
public class Lotto {
    //nom du fichier a importer
    private final String FILENAME = "cartes.json";

    public Lotto() {
    }

    private static HashMap<String, Carte> cartesMap = new HashMap<>();
    // méthode de Lotto qui initalise la liste de type Map depuis le fichier json
    public void initCartes(){
        try {
            //créer le reader qui va lire le fichier json
            JsonReader reader = Json.createReader(new FileReader(FILENAME));
            // crée l'objet json messsageJson
            JsonObject messageJson = reader.readObject();
            //Extraire le tableau cartesImport de cet objet json, c'est un tableau de cartes
            JsonArray cartesImport = messageJson.getJsonArray("cartes");

            //pour chacune des cartes de ce tableau, on transforme Rangee1/Rangee2/Rangee3 d'une String à un tableau de Integer
            for(JsonObject carte : cartesImport.getValuesAs(JsonObject.class)) {
                //instantiation d'un nouvel objet carte
                Carte c = new Carte();

                String str1 = carte.getString("Rangee1");
                String[] tabS1 = str1.split(";");
                ArrayList<Integer> r1 = new ArrayList<>();
                for(String s1: tabS1){
                    r1.add(Integer.parseInt(s1));
                }
                String str2 = carte.getString("Rangee2");
                String[] tabS2 = str2.split(";");
                ArrayList<Integer> r2 = new ArrayList<>();
                for(String s2: tabS2){
                    r2.add(Integer.parseInt(s2));
                }
                String str3 = carte.getString("Rangee3");
                String[] tabS3 = str3.split(";");
                ArrayList<Integer> r3 = new ArrayList<>();
                for(String s3: tabS3){
                    r3.add(Integer.parseInt(s3));
                }
                //attribution des éléments importé et modifié du json dans l'objet Carte.
                c.setRange1(r1);
                c.setRange2(r2);
                c.setRange3(r3);
                //utilisation de l'id de la carte comme Key dans notre liste Map, et Carte dans value.
                cartesMap.put(carte.getString("NumCarte"), c );

                /*System.out.println("On a ajoute une carte dans notre map" + cartesMap.size());
                System.out.println(c.toString());*/
            }

        } catch (FileNotFoundException ex) {
                Logger.getLogger(Lotto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getFILENAME() {
        return FILENAME;
    }

    public static HashMap<String, Carte> getCartesMap() {
        return cartesMap;
    }

    public static void setCartesMap(HashMap<String, Carte> cartesMap) {
        Lotto.cartesMap = cartesMap;
    }
}
