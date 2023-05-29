package inventaire;

import exceptions.*;
import payables.*;

/**
 * Classe représentant une base de données pour la gestion des objets Payable.
 * Utilise une liste chaînée simple comme structure de données.
 */
public class BaseDonnees {
    //
    // TODO 06-- Ajoutez tout le code nécessaire en vous basant sur le diagramme UML
    //         ainsi que la gestion des erreurs possibles si nécessaire
    // Indices: vous utilisez une liste chaînée simple comme structure de données.

    private NoeudPayable tete;
    private int nombrePayables;

    /**
     * Constructeur de la classe BaseDonnees.
     */
    public BaseDonnees() {
        tete = null;
        nombrePayables = 0;
    }

    /**
     * Méthode pour insérer un objet Payable dans la base de donnée.
     * @param p L'objet Payable à insérer
     * @throws ExceptionPayableExisteDeja   Si un objet Payable avec le même ID existe déjà dans la base de données.
     */
    public void inserer(Payable p) throws ExceptionPayableExisteDeja {
        if (trouverParID(p.getID()) != null) {
            throw new ExceptionPayableExisteDeja(p.getID());
        }
        tete = new NoeudPayable(p, tete);
        nombrePayables++;
    }

    /**
     * Méthode qui recherche et retourne un objet Payable dans la base de données en utilisant son ID.
     * @param ID L'ID de l'objet payable à rechercher
     * @return  L'objet Payable correspondant à l'ID, ou null s'il n'est pas trouvé.
     */
    public Payable trouverParID(int ID) {
        NoeudPayable courant = tete;
        while (courant != null) {
            if (courant.payable.getID() == ID) {
                return courant.payable;
            }
            courant = courant.getNoeudSuivant();
        }
        return null;
    }

    /**
     * Méthode pour retirer un objet Payable de la base de données en utilisant son ID.
     * @param ID    L'ID de l'objet Payable à retirer
     * @throws ExceptionPayableIntrouvable  Si aucun objet Payable avec l'ID spécifié n'est trouvé dans la base de données
     */
    public void enlever(int ID) throws ExceptionPayableIntrouvable {
        if (tete == null) {
            throw new ExceptionPayableIntrouvable(ID);
        }

        if (tete.payable.getID() == ID) {
            tete = tete.getNoeudSuivant();
            nombrePayables--;
            return;
        }

        NoeudPayable courant = tete;
        while (courant.getNoeudSuivant() != null) {
            if (courant.getNoeudSuivant().payable.getID() == ID) {
                courant.setNoeudSuivant(courant.getNoeudSuivant().getNoeudSuivant());
                nombrePayables--;
                return;
            }
            courant = courant.getNoeudSuivant();
        }

        throw new ExceptionPayableIntrouvable(ID);
    }

    /**
     * Méthode qui retourne un tableau contenant tous les objets Payable de la base de données.
     * @return un tableau d'objets Payable
     */
    public Payable[] getTableauPayables() {
        Payable[] payablesArray = new Payable[nombrePayables];
        int index = 0;
        NoeudPayable courant = tete;
        while (courant != null) {
            payablesArray[index] = courant.payable;
            courant = courant.getNoeudSuivant();
            index++;
        }
        return payablesArray;
    }
}
