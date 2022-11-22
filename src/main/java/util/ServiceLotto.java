package util;

import business.Carte;
import business.Lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;

public class ServiceLotto {
    public HashMap<String, Carte> cartes = Lotto.getCartesMap();

    public ServiceLotto() {
        //HashMap<String, Carte> cartes = new Lotto().initCartes();
    }

    //methode check carte
    public String ckeckCarte(String id, LinkedList<Integer> numTire) {

        int l1 = checkLigne(cartes.get(id.toUpperCase()).getRange1(), numTire);
        int l2 = checkLigne(cartes.get(id.toUpperCase()).getRange2(), numTire);
        int l3 = checkLigne(cartes.get(id.toUpperCase()).getRange3(), numTire);
        if ((l1 == 5) && (l2 == 5) && (l3 == 5)) {
            return "v3";
        } else if (((l1 == 5) && (l2 == 5)) || ((l2 == 5) && (l3 == 5)) || ((l1 == 5) && (l3 == 5))) {
            return "v2";
        } else if ((l1 == 5) || (l2 == 5) || (l3 == 5)) {
            return "v1";
        } else {
            return "rien";
        }
    }

    public int checkLigne(ArrayList<Integer> rangee, LinkedList<Integer> numTire){
        int i = 0;
        for(Integer n : rangee){
            for(Integer m : numTire){
                if(Objects.equals(n, m)){
                    i++;
                }
            }
        }
        return i;
    }
}
