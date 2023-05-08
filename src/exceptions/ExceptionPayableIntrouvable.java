package exceptions;
//
// TODO 08-- Ajoutez le code nécessaire pour créer l'exception générée
//         quand on essaie de référer à un payable inexistant
//
public class ExceptionPayableIntrouvable extends Exception {

    public ExceptionPayableIntrouvable(int ID) {
        super("L'ID " + ID + " n'existe pas");
    }
}
