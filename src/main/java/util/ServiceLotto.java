package util;

import business.Carte;
import business.Lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;
//Classe qui fait le lien entre Lotto et Console
public class ServiceLotto {
    //on récupère la Map des cartes instancié existante avec le getter.
    public HashMap<String, Carte> cartes = Lotto.getCartesMap();

    public ServiceLotto() {
    }

    //methode check carte qui renvoie un String v1, v2, v3 ou rien en fonction du nombre de lignes complètes.
    public String ckeckCarte(String id, LinkedList<Integer> numTire) {
        // On retourne le nombre de numéro de la carte qui sont présent dans la liste numTire, par ligne.
        int l1 = checkLigne(cartes.get(id.toUpperCase()).getRange1(), numTire);
        int l2 = checkLigne(cartes.get(id.toUpperCase()).getRange2(), numTire);
        int l3 = checkLigne(cartes.get(id.toUpperCase()).getRange3(), numTire);
        // Si les variables l1, l2, l3 sont à 5 cela veut dire que leur ligne est complète. On renvoie v1 s'il n'y a qu'une ligne, v2 s'il y en a deux et v3 s'il y en a 3.
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
    //Méthode qui vérifie une ligne, pour chaque numéros de la carte donné, on vérifie que le numero est dans la liste, si c'est le cas il incrémente un compteur et a la fin renvoie ce nombre.
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
