package exceptions;
//
// TODO 10-- Ajoutez le code nécessaire pour créer l'exception générée
//         quand le nombre de jours d'échéance passe sous zéro
//      Gracieusement fournie!

/**
 * Classe qui permet de créer une exception lorsque le nombre de jours d'échéance passe sous zéro.
 * Elle hérite de la classe Exception.
 */
public class ExceptionEcheanceInsuffisante extends Exception {

    /**
     * Constructeur de la classe ExceptionEcheanceInsuffisante.
     * @param jours Le nombre de jours qui entraîne une échéance négative
     */
    public ExceptionEcheanceInsuffisante(int jours) {
        super("Enlever " + jours + " d'échéance nous amènera à une échéance négative.");
    }
}
