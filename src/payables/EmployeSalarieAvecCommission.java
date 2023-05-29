package payables;

// TODO 01-- Ajoutez tout le code nécessaire pour coder la classe au complet en vous basant sur le diagramme UML
//         ainsi que la gestion des erreurs possibles si nécessaire
//

/**
 * La classe EmployeSalarieAvecCommission représente un employé rémunéré avec un salaire fixe et une commission sur les ventes,
 * et elle hérite de la classe EmployeSalarie et implémente l'interface Commission.
 */
public class EmployeSalarieAvecCommission extends EmployeSalarie implements Commission {
    private double tauxCommission;
    private double ventesBrutes;

    /**
     * Constructeur de la classe EmployeSalarieAvecCommission.
     * @param ID    L'identifiant d'un employé
     * @param n     Le nom complet d'un employé
     * @param nas   Le numéro d'assurance social d'un employé
     * @param s     Le salaire hebdomadaire d'un employé
     * @param tC    Le taux de commission d'un employé
     * @param vB    Le montant des ventes brutes réalisées par un employé
     * @param m     Une note/mémo sur l'employé
     */
    public EmployeSalarieAvecCommission(int ID, String n, String nas, double s, double tC, double vB, String m) {
        super(ID, n, nas, s, m);
        tauxCommission = tC;
        ventesBrutes = vB;
        categorie = Categorie.EmployeSalarieAvecCommission;
    }

    /**
     * Méthode pour obtenir le taux de commission d'un employé.
     * @return  Le taux de commission d'un employé
     */
    public double getTauxCommission() {
        return tauxCommission;
    }

    /**
     * Méthode pour définir le taux de commission d'un employé.
     * @param taux  Taux de commission d'un employé.
     */
    public void setTauxCommission(double taux) {
        tauxCommission = taux;
    }

    /**
     * Méthode pour obtenir le montant des ventes brutes réalisées par un employé.
     * @return  Le montant des ventes brutes réalisées par un employé
     */
    public double getVentesBrutes() {
        return ventesBrutes;
    }

    /**
     * Méthode pour définir le montant des ventes brutes réalisées par un employé.
     * @param ventes    Le montant des ventes brutes réalisées par un employé
     */
    public void setVentesBrutes(double ventes) {
        ventesBrutes = ventes;
    }

    /**
     * Méthode pour obtenir le montant de la commission d'un employé selon le montant des ventes brutes.
     * @param ventesBrutes  Le montant des ventes brutes réalisées par un employé
     * @return  Le montant de la commission d'un employé
     */
    public double getMontantCommission(double ventesBrutes) {
        return ventesBrutes * tauxCommission;
    }

    /**
     * Méthode pour obtenir le montant du paiement d'un employé.
     * @return  Le montant du paiement d'un employé
     */
    public double getMontantPaiement() {
        return super.getMontantPaiement() + getMontantCommission(ventesBrutes);
    }

    /**
     * Description de l'employé salarié avec commission.
     * @return La représentation sous forme de chaîne de caractères de l'employé.
     */
    @Override
    public String toString() {
        return String.format("%s; %s: %,.2f",
                super.toString(), "taux de commission", getTauxCommission());
    }

    /**
     * Description spécifique de l'employé salarié avec commission.
     * @return La représentation spécifique pour affichage de l'employé
     */
    public String toStringAffichage() {
        String info = super.toStringAffichage();
        info += " Commission [" + this.getTauxCommission()  + "] " +
         "Ventes [" + this.getVentesBrutes() + "]";
        return info;
    }

    /**
     * Description formatée pour la sauvegarde d'un employé salarié avec commission.
     * @return La représentation formatée à la sauvegarde d'un employé.
     */
    public String toStringSauvegarde() {
        String info = String.format("ID [%3d] Nom complet [%20s] NAS [%9s] Salaire [%6.2f] Mémo [%15s] Catégorie [%20s] Taux commission [%6.2f] Ventes brutes [%,.2f]",
                this.getID(), this.getNomComplet(), this.getNumeroAssuranceSociale(),
                super.getSalaireHebdomadaire(), this.getMemo(), this.getCategorieString(),
                this.getTauxCommission(), this.getVentesBrutes());
        return info;
    }
}