package business;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.json.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lotto {
    private final String FILENAME = "cartes.json";
    private static HashMap<String, Carte> cartesMap = new HashMap<>();
    public HashMap<String, Carte> initCartes(){
        try {
            JsonReader reader = Json.createReader(new FileReader(FILENAME));
                JsonObject messageJson = reader.readObject();
                JsonArray cartesImport = messageJson.getJsonArray("cartes");


            for(JsonObject carte : cartesImport.getValuesAs(JsonObject.class)) {
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
                c.setRange1(r1);
                c.setRange2(r2);
                c.setRange3(r3);
                cartesMap.put(carte.getString("NumCarte"), c );

                System.out.println("on a ajouté une carte dans notre map" + cartesMap.size());
                System.out.println(c.toString());
            }

        } catch (FileNotFoundException ex) {
                Logger.getLogger(Lotto.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cartesMap;

    }
}
