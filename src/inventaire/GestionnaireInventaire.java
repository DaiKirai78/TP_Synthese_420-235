package inventaire;

import exceptions.*;
import payables.*;

public class GestionnaireInventaire {
    //
    // TODO 07-- Ajoutez tout le code nécessaire en vous basant sur le diagramme UML
    //         ainsi que la gestion des erreurs possibles si nécessaire
    //

    private BaseDonnees baseDonnees;

    public GestionnaireInventaire() {
    }

    public void ajouterPayable(Payable p) throws ExceptionPayableExisteDeja {
        baseDonnees.inserer(p);
    }

    public void retirerPayable(int ID) throws ExceptionPayableIntrouvable {
        baseDonnees.enlever(ID);
    }

    public void augmenterEcheancePayable(int ID, int e) {
        baseDonnees.trouverParID(ID).augmenterEcheance(e);
    }

    public void diminuerEcheancePayable(int ID, int e) throws ExceptionEcheanceInsuffisante {
        baseDonnees.trouverParID(ID).diminuerEcheance(e);
    }

    public Payable getPayable(int ID) throws ExceptionPayableIntrouvable {
        Payable payable = baseDonnees.trouverParID(ID);
        if (payable != null)
            return payable;
        else
            throw new ExceptionPayableIntrouvable(ID);
    }

    public Payable[] getTableauPayables() {
        return baseDonnees.getTableauPayables();
    }
}
