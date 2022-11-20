package util;

import business.Carte;
import business.Lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class ServiceLotto {
    HashMap<String, Carte> cartes;

    public ServiceLotto() {
        HashMap<String, Carte> cartes = new Lotto().initCartes();
    }

    //methode check carte
    public String ckeckCarte(String id, LinkedList<Integer> numTire) {

        Carte carte = cartes.get(id);
        int l1 = checkLigne(carte.getRange1(), numTire);
        int l2 = checkLigne(carte.getRange2(), numTire);
        int l3 = checkLigne(carte.getRange3(), numTire);
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
                if(n==m){
                    i++;
                }
            }
        }
        return i;
    }
}
