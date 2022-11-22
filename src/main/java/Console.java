import util.ServiceLotto;

import java.util.LinkedList;

import java.util.Scanner;

public class Console {
    final private String DEL = "del";
    final private String QUINE = "v1";
    final private String DOUBLE_QUINE = "v2";
    final private String CARTON = "v3";
    final private String EXIT = "exit";
    private LinkedList<Integer> numTire = new LinkedList<>();
    private ServiceLotto service;
    private int compteur = 1;
    String id = null;
    String retour = null;

    public void runJeux() {
        //TODO Apparence de sout pour que le meneur de jeu entre les numéros + indication de lettre quand veut checker, + indication de lettre quand erreur a refaire?
        boolean running = true;
        System.out.println("__________________________________________________________________________________________");
        System.out.println("Aide de commande :");
        System.out.println("Entrez \"jouerles numeros tire les uns apres les autres, en validant avec la touche enter");
        System.out.println("Entrez les numeros tire les uns apres les autres, en validant avec la touche enter");
        System.out.println("Si vous vous etes trompe, taper \"del\", cela supprimera le dernier numero entre");
        System.out.println("Lorsque vous voulez controler une QUINE taper \"v1\"");
        System.out.println("Lorsque vous voulez controler une DOUBLE-QUINE taper \"v2\"");
        System.out.println("Lorsque vous voulez controler un CARTON taper \"v3\"");
        System.out.println("__________________________________________________________________________________________");
        System.out.println("Bonne partie de Lotto!!                           Vous jouez la partie no: " + compteur);
        while (running) {
            System.out.println("Entrer le numero tire, puis pressez enter");
            Scanner command = new Scanner(System.in);
            String entry = command.nextLine();
            if(isNumeric(entry)){
                if (numTire.contains(Integer.valueOf(entry))){
                        System.out.println("Numero deja present dans la liste");
                    System.out.println(numTire.toString());
                    } else if ( Integer.valueOf(entry)<1 ||Integer.valueOf(entry)>99 ){
                        System.out.println("le numero doit etre compris entre 1 et 99 inclus");
                    System.out.println(numTire.toString());
                    } else {
                        numTire.add(Integer.valueOf(entry));
                        System.out.println("Le numero " + entry + " a ete ajoute.");
                        System.out.println(numTire.toString());
                    }
                } else {

                switch (entry) {
                    case DEL:
                        Integer num = numTire.removeLast();
                        System.out.println("Le numero " + num + " a ete supprime de la liste.");
                        System.out.println(numTire.toString());
                        break;
                    case QUINE:
                        System.out.println("Veuillez entrer l'id de la carte a controler: ");
                        id = command.nextLine();
                        retour = service.ckeckCarte(id, numTire);
                        if (retour == "v1"){
                            System.out.println("la carte à bien un ligne complete, c'est QUINE!");
                        } else {
                            System.out.println("la carte n'est pas valide pour la QUINE");
                        }
                        break;
                    case DOUBLE_QUINE:
                        System.out.println("Veuillez entrer l'id de la carte a controler: ");
                        id = command.nextLine();
                        retour = service.ckeckCarte(id, numTire);
                        if (retour == "v2"){
                            System.out.println("la carte à bien deux lignes completes, c'est DOUBLE-QUINE!");
                        } else {
                            System.out.println("la carte n'est pas valide pour la DOUBLE-QUINE");
                        }
                        break;
                    case CARTON:
                        System.out.println("Veuillez entrer l'id de la carte a controler: ");
                        id = command.nextLine();
                        retour = service.ckeckCarte(id, numTire);
                        if (retour == "v3"){
                            System.out.println("la carte est complete, c'est CARTON!");
                            compteur++;
                            numTire.clear();
                        } else {
                            System.out.println("la carte n'est pas valide pour le CARTON");
                        }
                        break;
                    case EXIT :
                        running = false;
                        break;

                        default:
                        System.out.println("Commande non reconnue");
                        break;


                }
            }
        }

    }
    public boolean isNumeric(String entry){
        if (entry == null){
            return false;
        }
        try {
            Integer d = Integer.parseInt(entry);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
