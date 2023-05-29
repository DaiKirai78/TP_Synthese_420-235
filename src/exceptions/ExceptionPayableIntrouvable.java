package exceptions;
//
// TODO 08-- Ajoutez le code nécessaire pour créer l'exception générée
//         quand on essaie de référer à un payable inexistant
//

/**
 * Classe qui permet de créer une exception lorsque l'on essaie de référer à un payable inexistant.
 * Elle hérite de la classe Exception.
 */
public class ExceptionPayableIntrouvable extends Exception {

    /**
     * Constructeur de la classe ExceptionPayableIntrouvable
     * @param ID    L'ID de l'élément payable introuvable
     */
    public ExceptionPayableIntrouvable(int ID) {
        super("Payable " + ID + " n'est pas dans la base de données.");
    }
}
