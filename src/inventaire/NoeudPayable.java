package inventaire;

import payables.Payable;

/**
 * Cette classe représente un noeud d'une liste chaînée de Payable.
 */
public class NoeudPayable {

    public Payable payable;
    private NoeudPayable suivant;

    /**
     * Constructeur de la classe NoeudPayable.
     * @param p L'objet Payable contenu dans le noeud
     * @param suivant   Le noeud suivant dans la liste chaînée
     */
    public NoeudPayable(Payable p, NoeudPayable suivant) {
        this.payable = p;
        this.suivant = suivant;
    }

    /**
     * Méthode qui retourne le noeud suivant dans la liste chaînée.
     * @return le noeud suivant
     */
    public NoeudPayable getNoeudSuivant() {
        return suivant;
    }

    /**
     * Méthode pour modifier le noeud suivant dans la liste chaînée.
     * @param s Le nouveau noeud suivant
     */
    public void setNoeudSuivant(NoeudPayable s) {
        suivant = s;
    }
}
