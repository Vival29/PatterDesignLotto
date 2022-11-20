import business.Lotto;

public class MainApp {
    public static void main(String[] args) {
        //initialiser les cartes avec leur id et matrice
        //lancer la console
        new Lotto().initCartes();
        new Console().runJeux();
    }
}
