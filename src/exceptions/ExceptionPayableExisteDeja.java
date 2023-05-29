package exceptions;
//
// TODO 09-- Ajoutez le code nécessaire pour créer l'exception générée
//         quand on essaie de créer un payable avec un numéro de ID existant
//

/**
 * Classe qui permet de créer une exception lorsque l'on essaie de créer un payable avec un numéro de ID existant.
 * Elle hérite de la classe Exception.
 */
public class ExceptionPayableExisteDeja extends Exception {

    /**
     * Constructeur de la classe ExceptionPayableExisteDeja.
     * @param ID    L'ID déjà présent dans la base de données
     */
    public ExceptionPayableExisteDeja(int ID) {
        super("Payable " + ID + " est déjà présent dans la base de données.");
    }
}
