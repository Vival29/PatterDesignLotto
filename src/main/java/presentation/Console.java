package presentation;

import util.ServiceLotto;

import java.util.LinkedList;

import java.util.Objects;
import java.util.Scanner;

public class Console {
    final private String DEL = "del";
    final private String QUINE = "v1";
    final private String DOUBLE_QUINE = "v2";
    final private String CARTON = "v3";
    final private String EXIT = "exit";
    private LinkedList<Integer> numTire = new LinkedList<>();
    private ServiceLotto service = new ServiceLotto();
    private int compteur = 1;
    String id = null;
    String retour = null;

    public void runJeux() {
        // La console affiche les explication de fonctionnement puis demande au crieru d'entrer les numero tiré.
        boolean running = true;
        System.out.println(".__________________________________________________________________________________________.");
        System.out.println("| Aide de commande :                                                                       |");
        System.out.println("| Entrez les numéros tire les uns après les autres, en validant avec la touche [Enter]     |");
        System.out.println("| Si vous vous etes trompe, taper \"del\", cela supprimera le dernier numero entre         |");
        System.out.println("| Lorsque vous voulez controler une QUINE taper \"v1\"                                     |");
        System.out.println("| Lorsque vous voulez controler une DOUBLE-QUINE taper \"v2\"                              |");
        System.out.println("| Lorsque vous voulez controler un CARTON taper \"v3\"                                     |");
        System.out.println("| Si vous avez termine de jouer taper \"exit\"                                             |");
        System.out.println("|__________________________________________________________________________________________|");
        System.out.println("Bonne partie de Lotto!!                           Vous jouez la partie no: " + compteur);
        while (running) {
            System.out.println("Entrer le numéro tire, pressez [ENTER] ou choisissez un mot clé");
            Scanner command = new Scanner(System.in);
            String entry = command.nextLine();
            //vérifie si la commande entré dans la console est un nombre avec la méthode isNumeric, dans ce cas la inscrit le nombre dans la liste, Sinon passe en mode switch avec les constantes
            if(isNumeric(entry)){
                //Dans le cas ou le nombre est déja présent dans la liste, il affiche dansla console qu'il est déja présent. Si le nbombre n'est pas compris entre 1 et 99 il affiche qu'il dit etre compris entre 1 et 99 sinon il entre le num dans la liste.
                if (numTire.contains(Integer.valueOf(entry))){
                        System.out.println("Numéro déjà présent dans la liste");
                    System.out.println(numTire.toString());
                    } else if ( Integer.parseInt(entry)<1 ||Integer.parseInt(entry)>99 ){
                        System.out.println("Le numéro doit être compris entre 1 et 99 inclus");
                    System.out.println(numTire.toString());
                    } else {
                        numTire.add(Integer.valueOf(entry));
                        System.out.println("Le numéro " + entry + " a été ajouté."+" Liste des numéros tirés: " +numTire.toString());
                    }
                } else {
                // si ce n'est pas un numero alors il check que cela soit une des commandes constantes.
                switch (entry) {
                    // dans le cas ou le crieur s'est trompé il peut supprimer la dernière entré (ou celle d'avant) en LIFO
                    case DEL:
                        Integer num = numTire.removeLast();
                        System.out.println("Le numéro " + num + " a été supprimé de la liste.");
                        System.out.println(numTire.toString());
                        break;
                    case QUINE:
                        //verifie la quine en demandant l'id
                        System.out.println("Veuillez entrer l'id de la carte a contrôler: ");
                        id = command.nextLine();
                        //retour est un string qui sera soit v1, v2, v3 ou rien. Dans le cas de la quine on voudrait que ce soit v1 alors c'est ce que l'on verifie.
                        retour = service.ckeckCarte(id, numTire);
                        if (Objects.equals(retour, "v1")){
                            System.out.println("La carte a bien une ligne complete, c'est QUINE!");
                            System.out.println("Vous jouez maintenant pour la double quine!");
                        } else {
                            System.out.println("La carte n'est pas valide pour la QUINE");
                        }
                        break;
                    case DOUBLE_QUINE:
                        //retour est un string qui sera soit v1, v2, v3 ou rien. Dans le cas de la double quine on voudrait que ce soit v2 alors c'est ce que l'on verifie.
                        System.out.println("Veuillez entrer l'id de la carte a controler: ");
                        id = command.nextLine();
                        retour = service.ckeckCarte(id, numTire);
                        if (Objects.equals(retour, "v2")){
                            System.out.println("La carte a bien deux lignes completes, c'est DOUBLE-QUINE!");
                            System.out.println("Vous jouez maintenant pour le carton!");
                        } else {
                            System.out.println("La carte n'est pas valide pour la DOUBLE-QUINE");
                        }
                        break;
                    case CARTON:
                        //Si retour vaut v3 alors c'est carton
                        System.out.println("Veuillez entrer l'id de la carte a controler: ");
                        id = command.nextLine();
                        retour = service.ckeckCarte(id, numTire);
                        //dans le cas ou c'est v3, on incrément le compteur du nombre de partie, on vide la liste des numeros tires, on affiche a nouveau l'aide du début de partie et on recomence.
                        if (Objects.equals(retour, "v3")){
                            compteur++;
                            numTire.clear();
                            System.out.println("la carte est complete, c'est CARTON!");
                            System.out.println("Debut de partie " + compteur);
                            System.out.println(".__________________________________________________________________________________________.");
                            System.out.println("| Aide de commande :                                                                       |");
                            System.out.println("| Entrez les numéros tire les uns après les autres, en validant avec la touche [Enter]     |");
                            System.out.println("| Si vous vous etes trompe, taper \"del\", cela supprimera le dernier numero entre         |");
                            System.out.println("| Lorsque vous voulez controler une QUINE taper \"v1\"                                     |");
                            System.out.println("| Lorsque vous voulez controler une DOUBLE-QUINE taper \"v2\"                              |");
                            System.out.println("| Lorsque vous voulez controler un CARTON taper \"v3\"                                     |");
                            System.out.println("| Si vous avez termine de jouer taper \"exit\"                                             |");
                            System.out.println("|__________________________________________________________________________________________|");
                            System.out.println("Bonne partie de Lotto!!                                     Vous jouez la partie no: " + compteur);
                        } else {
                            System.out.println("La carte n'est pas valide pour le CARTON");
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
