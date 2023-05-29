package inventaire;

import exceptions.*;
import payables.*;

/**
 * Cette classe représente un gestionnaire d'inventaire.
 * Elle gère les opérations sur les objets Payable en utilisant une base de données.
 */
public class GestionnaireInventaire {
    //
    // TODO 07-- Ajoutez tout le code nécessaire en vous basant sur le diagramme UML
    //         ainsi que la gestion des erreurs possibles si nécessaire
    //

    private BaseDonnees baseDonnees;

    /**
     * Constructeur de la classe GestionnaireInventaire.
     */
    public GestionnaireInventaire() {
        baseDonnees = new BaseDonnees();
    }

    /**
     * Méthode pour ajouter un objet Payable à la base de données.
     * @param p L'objet Payable à ajouter
     * @throws ExceptionPayableExisteDeja   Si un objet Payable avec le même ID existe déjà dans la base de données.
     */
    public void ajouterPayable(Payable p) throws ExceptionPayableExisteDeja {
        baseDonnees.inserer(p);
    }

    /**
     * Méthode pour retirer un objet Payable dans la base de données.
     * @param ID L'ID de l'objet Payable à retirer
     * @throws ExceptionPayableIntrouvable  Si aucun objet Payable avec l'ID spécifié n'est trouvé dans la base de données.
     */
    public void retirerPayable(int ID) throws ExceptionPayableIntrouvable {
        baseDonnees.enlever(ID);
    }

    /**
     * Méthode pour augmenter le nombre de jours avant l'échéance d'un objet Payable.
     * @param ID    L'ID de l'objet Payable
     * @param e Le nombre de jours avant l'échéance de l'objet Payable
     */
    public void augmenterEcheancePayable(int ID, int e) {
        baseDonnees.trouverParID(ID).augmenterEcheance(e);
    }

    /**
     * Méthode pour diminuer le nombre de jours avant l'échéance d'un objet Payable.
     * @param ID L'ID de l'objet Payable.
     * @param e Le nombre de jours avant l'échéance de l'objet Payable
     * @throws ExceptionEcheanceInsuffisante     Si le nombre de jours spécifié dépasse l'échéance actuelle de l'objet Payable.
     * @throws ExceptionPayableIntrouvable  Si aucun objet Payable avec l'ID spécifié n'est trouvé dans la base de données.
     */
    public void diminuerEcheancePayable(int ID, int e) throws ExceptionEcheanceInsuffisante, ExceptionPayableIntrouvable {
        if (baseDonnees.trouverParID(ID) == null) {
            throw new ExceptionPayableIntrouvable(ID);
        }
        baseDonnees.trouverParID(ID).diminuerEcheance(e);
    }

    /**
     * Méthode qui retourne un objet Payable de la base de données en utilisant son ID.
     * @param ID L'ID de l'objet Payable
     * @return  L'objet Payable correspondant à l'ID
     * @throws ExceptionPayableIntrouvable  Si aucun objet Payable avec l'ID spécifié n'est trouvé dans la base de données.
     */
    public Payable getPayable(int ID) throws ExceptionPayableIntrouvable {
        Payable payable = baseDonnees.trouverParID(ID);
        if (payable != null)
            return payable;
        else
            throw new ExceptionPayableIntrouvable(ID);
    }

    /**
     * Méthode qui retourne un tableau contenant tous les objets Payable de la base de données.
     * @return un tableau d'objets Payable
     */
    public Payable[] getTableauPayables() {
        return baseDonnees.getTableauPayables();
    }
}
